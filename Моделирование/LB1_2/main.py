import numpy as np
import matplotlib.pyplot as plt

# задаем параметры метода
a = 1
b = 3
n = 50
h = (b-a)/n
tol = 1e-6
max_iter = 1000

# создаем массивы для аппроксимации узлов и интервалов
x = np.linspace(a, b, n+1)
U = np.zeros(n+1)

# задаем начальное приближение
for i in range(n+1):
    U[i] = 1 - x[i]/2

# создаем матрицу для системы уравнений
A = np.zeros((n-1, n-1))
F = np.zeros(n-1)
for i in range(1, n):
    A[i-1, i-1] = -2*(1/x[i] + 3)/h**2 - x[i]/h + np.log(2+x[i])
    if i < n-1:
        A[i-1, i] = 1*(1/x[i+1] + 3)/h**2
    if i > 1:
        A[i-1, i-2] = 1*(1/x[i-1] + 3)/h**2
    F[i-1] = 1 - x[i]/2


iter_num = 0
delta = tol + 1
while delta > tol and iter_num < max_iter:
    U_prev = np.copy(U)
    for i in range(1, n):
        U[i] = (F[i-1] - (1/x[i] + 3)*(U[i+1] - 2*U[i] + U[i-1])/h**2 - x[i]*(U[i+1] - U[i])/h)/(-2*(1/x[i] + 3)/h**2 - x[i]/h + np.log(2+x[i]))
    delta = np.sum(np.abs(U - U_prev))
    iter_num += 1

# выводим результаты
print(f"Number of iterations: {iter_num}")
print(f"Residual error: {delta}")
plt.plot(x, U)
plt.xlabel('x')
plt.ylabel('u(x)')
plt.title('Approximate solution by finite difference method')
plt.show()