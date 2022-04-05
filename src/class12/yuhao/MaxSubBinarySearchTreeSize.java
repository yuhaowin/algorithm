package class12.yuhao;

/**
 * 二叉树的递归套路深度实践
 * 判断二叉树是否是搜索二叉树
 * <p>
 * 搜索二叉树:
 * 每一棵子树的头节点的值大于左节点的值，头节点的值小于右节点的值，经典的搜索二叉树没有重复值。
 * <p>
 * 方法一: 中序遍历，值是上升的 -> true
 * 方法二: 如果判断以某个节点作为头节点的子树是不是搜索二叉树：
 * 1、它的左树是搜索二叉树
 * 2、它的右树是搜索二叉树
 * 3、左树 max < cur < 右树 min
 */
public class MaxSubBinarySearchTreeSize {
    public static void main(String[] args) {
        Node head = new Node(0,
                new Node(-1), new Node(1));
        MaxSubBinarySearchTreeSize binarySearchTree = new MaxSubBinarySearchTreeSize();
        System.out.println(binarySearchTree.process(head).MaxSize);
    }

    public Info process(Node head) {
        if (head == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Info left = process(head.left);
        Info right = process(head.right);


        int min = Math.min(head.value, Math.min(left.min, right.min));
        int max = Math.max(head.value, Math.max(left.max, right.max));
        boolean bst = left.isBS && right.isBS && left.max < head.value && head.value < right.min;

        int maxSize = Math.max(left.MaxSize, right.MaxSize);
        if (bst) {
            maxSize = left.MaxSize + right.MaxSize + 1;
        }

        return new Info(bst, min, max, maxSize);
    }

    //------------------------------------------------------------------------------------------------------------------

    static class Info {
        public boolean isBS;
        public int min;
        public int max;
        public int MaxSize;

        public Info(boolean isBS, int min, int max, int maxSize) {
            this.isBS = isBS;
            this.min = min;
            this.max = max;
            MaxSize = maxSize;
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
