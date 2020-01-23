#problem ID: jewelrybox

import math

list = []
entire_case = int(input())


for case in range(0,entire_case):
    x, y = input().split()
    x = float(x)
    y = float(y)

    a = 12
    b = -4 * (x+y)
    c = x*y
    d = b**2 + (-4 * a * c)

    r1 = (-b + math.sqrt(d)) / (2*a)
    r2 = (-b - math.sqrt(d)) / (2*a)

    if(r1 > r2):
        r = r2
    elif(r1 < r2):
        r = r1

    v = (x- (2*r)) * (y- (2*r)) * r
    list.append(v)

for x in list:
    print(x)
    #print(round(x, 13))
