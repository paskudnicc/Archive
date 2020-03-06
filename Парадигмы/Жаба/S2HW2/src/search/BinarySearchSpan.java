package search;

public class BinarySearchSpan {
//  sorted (l, r) means for i=l..r - 1: a[i] >= a[i+1]

    //    ]a[l] = y, y > a[l + 1], a[r] = z, z < a[r - 1]
    // PRE: sorted(l,r) && a[r] < x <= a[l]
    public static int findIterativeUpperBound(int x, int[] a, int l, int r) {
        // INV: lStart <= l < r <= rStart && a[r] < x <= a[l] && r' - l' < r - l
        while (r - l > 1) {
            // INV: lStart <= l < r <= rStart && a[r] < x <= a[l] && r' - l' < r - l
            int m = (l + r) / 2;
            // r - l > 1 => r > 1 + l ==> l < m < r
            // lStart < m < rStart -> a[m] exists
            if (a[m] > x) {
//              lStart <= l < r <= rStart && a[r] < x <= a[l] && l < m < r && a[m] > x ==> a[l] > a[m] > x > a[r]
//              l' = m && r' = r ==> l' > l && r' = r ==> r' - l' < r - l
                l = m;
                //lStart <= l < r <= rStart && a[r] < x <= a[l] && r' - l' < r - l
            } else {
                // a[m] <= x && a[r] < x <= a[l] && lStart <= l < m < r <= rStart ==> a[r] < a[m] <= x <= a[l]
                // l' = l && r' = m -> r' < r && l' = l -> r' - l' < r - l
                r = m;
                // lStart <= l < r <= rStart && a[r] < x <= a[l] && r' - l' < r - l
            }
        }
        // l + 1 >= r  && l < r ->  l + 1 = r
        //lStart <= l < r <= rStart && a[r] < x <= a[l] && l + 1 = r ->
        // a[r] < x && a[r - 1] >= x
        return r;
    }
    // POST: R: a[R] < x && a[R - 1] >= x && a is immutable


    //    ]a[l] = y, y > a[l + 1], a[r] = z, z < a[r - 1]
    // PRE: sorted(l,r) && a[r] < x <= a[l]
    public static int findRecursiveLowerBound(int x, int[] a, int l, int r) {
        // lStart <= l < r <= rStart && a[r] < x <= a[l]
        if (r - l == 1) {
            // r - l = 1 && a[r] < x && a[l] >= x ==> (a[r] < x && a[r - 1] >= x)
            // l = r - 1 ==> a[l] >= x && a[l + 1] < x
            return l;
        }
        // lStart <= l < r <= rStart && a[r] < x <= a[l] && r > l + 1

        int m = (l + r) / 2;
        // lStart <= l < r <= rStart && a[r] < x <= a[l] && r > l + 1
        // r > l + 1 ==> l < (r + l) / 2 = m < r
        // lStart < m < rStart ==> a[m] exists

        if (a[m] >= x) {
            // x <= a[m] && a[r] < x <= a[l] && lStart <= l < m < r <= rStart ==> a[r] < x <= a[m] <= a[l]
            // l' = m && r' == r -> r' = r && l' > l -> r' - l' < r - l
            // lStart <= m < r <= rStart && a[r] < x <= a[m] && r' - l' < r - l

            return findRecursiveLowerBound(x, a, m, r);
        }
        // a[m] < x && a[r] < x <= a[l] && lStart <= l < m < r <= rStart ==> a[r] < a[m] < x <= a[l]
        // l' = l && r' = m -> r' < r && l' = l -> r' - l' < r - l
        // lStart <= l < m <= rStart && a[m] < x <= a[l] && r' - l' < r - l

        return findRecursiveLowerBound(x, a, l, m);
    }
    // POST: a[R] >= x && a[R + 1] < x && a is immutable


    //  PRE: args.length > 0, args - parseble to int && for i = 1..args.length - 2: (int)args[i] >= (int)args[i + 1]
    public static void main(String[] args) {
//        args.length > 0 => args[0] exists, parseble => we can parse
        int x = Integer.parseInt(args[0]);

        int[] a = new int[args.length - 1];
//        for i=0..a.length - 1: a[i] = 0
        for (int i = 1; i < args.length; i++) {
//            parseble => we can parse
            a[i - 1] = Integer.parseInt(args[i]);
        }
//        args is sorted(1, args.length - 1) => a is sorted(0, a.length)
        int l = findIterativeUpperBound(x, a, -1, a.length);
//        a[l] < x && a[l - 1] >= x && a is immutable
//        args is sorted(1, args.length - 1) => a is sorted(0, a.length)
        int r = findRecursiveLowerBound(x, a, -1, a.length);
//        a[r] <= x && a[r + 1] > x
//        a[l] < x, a[l:r] <= x, a[r] > x
        System.out.println(l + " " + (r - l + 1));
    }
}
// Post: a[left] <= x && a[left - 1] > x && a[right] < x && a[right - 1] >= x &&
// printed i - point of insertion and span of interval = x
