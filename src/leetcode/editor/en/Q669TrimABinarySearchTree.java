package leetcode.editor.en;

public class Q669TrimABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q669TrimABinarySearchTree().new Solution();
        TreeNode head = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        TreeNode result = solution.trimBST(head, 1, 2);
        System.out.println();
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
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return root;
            }
            if (root.val < low) {
                // 只会中一个
                return trimBST(root.right, low, high);
            } else {
                root.right = trimBST(root.right, low, high);
            }
            if (root.val > high) {
                // 只会中一个
                return trimBST(root.left, low, high);
            } else {
                root.left = trimBST(root.left, low, high);
            }
            return root;
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