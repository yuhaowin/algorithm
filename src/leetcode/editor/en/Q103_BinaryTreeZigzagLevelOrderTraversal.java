package leetcode.editor.en;

import java.util.*;

public class Q103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q103_BinaryTreeZigzagLevelOrderTraversal().new Solution();
        TreeNode root = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), null));
        List<List<Integer>> lists = solution.zigzagLevelOrder(root);
        System.out.println();
        //3,9,20,null,null,15,7
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            queue.add(root);
            boolean flag = true;
            while (!queue.isEmpty()) {
                Deque<Integer> item = new LinkedList<>();
                int num = queue.size();
                for (int i = 0; i < num; i++) {
                    TreeNode node = queue.poll();
                    if (flag) {
                        item.offerLast(node.val);
                    } else {
                        item.offerFirst(node.val);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                flag = !flag;
                res.add((List<Integer>) item);
            }
            return res;
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