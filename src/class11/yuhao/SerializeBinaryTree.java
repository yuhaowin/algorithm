package class11.yuhao;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 实现二叉树的序列化和反序列化
 * 1）先序方式序列化和反序列化
 * 2）按层方式序列化和反序列化
 */
public class SerializeBinaryTree {

    public static void main(String[] args) {
        Node head = new Node(0,
                new Node(11,
                        new Node(21), new Node(22)), new Node(12, new Node(23), new Node(24)));

        Node benchmark = new Node(0,
                new Node(11,
                        new Node(21), new Node(22)), new Node(12, new Node(23), new Node(24)));

        SerializeBinaryTree binaryTree = new SerializeBinaryTree();
        System.out.println(binaryTree.check(head, benchmark));

        Node head1 = binaryTree.build(binaryTree.serialize(head));
        System.out.println(binaryTree.check(head, head1));

        Node head2 = binaryTree.buildLevelSerial(binaryTree.levelSerial(head));
        System.out.println(binaryTree.check(head, head2));
    }

    //------------------------------------------------------------------------------------------------------------------
    // 先序序列化 binary tree
    public Queue<Integer> serialize(Node head) {
        Queue<Integer> queue = new LinkedList<>();
        preSerialize(head, queue);
        return queue;
    }

    private void preSerialize(Node head, Queue<Integer> queue) {
        if (head == null) {
            queue.add(null);
            return;
        }
        queue.add(head.value);
        preSerialize(head.left, queue);
        preSerialize(head.right, queue);
    }

    // 先序反序列化 binary tree
    public Node build(Queue<Integer> queue) {
        Integer val = queue.poll();
        if (val == null) {
            return null;
        }
        Node head = new Node(val);
        head.left = build(queue);
        head.right = build(queue);
        return head;
    }

    //------------------------------------------------------------------------------------------------------------------

    public List<Integer> levelSerial(Node head) {
        List<Integer> result = new LinkedList<>();
        if (head == null) {
            result.add(null);
            return result;
        }
        Queue<Node> temp = new LinkedList<>();
        temp.add(head);
        result.add(head.value);
        while (!temp.isEmpty()) {
            Node node = temp.poll();
            if (node.left != null) {
                result.add(node.left.value);
                temp.add(node.left);
            } else {
                result.add(null);
            }
            if (node.right != null) {
                result.add(node.right.value);
                temp.add(node.right);
            } else {
                result.add(null);
            }
        }
        return result;
    }

    public Node buildLevelSerial(List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();
        for (Integer item : list) {
            queue.add(item);
        }
        Integer val = queue.poll();
        if (val == null) {
            return null;
        }
        Queue<Node> temp = new LinkedList<>();
        Node head = new Node(val);
        temp.add(head);
        while (!temp.isEmpty()) {
            Node node = temp.poll();
            node.left = generateNode(queue.poll());
            node.right = generateNode(queue.poll());
            if (node.left != null) {
                temp.add(node.left);
            }
            if (node.right != null) {
                temp.add(node.right);
            }
        }
        return head;
    }

    private Node generateNode(Integer val) {
        if (val == null) {
            return null;
        }
        return new Node(val);
    }

    public boolean check(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1 == null || head2 == null) {
            return false;
        }

        boolean checkSelf = head1.value == head2.value;
        boolean checkLeft = check(head1.left, head2.left);
        boolean checkRight = check(head1.right, head2.right);

        return checkSelf && checkLeft && checkRight;
    }

    //------------------------------------------------------------------------------------------------------------------

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
