package leetcode.editor.en;

public class Q105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] pre = new int[]{2, 3, 4};
        int[] in = new int[]{4, 3, 2};
        solution.buildTree(pre, in);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
            if (L1 > R1) {
                System.out.println(111);
                return null;
            }
            if (L2 > R2) {
                System.out.println(222);
                return null;
            }

            TreeNode head = new TreeNode(pre[L1]);
            if (L1 == R1) {
                return head;
            }
            int findIndex = L2;
            for (; findIndex <= R2; findIndex++) {
                if (in[findIndex] == pre[L1]) {
                    break;
                }
            }
            head.left = f(pre, L1 + 1, L1 + findIndex - L2, in, L2, findIndex - 1);
            head.right = f(pre, L1 + findIndex - L2 + 1, R1, in, findIndex + 1, R2);
            return head;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class TreeNode {
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