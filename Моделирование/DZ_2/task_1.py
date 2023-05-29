import matplotlib.pyplot as plt
import numpy as np
import math

def U(x, t):
    pi = np.pi
    r = 0.0
    r = 12*math.cos(14*pi*t)*math.sin(2*pi*x) + math.sin(21*pi*t)*math.sin(3*pi*x)
    print("r=",r)
    print(2/math.pi+t, "\n")
    return r

l = 4
a = 7

t = [0.0, 0.3, 0.6, 0.68, 0.76]
color = ['g-', 'b-', 'r-', 'c-', 'y-']
indx = 0
for tt in t:
     x = np.linspace(0, 1.1, num=200)
     print("x=",x)
     y = []
     print("tt=",tt)
     for i in x:
        y.append(U(i, tt))
     plt.plot(x, y, '%s' % color[indx], linewidth=2, label='t = %.1f '% tt)
     indx+=1
plt.xlabel('x')
plt.ylabel('U(x, t)')
plt.grid(True)
plt.legend(loc=0)
plt.show()
