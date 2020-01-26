#Problem ID: whatdoesthefoxsay

testCase = int(input())
entire_result_list = []
for x in range(testCase):
    s = input().split()
    result = []
    flag = True
    word = []

    while flag:
        temp = str(input())
        if temp == "what does the fox say?":
            flag = False
            break
        temp = temp.split()
        if temp[0] == "fox":
            continue
        else:
            word.append(temp[len(temp)-1])

    for i in range(0, len(s)):
        if s[i] in word:
            continue
        else:
            result.append(s[i])
    else:
        s = ""
        for i in result:
            s += i+' '
        else:
            entire_result_list.insert(x, s)
else:
    for result in entire_result_list:
        print(result)
