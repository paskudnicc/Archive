#include <iostream>

using namespace std;

int msort (int** array, unsigned int n, unsigned int m = 1, unsigned int target = 0) {
    unsigned int d, i, j, p1, p2, e1, e2;
    int **temp;
    temp = new int* [n];
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
    unsigned int i, j, n, m = 1, tar = 0;
    int** array;
    bool endl = 0;
    cin >> n;
    if (n == 0) {
        cin >> n >> m >> tar;
        endl = 1;
    }
    array = new int* [n];
    for (i = 0; i < n; i++) {
        array[i] = new int [m];
        for (j = 0; j < m; j++) {
            cin >> array[i][j];
        }
    }
    msort(array, n, m, tar);
    for (i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
            cout << array[i][j] << ' ';
        }
        if (endl) {
            cout << '\n';
        }
    }
    for (i = 0; i < n; i++) {
        delete [] (array[i]);
    }
    delete[] (array);
}