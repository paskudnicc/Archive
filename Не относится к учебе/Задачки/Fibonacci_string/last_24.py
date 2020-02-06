import re


def count_substrings(string, substring):
    substring_re = '(?=(%s))' % re.escape(substring)
    return len(re.findall(substring_re, string))


# copy paste


n = int(input())
test_str = input()

res = [0] * 45

arr = [''] * 10
for i in range(10):
    a = 'A'
    b = 'B'
    for _ in range(i):
        b, a = (b + a), b
    arr[i] = a
    res[i] = count_substrings(a, test_str)

l = len(test_str) - 1

c0 = count_substrings(arr[9][-l:] + arr[8][:l], test_str)
c1 = count_substrings(arr[8][-l:] + arr[8][:l], test_str)

for i in range(10, n):
    if i % 2 == 0:
        res[i] = c0 + res[i - 1] + res[i - 2]
    else:
        res[i] = c1 + res[i - 1] + res[i - 2]

print(res[n - 1])