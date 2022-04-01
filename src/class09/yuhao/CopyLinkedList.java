package class09.yuhao;

import java.util.HashMap;
import java.util.Map;

/**
 * 一种特殊的单链表节点类描述如下
 * static class Node {
 * int val;
 * Node next;
 * Node rand;
 * public Node(int val) {
 * this.val = val;
 * }
 * public Node(int val, Node next) {
 * this.val = val;
 * this.next = next;
 * }
 * }
 * rand 指针是单链表节点结构中新增的指针，rand 可能指向链表中的任意一个节点，也可能指向 null。
 * 给定一个由 Node 节点类型组成的无环单链表的头节点 head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点。
 * 要求: 时间复杂度O(N)，额外空间复杂度O(1)
 */
public class CopyLinkedList {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        //--------------------------------------------------------------------------------------------------------------

        head.random = node5;
        node1.random = node2;
        node2.random = node4;
        node3.random = node1;
        node4.random = node3;
        node5.random = head;

        CopyLinkedList copyLinkedList = new CopyLinkedList();
        copyLinkedList.copy1(head);
    }

    public Node copy(Node head) {
        if (head == null) {
            return null;
        }
        // key 老 node, value 新 node
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    public Node copy1(Node head) {
        if (head == null) {
            return null;
        }

        Node temp = head;
        Node next;
        while (temp != null) {
            next = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = next;
            temp = next;
        }

        temp = head;
        while (temp != null) {
            temp.next.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
        }

        Node result = head.next;
        temp = head;
        Node copy = result;
        // 老新混在一起，next方向上，random正确
        // next方向上，把新老链表分离
        while (temp != null) {
            next = temp.next.next;
            temp.next = next;
            copy.next = next != null ? next.next : null;
            copy = copy.next;
            temp = next;
        }
        return result;
    }

    //------------------------------------------------------------------------------------------------------------------

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
