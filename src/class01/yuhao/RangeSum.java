package class01.yuhao;

/**
 * 前缀和
 */
public class RangeSum {

    public static void main(String[] args) {
        int[] source = {3, 2, 5, 3, 7, 1, 8, 4, 9, 3, 8, 4, 0, 3, 8};
        sum(source);
        System.out.println(get(1, 3));
    }

    public static int[] preSum;

    public static void sum(int[] arr) {
        int N = arr.length;
        preSum = new int[N];
        preSum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
    }

    public static int get(int L, int R) {
        return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
    }
}
