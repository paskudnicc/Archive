#include <iostream>
#include <cstring>
using namespace std;

int fact (int n);
void bool_print (bool arr[]);

int main()
{
    int i=1, n, nn, col, t, tt;
    cin >> n;
    nn = n + 1;
    int fast_fact[n];
    for (i = 1; i <= nn; i++)
        fast_fact[i] = fact(i);
    bool num[nn];
    for (i = 0; i < fast_fact[nn]; i++)
    {
        memset(num, 0, nn);
        for (col = n; col > 0; col--)
        {
            t = (i/fast_fact[col])%(col+1);
            //bool_print(num);
            tt = 0;
            while (num[tt]) tt++;
            for (; t > 0; t--)
            {
                do
                    tt++;
                while (num [tt]);
            }
            num[tt] = 1;
            /* âûáðàòü äåéñòâèå */
            cout << tt << ' ';
        }
        tt = 0;
        while (num[tt]) tt++;
        cout << tt << '\n';
    }
    return 0;
}

int fact (int n)
{
    int f = 1;
    for (; n >= 2; n--)
        f *= n;
    return f;
}

void bool_print (bool arr[])
{
    for (int i = 0; i < sizeof(arr); i++)
        cout << arr[i] << ' ';
    cout << '\n';
}
