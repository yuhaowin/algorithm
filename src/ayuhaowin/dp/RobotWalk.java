package ayuhaowin.dp;

/**
 * 假设有排成一行的N个位置，记为1~N，N一定大于或等于2
 * <p>
 * 开始时机器人在其中的M位置上(M一定是1~N中的一个)
 * <p>
 * 如果机器人来到1位置，那么下一步只能往右来到2位置
 * <p>
 * 如果机器人来到N位置，那么下一步只能往左来到N-1位置；
 * <p>
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走
 * <p>
 * 规定机器人必须走K步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * <p>
 * 给定四个参数N、M、K、P，返回方法数。
 */
public class RobotWalk {

  public static void main(String[] args) {
    RobotWalk robotWalk = new RobotWalk();
    System.out.println(robotWalk.way(5, 2, 4, 6));
    System.out.println(robotWalk.way1(5, 2, 4, 6));
    System.out.println(robotWalk.way2(5, 2, 4, 6));
  }

  private int way(int N, int start, int aim, int K) {
    return process(start, K, aim, N);
  }

  /**
   * 暴力递归
   *
   * @param cur  机器人当前位置
   * @param rest 还有多少步需要走
   * @param aim  机器人的目标
   * @param N    1-N
   * @return 机器人从 cur 走 rest 步到 aim 位置的方法数
   */
  private int process(int cur, int rest, int aim, int N) {
    if (rest == 0) {
      return cur == aim ? 1 : 0;
    }
    // rest > 0
    if (cur == 1) { // 1 -> 2
      return process(2, rest - 1, aim, N);
    }
    if (cur == N) {  // N-1 <- N
      return process(N - 1, rest - 1, aim, N);
    }
    return process(cur - 1, rest - 1, aim, N) + process(cur + 1, rest - 1, aim, N);
  }

  //------------------------------------------------------------------------------------------------


  /**
   * 从顶向下的动态规划（记忆化搜索）
   */
  private int way1(int N, int start, int aim, int K) {
    int[][] dp = new int[N + 1][K + 1];
    for (int i = 0; i < N + 1; i++) {
      for (int j = 0; j < K + 1; j++) {
        dp[i][j] = -1;
      }
    }
    return process1(start, K, aim, N, dp);
  }

  private int process1(int cur, int rest, int aim, int N, int[][] dp) {
    if (dp[cur][rest] != -1) {
      return dp[cur][rest];
    }
    int answer;
    if (rest == 0) {
      answer = cur == aim ? 1 : 0;
    } else if (cur == 1) { // 1 -> 2
      answer = process1(2, rest - 1, aim, N, dp);
    } else if (cur == N) {  // N-1 <- N
      answer = process1(N - 1, rest - 1, aim, N, dp);
    } else {
      answer = process1(cur - 1, rest - 1, aim, N, dp) + process1(cur + 1, rest - 1, aim, N, dp);
    }
    dp[cur][rest] = answer;
    return answer;
  }

  //------------------------------------------------------------------------------------------------


  /**
   * 动态规划 - 填表
   */
  private int way2(int N, int start, int aim, int K) {
    int[][] dp = new int[K + 1][N + 1];
    dp[0][aim] = 1;
    for (int i = 1; i < K + 1; i++) {
      dp[i][1] = dp[i - 1][2];

      for (int j = 2; j < N; j++) {
        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
      }

      dp[i][N] = dp[i - 1][N - 1];
    }
    return dp[K][start];
  }
}
