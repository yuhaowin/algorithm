//Given the root of a binary tree, return the preorder traversal of its nodes'
//values. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [1,2,3]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 787 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q144BinaryTreePreorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            process(root, ans);
            return ans;
        }

        private void process(TreeNode node, List<Integer> ans) {
            if (node == null) {
                return;
            }
            ans.add(node.val);
            process(node.left, ans);
            process(node.right, ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}