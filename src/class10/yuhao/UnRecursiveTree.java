package class10.yuhao;

import java.util.Stack;

/**
 * 非递归遍历二叉树
 */
public class UnRecursiveTree {

    public static void main(String[] args) {
        Node head = new Node(1,
                new Node(2), new Node(3));
        UnRecursiveTree tree = new UnRecursiveTree();
        tree.pre(head);
        System.out.println("\n----------------------");
        tree.min(head);
        System.out.println("\n----------------------");
        tree.post(head);
    }


    /**
     * 前序遍历
     */
    public void pre(Node head) {
        Stack<Node> temp = new Stack<>();
        temp.push(head);
        while (!temp.isEmpty()) {
            Node cur = temp.pop();
            System.out.print(cur.value + " ");
            if (cur.right != null) {
                temp.push(cur.right);
            }
            if (cur.left != null) {
                temp.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void min(Node head) {
        Stack<Node> temp = new Stack<>();
        Node cur = head;
        while (!temp.isEmpty() || cur != null) {
            if (cur != null) {
                temp.push(cur);
                cur = cur.left;
            } else {
                cur = temp.pop();
                System.out.print(cur.value + " ");
                cur = cur.right;
            }
        }
    }

    /**
     * 后序遍历
     */
    public void post(Node head) {
        Stack<Node> temp = new Stack<>();
        Stack<Node> temp1 = new Stack<>();
        temp.push(head);
        while (!temp.isEmpty()) {
            Node cur = temp.pop();
            temp1.push(cur);
            if (cur.left != null) {
                temp.push(cur.left);
            }
            if (cur.right != null) {
                temp.push(cur.right);
            }
        }
        while (!temp1.isEmpty()) {
            System.out.print(temp1.pop().value + " ");
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
