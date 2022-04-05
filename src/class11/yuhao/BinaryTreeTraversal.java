package class11.yuhao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现二叉树的按层遍历
 * 1)其实就是宽度优先遍历，用队列
 * 2)可以通过设置 flag 变量的方式，来发现某一层的结束（看题目）
 */
public class BinaryTreeTraversal {

    public static void main(String[] args) {

        Node head = new Node(0,
                new Node(11,
                        new Node(21), new Node(22)), new Node(12, new Node(23), new Node(24)));
        BinaryTreeTraversal traversal = new BinaryTreeTraversal();
        traversal.traversal(head);
    }

    public void traversal(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    //------------------------------------------------------------------------------------------------------------------

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
