package class23.yuhao_dp;

/**
 * N皇后问题是指在N*N的棋盘上要摆N个皇后，
 * <p>
 * 要求任何两个皇后不同行、不同列，也不在同一条斜线上
 * <p>
 * 给定一个整数n，返回n皇后的摆法有多少种。
 * <p>
 * n=1，返回1
 * <p>
 * n=2或3，2皇后和3皇后问题无论怎么摆都不行，返回0
 * <p>
 * n=8，返回92
 */
public class NQueens {

    public static void main(String[] args) {
        int N = 8;
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.process(N));
    }

    public int process(int n) {
        int[] record = new int[n + 1];
        return recursive(record, 0, n);
    }

    // 在第 i 行上放皇后，一行只放一个皇后
    public int recursive(int[] record, int i, int n) {
        // 已经填到之后一行，说明之前的决定可以形成一种方法
        if (i == n) {
            return 1;
        }
        int ways = 0;
        // 从第 0 列尝试放第 i 行的皇后
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                ways += recursive(record, i + 1, n);
            }
        }
        return ways;
    }

    // i 行，j 列
    private boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            boolean sameColumn = record[k] == j;
            boolean diagonal = Math.abs(i - k) == Math.abs(j - record[k]);
            if (sameColumn || diagonal) {
                return false;
            }
        }
        return true;
    }
}
