package leetcode.editor.en;

/**
 * todo 中序遍历，是否一直升序，morris 遍历
 */
public class Q98_ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q98_ValidateBinarySearchTree().new Solution();
        System.out.println(solution.isValidBST(new TreeNode(123, null, null)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return process(root).isBST;
        }

        private Info process(TreeNode node) {
            if (node == null) {
                return new Info(Long.MAX_VALUE, Long.MIN_VALUE, true);
            }
            Info leftInfo = process(node.left);
            Info rightInfo = process(node.right);

            long max = Math.max(node.val, Math.max(leftInfo.max, rightInfo.max));
            long min = Math.min(node.val, Math.min(leftInfo.min, rightInfo.min));
            boolean BST = leftInfo.isBST && rightInfo.isBST && leftInfo.max < node.val && node.val < rightInfo.min;
            return new Info(min, max, BST);
        }
    }

    class Info {
        long min;
        long max;
        boolean isBST;

        public Info(long min, long max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
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