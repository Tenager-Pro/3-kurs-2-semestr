import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D


u = lambda x, t, n: \
    - np.sin(n * x) * 16 / np.pi * np.exp(-27*t) \
    * (np.exp(-3 * ((pow(n,2) + 9)*t)) * (np.exp(3 * pow(n, 2)*t) - 1) / pow(n, 2)) \
    * (n * (np.cos(n * np.pi) + 1) / (pow(n, 2) - 9) if n != 3 else 0)


xs = np.linspace(0, np.pi, 25)
ts = np.linspace(0, 0.1, 5)

fig = plt.figure()
ax = plt.axes(projection='3d')
X, Y = np.meshgrid(ts, xs)

res = u(Y, X, 1)
for n in range(2, 16):
    us = u(Y, X, n)
    res += us

ax.plot_surface(X, Y, res, rstride=1, cstride=1,
    cmap='OrRd', edgecolor='none')
ax.set_xlabel('$t$')
ax.set_ylabel('$x$')
ax.set_zlabel('$u$')
plt.show()

fig = plt.figure()
ax = plt.axes()
X, Y = np.meshgrid(ts, xs)

for i in range(len(ts)):
    plt.plot([xs[i] for j in res[:, i]], res[:, i], label=f"$t={ts[i]:.2f}$")

ax.set_xlabel("$x$")
ax.set_ylabel("$u(x, t)$")
plt.legend(framealpha=0.5, frameon=True)

plt.show()
