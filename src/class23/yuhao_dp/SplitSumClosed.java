package class23.yuhao_dp;

import java.util.Arrays;

/**
 * 给定一个正数数组arr
 * <p>
 * 请把 arr 中所有的数分成两个集合，尽量让两个集合的累加和接近
 * <p>
 * 返回：最接近的情况下，较小集合的累加和
 */
public class SplitSumClosed {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 100};
        SplitSumClosed splitSumClosed = new SplitSumClosed();
        System.out.println(splitSumClosed.process(arr));
        System.out.println(splitSumClosed.dp(arr));
    }


    public int process(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        return recursive(arr, 0, sum / 2);
    }

    /**
     * 从 index 位置到最后，返回最累加和，最接近但是不超过 rest 的值
     */
    public int recursive(int[] arr, int index, int rest) {
        if (index == arr.length) {// index 到最后了，没有数了
            return 0;
        }
        // 不要 index 位置的数
        int p1 = recursive(arr, index + 1, rest);
        int p2 = 0;
        if (arr[index] <= rest) {
            p2 = arr[index] + recursive(arr, index + 1, rest - arr[index]);
        }
        return Math.max(p1, p2);
    }


    //------------------------------------------------------------------------------------------------------------------


    public int dp(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        sum = sum / 2;
        int N = arr.length + 1;
        int[][] dp = new int[N][sum+1];
        for (int index = arr.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= sum; rest++) {
                // 不要 index 位置的数
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                if (arr[index] <= rest) {
                    p2 = arr[index] + dp[index + 1][rest - arr[index]];
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][sum];
    }
}
