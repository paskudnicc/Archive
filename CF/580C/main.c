#include <stdio.h>
#include <stdlib.h>

#define max(a,b) a > b ? a : b;
#define START_SIZE 16

typedef struct {
    int* content;
    size_t msz;
    size_t sz;
} List;


List* init() {
    List *new_list = malloc(sizeof(List));
    new_list->content = malloc(START_SIZE * sizeof(int));
    new_list->msz = START_SIZE;
    new_list->sz = 0;
    return new_list;
}


void resize(List* list) {
    list->msz *= 1.5;
    list->content = realloc(list->content, list->msz * sizeof(int));
}


void add(List* list, int x) {
    if (list->sz >= list->msz) {
        resize(list);
    }
    list->content[list->sz] = x;
    list->sz++;
}


int **arr_init(int n, int m) {
    int **arr = malloc(n * sizeof(int*) + n * m * sizeof(int));
    arr[0] = (int*) (arr + n);
    for (int i = 0; i < n; ++i) {
        arr[i] = arr[0] + i * m;
    }
    return arr;
}

// ver[0][i] - size of cat group starting in i
// ver[1][i] - parent of i
// ver[2][i] - max cat group from i and upper
// ver[2][i] < 0: this node is not calculated
// ver[2][i] == -2 - this is a leaf
// ver[2][i] == -1 - this is not a leaf

void calculate(int **ver, int x) {
    int par = ver[1][x];
    if (ver[2][par] == -1) {
        calculate(ver, par);
    }
    if (ver[0][x]) {
        ver[0][x] = ver[0][par] + 1;
    }
    ver[2][x] = max(ver[0][x], ver[2][par]);
}


void list2tree(List** prepare, int** ver, int x) {
    for (int i = 0; i < prepare[x]->sz; ++i) {
        int child = prepare[x]->content[i];
        if (ver[2][child] == -2) {
            ver[2][x] = -1;
            ver[1][child] = x;
            list2tree(prepare, ver, child);
        }
    }
}


int main() {
    int n, c;
    scanf("%d %d", &n, &c);
    List** prepare = malloc(n * sizeof(List*));
    for (int i = 0; i < n; ++i) {
        prepare[i] = init();
    }
    int **ver = arr_init(3, n);
    for (int i = 0; i < n; ++i) {
        scanf("%d", &ver[0][i]);
        ver[2][i] = -2;
    }
    for (int i = 1; i < n; ++i) {
        int x, y;
        scanf("%d %d", &x, &y);
        add(prepare[x - 1], y - 1);
        add(prepare[y - 1], x - 1);
    }
    list2tree(prepare, ver, 0);
    ver[2][0] = ver[0][0];
    int r = 0;
    for (int i = 0; i < n; ++i) {
        if (ver[2][i] == -2) {
            calculate(ver, i);
            if (ver[2][i] <= c) {
                r++;
            }
        }
    }
    printf("%d\n", r);
    free(ver);
    for (int i = 0; i < n; ++i) {
        free(prepare[i]);
    }
    free(prepare);
    return 0;
}