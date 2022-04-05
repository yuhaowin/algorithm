package class12.yuhao;

/**
 * 二叉树的递归套路深度实践
 * 给定一棵二叉树的头节点 head，任何两个节点之间都存在距离，（从一个节点到另外一个节点经过的节点的个数）
 * 返回整棵二叉树的最大距离
 * x 左树的最大距离
 * x 右树的最大距离
 * x 左树到 x 的距离(高度) + x 右树到 x 的距离（高度）+ 1
 */
public class MaxDistance {

    public static void main(String[] args) {
        Node head = new Node(0,
                new Node(11), new Node(12));

        MaxDistance maxDistance = new MaxDistance();
        System.out.println(maxDistance.process(head).distance);
    }


    public Info process(Node head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info left = process(head.left);
        Info right = process(head.right);
        int height = Math.max(left.height, right.height) + 1;

        int p1 = left.distance;
        int p2 = right.distance;
        int p3 = left.height + right.height + 1;

        int distance = Math.max(p1, Math.max(p2, p3));

        return new Info(height, distance);
    }

    //------------------------------------------------------------------------------------------------------------------

    static class Info {
        public int height;
        public int distance;

        public Info(int height, int distance) {
            this.height = height;
            this.distance = distance;
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
