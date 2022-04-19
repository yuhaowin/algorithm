package class19.yuhao_dp;

/**
 * 规定1和A对应、2和B对应、3和C对应、11和K对应、26和Z对应
 * 那么一个数字字符串比如"111"就可以转化为"AAA"、"KA"和"AK"
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 */
public class ConvertToLetterString {

    public static void main(String[] args) {
        String str = "1111111111111111111111111111111111111111";
        ConvertToLetterString convert = new ConvertToLetterString();
        convert.benchmark(str);
    }

    public void benchmark(String str) {
        char[] array = str.toCharArray();
        long start = System.currentTimeMillis();
        System.out.println(String.format("共 %s 种,耗时 %s ms", dp(array), System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(String.format("共 %s 种,耗时 %s ms", process(0, array), System.currentTimeMillis() - start));
    }

    //------------------------------------------------------------------------------------------------------------------

    private int process(int index, char[] array) {
        if (index == array.length) {
            return 1;
        }
        if (array[index] == '0') {
            return 0;
        }
        int ways = process(index + 1, array);
        if (index + 1 < array.length && (array[index] - '0') * 10 + (array[index + 1] - '0') < 27) {
            ways += process(index + 2, array);
        }
        return ways;
    }

    //------------------------------------------------------------------------------------------------------------------

    private int dp(char[] array) {
        int N = array.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int index = N - 1; index >= 0; index--) {
            if (array[index] != '0') { // 等于 '0' 时是 0 种。
                int ways = dp[index + 1];
                if (index + 1 < N && (array[index] - '0') * 10 + (array[index + 1] - '0') < 27) {
                    ways += dp[index + 2];
                }
                dp[index] = ways;
            }
        }
        return dp[0];
    }
}
