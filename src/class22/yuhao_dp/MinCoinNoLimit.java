package class22.yuhao_dp;

/**
 * arr 是面值数组，其中的值都是正数且没有重复。再给定一个正数 aim。
 * <p>
 * 每个值都认为是一种面值，且认为张数是无限的。
 * <p>
 * 返回组成 aim 的最少货币数
 */
public class MinCoinNoLimit {

    public static void main(String[] args) {
        int[] arr = new int[]{22, 30, 20, 16, 4, 17, 9, 26, 13};
        int aim = 22;
        MinCoinNoLimit noLimit = new MinCoinNoLimit();
        System.out.println(noLimit.process(arr, aim));
    }

    public int process(int[] arr, int aim) {
        return recursive(arr, 0, aim);
    }

    public int recursive(int[] arr, int index, int rest) {

        if (index == arr.length) {
            return rest == 0 ? 0 : Integer.MAX_VALUE;
        }

        int count = Integer.MAX_VALUE;

        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {

            int next = recursive(arr, index + 1, rest - zhang * arr[index]);

            if (next != Integer.MAX_VALUE) {
                count = Math.min(count, next + zhang);
            }
        }

        return count;
    }

    //------------------------------------------------------------------------------------------------------------------

    public int dp(int[] arr, int aim) {
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];

        for (int i = 1; i <= aim; i++) {
            dp[N][i] = Integer.MAX_VALUE;
        }

        return dp[0][aim];
    }
}
