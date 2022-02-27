package class19.yuhao_dp;

/**
 * 求两个字符串的最长公共子序列的长度
 * <p>
 * 字符串 abc123ee 和 字符串 xyz123cc 最长公共子序列是 3
 */
public class LongestCommonSubsequence {

  public static void main(String[] args) {

    LongestCommonSubsequence subsequence = new LongestCommonSubsequence();

    String str1 = "abc123ee";
    String str2 = "xyz123cc";

    System.out.println(
        subsequence.process(str1.toCharArray(), str2.toCharArray(), str1.length() - 1,
            str2.length() - 1));

  }


  public int process(char[] str1, char[] str2, int i, int j) {

    if (i == 0 && j == 0) {
      return str1[i] == str2[j] ? 1 : 0;
    }

    if (i == 0) {
      return str1[i] == str2[j] ? 1 : process(str1, str2, i, j - 1);
    }

    if (j == 0) {
      return str1[i] == str2[j] ? 1 : process(str1, str2, i - 1, j);
    }

    int p1 = process(str1, str2, i, j - 1);
    int p2 = process(str1, str2, i - 1, j);
    int p3 = str1[i] == str2[j] ? (1 + process(str1, str2, i - 1, j - 1)) : 0;
    return Math.max(p1, Math.max(p2, p3));
  }

}
