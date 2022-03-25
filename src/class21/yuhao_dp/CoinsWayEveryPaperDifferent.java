package class21.yuhao_dp;

/**
 * arr 是货币数组，其中的值都是正数。再给定一个正数 aim。
 * <p>
 * 每个值都认为是一张货币， 即便是值相同的货币也认为每一张都是不同的，
 * <p>
 * 返回组成 aim 的方法数 例如：arr = {1,1,1}、aim = 2
 * <p>
 * 第 0 个和第 1 个能组成 2，第 1 个和第 2 个能组成 2，第 0 个和第 2 个能组成 2
 * <p>
 * 一共就 3 种方法，所以返回 3
 */
public class CoinsWayEveryPaperDifferent {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1};
        int aim = 2;
        CoinsWayEveryPaperDifferent wayEveryPaperDifferent = new CoinsWayEveryPaperDifferent();
        System.out.println(wayEveryPaperDifferent.process(arr, aim));
        System.out.println(wayEveryPaperDifferent.dp(arr, aim));
    }

    private int process(int[] arr, int arm) {
        return recursive(arr, 0, arm);
    }

    private int recursive(int[] arr, int index, int arm) {
        if (arr.length == index) {
            return arm == 0 ? 1 : 0;
        } else {
            return recursive(arr, index + 1, arm - arr[index]) + recursive(arr, index + 1, arm);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    private int dp(int[] arr, int arm) {
        int[][] dp = new int[arr.length + 1][arm + 1];
        dp[arr.length][0] = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= arm; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j - arr[i] >= 0) {
                    dp[i][j] += dp[i + 1][j - arr[i]];
                }
            }
        }
        return dp[0][arm];
    }
}
