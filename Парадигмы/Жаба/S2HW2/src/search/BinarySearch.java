package search;

public class BinarySearch {
//    pre:
//    i <= j ==> a[i] >= a[j] ('sorted')
    public static int findIterative(int x, int[] a) {
        int l = -1;
        int r = a.length;
//        sorted && -1 <= l < r <= a.length
        int m;
//         l' = l, r' = r
//         l <= res - 1; res <= r
//         l' <= res - 1; res <= r'
//         (-1 <= l < r <= a.length) && sorted && (l = -1 or a[l] > x) && (r = a.length or a[r] <= x)
//         (-1 <= l' < r' <= a.length) && sorted && (l' = -1 or a[l'] > x) && (r' = a.length or a[r'] <= x)
        while (r - l != 1) {
//            l + 1 != r
//            INV:
//            l' = l, r' = r
//            l <= res - 1; res <= r
//            l' <= res - 1; res <= r'
//            (-1 <= l < r <= a.length) && sorted && (l = -1 or a[l] > x) && (r = a.length or a[r] <= x)
//            (-1 <= l' < r' <= a.length) && sorted && (l' = -1 or a[l'] > x) && (r' = a.length or a[r'] <= x)
            m = (l + r) / 2;
//            l + 1 != r && l < r ==> l < m < r, -1 < m < a.length
//            l' = l, r' = r
//            l <= res - 1; res <= r
//            l' <= res - 1; res <= r'
//            (-1 <= l < r <= a.length) && sorted && (l = -1 or a[l] > x) && (r = a.length or a[r] <= x)
//            (-1 <= l' < r' <= a.length) && sorted && (l' = -1 or a[l'] > x) && (r' = a.length or a[r'] <= x)
            if (a[m] > x) {
//            -1 <= k < m ==> a[k + 1] > x ==> k != res - 1 because:
//            post:
//            1) (res = a.length = 0 or
//            2) a[res - 1] > x && (res = a.length or a[res] <= x) or
//            3) res = 0 && a[res] <= x) &&
//            4) res - целое

//            1) res - 1 = res - 1, res - 1 + 1 = res
//            res - 1 + 1 = res = a.length; m < a.length; (m - 1) + 1 < a.length; res - 1 <= m - 1 ==> res - 1 + 1 < a.length - противоречие!
//            res - 1 > m - 1, res - 1 >= m

//            2) a[res - 1] > x && (res = a.length or a[res] <= x)
//            a[res - 1] > x && (res - 1 + 1 = a.length or a[res - 1 + 1] <= x)
//            res - 1 + 1 = a.length ==> res - 1 >= m
//            a[res - 1 + 1] <= x ==> res - 1 != k

//            3) res = 0 && a[res] <= x
//            res - 1 + 1 = 0 ==> res - 1 = -1 ==> m >= 0 ==> a[0] > x ==> a[res] > x - противоречие!

//            следовательно, l >= res - 1 >= m ==> l >= m

//            l < m < r, -1 < m < r <= a.length
//            ]l' = m, r' = r
//            l <= res - 1; res <= r
//            l' <= res - 1; res <= r'
//            (-1 <= l < r <= a.length) && sorted && (l = -1 or a[l] > x) && (r = a.length or a[r] <= x)
//            (-1 < l' < r <= a.length) && sorted && (a[l'] > x) && (r' = a.length or a[r'] <= x) ==>
//            (-1 <= l' < r' <= a.length) && sorted && (l' = -1 or a[l'] > x) && (r' = a.length or a[r'] <= x)
                l = m;
//            l' = l, r' = r
//            l <= res - 1; res <= r
//            l' <= res - 1; res <= r'
//            (-1 <= l < r <= a.length) && sorted && (l = -1 or a[l] > x) && (r = a.length or a[r] <= x)
//            (-1 <= l' < r' <= a.length) && sorted && (l' = -1 or a[l'] > x) && (r' = a.length or a[r'] <= x)
            } else {
//            -1 < m < k <= a.length ==> a[k - 1] <= x ==> res != k because:
//            post:
//            1) (res = a.length = 0 or
//            2) a[res - 1] > x && (res = a.length or a[res] <= x) or
//            3) res = 0 && a[res] <= x) &&
//            4) res - целое

//            1) res = k
//            res = a.length = 0
//            -1 < m < res <= a.length = 0, -1 < m < 0 - противоречие! m должно быть целым

//            2) res != a.length - доказано
//            a[res] <= x && a[res - 1] <= x && a[res - 1] > x - противоречие!

//            3) -1 < m < res = 0; -1 < m < 0 - противоречие! m должно быть целым

//            следовательно, res <= m, при этом res <= r - имеет смысл ограничить поиски

//            l < m < r, -1 <= l < m < a.length
//            ]l' = l, r' = m
//            l <= res - 1; res <= r
//            l' <= res - 1; res <= r'
//            (-1 <= l < r <= a.length) && sorted && (l = -1 or a[l] > x) && (r = a.length or a[r] <= x)
//            (-1 <= l' < r' < a.length) && sorted && (l' = -1 or a[l'] > x) && (a[r'] <= x)
//            (-1 <= l' < r' <= a.length) && sorted && (l' = -1 or a[l'] > x) && (r' = a.length or a[r'] <= x)
                r = m;
//            l' = l, r' = r
//            l <= res - 1; res <= r
//            l' <= res - 1; res <= r'
//            (-1 <= l < r <= a.length) && sorted && (l = -1 or a[l] > x) && (r = a.length or a[r] <= x)
//            (-1 <= l' < r' <= a.length) && sorted && (l' = -1 or a[l'] > x) && (r' = a.length or a[r'] <= x)
            }
        }
//        (-1 <= l < r <= a.length) && sorted && (l = -1 or a[l] > x) && (r = a.length or a[r] <= x)
//        l <= res - 1, l + 1 <= res; res <= r = l + 1 <= res ==> r = res
//        (-1 <= l < l + 1 = r <= a.length) && sorted &&
//        (l = -1 (==> r = 0) or a[l] > x) && (r = a.length (==> l = a.length - 1) or a[r] <= x)
//        -1 < r ==> 0 <= r <= a.length
//        ]a.length != 0
//        r = a.length ==> r > 0 ==> r - 1 > - 1 ==> l != -1 ==> a[l] > x ==> a[r - 1] > x
//        (r != a.length ==> a[r] <= x) && (r - 1 = l = -1 or a[r - 1] = a[l] > x)
        return r;
    }
// post:
// (res = a.length = 0 or
// a[res - 1] > x && (res = a.length or a[res] <= x) or
// res = 0 && a[res] <= x) &&
// res - целое


//    i <= j ==> a[i] >= a[j] ('sorted')
    public static int findRecursive(int x, int[] a) {
//    (-1 <= -1 < 0 <= a.length <= a.length) && sorted && (-1 == -1) && (a.length == a.length)
//    ]l = -1, r = a.length
//    (-1 <= l < r <= a.length) && sorted && (l = -1 or a[l] > x) && (r = a.length or a[r] <= x)
        return findRecursive(-1, a.length, x, a);
    }
// post:
// (res = a.length = 0 or
// a[res - 1] > x && (res = a.length or a[res] <= x) or
// res = 0 && a[res] <= x) &&
// res - целое

//    pre:
//    i <= j ==> a[i] >= a[j] ('sorted')
//    (-1 <= l < r <= a.length) && sorted && (l = -1 or a[l] > x) && (r = a.length or a[r] <= x)
    public static int findRecursive(int l, int r, int x, int[] a) {
        if (r - l == 1) {
//        l <= res - 1, l + 1 <= res; res <= r = l + 1 <= res ==> r = res
//        r - l = 1
//        r - 1 = l
//        (-1 <= l < l + 1 = r <= a.length) && sorted &&
//        (l = -1 (==> r = 0) or a[l] > x) && (r = a.length (==> l = a.length - 1) or a[r] <= x)
//        -1 < r ==> 0 <= r <= a.length
//        ]a.length != 0
//        r = a.length ==> r > 0 ==> r - 1 > - 1 ==> l != -1 ==> a[l] > x ==> a[r - 1] > x
//        (r != a.length ==> a[r] <= x) && (r - 1 = l = -1 or a[r - 1] = a[l] > x)
            return r;
        }
//      r - l != 1, l < r
        int m = (l + r) / 2;
//      l < m < r
        if (a[m] > x) {
//            -1 <= k < m ==> a[k + 1] > x ==> k != res - 1 because:
//            post:
//            1) (res = a.length = 0 or
//            2) a[res - 1] > x && (res = a.length or a[res] <= x) or
//            3) res = 0 && a[res] <= x) &&
//            4) res - целое

//            1) res - 1 = res - 1, res - 1 + 1 = res
//            res - 1 + 1 = res = a.length; m < a.length; (m - 1) + 1 < a.length; res - 1 <= m - 1 ==> res - 1 + 1 < a.length - противоречие!
//            res - 1 > m - 1, res - 1 >= m

//            2) a[res - 1] > x && (res = a.length or a[res] <= x)
//            a[res - 1] > x && (res - 1 + 1 = a.length or a[res - 1 + 1] <= x)
//            res - 1 + 1 = a.length ==> res - 1 >= m
//            a[res - 1 + 1] <= x ==> res - 1 != k

//            3) res = 0 && a[res] <= x
//            res - 1 + 1 = 0 ==> res - 1 = -1 ==> m >= 0 ==> a[0] > x ==> a[res] > x - противоречие!

//            следовательно, l >= res - 1 >= m ==> l >= m


//    m <= res - 1; res <= r
//    (-1 <= l < r <= a.length) && sorted && (l = -1 or a[l] > x) && (r = a.length or a[r] <= x)
//    (-1 <= l < m < r <= a.length) && sorted && (a[m] > x) && (r = a.length or a[r] <= x)
//    (-1 <= m < r <= a.length) && sorted && (m = -1 or a[m] > x) && (r = a.length or a[r] <= x)
            return findRecursive(m, r, x, a);
        }
//            -1 < m < k <= a.length ==> a[k - 1] <= x ==> res != k because:
//            post:
//            1) (res = a.length = 0 or
//            2) a[res - 1] > x && (res = a.length or a[res] <= x) or
//            3) res = 0 && a[res] <= x) &&
//            4) res - целое

//            1) res = k
//            res = a.length = 0
//            -1 < m < res <= a.length = 0, -1 < m < 0 - противоречие! m должно быть целым

//            2) res != a.length - доказано
//            a[res] <= x && a[res - 1] <= x && a[res - 1] > x - противоречие!

//            3) -1 < m < res = 0; -1 < m < 0 - противоречие! m должно быть целым

//            следовательно, res <= m, при этом res <= r - имеет смысл ограничить поиски

//        res <= m, res - 1 >= l
        
//    (-1 <= l < r <= a.length) && sorted && (l = -1 or a[l] > x) && (r = a.length or a[r] <= x)
//    (-1 <= l < m < r <= a.length) && sorted && (l = -1 or a[l] > x) && (a[m] <= x)
//    (-1 <= l < m <= a.length) && sorted && (l = -1 or a[l] > x) && (m = a.length or a[m] <= x)
        return findRecursive(l, m, x, a);
    }
// post:
// (res = a.length = 0 or
// a[res - 1] > x && (res = a.length or a[res] <= x) or
// res = 0 && a[res] <= x) &&
// res - целое

//    pre
//    args.length >= 1, все элементы массива args могут парситься
//    создадим массив a: int[] a = parseInt(args[i]), где i >= 1
//    i <= j ==> a[i] >= a[j] ('sorted')
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int[] a = new int [args.length - 1];
        for (int i = 1; i < args.length; i++) {
            a[i - 1] = Integer.parseInt(args[i]);
        }
//       i <= j ==> a[i] >= a[j] ('sorted')
        System.out.println(findIterative(x, a));
//        System.out.println(findRecursive(x, a));
//        System.out.println(findRecursive(2, new int[]{2, 2, 1, 1, 0}));
    }
}
// post выведено число res:
// (res = a.length = 0 or
// a[res - 1] > x && (res = a.length or a[res] <= x) or
// res = 0 && a[res] <= x) &&
// res - целое
