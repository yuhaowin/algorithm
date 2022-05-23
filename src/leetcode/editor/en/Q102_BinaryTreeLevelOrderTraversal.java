package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q102_BinaryTreeLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
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
                result.add(levelResult);
            }
            return result;
        }

        public List<List<Integer>> levelOrder1(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> temp = new LinkedList<>();
            List<Integer> levelResult = new ArrayList<>();
            TreeNode cur = root;
            TreeNode next = null;
            temp.add(root);
            while (!temp.isEmpty()) {
                TreeNode node = temp.poll();
                levelResult.add(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                    next = node.left;
                }
                if (node.right != null) {
                    temp.add(node.right);
                    next = node.right;
                }
                if (cur == node) {
                    cur = next;
                    result.add(levelResult);
                    levelResult = new ArrayList<>();
                }
            }
            return result;
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