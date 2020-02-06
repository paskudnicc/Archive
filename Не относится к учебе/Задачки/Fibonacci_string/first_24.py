n = int(input())
a = 'a'
b = 'b'
for i in range(n - 1):
    b, a = (b + a)[:25], b[:25]
print(a)
