package class01.yuhao;

/**
 * 阶乘之和
 */
public class FactorialSum {

    public static void main(String[] args) {
        int N = 10;
        FactorialSum factorialSum = new FactorialSum();
        System.out.println(factorialSum.factorialSum1(N));
        System.out.println(factorialSum.factorialSum2(N));
    }

    public long factorialSum1(int n) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            // 每个数都计算一次阶乘，然后累加起来
            result += factorial(i);
        }
        return result;
    }

    /**
     * 计算 n 的阶乘
     */
    private long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    //------------------------------------------------------------------------------------------------------------------

    public long factorialSum2(int n) {
        long temp = 1;
        long result = 0;
        for (int i = 1; i <= n; i++) {
            temp *= i;
            result += temp;
        }
        return result;
    }
}
