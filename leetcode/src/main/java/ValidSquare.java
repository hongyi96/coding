import java.util.Arrays;

/**
 * @Author hongyi
 * @Date 2022/7/29 16:09
 */

public class ValidSquare {
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //求出6条边，四条边长和两条对角线。
        if (p1[0] == p2[0] && p1[1] == p2[1]) {
            return false;
        }
        long[] l = new long[6];
        l[0] = len(p1, p2);
        l[1] = len(p1, p3);
        l[2] = len(p1, p4);
        l[3] = len(p2, p3);
        l[4] = len(p2, p4);
        l[5] = len(p3, p4);
        //对角线一定长于边长
        Arrays.sort(l);
        return l[0] == l[1] && l[0] == l[2] && l[0] == l[3] && l[4] == l[5];
    }

    public static long len(int[] x, int[] y) {
        return (long) (x[0] - y[0]) * (x[0] - y[0]) + (long) (x[1] - y[1]) * (x[1] - y[1]);
    }
}
