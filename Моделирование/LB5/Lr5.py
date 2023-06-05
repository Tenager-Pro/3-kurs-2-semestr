import numpy as np

# Определение начальных условий
n = 100  # количество уравнений
eps = 1e-6  # точность решения
max_iter = 1000  # максимальное количество итераций
x0 = np.zeros(n)  # начальное приближение
b = np.ones(n)  # правая часть уравнения

# Определение Чебышевского набора параметров
a = 0.5  # начальное значение
d = 2 / (n - 1)  # шаг
t = a + d * np.arange(n)  # набор параметров Чебышева

# Вычисление матрицы коэффициентов
A = np.diag(2 * np.ones(n)) - np.diag(np.ones(n - 1), 1) - np.diag(np.ones(n - 1), -1)

# Вычисление обратной матрицы с помощью метода попеременных шагов
x = x0.copy()
for k in range(max_iter):
    # Обратный ход попеременного треугольного метода
    for i in range(n - 1, 0, -2):
        x[i] = (b[i] - np.dot(A[i, i + 1:], x[i + 1:])) / A[i, i]
    for i in range(0, n, 2):
        x[i] = (b[i] - np.dot(A[i, :i], x[:i]) - np.dot(A[i, i + 1:], x[i + 1:])) / A[i, i]
    # Вычисление нового приближения по Чебышевскому набору параметров
    z = x + np.sin((2 * k + 1) * np.pi / (2 * n)) * t
    # Проверка на достижение заданной точности
    if np.linalg.norm(x - z) < eps:
        break
    x = z.copy()

print(f"Solution: {x}")
