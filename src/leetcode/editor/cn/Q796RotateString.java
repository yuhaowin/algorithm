//Given two strings s and goal, return true if and only if s can become goal
//after some number of shifts on s. 
//
// A shift on s consists of moving the leftmost character of s to the rightmost 
//position. 
//
// 
// For example, if s = "abcde", then it will be "bcdea" after one shift. 
// 
//
// 
// Example 1: 
// Input: s = "abcde", goal = "cdeab"
//Output: true
// Example 2: 
// Input: s = "abcde", goal = "abced"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, goal.length <= 100 
// s and goal consist of lowercase English letters. 
// 
// Related Topics 字符串 字符串匹配 👍 220 👎 0

package leetcode.editor.cn;

public class Q796RotateString {
    public static void main(String[] args) {
        Solution solution = new Q796RotateString().new Solution();
        System.out.println(solution.rotateString("abcde", "cdeab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.equals(goal)) {
                return true;
            }
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {
                swap(array, 0, array.length - 1);
            }
            return false;
        }

        public void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}