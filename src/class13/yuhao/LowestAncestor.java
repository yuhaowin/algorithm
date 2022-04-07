package class13.yuhao;

/**
 * 给定一棵二叉树的头节点 head，和另外两个节点 a 和 b
 * 返回 a 和 b 的最低公共祖先
 */
public class LowestAncestor {
    public static void main(String[] args) {
        LowestAncestor ancestor = new LowestAncestor();
    }


    public Node findAncestor(Node head, Node a, Node b) {
        return process(head, a, b).ancestor;
    }

    private Info process(Node head, Node a, Node b) {
        if (head == null) {
            return new Info(false, false, null);
        }

        Info left = process(head.left, a, b);
        Info right = process(head.right, a, b);

        boolean findA = (head == a) || left.findA || right.findA;
        boolean findB = (head == b) || left.findB || right.findB;

        Node ancestor = null;
        if (left.ancestor != null) {
            ancestor = left.ancestor;
        }

        if (right.ancestor != null) {
            ancestor = right.ancestor;
        }

        if (ancestor == null && findA && findB) {
            ancestor = head;
        }

        return new Info(findA, findB, ancestor);
    }

    //------------------------------------------------------------------------------------------------------------------

    static class Info {
        public boolean findA;
        public boolean findB;
        public Node ancestor;

        public Info(boolean findA, boolean findB, Node ancestor) {
            this.findA = findA;
            this.findB = findB;
            this.ancestor = ancestor;
        }
    }

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
