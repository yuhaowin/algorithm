package leetcode.editor.en;

public class Q2_AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Q2_AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode ans = solution.addTwoNumbers(l1, l2);
        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode temp = dummy;

            int v1, v2, carry = 0;
            while (l1 != null || l2 != null) {
                v1 = 0;
                v2 = 0;
                if (l1 != null) {
                    v1 = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    v2 = l2.val;
                    l2 = l2.next;
                }
                int sum = v1 + v2 + carry;
                carry = sum / 10;
                int currentVal = sum % 10;
                temp.next = new ListNode(currentVal);
                temp = temp.next;
            }
            // 如果还有进位，单独处理
            if (carry == 1) {
                temp.next = new ListNode(1);
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //Definition for singly-linked list.
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