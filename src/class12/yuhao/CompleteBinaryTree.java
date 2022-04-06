package class12.yuhao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二叉树是否是完全二叉树
 * 方法一:
 * 1、某个节点有右节点，没有左节点  -> false
 * 2、如果遇到了不双全的节点之后，又发现当前节点不是叶节点 -> false
 * <p>
 * 方法二:
 * 左树满、右树满、左树高等于右树高
 * 左树满、右树满、左树高等于右树高 +1
 * 左树满、右树完全、左树高等于右树高
 * 左树完全、右树满、左树高等于右树高 +1
 */
public class CompleteBinaryTree {

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree();
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (completeBinaryTree.completeBinaryTree1(head) != completeBinaryTree.completeBinaryTree2(head)) {
                System.out.println("Oops!");
            }
        }
    }

    public boolean completeBinaryTree1(Node head) {
        if (head == null) {
            return true;
        }
        boolean leaf = false;
        Queue<Node> temp = new LinkedList<>();
        temp.add(head);
        while (!temp.isEmpty()) {
            Node node = temp.poll();
            Node left = node.left;
            Node right = node.right;
            if (left == null && right != null) {
                return false;
            }
            if (leaf && (left != null || right != null)) {
                return false;
            }
            if (left != null) {
                temp.add(left);
            }
            if (right != null) {
                temp.add(right);
            }
            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }

    public boolean completeBinaryTree2(Node head) {
        return process(head).complete;
    }

    private Info process(Node head) {
        if (head == null) {
            return new Info(true, true, 0);
        }
        Info left = process(head.left);
        Info right = process(head.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean full = left.full && right.full && left.height == right.height;
        boolean complete = full;

        if (left.full && right.full && left.height == right.height + 1) {
            complete = true;
        }
        if (left.full && right.complete && left.height == right.height) {
            complete = true;
        }
        if (left.complete && right.full && left.height == right.height + 1) {
            complete = true;
        }

        return new Info(full, complete, height);
    }


    //------------------------------------------------------------------------------------------------------------------
    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    static class Info {
        public boolean full;
        public boolean complete;
        public int height;

        public Info(boolean full, boolean complete, int height) {
            this.full = full;
            this.complete = complete;
            this.height = height;
        }
    }

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
}
