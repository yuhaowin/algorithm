package class11.yuhao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树最宽的层有多少个节点
 */
public class TreeMaxWidth {
    public static void main(String[] args) {
        Node head = new Node(0,
                new Node(11,
                        new Node(21), new Node(22)), new Node(12, new Node(23), new Node(24)));

        TreeMaxWidth maxWidth = new TreeMaxWidth();
        System.out.println(maxWidth.getMaxWidth(head));
    }

    public int getMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> temp = new LinkedList<>();
        temp.add(head);
        int maxWidth = 0;
        Node curEnd = head;
        Node nextEnd = null;
        int curWidth = 0;
        while (!temp.isEmpty()) {
            Node node = temp.poll();
            curWidth++;
            if (node.left != null) {
                nextEnd = node.left;
                temp.add(node.left);
            }
            if (node.right != null) {
                nextEnd = node.right;
                temp.add(node.right);
            }

            if (node == curEnd) {
                maxWidth = Math.max(maxWidth, curWidth);
                curWidth = 0;
                curEnd = nextEnd;
            }
        }
        return maxWidth;
    }

    //------------------------------------------------------------------------------------------------------------------

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
