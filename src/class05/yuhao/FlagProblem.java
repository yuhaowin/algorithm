package class05.yuhao;

/**
 * 荷兰国旗问题一：
 * 给定一个数组 arr，给定一个数 x，小于等于 x 的数放在左边（不要求有序），大于 x 的数放在右边（不要求有序）。
 * 要求,不能使用辅助数组，O(N)
 * 荷兰国旗问题二：
 * 给定一个数组 arr，给定一个数 x，小于 x 的数放在左边（不要求有序），等于 x 的数放中间，大于 x 的数放在右边（不要求有序）。
 * 要求,不能使用辅助数组，O(N)
 */
public class FlagProblem {

    public static void main(String[] args) {
        FlagProblem flagProblem = new FlagProblem();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        flagProblem.sort(nums, 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 1、当前数 <= x ---> 把当前数和小于等于区域的下一个数交换,小于等于区域向右扩大 1 个,当前数到下一个。
     * 2、当前数  > x ---> 当前数到下一个。
     * 小于区域的推着大于区域的数往右走。
     */
    public void sort0(int[] nums, int x) {
        int N = nums.length;
        int L = -1;
        int index = 0;
        while (index < N) {
            if (nums[index] > x) {
                index++;
            } else {
                swap(nums, index, L + 1);
                L++;
                index++;
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * 1、当前数 < x ---> 把当前数和小于区域的下一个数交换,小于区域向右扩大 1 个,当前数到下一个。
     * 2、当前数 = x ---> 当前数到下一个。
     * 3、当前数 > x ---> 把当前数和大于区域的上一个数交换,大于区域向左扩大 1 个,当前数不变。
     */
    public void sort(int[] nums, int x) {
        int N = nums.length;
        int L = -1;
        int R = N;
        int index = 0;
        while (index < R) {
            if (nums[index] < x) {
                swap(nums, index, L + 1);
                index++;
                L++;
            } else if (nums[index] == x) {
                index++;
            } else if (nums[index] > x) {
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
