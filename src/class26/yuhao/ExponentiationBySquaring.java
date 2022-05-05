package class26.yuhao;

/**
 * 快速幂 平方求幂
 */
public class ExponentiationBySquaring {
    public static void main(String[] args) {
        int x = 10;
        int n = 3;

        ExponentiationBySquaring squaring = new ExponentiationBySquaring();
        long result1 = squaring.pow(x, n);
        double result2 = Math.pow(x, n);

        System.out.println(result1);
        System.out.println(result2);
    }

    public long pow(int x, int n) {
        int ans = 1;
        while (n != 0) {
            //如果n的当前末位为1
            if ((n & 1) == 1) {
                ans *= x;  //ans乘上当前的a
            }
            x *= x;        //a自乘
            n >>= 1;       //n往右移一位
        }
        return ans;
    }
}
