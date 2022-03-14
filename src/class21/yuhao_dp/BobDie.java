package class21.yuhao_dp;

/**
 * 给定 5 个参数, N、M、row、col、k
 * <p>
 * 表示在 N*M 的区域上，醉汉 Bob 初始在 (row,col) 位置
 * <p>
 * Bob 一共要迈出 k 步，且每步都会等概率向上下左右四个方向走一个单位
 * <p>
 * 任何时候 Bob 只要离开 N*M 的区域，就直接死亡
 * <p>
 * 返回 k 步之后，Bob 还在 N*M 的区域的概率
 */
public class BobDie {

  public static void main(String[] args) {
    BobDie bobDie = new BobDie();
    int N = 50;
    int M = 50;
    int row = 6;
    int column = 6;
    int k = 15;
    long startTime = System.currentTimeMillis();
    int liveCount = bobDie.process(N, M, row, column, k);
    System.out.println(System.currentTimeMillis() - startTime + " ms");
    System.out.println(
        String.format("live count: %s , probability: %s", liveCount, liveCount / Math.pow(4, k)));

    startTime = System.currentTimeMillis();
    System.out.println(bobDie.dp(N, M, row, column, k));
    System.out.println(System.currentTimeMillis() - startTime + " ms");
  }


  private int process(int N, int M, int row, int col, int k) {
    return recursive(N, M, row, col, k);
  }

  private int recursive(int N, int M, int currentRow, int currentCol, int rest) {
    // base case
    if (currentRow < 0 || currentRow >= N) {
      return 0;
    }
    if (currentCol < 0 || currentCol >= M) {
      return 0;
    }

    // 当剩余步数为 0 时，搜集到一种成功的方法。
    if (rest == 0) {
      return 1;
    }

    // 从 [row,col] 位置向上下左右四个方向走 rest-1 的方法数。
    int up = recursive(N, M, currentRow - 1, currentCol, rest - 1);
    int down = recursive(N, M, currentRow + 1, currentCol, rest - 1);
    int left = recursive(N, M, currentRow, currentCol - 1, rest - 1);
    int right = recursive(N, M, currentRow, currentCol + 1, rest - 1);

    return up + down + left + right;
  }

  //------------------------------------------------------------------------------------------------

  private int dp(int N, int M, int row, int col, int k) {
    int[][][] dp = new int[N + 1][M + 1][k + 1];

    for (int i = 0; i < N + 1; i++) {
      for (int j = 0; j < M + 1; j++) {
        dp[i][j][0] = 1;
      }
    }

    for (int rest = 1; rest <= k; rest++) {
      for (int currentRow = 0; currentRow < N; currentRow++) {
        for (int currentCol = 0; currentCol < M; currentCol++) {
          int up = pick(dp, currentRow - 1, currentCol, rest - 1);
          int down = pick(dp, currentRow + 1, currentCol, rest - 1);
          int left = pick(dp, currentRow, currentCol - 1, rest - 1);
          int right = pick(dp, currentRow, currentCol + 1, rest - 1);
          dp[currentRow][currentCol][rest] = up + down + left + right;
        }
      }
    }

    return dp[row][col][k];
  }

  private int pick(int[][][] dp, int currentRow, int currentCol, int rest) {
    int N = dp.length;
    int M = dp[0].length;

    if (currentRow < 0 || currentRow >= N) {
      return 0;
    }
    if (currentCol < 0 || currentCol >= M) {
      return 0;
    }

    return dp[currentRow][currentCol][rest];
  }
}
