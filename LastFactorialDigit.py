# problem ID: lastfactorialdigit

times = int(input())
list = []

if times > 10:
    print("you exceed the limit. It must be equal or less then 10")
else:
    for x in range(times):
        num = int(input())
        temp = 1
        for x in range(1,num+1):
            temp *= x
            temp %= 10
        else:
            list.append(temp)
    else:
        for x in list:
            print(x)
