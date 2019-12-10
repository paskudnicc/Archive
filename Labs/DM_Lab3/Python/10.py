i = 0
n = int(input())
n_pow = 2 << (n - 2);
if n == 1:
    n_pow = 1;
raz = [0] * n
for _ in range(n_pow -1, -1, -1):
    for i in range(n):
        print(raz[i], end=' ')
    print('\n')
    if raz[i] != 1:
        raz[i] -= 1
        i += 1
        raz[i] += 1
    else:
        ii = 1
        while (!--raz[i--])
            ii++;
        i += 2;
        raz[i] += ii;