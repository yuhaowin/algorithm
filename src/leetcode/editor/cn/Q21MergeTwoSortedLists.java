//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2294 👎 0

package leetcode.editor.cn;

public class Q21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Q21MergeTwoSortedLists().new Solution();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = solution.mergeTwoLists(l1, l2);
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null || list2 == null) {
                return list1 == null ? list2 : list1;
            }
            ListNode prehead = new ListNode(-1);
            ListNode result = prehead;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    result.next = list1;
                    list1 = list1.next;
                } else {
                    result.next = list2;
                    list2 = list2.next;
                }
                result = result.next;
            }
            result.next = list1 == null ? list2 : list1;
            return prehead.next;
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