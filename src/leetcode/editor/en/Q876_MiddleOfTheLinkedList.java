package leetcode.editor.en;

public class Q876_MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Solution solution = new Q876_MiddleOfTheLinkedList().new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(solution.middleNode(head).val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     */
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