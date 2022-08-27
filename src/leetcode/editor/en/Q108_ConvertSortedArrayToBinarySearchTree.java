package leetcode.editor.en;

public class Q108_ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q108_ConvertSortedArrayToBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        // 用二分之后的点，作为 root 节点
        public TreeNode sortedArrayToBST(int[] nums) {
            return process(nums, 0, nums.length - 1);
        }

        private TreeNode process(int[] nums, int L, int R) {
            if (L > R) {
                return null;
            }
            if (L == R) {
                return new TreeNode(nums[L]);
            }
            int M = (L + R) / 2;
            TreeNode root = new TreeNode(nums[M]);
            root.left = process(nums, L, M - 1);
            root.right = process(nums, M + 1, R);
            return root;
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