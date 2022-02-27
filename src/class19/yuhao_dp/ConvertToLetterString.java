package class19.yuhao_dp;

/**
 * 规定1和A对应、2和B对应、3和C对应、11 和K对应、26和Z对应
 * <p>
 * 那么一个数字字符串比如“111”就可以转化为"AAA"、"KA"和"AK"
 * <p>
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 */
public class ConvertToLetterString {

  public static void main(String[] args) {

    ConvertToLetterString convert = new ConvertToLetterString();
    convert.test("111111111111111111111111111111111111111111111");
  }

  public void test(String str) {
    char[] array = str.toCharArray();
    long start = System.currentTimeMillis();
    System.out.println(process(array, 0));
    System.out.println(System.currentTimeMillis() - start);
    start = System.currentTimeMillis();
    System.out.println(processDp(array));
    System.out.println(System.currentTimeMillis() - start);
  }

  private int process(char[] array, int index) {
    if (index == array.length) {
      return 1;
    }

    if (array[index] == '0') {
      return 0;
    }

    int ways = process(array, index + 1);

    if (index + 1 < array.length && (array[index] - '0') * 10 + (array[index + 1] - '0') < 27) {
      ways += process(array, index + 2);
    }

    return ways;
  }

  private int processDp(char[] array) {
    int[] dp = new int[array.length + 1];
    dp[array.length] = 1;
    for (int index = dp.length - 2; index >= 0; index--) {
      if (array[index] != '0') {
        int ways = dp[index + 1];
        if (index + 1 < array.length && (array[index] - '0') * 10 + (array[index + 1] - '0') < 27) {
          ways += dp[index + 2];
        }
        dp[index] = ways;
      }
    }
    return dp[0];
  }
}
