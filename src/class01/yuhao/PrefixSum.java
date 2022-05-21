package class01.yuhao;

/**
 * 前缀和
 */
public class PrefixSum {

    public static void main(String[] args) {
        int[] source = {3, 2, 5, 3, 7, 1, 8, 4, 9, 3, 8, 4, 0, 3, 8};
        PrefixSum prefixSum = new PrefixSum();
        prefixSum.preSum(source);
        for (int item : prefixSum.preSum) {
            System.out.print(item + " ");
        }
        System.out.println("\n" + prefixSum.get(1, 3));
    }

    private int[] preSum;

    /**
     * preSum i 位置表示: [0,i] 范围的和
     */
    public void preSum(int[] arr) {
        int N = arr.length;
        preSum = new int[N];
        preSum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
    }

    /**
     * 获取 [L,R] 范围的和
     */
    public int get(int L, int R) {
        return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
    }
}
