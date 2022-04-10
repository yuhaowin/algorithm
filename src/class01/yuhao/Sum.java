package class01.yuhao;

/**
 * @author yuhao
 * @version 5.11.0
 * @date 2021年06月26日 22:56:00
 */
public class Sum {

    public static long sum(int n) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += fun1(i);
        }
        return result;
    }

    public static long fun1(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long sum2(int n) {
        long result = 0;
        long temp = 1;
        for (int i = 1; i <= n; i++) {
            temp *= i;
            result += temp;
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(sum(10));
        System.out.println(sum2(10));
    }
}
