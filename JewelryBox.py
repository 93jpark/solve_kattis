#problem ID: jewelrybox

import sympy as sym
import math

h = sym.Symbol('h')

list = []
#entire_case = int(input())

x, y = input().split()
x = int(x)
y = int(y)

a = 12
b = -4 * (x+y)
c = x*y
d = b**2 + (-4 * a * c)

r1 = (-b + math.sqrt(d)) / (2*a)
r2 = (-b - math.sqrt(d)) / (2*a)
if(r1 > r2):
    r = r1
elif(r1 < r2):
    r = r2
print(r)
v = (x- (2*r)) * (y- (2*r)) * r
print(v)
#

#list.append([x, y])

#for case in range(0,entire_case):
#print(list)