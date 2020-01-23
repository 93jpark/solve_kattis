s = str(input())

letter=[s[0]]

for x in range(0,len(s)):
    if s[x] == '-':
      letter.append(s[x+1])
else:
    s = ""
    for x in letter:
        s += x
    else:
        print(s)