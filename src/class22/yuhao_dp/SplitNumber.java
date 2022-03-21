package class22.yuhao_dp;

/**
 * 给定一个正数1，裂开的方法有一种，（1）
 * <p>
 * 给定一个正数2，裂开的方法有两种，（1、1) 和 (2）
 * <p>
 * 给定一个正数3，裂开的方法有三种，（1、1、1）、（1、2)、（3)
 * <p>
 * 给定一个正数4，裂开的方法有五种，(1、1、1、1)、(1、1、2)、(1、3)、（2、 2)、(4）
 * <p>
 * 给定一个正数n，求裂开的方法数。动态规划
 * <p>
 * 优化状态依赖的技巧
 */
public class SplitNumber {

    public static void main(String[] args) {
        int n = 39;
        SplitNumber split = new SplitNumber();
        System.out.println(split.process(n));
        System.out.println(split.dp1(n));
        System.out.println(split.dp2(n));
    }

    public int process(int n) {
        return recursive(1, n);
    }

    public int recursive(int pre, int rest) {
        if (rest == 0) {
            return 1;
        }
        if (pre > rest) {
            return 0;
        }
        if (pre == rest) {
            return 1;
        }

        int ways = 0;
        for (int i = pre; i <= rest; i++) {
            ways += recursive(i, rest - i);
        }
        return ways;
    }

    //------------------------------------------------------------------------------------------------------------------

    public int dp1(int n) {
        int N = n + 1;
        int[][] dp = new int[N][N];

        for (int pre = 1; pre < N; pre++) {
            dp[pre][0] = 1;
            dp[pre][pre] = 1;
        }

        for (int pre = n - 1; pre >= 1; pre--) {
            for (int rest = pre + 1; rest <= n; rest++) {
                int ways = 0;
                for (int i = pre; i <= rest; i++) {
                    ways += dp[i][rest - i];
                }
                dp[pre][rest] = ways;
            }
        }
        return dp[1][n];
    }

    //------------------------------------------------------------------------------------------------------------------

    public int dp2(int n) {
        int N = n + 1;
        int[][] dp = new int[N][N];

        for (int pre = 1; pre < N; pre++) {
            dp[pre][0] = 1;
            dp[pre][pre] = 1;
        }

        for (int pre = n - 1; pre >= 1; pre--) {
            for (int rest = pre + 1; rest <= n; rest++) {
                dp[pre][rest] = dp[pre + 1][rest] + dp[pre][rest - pre];
            }
        }
        return dp[1][n];
    }
}
