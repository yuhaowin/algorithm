//Given the root of a binary tree, determine if it is a valid binary search
//tree (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the 
//node's key. 
// The right subtree of a node contains only nodes with keys greater than the 
//node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1512 👎 0

package leetcode.editor.cn;

public class Q98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q98ValidateBinarySearchTree().new Solution();
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
        public boolean isValidBST(TreeNode root) {
            return process(root).BST;
        }

        private Info process(TreeNode x) {
            if (x == null) {
                return new Info(true, Long.MAX_VALUE, Long.MIN_VALUE);
            }
            Info left = process(x.left);
            Info right = process(x.right);

            long min = Math.min(x.val, Math.min(left.min, right.min));
            long max = Math.max(x.val, Math.max(left.max, right.max));
            boolean BST = left.BST && right.BST && left.max < x.val && x.val < right.min;

            return new Info(BST, min, max);
        }
    }

    class Info {
        public boolean BST;
        public long min;
        public long max;

        public Info(boolean BST, long min, long max) {
            this.BST = BST;
            this.min = min;
            this.max = max;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    static class TreeNode {
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