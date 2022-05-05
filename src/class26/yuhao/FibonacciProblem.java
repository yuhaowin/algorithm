package class26.yuhao;

/**
 * |F(N),F(N-1)|=|F(N-1),F(N-2)| * |a,b|
 * |c,d|
 * 求斐波那契数列矩阵乘法的方法
 * 1、斐波那契数列的线性求解 O(N) 的方式非常好理解
 * 2、同时利用线性代数，也可以改写出另一种表示: |F(N),F(N-1)|=|F(2),F(1)| * 某个二阶矩阵的 N-2 次方行列式
 * 3、求出这个二阶矩阵，进而最快求出这个二阶矩阵的 N-2 次方
 * 线性代数就是为了解决严格递推问题的
 */
public class FibonacciProblem {

    public static void main(String[] args) {
        int n = 10;
        FibonacciProblem fibonacciProblem = new FibonacciProblem();
        System.out.println(fibonacciProblem.recursive(n) == fibonacciProblem.f(n));
        for (int i = 1; i < 20; i++) {
            System.out.println(fibonacciProblem.f(i));
        }
    }

    public int recursive(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * F1=1,F2=1,F3=2,F4=3,F5=5
     * |3,2|=|2,1|*|ab/cd|
     * |5,3|=|3,2|*|ab/cd|
     * 3=2a+c
     * 2=2b+d
     * 5=3a+2c
     * 3=3b+2d
     * a=1,c=1,b=1,d=0
     */
    public int f(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {
                {1, 1},
                {1, 0}
        };
        int[][] res = matrixPower(base, n - 2);
        return 1 * res[0][0] + 1 * res[1][0];
    }

    //------------------------------------------------------------------------------------------------------------------

    public int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        // res = 矩阵中的1
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        // 矩阵1次方
        int[][] t = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = matrixMultiplication(res, t);
            }
            t = matrixMultiplication(t, t);
        }
        return res;
    }

    // 两个矩阵乘完之后的结果返回
    private int[][] matrixMultiplication(int[][] a, int[][] b) {
        int n = a.length;
        int m = b[0].length;
        int k = a[0].length; // a的列数同时也是b的行数
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int c = 0; c < k; c++) {
                    ans[i][j] += a[i][c] * b[c][j];
                }
            }
        }
        return ans;
    }
}
