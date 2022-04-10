package class01.yuhao;

/**
 * @author yuhao
 * @version 5.11.0
 * @date 2021年06月27日 10:41:00
 */
public class RangeSum {

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


    public static void main(String[] args) {
        int[] source = {3, 2, 5, 3, 7, 1, 8, 4, 9, 3, 8, 4, 0, 3, 8};
        sum(source);
        System.out.println(get(1, 3));
    }
}
