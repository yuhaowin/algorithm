package class09.yuhao;


/**
 * 快慢指针
 * 1）输入链表头节点，奇数长度返回中点，偶数长度返回上中点
 * 2）输入链表头节点，奇数长度返回中点，偶数长度返回下中点
 * 3）输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
 * 4）输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
 */
public class LinkedListMid {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        LinkedListMid test = new LinkedListMid();
        System.out.println(test.func1(head1).val == 2);
        System.out.println(test.func1(head2).val == 3);
        System.out.println("------------------------");
        System.out.println(test.func2(head1).val == 3);
        System.out.println(test.func2(head2).val == 3);

        System.out.println("------------------------");

        System.out.println(test.func3(head1).val == 1);
        System.out.println(test.func3(head2).val == 2);
        System.out.println("------------------------");
        System.out.println(test.func4(head1).val == 2);
        System.out.println(test.func4(head2).val == 2);
    }

    /**
     * 1）输入链表头节点，奇数长度返回中点，偶数长度返回上中点
     */
    public ListNode func1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 2）输入链表头节点，奇数长度返回中点，偶数长度返回下中点
     */
    public ListNode func2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 3）输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
     */
    public ListNode func3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 4）输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
     */
    public ListNode func4(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
