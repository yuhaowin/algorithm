//Given an integer n, return the number of structurally unique BST's (binary
//search trees) which has exactly n nodes of unique values from 1 to n. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1676 👎 0

package leetcode.editor.cn;

public class Q96UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new Q96UniqueBinarySearchTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            if (n == 1 || n == 0) {
                return 1;
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                int left = numTrees(i - 1);
                int right = numTrees(n - i);
                ans += left * right;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}