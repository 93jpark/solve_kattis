# Problem ID:akcija

n = int(input())
d = n//3
list = []
sum = 0
for x in range(0, n):
    list.append(int(input()))


list.sort()
list.reverse()
#print(list)
#print(list)


for x in range(0, n):
    if x%3 == 2:
        if x!=0:
            list[x] = 0
else:
    #print(list)
    for x in list:
        sum += x
    else:
        print(sum)

