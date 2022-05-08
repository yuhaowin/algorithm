package leetcode.editor.en;

public class Q111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Q111MinimumDepthOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.minDepth(root));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDepth(TreeNode root) {
            return process(root).min;
        }

        private Info process(TreeNode node) {
            if (node == null) {
                return new Info(0);
            }
            if (node.left == null && node.right == null) {
                return new Info(1);
            }
            int min = 0;
            Info leftInfo = process(node.left);
            Info rightInfo = process(node.right);

            if (node.left != null) {
                min = leftInfo.min + 1;
            }
            if (node.right != null) {
                min = rightInfo.min + 1;
            }
            if (node.left != null && node.right != null) {
                min = Math.min(leftInfo.min, rightInfo.min) + 1;
            }
            return new Info(min);
        }
    }

    class Info {
        public int min;

        public Info(int min) {
            this.min = min;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //Definition for a binary tree node.
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