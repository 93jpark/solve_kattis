print('Skener')

import numpy as np

row, col, zr, zc = [int(x) for x in input().split()]

list = []
for x in range(0,row):
    input_row = input()
    temp = []
    for y in range(0,col):
        temp.append(input_row[y])
    list.append(temp)


arr = np.array(list)
print(arr)

#for x in range(row):