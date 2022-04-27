package class20.yuhao_dp;

/**
 * 有一个象棋的棋盘,然后把整个棋盘放入第一象限，棋盘的最左下角是(0,0)位置
 * 那么整个棋盘就是横坐标上 9 条线、纵坐标上 10 条线的区域
 * 现在给你三个 参数x,y,step
 * 返回 "马" 从(0,0)位置出发，必须走 step 步,最后落在(x,y)上的方法数有多少种?
 * https://image.yuhaowin.com/2022/03/06/120814.jpg
 */
public class HorseJump {

    public static void main(String[] args) throws InterruptedException {
        int x = 7;
        int y = 7;
        int step = 10;

        HorseJump jump = new HorseJump();
        System.out.println(jump.process(0, 0, step, x, y));
        System.out.println(jump.dp(step, x, y));
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * 当前在 (a,b) 位置，跳 rest 步到达 (x,y) 位置的方法数
     */
    private int process(int a, int b, int rest, int x, int y) {
        //base case
        if (rest == 0) {// 当还是 0 步的时候，如果刚好到达目标位置，收获到一种方法数。
            return (a == x && b == y) ? 1 : 0;
        }
        if (a < 0 || a > 8 || b < 0 || b > 9) {// 如果跳出棋盘，方法数为0。
            return 0;
        }

        int p1 = process(a + 1, b + 2, rest - 1, x, y);
        int p2 = process(a + 2, b + 1, rest - 1, x, y);
        int p3 = process(a + 2, b - 1, rest - 1, x, y);
        int p4 = process(a + 1, b - 2, rest - 1, x, y);
        int p5 = process(a - 1, b - 2, rest - 1, x, y);
        int p6 = process(a - 2, b - 1, rest - 1, x, y);
        int p7 = process(a - 2, b + 1, rest - 1, x, y);
        int p8 = process(a - 1, b + 2, rest - 1, x, y);

        return p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8;
    }

    //------------------------------------------------------------------------------------------------------------------

    private int dp(int k, int x, int y) {
        int[][][] dp = new int[9][10][k + 1];
        dp[x][y][0] = 1;
        for (int rest = 1; rest <= k; rest++) {
            for (int a = 0; a < 9; a++) {
                for (int b = 0; b < 10; b++) {
                    int p1 = pick(dp, a + 1, b + 2, rest - 1);
                    int p2 = pick(dp, a + 2, b + 1, rest - 1);
                    int p3 = pick(dp, a + 2, b - 1, rest - 1);
                    int p4 = pick(dp, a + 1, b - 2, rest - 1);
                    int p5 = pick(dp, a - 1, b - 2, rest - 1);
                    int p6 = pick(dp, a - 2, b - 1, rest - 1);
                    int p7 = pick(dp, a - 2, b + 1, rest - 1);
                    int p8 = pick(dp, a - 1, b + 2, rest - 1);
                    dp[a][b][rest] = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8;
                }
            }
        }
        return dp[0][0][k];
    }

    private int pick(int[][][] dp, int x, int y, int rest) {
        if (x < 0 || x > 8 || y < 0 || y > 9) {// 如果跳出棋盘，方法数为0。
            return 0;
        } else {
            return dp[x][y][rest];
        }
    }
}
