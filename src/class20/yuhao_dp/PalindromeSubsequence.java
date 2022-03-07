package class20.yuhao_dp;

/**
 * 给定一个字符串str，返回这个字符串的最长回文子序列长度
 * <p>
 * 比如：str = “a12b3c43def2ghilkpm“
 * <p>
 * 最长回文子序列是 “1234321〞或者 “123c321”，返回长度7
 * <p>
 * 回文的意思是：对称
 * <p>
 * 子序列：可以不连续
 * <p>
 * 解法一：一个字符串的最长回文子序列 == 这个字符串和它的逆序字符串的最长公共子序列
 * <p>
 * 解法二：范围模型，讨论开头和结尾的情况
 */
public class PalindromeSubsequence {

  public static void main(String[] args) {
    PalindromeSubsequence t = new PalindromeSubsequence();
    int sum = t.process1("aa");
    System.out.println(sum);
  }

  private int process(String str) {
    char[] chars = str.toCharArray();
    int sum = f(chars, 0, chars.length - 1);
    return sum;
  }

  /**
   * [L...R] L 到 R 范围最长回文的长度
   *
   * @param chars
   * @param L
   * @param R
   * @return
   */
  private int f(char[] chars, int L, int R) {
    // base case
    if (L == R) {
      return 1; //只有一个字符串，回文长度为 1
    }
    if (L == R - 1) {
      return chars[L] == chars[R] ? 2 : 1; //两个字符串，如果两个字符串相等回文长度为2，不相信回文长度为1。
    }
    /**
     * 普遍情况,范围尝试模型，讨论开头和结尾的情况
     * 1、最长回文子序列，不以L开头，也不以R结尾
     * 2、最长回文子序列，以L开头，不以R结尾
     * 3、最长回文子序列，不以L开头，以R结尾
     * 4、最长回文子序列，不以L开头，也不以R结尾
     */
    int p1 = f(chars, L + 1, R - 1);
    int p2 = f(chars, L, R - 1);
    int p3 = f(chars, L + 1, R);
    int p4 = 0;
    if (chars[L] == chars[R]) { // 只有 L 和 R 上的字符相当，才有第四种情况
      p4 = 2 + f(chars, L + 1, R - 1);
    }
    return Math.max(p1, Math.max(p2, Math.max(p3, p4)));
  }


  public int process1(String s) {
    char[] chars = s.toCharArray();
    int N = chars.length;
    int[][] dp = new int[N][N];
    return dp(chars, dp);
  }

  private int dp(char[] chars, int[][] dp) {
    int N = chars.length;
    for (int i = 0; i < N; i++) {
      dp[i][i] = 1;
    }
    for (int i = 1; i < N; i++) {
      dp[i - 1][i] = chars[i] == chars[i - 1] ? 2 : 1;
    }

    for (int R = 2; R < N; R++) {
      for (int L = R - 2; L >= 0; L--) {
        int p1 = dp[L + 1][R - 1];
        int p2 = dp[L][R - 1];
        int p3 = dp[L + 1][R];
        int p4 = 0;
        if (chars[L] == chars[R]) { // 只有 L 和 R 上的字符相当，才有第四种情况
          p4 = 2 + p1;
        }
        dp[L][R] = Math.max(p1, Math.max(p2, Math.max(p3, p4)));
      }
    }
    return dp[0][chars.length - 1];
  }

  /**
   * dp 优化后
   */
  private int dpOptimize(char[] chars, int[][] dp) {
    int N = chars.length;
    for (int i = 0; i < N; i++) {
      dp[i][i] = 1;
    }
    for (int i = 1; i < N; i++) {
      dp[i - 1][i] = chars[i] == chars[i - 1] ? 2 : 1;
    }

    for (int R = 2; R < N; R++) {
      for (int L = R - 2; L >= 0; L--) {
        /**
         * 任意位置的数依赖它左边的、下面的、左下的数，但是左下的数一定小于等于左边、下面的
         * 所以可以放弃左下的数进行比较
         */
        int p2 = dp[L][R - 1];
        int p3 = dp[L + 1][R];
        dp[L][R] = Math.max(p2, p3);
        if (chars[L] == chars[R]) {
          int p1 = dp[L + 1][R - 1];
          dp[L][R] = Math.max(dp[L][R], 2 + p1);
        }
      }
    }
    return dp[0][chars.length - 1];
  }
}
