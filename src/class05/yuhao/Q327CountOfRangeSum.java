package class05.yuhao;

/**
 * TODO
 * 给定一个数组 arr，两个整数 lower 和 upper，
 * 返回 arr 中有多少个子数组的累加和在 [lower,upper] 范围上。
 */
public class Q327CountOfRangeSum {

    public static void main(String[] args) {
        int lower = -2;
        int upper = 2;
        int[] nums = new int[]{-2, 5, -1};
        Q327CountOfRangeSum countOfRangeSum = new Q327CountOfRangeSum();
        System.out.println(countOfRangeSum.countRangeSum(nums, lower, upper));
        System.out.println("-----------------------------------------------");
        System.out.println(countOfRangeSum.countRangeSum1(nums, lower, upper));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int min = preSum[i] - upper;
            int max = preSum[i] - lower;
            for (int j = 0; j < i; j++) {
                if (min <= preSum[j] && preSum[j] <= max || min == 0 || max == 0) {
                    System.out.println(String.format("[%s,%s], num:%s", min, max, preSum[j]));
                    count++;
                }
            }
        }
        return count;
    }

    public int countRangeSum1(int[] nums, int lower, int upper) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int min = preSum[i] - upper;
            int max = preSum[i] - lower;
            for (int j = 1; j <= i; j++) {
                if (min <= preSum[j - 1] && preSum[j - 1] <= max) {
                    System.out.println(String.format("[%s,%s], num:%s", min, max, preSum[j - 1]));
                    count++;
                }
                System.out.println(String.format("11[%s,%s], num:%s", min, max, preSum[j - 1]));
            }
        }
        return count;
    }
}
