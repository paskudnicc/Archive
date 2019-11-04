#include <iostream>
#include <algorithm>

using namespace std;

void swap(double* a, double* b) {
    double t = *a;
    *a = *b;
    *b = t;
}

void insertion_sort(double* arr, int l, int r) {
    for (int i = l; i < r; ++i) {
        for (int j = i; j > l; --j) {
            if (arr[j - 1] > arr[j]) {
                swap(&arr[j], &arr[j - 1]);
            } else {
                break;
            }
        }
    }
}

pair<int, int> partition(double* arr, int l, int r, double pivot) {
    int start = l;
    while (1) {
        while (l <= r) {
            if (arr[l] <= pivot) {
                l += 1;
            } else {
                break;
            }
        }
        while (l <= r) {
            if (arr[r] > pivot) {
                r -= 1;
            } else {
                break;
            }
        }
        if (l < r) {
            swap(&arr[l], &arr[r]);
            l += 1;
            r -= 1;
        } else {
            int answ = r;
            r = start;
            while (1) {
                while (l <= r) {
                    if (arr[r] == pivot) {
                        r -= 1;
                    } else {
                        break;
                    }
                }
                while (l <= r) {
                    if (arr[l] != pivot) {
                        l += 1;
                    } else {
                        break;
                    }
                }
                if (l < r) {
                    swap(&arr[l], &arr[r]);
                    l += 1;
                    r -= 1;
                } else {
                    break;
                }
            }
            pair <int, int> phuckcpp;
            phuckcpp.first = r + 1;
            phuckcpp.second = answ;
            return phuckcpp;
        }
    }
}

int median_of_medians(double * a, int left, int right, int k) {
    if (right - left <= 5) {
        insertion_sort(a, left, right);
        return left + k;
    }

    int blocks = (left + right) / 5;
    int b = left, c = left;
    for (int i = 0; i < blocks; ++i) {
        insertion_sort(a, left + i * 5, left + (i + 1) * 5);
        b += 2;
        swap(&a[b], &a[c]);
        c += 1;
        b += 3;
    }
    int pivot_index = median_of_medians(a, left, left + blocks, blocks / 2);
    pair <int, int> app;
    app = partition(a, left, right - 1, a[pivot_index]);

    if (k < app.first) {
        return median_of_medians(a, left, app.first, k);
    }
    if (k <= app.second) {
        return app.first;
    }
    return median_of_medians(a, app.second + 1, right, k - app.second - 1);
}

int n, k;

double summ(double cftnt, double** vw, double* prep) {

    for (int j = 0; j < n; ++j) {
        prep[j] = vw[j][0] - vw[j][1] * cftnt;
    }
    median_of_medians(prep, 0, n, k - 1);
    double sum = 0;
    for (int i = n - 1; i < n; ++i) {
        sum += prep[i];
    }
    return sum;
}
int msort (double** array, unsigned int n, unsigned int m = 1, unsigned int target = 0) {
    unsigned int d, i, j, p1, p2, e1, e2;
    double **temp;
    temp = new double* [n];
    for (i = 0; i < n; i++) {
        temp[i] = array[i];
    }
    if (n <= 1) {
        return 0;
    }
    for (d = 1; d < n; d *= 2) {
        for (i = 0; i + d < n; i += d * 2) {
            p1 = i;
            j = i;
            p2 = i + d;
            e1 = p2;
            e2 = min(n, i + d * 2);
            while (p1 + p2 < e1 + e2) {
                if (p1 == e1 || (p2  < e2 && array[p2][target] < array[p1][target])) {
                    temp[j++] = array[p2++];
                } else {
                    temp[j++] = array[p1++];
                }
            }
        }
        for (i = 0; i < n; i++) {
            array[i] = temp[i];
        }
    }
    delete[] (temp);
    return 1;
}

int main() {
    cin >> n >> k;
    double** vw = new double* [n];
    double * prep = new double [n];
    for (int i = 0; i < n; ++i) {
        vw[i] = new double [2];
        cin >> vw[i][0] >> vw[i][1];
    }

    double minc = 0;
    double maxc = 10000000;
    for (int i = 0; i < 50; ++i) {
        double c = (minc + maxc) / 2;
        if (summ(c, vw, prep) < 0) {
            maxc = c;
        } else {
            minc = c;
        }
    }
    for (int i = 0; i < n; ++i) {
        vw[i][0] = vw[i][0] - vw[i][1] * maxc;
        vw[i][1] = i + 1;
    }
    msort(vw, n, 2, 0);
    for (int i = n - k; i < n; ++i) {
        cout << vw[i][1] << '\n';
    }
    return 0;
}