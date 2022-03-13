package class21.yuhao_dp;

/**
 * arr是货币数组，其中的值都是正数。再给定一个正数aim。
 * <p>
 * 每个值都认为是一张货币， 即便是值相同的货币也认为每一张都是不同的，
 * <p>
 * 返回组成aim的方法数 例如：arf = {1，1，1}，aim = 2
 * <p>
 * 第0个和第1个能组成2，第1个和第2个能组成2，第0个和第2个能组成2
 * <p>
 * 一共就3种方法，所以返回3
 */
public class CoinsWayEveryPaperDifferent {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 1, 1};
    int aim = 2;
    CoinsWayEveryPaperDifferent t = new CoinsWayEveryPaperDifferent();
    System.out.println(t.process(arr, aim));
    System.out.println(t.dp(arr, 2));

  }

  private int process(int[] arr, int arm) {
    return test(arr, 0, arm);
  }


  private int test(int[] arr, int index, int arm) {
    if (arr.length == index) {
      return arm == 0 ? 1 : 0;
    } else {
      return test(arr, index + 1, arm - arr[index]) + test(arr, index + 1, arm);
    }
  }

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
