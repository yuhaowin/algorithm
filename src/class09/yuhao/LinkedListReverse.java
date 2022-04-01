package class09.yuhao;

/**
 * 单链表反转
 * head -> 1 -> 2 -> 3 -> 4 -> 5 -> null
 * head -> 5 -> 4 -> 3 -> 2 -> 1 -> null
 */
public class LinkedListReverse {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        LinkedListReverse reverse = new LinkedListReverse();
        head = reverse.reverse(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 头插法
     */
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = null;
        head = null;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = head;
            head = q;
        }
        return head;

//        ListNode next = null;
//        while (p != null) {
//            next = p.next;
//            p.next = q;
//            q = p;
//            p = next;
//        }
//        return q;
    }

    //------------------------------------------------------------------------------------------------------------------

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
