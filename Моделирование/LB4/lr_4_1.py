import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits import mplot3d
import scipy.linalg as la
from prettytable import PrettyTable

p = lambda x: x + 1


def f(x, t):
    # return x+t
    return pow(x, 3) - 9 * pow(x, 2) - 6 * x + 3 * pow(t, 2) + pow(t, 3)


def lu(u: np.array, x: np.linspace, t: np.linspace,
       i, k, h):
    return p(x[i] + h / 2) * (u[i + 1, k] - u[i, k]) / pow(h, 2) - \
        p(x[i] - h / 2) * (u[i, k] - u[i - 1, k]) / pow(h, 2) - u[i, k]


def solve(h, tau, sigma):
    x_min = 0
    x_max = 1
    xs = np.arange(x_min, x_max + h, h)
    n_x = len(xs)

    t_min = 0
    t_max = 0.1
    ts = np.arange(t_min, t_max + tau, tau)
    n_t = len(ts)

    # phi = lambda x: x
    # alpha = lambda t: t
    # beta = lambda t: 2 + t

    phi = lambda x: pow(x, 3)
    alpha = lambda t: pow(t, 3)
    beta = lambda t: 4 + pow(t, 3)

    U = np.zeros((n_x, n_t))
    G = np.zeros((n_x, n_t))
    U[:, 0] = [phi(x) for x in xs]
    print(U[:, 0])
    A = np.zeros((n_x - 1))
    B = np.zeros((n_x))
    C = np.zeros((n_x - 1))

    for k in range(1, n_t):
        for i in range(1, n_x - 1):
            G[i, k] = - U[i, k - 1] / tau \
                      - (1 - sigma) * lu(U, xs, ts, i, k - 1, h) \
                      - f(xs[i], ts[k])
            A[i - 1] = sigma * p(xs[i] - h / 2) / pow(h, 2)
            B[i] = - (sigma * p(xs[i] + h / 2) / pow(h, 2) + \
                      sigma * p(xs[i] - h / 2) / pow(h, 2) + sigma + 1 / tau)
            C[i] = sigma * p(xs[i] + h / 2) / pow(h, 2)

        B[0] = 1
        C[0] = 0
        A[-1] = -1
        B[-1] = h + 1

        G[0, k] = alpha(ts[k])
        G[-1, k] = h * beta(ts[k])

        matrix = np.array([[0, *C], B, [*A, 0]])

        U[:, k] = la.solve_banded((1, 1), matrix, G[:, k])

    return [xs, ts, U]


def makeTableFromResult(xs, ts, U):
    table = PrettyTable()
    ts = ts.round(4)
    xs = xs.round(4)
    U = U.round(5)
    table.add_column("x \ t", xs)
    for k in range(len(ts)):
        table.add_column(f"{ts[k]}", U[:, k])
    return table


sigma = 0.5
[xs, ts, U] = solve(0.1, 0.001, sigma)

fig = plt.figure()
ax = plt.axes(projection='3d')
X, Y = np.meshgrid(ts, xs)
ax.plot_surface(X, Y, U, rstride=1, cstride=1,
                cmap='YlOrBr', edgecolor='none')
ax.set_xlabel('$t$')
ax.set_ylabel('$x$')
ax.set_zlabel('$u$')

plt.show()


def makeTableFromStep(hs, taus, diff, exact_diff):
    table = PrettyTable()
    table.add_column("h", hs)
    table.add_column("tau", taus)
    table.add_column("||U_exact-U_h||", diff)
    table.add_column("||U_2h-U_h||", exact_diff)
    return table


def makeTableFromResult(xs, ts, U):
    table = PrettyTable()
    ts = ts.round(3)
    xs = xs.round(3)
    U = U.round(3)
    table.add_column("x \ t", xs)
    for k in range(len(ts)):
        table.add_column(f"{ts[k]}", U[:, k])
    return table


[xs, ts, U] = solve(0.25, 0.01, sigma)

print("Результат:")
print(makeTableFromResult(xs, ts, U))

h = 0.25
tau = 0.0005

hs = []
taus = []
exact_diff = []
last_diff = []

[_, _, last_u] = solve(h, tau, sigma)
last_u = last_u[0::2]

for i in range(3):
    [xs, ts, U] = solve(h, tau, sigma)

    u = lambda t, x: x ** 3 + t ** 3
    U_exact = np.array([[u(t, x) for t in ts] for x in xs])

    hs.append(h)
    taus.append(tau)
    exact_diff.append(np.amax(np.abs(U - U_exact)))
    last_diff.append(np.amax(np.abs(last_u - U[0::2])))

    h /= 2
    last_u = U

hs = np.array(hs).round(5)
taus = np.array(taus).round(5)
exact_diff = np.array(exact_diff).round(4)
last_diff = np.array(last_diff).round(4)

print(makeTableFromStep(hs, taus, exact_diff, last_diff))
