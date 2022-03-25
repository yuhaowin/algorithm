package class21.yuhao_dp;

/**
 * arr 是面值数组，其中的值都是正数且没有重复。再给定一个正数 aim。
 * <p>
 * 每个值都认为是一种面值，且认为张数是无限的。
 * <p>
 * 返回组成 aim 的方法数
 * <p>
 * 例如：arr={1,2}、aim = 4
 * <p>
 * 方法如下: 1+1+1+1、1+1+2、 2+2
 * <p>
 * 一共就 3 种方法，所以返回 3
 */
public class CoinsWayNoLimit {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        int aim = 4;
        CoinsWayNoLimit wayNoLimit = new CoinsWayNoLimit();
        System.out.println(wayNoLimit.process(arr, aim));
        System.out.println(wayNoLimit.dp1(arr, aim));
        System.out.println(wayNoLimit.dp2(arr, aim));
    }

    public int process(int[] arr, int aim) {
        return recursive(arr, 0, aim);
    }

    public int recursive(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }

        int current = arr[index];
        int ways = 0;
        for (int zhang = 0; zhang * current <= rest; zhang++) {
            ways += recursive(arr, index + 1, rest - (zhang * current));
        }
        return ways;
    }

    //------------------------------------------------------------------------------------------------------------------

    public int dp1(int[] arr, int aim) {
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;

        for (int index = N - 1; index >= 0; index--) {
            int current = arr[index];
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * current <= rest; zhang++) {
                    ways += dp[index + 1][rest - (zhang * current)];
                }
                dp[index][rest] = ways;
            }
        }

        return dp[0][aim];
    }

    //------------------------------------------------------------------------------------------------------------------

    public int dp2(int[] arr, int aim) {
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;

        for (int index = N - 1; index >= 0; index--) {
            int current = arr[index];
            for (int rest = 0; rest <= aim; rest++) {
                //(index,rest) 位置依赖下面一行(index+1,rest)和左侧少一个当前面额的位置(index,rest-current)
                dp[index][rest] = dp[index + 1][rest];
                if (rest >= current) {
                    dp[index][rest] += dp[index][rest - current];
                }
            }
        }

        return dp[0][aim];
    }
}
