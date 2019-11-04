from time import *
from random import *

def insertion_sort(arr, l, r):
    for i in range(l, r):
        for j in range(i, l, -1):
            if arr[j - 1] > arr[j]:
                arr[j], arr[j - 1] = arr[j - 1], arr[j]
            else:
                break


def partition(arr, l, r, pivot):
    start = l
    while True:
        while l <= r:
            if arr[l] <= pivot:
                l += 1
            else:
                break
        while l <= r:
            if arr[r] > pivot:
                r -= 1
            else:
                break
        if l < r:
            arr[l], arr[r] = arr[r], arr[l]
            l += 1
            r -= 1
        else:
            answ = r
            l = start
            while True:
                while l <= r:
                    if arr[r] == pivot:
                        r -= 1
                    else:
                        break
                while l <= r:
                    if arr[l] != pivot:
                        l += 1
                    else:
                        break
                if l < r:
                    arr[l], arr[r] = arr[r], arr[l]
                    l += 1
                    r -= 1
                else:
                    break
            return r + 1, answ


def median_of_medians(a, left=0, right=None, k=None):
    if right - left <= 5:
        insertion_sort(a, left, right)
        return left + k

    blocks = (right - left) // 5
    b, c = left, left

    for i in range(blocks):
        insertion_sort(a, left + i * 5, left + (i + 1) * 5)
        b += 2
        a[b], a[c] = a[c], a[b]
        c += 1
        b += 3

    pivot_index = median_of_medians(a, left, left + blocks, blocks // 2)

    first_app, last_app = partition(a, left, right - 1, a[pivot_index])

    if k < first_app:
        return median_of_medians(a, left, first_app, k)

    if k <= last_app:
        return first_app
    return median_of_medians(a, last_app + 1, right, k - last_app - 1)

def summ(cftnt, maxxtime):
    time2 = time()
    for j in range(n):
        prep[j] = vw[j][0] - vw[j][1] * cftnt
    median_of_medians(prep, 0, n, k - 1)
    maxxtime = max(maxxtime, time() - time2)
    return sum(prep[n - k:])



time1 = time()
# n, k = map(int, input().split())
n = 100000
k = randrange(1, n)
prep = [None] * n
vw = [None] * n
for i in range(n):
    # vw[i] = list(map(int, input().split()))
    vw[i] = [randrange(1, 1000), randrange(1, 1000)]
minc = 0
maxc = 10000000
maxtime = time()
for i in range(30):
    c = (minc + maxc) / 2
    if summ(c, maxtime) < 0:
        maxc = c
    else:
        minc = c
for i in range(n):
    vw[i][0] = vw[i][0] - vw[i][1] * maxc
    vw[i][1] = i + 1
vw.sort()
for i in range(n - k, n):
    print(vw[i][1])
print(time() - time1, maxtime)