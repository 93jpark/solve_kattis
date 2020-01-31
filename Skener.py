print('Skener')

import numpy as np

row, col, zr, zc = [int(x) for x in input().split()]

list = []
result = []
for x in range(0,row):
    input_row = input()
    temp = []
    for y in range(0,col):
        temp.append(input_row[y])
    list.append(temp)


arr = np.array(list)
print(arr)
print()
print(arr[:1,])


"""

for x in range(0, row):
    temp_str = "";
    for r in range(0, zr):
        for y in range(0, col):
            for c in range(0, zc):
                temp_str += arr[x, y]
    result.append(temp_str)
    print(temp_str)
else:
    print(result)

"""