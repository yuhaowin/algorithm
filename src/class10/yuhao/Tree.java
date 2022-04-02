package class10.yuhao;

public class Tree {

    public void f(Node head) {
        if (head == null) {
            return;
        }
        // 第一次访问自己
        f(head.left);
        // 第二次访问自己
        f(head.right);
        // 第三次访问自己
    }

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }
}
