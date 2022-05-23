package leetcode.editor.en;

import java.util.*;

public class Q107_BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new Q107_BinaryTreeLevelOrderTraversalIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            Deque<List<Integer>> result = new LinkedList<>();
            if (root == null) {
                return (List<List<Integer>>) result;
            }
            Queue<TreeNode> temp = new LinkedList<>();
            temp.add(root);
            while (!temp.isEmpty()) {
                int size = temp.size();
                List<Integer> levelResult = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = temp.poll();
                    levelResult.add(node.val);
                    if (node.left != null) {
                        temp.add(node.left);
                    }
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                }
                result.offerFirst(levelResult);
            }
            return (List<List<Integer>>) result;
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