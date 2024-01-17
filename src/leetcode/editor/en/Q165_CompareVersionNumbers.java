package leetcode.editor.en;

public class Q165_CompareVersionNumbers {
    public static void main(String[] args) {
        Solution solution = new Q165_CompareVersionNumbers().new Solution();
        solution.compareVersion("1.0.1", "1");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int compareVersion(String version1, String version2) {
            int length1 = version1.length(), length2 = version2.length();
            int index1 = 0, index2 = 0;
            while (index1 < length1 || index2 < length2) {
                int subVersion1 = 0;
                for (; index1 < length1 && version1.charAt(index1) != '.'; ++index1) {
                    subVersion1 = subVersion1 * 10 + (version1.charAt(index1) - '0');
                }
                ++index1; // 跳过点号

                int subVersion2 = 0;
                for (; index2 < length2 && version2.charAt(index2) != '.'; ++index2) {
                    subVersion2 = subVersion2 * 10 + (version2.charAt(index2) - '0');
                }
                ++index2; // 跳过点号
                if (subVersion1 != subVersion2) {
                    return subVersion1 > subVersion2 ? 1 : -1;
                }
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}