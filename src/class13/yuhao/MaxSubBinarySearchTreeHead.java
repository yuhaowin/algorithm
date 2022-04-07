package class13.yuhao;

/**
 * 二叉树的递归套路深度实践
 * 给定一棵二叉树的头节点 head，返回这棵二叉树中最大的二叉搜索子树的头节点
 * <p>
 * 二叉搜索树:
 * 每一棵子树的头节点的值大于左节点的值，头节点的值小于右节点的值，经典的搜索二叉树没有重复值。
 * <p>
 * 方法一: 中序遍历，值是上升的 -> true
 * 方法二: 如果判断以某个节点作为头节点的子树是不是二叉搜索树：
 * 1、它的左树是二叉搜索树
 * 2、它的右树是二叉搜索树
 * 3、左树 max < cur < 右树 min
 */
public class MaxSubBinarySearchTreeHead {
    public static void main(String[] args) {
        Node head = new Node(0,
                new Node(-1), new Node(1));
        MaxSubBinarySearchTreeHead binarySearchTree = new MaxSubBinarySearchTreeHead();
        System.out.println(binarySearchTree.process(head).maxHead.value);
    }

    public Info process(Node head) {
        if (head == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, null);
        }
        Info left = process(head.left);
        Info right = process(head.right);


        int min = Math.min(head.value, Math.min(left.min, right.min));
        int max = Math.max(head.value, Math.max(left.max, right.max));
        boolean bst = left.isBS && right.isBS && left.max < head.value && head.value < right.min;

        Node subHead = left.maxSize > right.maxSize ? left.maxHead : right.maxHead;
        int maxSize = Math.max(left.maxSize, right.maxSize);
        if (bst) {
            maxSize = left.maxSize + right.maxSize + 1;
            subHead = head;
        }

        return new Info(bst, min, max, maxSize, subHead);
    }

    //------------------------------------------------------------------------------------------------------------------

    static class Info {
        public boolean isBS;
        public int min;
        public int max;
        public int maxSize;
        public Node maxHead;

        public Info(boolean isBS, int min, int max, int maxSize, Node maxHead) {
            this.isBS = isBS;
            this.min = min;
            this.max = max;
            this.maxSize = maxSize;
            this.maxHead = maxHead;
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
