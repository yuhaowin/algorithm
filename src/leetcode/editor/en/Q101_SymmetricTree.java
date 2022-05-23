package leetcode.editor.en;

public class Q101_SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new Q101_SymmetricTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return process(root.left, root.right);
        }

        private boolean process(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (!(left != null && right != null)) {
                return false;
            }
            return left.val == right.val && process(left.left, right.right) && process(left.right, right.left);
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