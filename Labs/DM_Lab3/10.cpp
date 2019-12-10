#include <cstdio>
#include <cstring>

using namespace std;

inline void readInt(int *N);

inline void writeUInt(unsigned int x);

int main() {
    int n, i, ii;
    unsigned long long n_pow;
    readInt(&n);
    i = n -1;
    if (n == 1)
        n_pow = 1;
    else
        n_pow = 2 << (n - 2);
    unsigned int raz[n];
    memset(raz, 1, n);
    while (n_pow--) {
        for (ii = 0; ii < n; ii++)
            if (raz[ii])
                writeUInt(raz[ii]);
        putc('\n', stdout);
        if (raz[i] != 1) {
            raz[i]--;
            raz[++i]++;
        } else {
            ii = 1;
            while (!--raz[i--])
                ii++;
            i += 2;
            raz[i] += ii;
        }
    }
    return 0;
}

inline void readInt(int *N) {
    int s = 1, x = 0, c = getc(stdin);
    while (c <= 32)
        c = getc(stdin);
    if (c == '-')
        s = -1, c = getc(stdin);
    while ('0' <= c && c <= '9')
        x = x * 10 + c - '0', c = getc(stdin);
    *N = x * s;
}

inline void writeUInt(unsigned int x) {
    char s[15];
    int n = 0;
    while (x || !n)
        s[n++] = '0' + x % 10, x /= 10;
    while (n--)
        putc(s[n], stdout);
    putc(' ', stdout);
}
