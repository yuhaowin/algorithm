//Given the head of a singly linked list, return true if it is a palindrome.
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 10⁵]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics 栈 递归 链表
// 双指针 👍 1330 👎 0

package leetcode.editor.cn;

public class Q234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new Q234PalindromeLinkedList().new Solution();
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
        public boolean isPalindrome(ListNode head) {
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
    }
//leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
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