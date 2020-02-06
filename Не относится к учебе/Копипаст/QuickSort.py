def partition(arr, l, r):
    p = l
    pivot = arr[p]
    l += 1
    i = l
    while i <= r:
        if arr[i] <= pivot:
            arr[i], arr[l] = arr[l], arr[i]
            l += 1
        i += 1
    l -= 1
    arr[p], arr[l] = arr[l], arr[p]
    return l


def quicksort(array, l, r):
    if l < r:
        sorted = 1
        for i in range(l, r):
            if array[i] > array[i + 1]:
                sorted = 0
                break
        if sorted == 1:
            return
        split = partition(array, l, r)
        quicksort(array, l, split - 1)
        quicksort(array, split + 1, r)


n = int(input())
a = list(map(int, input().split()))
quicksort(a, 0, n - 1)
for i in a:
    print(i, end=' ')
