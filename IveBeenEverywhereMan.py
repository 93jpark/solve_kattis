# problem ID: everywhere

cases = int(input())
result = []

for x in range(0, cases):
    num_country = int(input())
    sets = set()
    for c in range(0, num_country):
        sets.add(input())
    result.append(len(sets))

for x in result:
    print(x)