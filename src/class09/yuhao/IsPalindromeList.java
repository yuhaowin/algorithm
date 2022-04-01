package class09.yuhao;

import java.util.Stack;

/**
 * 给定一个单链表的头节点 head，请判断该链表是否为回文结构。
 * 1)哈希表方法特别简单（笔试用）
 * 2)改原链表的方法就需要注意边界了（面试用）
 */
public class IsPalindromeList {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));

        IsPalindromeList test = new IsPalindromeList();
        System.out.println(test.isPalindrome1(head1));
        System.out.println(test.isPalindrome1(head2));

        System.out.println("-----------------------");

        System.out.println(test.isPalindrome2(head1));
        System.out.println(test.isPalindrome2(head2));

        System.out.println("-----------------------");

        System.out.println(test.isPalindrome3(head1));
        System.out.println(test.isPalindrome3(head2));
    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return true;
        }
        Stack<Integer> temp = new Stack<>();
        ListNode list = head;
        while (list != null) {
            temp.push(list.val);
            list = list.next;
        }
        ListNode list1 = head;
        while (list1 != null) {
            Integer pop = temp.pop();
            if (list1.val != pop) {
                return false;
            }
            list1 = list1.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Integer> temp = new Stack<>();
        while (slow != null) {
            temp.push(slow.val);
            slow = slow.next;
        }
        while (!temp.isEmpty()) {
            if (head.val != temp.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    public boolean isPalindrome3(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 此时 slow 在上 mid 位置

        // 从 slow 位置开始...end 位置进行 reverse
        ListNode p = slow;
        ListNode q = null;
        slow = null;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = slow;
            slow = q;
        }
        // 此时 slow 已经 reverse，从 end 开始到 mid 位置

        // 比较每一个位置是否一致
        ListNode t1 = slow;
        ListNode t2 = head;
        boolean result = true;
        while (t1 != null && t2 != null) {
            if (t1.val != t2.val) {
                result = false;
                break;
            }
            t1 = t1.next;
            t2 = t2.next;
        }

        // 恢复原始链表的结构
        p = slow;
        q = null;
        slow = null;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = slow;
            slow = q;
        }

        return result;
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
