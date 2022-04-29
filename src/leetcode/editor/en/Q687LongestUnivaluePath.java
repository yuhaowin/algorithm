package leetcode.editor.en;

public class Q687LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new Q687LongestUnivaluePath().new Solution();
        TreeNode head = new TreeNode(1, new TreeNode(4, new TreeNode(4), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(5)));
        System.out.println(solution.longestUnivaluePath(head));
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
        public int longestUnivaluePath(TreeNode root) {
            return test(root).maxPath == 0 ? 0 : test(root).maxPath - 1;
        }

        private Info test(TreeNode node) {
            if (node == null) {
                return new Info(0, 0);
            }
            Info leftInfo = test(node.left);
            Info rightInfo = test(node.right);

            int length = 1;
            if (node.left != null && node.left.val == node.val) {
                length = Math.max(length, leftInfo.length + 1);
            }

            if (node.right != null && node.right.val == node.val) {
                length = Math.max(length, rightInfo.length + 1);
            }

            int p1 = leftInfo.maxPath;
            int p2 = rightInfo.maxPath;
            int maxPath = Math.max(length, Math.max(p1, p2));
            if (node.left != null && node.right != null && node.left.val == node.val && node.right.val == node.val) {
                maxPath = Math.max(maxPath, leftInfo.length + rightInfo.length + 1);
            }
            return new Info(length, maxPath);
        }
    }

    class Info {
        // 以 x 节点为头的最大路径
        public int length;
        // 以 x 节点的数的最大路径
        public int maxPath;

        public Info(int length, int maxPath) {
            this.length = length;
            this.maxPath = maxPath;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class TreeNode {
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