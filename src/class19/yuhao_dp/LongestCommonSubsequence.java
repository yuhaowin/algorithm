package class19.yuhao_dp;

/**
 * 求两个字符串的最长公共子序列的长度
 * 字符串 abc123ee 和字符串 xyz123cc 最长公共子序列是 3
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        char[] str1 = "abc123ee".toCharArray();
        char[] str2 = "xyz123cc".toCharArray();
        LongestCommonSubsequence subsequence = new LongestCommonSubsequence();
        int result = subsequence.process(str1.length - 1, str2.length - 1, str1, str2);
        System.out.println(result);
        System.out.println(subsequence.dp(str1, str2));
    }

    //------------------------------------------------------------------------------------------------------------------

    public int process(int i, int j, char[] str1, char[] str2) {
        if (i == 0 && j == 0) {
            return str1[i] == str2[j] ? 1 : 0;
        }
        if (i == 0) {
            return str1[i] == str2[j] ? 1 : process(i, j - 1, str1, str2);
        }
        if (j == 0) {
            return str1[i] == str2[j] ? 1 : process(i - 1, j, str1, str2);
        }
        int p1 = process(i, j - 1, str1, str2);
        int p2 = process(i - 1, j, str1, str2);
        int p3 = str1[i] == str2[j] ? (1 + process(i - 1, j - 1, str1, str2)) : 0;
        return Math.max(p1, Math.max(p2, p3));
    }

    //------------------------------------------------------------------------------------------------------------------

    public int dp(char[] str1, char[] str2) {
        int N = str1.length;
        int M = str2.length;
        int[][] dp = new int[N][M];
        if (str1[0] == str2[0]) {
            dp[0][0] = 1;
        }
        for (int j = 1; j < M; j++) {
            dp[0][j] = str1[0] == str2[j] ? 1 : dp[0][j - 1];
        }
        for (int i = 1; i < N; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int p1 = dp[i][j - 1];
                int p2 = dp[i - 1][j];
                int p3 = str1[i] == str2[j] ? (1 + dp[i - 1][j - 1]) : 0;
                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }
        return dp[N - 1][M - 1];
    }
}
