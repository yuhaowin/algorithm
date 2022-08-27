package leetcode.editor.en;

/**
 * 反转单链表
 */
public class Q206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new Q206_ReverseLinkedList().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList1(ListNode head) {
            if (head == null) {
                return head;
            }
            head = new ListNode(0, head);
            ListNode p = head.next;
            ListNode q = null;
            head.next = null;
            while (p != null) {
                q = p;
                p = p.next;
                q.next = head.next;
                head.next = q;
            }
            return head.next;
        }

        /**
         * 头插法
         */
        public ListNode reverseList2(ListNode head) {
            if (head == null) {
                return head;
            }
            //使用头插法
            ListNode dummy = new ListNode(0);
            ListNode newHead = dummy;
            ListNode temp = null;
            while (head != null) {
                //从head摘下一个头
                temp = head;
                head = head.next;  //head移到下一个
                temp.next = newHead.next;   //头插法插入
                newHead.next = temp;
            }
            return dummy.next;
        }

        /**
         * 头插法
         */
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return head;
            }
            //使用头插法
            ListNode newHead = null;
            ListNode temp = null;
            while (head != null) {
                //从head摘下一个头
                temp = head;
                head = head.next;  //head移到下一个
                temp.next = newHead;   //头插法插入
                newHead = temp;
            }
            return newHead;
        }

        /**
         * 迭代法
         */
        public ListNode reverseList3(ListNode head) {
            ListNode prev = null;
            ListNode next = null;
            while (head != null) {
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
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