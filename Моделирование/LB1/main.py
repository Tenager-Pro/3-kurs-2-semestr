import numpy
import sympy
from math import *

from numpy import linspace,zeros,arange
import sympy


def analite_first_derivative(x):
    return 3*exp(3*x)

def analite_second_derivative(x):
    return 9*exp(3*x)
def function(x):
    return exp(3*x)


def divided_diff(x, y):
    n = len(y)
    coef = zeros([n, n])
    coef[:, 0] = y

    for j in range(1, n):
        for i in range(n - j):
            coef[i][j] = \
                (coef[i + 1][j - 1] - coef[i][j - 1]) / (x[i + j] - x[i])

    return coef


def newton_poly_derivative(coef, points, x):
    n = len(points) - 1
    dp = 0
    p = coef[n]

    for k in range(1, n + 1):
        dp *= (x - points[n-k])
        dp += p
        p *= (x - points[n-k])
        p += coef[n-k]

    return dp

def ex3():

    point = 2
    start = 1.9
    stop = 2.1
    n = 5

    points = linspace(start=start, stop=stop, num=n)
    y = [function(x) for x in points]

    newton_divided_diff = divided_diff(points, y)
    coef = newton_divided_diff[0, :]

    newton_first_derivative = newton_poly_derivative(coef, points, 2)
    delta = abs(analite_first_derivative(point) - newton_first_derivative)

    print("Точки",points)
    print(f"Разделённые разности:")
    print(newton_divided_diff)

    sym_x = sympy.Symbol("x")
    polynom = newton_poly_derivative(coef, points, sym_x)
    polynom = sympy.simplify(polynom)
    print(f"P_{n}(x)=", polynom, '\n')

    print(f"{'Первая производнаяпо формуле:':40} {(4 * function(2.05) - 3 * function(2.0) - function(2.1)) / .05 / 2}")
    print(
        f"{'Дельта:':40} {abs(analite_first_derivative(point) - (4 * function(2.05) - 3 * function(2.0) - function(2.1)) / .05 / 2)}")
    print(f"{'Производная Ньютон:':40} {newton_first_derivative}")
    print(f"{'Дельта:':40} {abs(analite_first_derivative(point) - newton_first_derivative)}")


def df(x, h):
    return (-3 * function(x) + 4 * function(x + h) - function(x + 2 * h)) / (2 * h)

def ex2():
    x = 1
    h = 0.1
    acc = 3 * exp(3 * x)
    y = df(x, h)
    error = y - acc
    print("h                 df        error")
    while (abs(y - acc) <= abs(error)):
        error = y - acc
        print("{0:<17} {1:3.5f} {2}".format(h, y, abs(error)))
        h = h / 2;
        y = df(x, h)
    print("{0:<17} {1:3.5f} {2}".format(h, y, abs(y - acc)))
    print('Экспереминтальное h: {0}'.format(h))
    print('Теоретическое h: {0}'.format(sqrt(3 * (5 / 1000000) / (27 * exp(3 * x)))))
def derivative_oh(func, x: list, n: int):
    derivative = n * [None]
    derivative[0] = round((func(x[1]) - func(x[0])) / (x[1] - x[0]))
    for i in range(1, n):
        derivative[i] = round((func(x[i]) - func(x[i - 1])) /(x[i] - x[i - 1]), 4)
    return derivative

def derivative_oh2(func, x: list, n: int):
    derivative = n * [None]
    derivative[0] = round((4 * func(x[1]) - 3 * func(x[0]) - func(x[2])) / (x[1] - x[0]) / 2, 4)
    derivative[1] = round((4 * func(x[2]) - 3 * func(x[1]) - func(x[3])) / (x[2] - x[1]) / 2, 4)
    for i in range(2, n):
        derivative[i] = round((3 * func(x[i]) - 4 * func(x[i - 1]) + func(x[i - 2])) / (x[i] - x[i - 1]) / 2, 4)
    return derivative

def second_derivative_oh2(func, x: list, n: int):
    derivative = n * [None]
    for i in range(1, n - 1):
        derivative[i] = round((func(x[i + 1]) - 2 * func(x[i]) + func(x[i - 1])) / (x[i] - x[i - 1]) ** 2, 4)
    return derivative

def calculate_inaccuraty(first: list, second: list):
    if len(first) != len(second):
        return [0]
    inacuraty = len(first) * [0];
    for i in range(0, len(first)):
        if first[i] is None or second[i] is None:
            inacuraty[i] = None
        else:
            inacuraty[i] = round(abs(first[i] - second[i]), 4)
    return inacuraty





if __name__ == "__main__":
    count = 11
    x = [round(i, 3) for i in numpy.linspace(0, 1, count)]
    first_derivative = [round(analite_first_derivative(i), 4) for i in x]
    second_derivative = [round(analite_second_derivative(i), 4) for i in x]

    a1 = derivative_oh(function, x, len(x))
    a2 = derivative_oh2(function, x, len(x))
    a3 = second_derivative_oh2(function, x, len(x))
    inaccuraty = calculate_inaccuraty(a1, first_derivative)
    inaccuraty2 = calculate_inaccuraty(a2, first_derivative)
    inaccuraty3 = calculate_inaccuraty(a3, second_derivative)
    print("i","|","x","|","f(x)","|","f'","|","f' O(h)","|","погр. O(h)","|"
              ,"f' O(h**2)","|","погр. O(h**2)","|","f''","|"
              ,"f'' O(h**2)","|","погр. O(h**2)")
    for i in range(count):
        print(str(i),"|",x[i],"|",function(x[i]),"|",first_derivative[i],"|",a1[i],"|"
              ,inaccuraty[i],"|",a2[i],"|",inaccuraty2[i],"|"
              ,"|",second_derivative[i],"|",a3[i],"|",inaccuraty3[i])
    print("\n")
    print("Задание №2")
    ex2()
    print("\n")
    print("Задание №3")
    ex3()