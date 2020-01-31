
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

#print(arr[:,0])

for y in range(zc):
    temp_str = ""
    for x in range(zr):
        for i in arr[:x]:
            print(i)

print(temp_str)

"""
for x in range(0, row):
    temp_str = "";
    for r in range(0, zr):
        for y in range(0, col):
            for c in range(0, zc):
                temp_str += arr[x, y]

else:
    print(result)
"""