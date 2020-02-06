#include <stdio.h>

#define read(integer) scanf("%d", &integer)
#define print(integer) printf("%d ", integer)
#define endl printf("\n")

void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}


int partition(int* arr, int l, int r) {
    int p = l;
    int pivot = arr[p];
    l += 1;
    for (int i = l; i <= r; ++i) {
        if (arr[i] <= pivot) {
            swap(&arr[i], &arr[l]);
            ++l;
        }
    }
    swap(&arr[p], &arr[--l]);
    return l;
}


void quicksort(int* arr, int l, int r) {
    if (l < r) {
        int sorted = 1;
        for (int i = l; i < r; ++i) {
            if (arr[i] > arr[i + 1]) {
                sorted = 0;
                break;
            }
        }
        if (sorted) {
            return;
        }
        int split = partition(arr, l, r);
        quicksort(arr, l, split - 1);
        quicksort(arr, split + 1, r);
    }
}

int main() {
    int n;
    read(n);
    int a[n];
    for (int i = 0; i < n; ++i) {
        read(a[i]);
    }
    quicksort(a, 0, n - 1);
    for (int i = 0; i < n; ++i) {
        print(a[i]);
    }
    endl;
    return 0;
}