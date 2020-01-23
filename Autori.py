s = str(input())

letter=[]

for x in s:
    if s[x] == -:
      letter.append(s[x+1])
else:
    print(letter)