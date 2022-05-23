package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class Q94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q94_BinaryTreeInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            process(root, result);
            return result;
        }

        private void process(TreeNode node, List<Integer> res) {
            if (node == null) {
                return;
            }
            process(node.left, res);
            res.add(node.val);
            process(node.right, res);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
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