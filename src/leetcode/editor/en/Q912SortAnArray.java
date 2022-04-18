package leetcode.editor.en;

public class Q912SortAnArray {
    public static void main(String[] args) {
        Solution solution = new Q912SortAnArray().new Solution();
        int[] nums = new int[]{2, 3, 1, 6, 4, 7, 5, 0, 8, 3};
        solution.sortArray(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            if (nums != null && nums.length > 1) {
                processVersion3(nums, 0, nums.length - 1);
            }
            return nums;
        }

        public void processVersion3(int[] arr, int L, int R) {
            if (L >= R) {
                return;
            }
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] equalArea = netherlandsFlag(arr, L, R);
            processVersion3(arr, L, equalArea[0] - 1);
            processVersion3(arr, equalArea[1] + 1, R);
        }

        /**
         * 返回等于区域的下标
         */
        private int[] netherlandsFlag(int[] arr, int L, int R) {
            if (L > R) {
                return new int[]{-1, -1};
            }
            if (L == R) {
                return new int[]{L, R};
            }
            int less = L - 1;   // < 区 右边界
            int more = R;       // > 区 左边界
            int index = L;
            while (index < more) { // 当前位置，不能和 >区的左边界撞上
                if (arr[index] == arr[R]) {
                    index++;
                } else if (arr[index] < arr[R]) {
                    swap(arr, less + 1, index);
                    less++;
                    index++;
                } else if (arr[index] > arr[R]) {
                    swap(arr, index, more - 1);
                    more--;
                }
            }
            swap(arr, more, R); // <[R]   =[R]   >[R]
            return new int[]{less + 1, more};
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}