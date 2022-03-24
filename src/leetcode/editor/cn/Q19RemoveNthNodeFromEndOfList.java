//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1903 👎 0

package leetcode.editor.cn;

public class Q19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new Q19RemoveNthNodeFromEndOfList().new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        head = new ListNode(1, new ListNode(2));

        ListNode listNode = solution.removeNthFromEnd(head, 2);
        System.out.println();
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
        public ListNode removeNthFromEnd(ListNode head, int n) {

//            ListNode temp = head;
//            int length = getLength(head);
//
//            if (length == n) {
//                return head.next;
//            }
//
//            for (int i = 1; i < length - n; i++) {
//                temp = temp.next;
//            }
//
//            temp.next = temp.next.next;
//            return head;

            ListNode first = head;
            ListNode second = null;

            while (first != null) {
                n--;
                if (n == -1) {
                    second = head;
                }
                if (n < -1) {
                    second = second.next;
                }
                first = first.next;
            }

            if (second == null) {
                return head.next;
            } else {
                second.next = second.next.next;
            }
            return head;
        }

        private int getLength(ListNode temp) {
            int count = 0;
            while (temp != null) {
                temp = temp.next;
                count++;
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


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