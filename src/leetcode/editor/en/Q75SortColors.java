package leetcode.editor.en;

public class Q75SortColors {
    public static void main(String[] args) {
        Solution solution = new Q75SortColors().new Solution();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int N = nums.length;
            int index = 0;
            int L = -1;
            int R = N;
            while (index < R) {
                if (nums[index] < 1) {
                    swap(nums, index, L + 1);
                    index++;
                    L++;
                } else if (nums[index] == 1) {
                    index++;
                } else if (nums[index] > 1) {
                    swap(nums, index, R - 1);
                    R--;
                }
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