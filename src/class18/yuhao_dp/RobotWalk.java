package class18.yuhao_dp;

/**
 * 假设有排成一行的 N 个位置，记为 1~N，N 一定大于或等于 2
 * <p>
 * 开始时机器人在其中的 M 位置上( M 一定是 1~N 中的一个)
 * 如果机器人来到 1 位置，那么下一步只能往右来到 2 位置
 * 如果机器人来到 N 位置，那么下一步只能往左来到 N-1 位置；
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走
 * 规定机器人必须走 K 步，最终能来到 P 位置( P 也是 1~N 中的一个)的方法有多少种
 * 给定四个参数 N、M、K、P，返回方法数。
 */
public class RobotWalk {

    public static void main(String[] args) {
        int N = 5;
        int start = 2;
        int aim = 4;
        int K = 6;
        RobotWalk robotWalk = new RobotWalk();
        System.out.println(robotWalk.way1(N, start, aim, K));
        System.out.println(robotWalk.way2(N, start, aim, K));
        System.out.println(robotWalk.way3(N, start, aim, K));
    }

    //------------------------------------------------------------------------------------------------------------------

    private int way1(int N, int start, int aim, int K) {
        return proces1(start, K, aim, N);
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
    private int proces1(int cur, int rest, int aim, int N) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        // rest > 0
        if (cur == 1) { // 1 -> 2
            return proces1(2, rest - 1, aim, N);
        }
        if (cur == N) {  // N-1 <- N
            return proces1(N - 1, rest - 1, aim, N);
        }
        return proces1(cur - 1, rest - 1, aim, N) + proces1(cur + 1, rest - 1, aim, N);
    }

    // 另外一种处理边界的方案
    private int process0(int cur, int rest, int aim, int N) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        // rest > 0
        if (cur < 1 || cur > N) {
            return 0;
        }
        int p1 = process0(cur - 1, rest - 1, aim, N);
        int p2 = process0(cur + 1, rest - 1, aim, N);
        return p1 + p2;
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * 从顶向下的动态规划（记忆化搜索）
     */
    private int way2(int N, int start, int aim, int K) {
        int[][] cache = new int[N + 1][K + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                cache[i][j] = -1;
            }
        }
        return process2(start, K, aim, N, cache);
    }

    private int process2(int cur, int rest, int aim, int N, int[][] cache) {
        if (cache[cur][rest] != -1) {
            return cache[cur][rest];
        }
        int answer;
        if (rest == 0) {
            answer = cur == aim ? 1 : 0;
        } else if (cur == 1) { // 1 -> 2
            answer = process2(2, rest - 1, aim, N, cache);
        } else if (cur == N) {  // N-1 <- N
            answer = process2(N - 1, rest - 1, aim, N, cache);
        } else {
            answer = process2(cur - 1, rest - 1, aim, N, cache) + process2(cur + 1, rest - 1, aim, N, cache);
        }
        cache[cur][rest] = answer;
        return answer;
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * 动态规划 - 填表
     */
    private int way3(int N, int start, int aim, int K) {
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
