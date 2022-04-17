package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * todo 需要使用 quick sort 优化
 * https://image.yuhaowin.com/2022/04/15/224112.png
 */
public class Q215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new Q215KthLargestElementInAnArray().new Solution();
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(solution.findKthLargest(nums, k));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest1(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
            for (int num : nums) {
                queue.offer(num);
            }
            int ans = -1;
            for (int i = 0; i < k; i++) {
                ans = queue.poll();
            }
            return ans;
        }

        public int findKthLargest(int[] nums, int k) {
            int heapSize = nums.length;
            for (int index = nums.length / 2; index >= 0; index--) {
                shiftDown(nums, index, heapSize);
            }

            for (int i = 0; i < k - 1; i++) {
                heapSize--;
                swap(nums, 0, heapSize);
                shiftDown(nums, 0, heapSize);
            }

            return nums[0];
        }

        private void shiftDown(int[] arr, int index, int heapSize) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            while (left < heapSize) {
                int large = right < heapSize && arr[right] > arr[left] ? right : left;
                large = arr[large] > arr[index] ? large : index;
                if (large == index) {
                    break;
                }
                swap(arr, index, large);
                index = large;
                left = 2 * index + 1;
                right = 2 * index + 2;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}