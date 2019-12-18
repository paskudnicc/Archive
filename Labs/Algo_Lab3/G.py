skobki = input()

lenn = len(skobki)
inf = 99999999999999
dp = [None] * lenn
for i in range(lenn):
    dp[i] = [0] * lenn

for r in range(lenn):
    dp[r][r] = 1
    for l in range(r - 1, -1, -1):
        if skobki[l] == '{' and skobki[r] == '}' or \
        skobki[l] == '(' and skobki[r] == ')' or \
        skobki[l] == '[' and skobki[r] == ']':
            min = dp[l + 1][r - 1]
        else:
            min = inf
        for k in range(l, r):
            if dp[k + 1][r] + dp[l][k] < min:
                min = dp[k + 1][r] + dp[l][k]
                # bestDiv = k
        dp[l][r] = min

    print(*dp, sep='\n')
    print()
# x in range l, r
# dp[l][r] = dp[x + 1][r] + dp[l][x]

# 1 0 1 2 1 2 1 2
# { } ) ( ) [ ] )
# ^ v ^ ^ v ^ v ^
# + + - + + + + -

# 1 2 3 4 5 4 3 2 1 0
# ( ( ( ( ( ) ) ) ) )
# ^ ^ ^ ^ ^ v v v v v
# + + + + + + + + + +
