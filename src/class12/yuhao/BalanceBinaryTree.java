package class12.yuhao;

/**
 * 二叉树的递归套路深度实践
 * 给定一棵二叉树的头节点 head，返回这颗二叉树是不是平衡二叉树
 * <p>
 * 平衡二叉树:
 * 所有子树其左子树和右子树的高度相差不能超过 1。
 * <p>
 * 如果判断以某个节点作为头节点的子树是不是平衡二叉树：
 * 1、它的左树是平衡二叉树
 * 2、它的右树是平衡二叉树
 * 3、左树和右树高度差不超过 1
 */
public class BalanceBinaryTree {

    public static void main(String[] args) {
        BalanceBinaryTree balanceBinaryTree = new BalanceBinaryTree();
    }

    public Info test(Node head) {
        if (head == null) {
            return new Info(true, 0);
        }
        Info left = test(head.left);
        Info right = test(head.right);
        int minus = Math.abs(left.height - right.height);
        int height = Math.max(left.height, right.height) + 1;
        boolean balance = left.isBalance && right.isBalance && minus < 1;
        return new Info(balance, height);
    }

    //------------------------------------------------------------------------------------------------------------------

    static class Info {
        public boolean isBalance;
        public int height;

        public Info(boolean isBalance, int height) {
            this.isBalance = isBalance;
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
