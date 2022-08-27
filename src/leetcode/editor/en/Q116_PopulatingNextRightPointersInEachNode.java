package leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class Q116_PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new Q116_PopulatingNextRightPointersInEachNode().new Solution();
        System.out.println(99099);
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        root.left = node1;
        root.right = node2;
        Node connect = solution.connect(root);
        System.out.println();


    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                Node pre = null;
                for (int i = 0; i < size; i++) {
                    Node cur = q.poll();
                    cur.next = pre;
                    pre = cur;
                    if (cur.right != null) {
                        q.add(cur.right);
                    }
                    if (cur.left != null) {
                        q.add(cur.left);
                    }
                }

            }
            return root;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}