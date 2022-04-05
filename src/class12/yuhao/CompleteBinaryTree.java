package class12.yuhao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二叉树是否是完全二叉树
 * 1、某个节点有右节点，没有左节点  -> false
 * 2、如果遇到了不双全的节点之后，又发现当前节点不是叶节点 -> false
 */
public class CompleteBinaryTree {

    public static void main(String[] args) {
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree();
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
            if (left == null && right == null) {
                leaf = true;
            }
        }
        return true;
    }

    //------------------------------------------------------------------------------------------------------------------

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
}
