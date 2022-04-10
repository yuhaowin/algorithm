package class16.yuhao;

import class16.Node;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 深度优先遍历
 */
public class DFS {

    public static void main(String[] args) {
        Node head = new Node(0);

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node2.nexts.add(node3);

        Node node12 = new Node(12);
        node12.nexts.add(node3);

        Node node11 = new Node(11);
        node11.nexts.add(node12);

        node1.nexts.add(node11);
        node1.nexts.add(node2);

        head.nexts.add(node1);
        head.nexts.add(node2);
        head.nexts.add(node3);

        DFS dfs = new DFS();

        dfs.dfs(head);
        System.out.println();
        dfs.test(head, new HashSet<>());
    }

    public void dfs(Node head) {
        if (head == null) {
            return;
        }

        Stack<Node> temp = new Stack<>();
        Set<Node> trim = new HashSet<>();
        temp.add(head);
        trim.add(head);
        System.out.print(head.value + " ");
        while (!temp.isEmpty()) {
            Node node = temp.pop();
            for (Node next : node.nexts) {
                if (!trim.contains(next)) {
                    temp.add(node);
                    temp.add(next);
                    trim.add(next);
                    System.out.print(next.value + " ");
                    break;
                }
            }
        }
    }

    public void test(Node head, Set<Node> trim) {
        if (head == null) {
            return;
        }
        if (trim.contains(head)) {
            return;
        }
        System.out.print(head.value + " ");
        trim.add(head);
        for (Node next : head.nexts) {
            test(next, trim);
        }
    }
}
