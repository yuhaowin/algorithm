package class16.yuhao;

import class16.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 宽度优先遍历
 */
public class BFS {

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


        BFS bfs = new BFS();
        bfs.bfs(head);
    }

    public void bfs(Node head) {
        if (head == null) {
            return;
        }

        Set<Node> trim = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        trim.add(head);
        queue.add(head);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.value + " ");
            for (Node next : node.nexts) {
                if (!trim.contains(next)) {
                    trim.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
