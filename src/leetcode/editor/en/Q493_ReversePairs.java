package leetcode.editor.en;

public class Q493_ReversePairs {
    public static void main(String[] args) {
        Solution solution = new Q493_ReversePairs().new Solution();
        int[] nums = new int[]{2, 4, 3, 5, 1};
        System.out.println(solution.reversePairs(nums) == 3);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(((long) 2147483647 * 2));
        System.out.println(((long) (2147483647 * 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reversePairs(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }
            return recursive(nums, 0, nums.length - 1);
        }

        public int recursive(int[] arr, int L, int R) {
            if (L == R) {
                return 0;
            }
            int M = (L + R) / 2;
            int left = recursive(arr, L, M);
            int right = recursive(arr, M + 1, R);
            int merge = merge(arr, L, M, R);
            return left + right + merge;
        }

        public int merge(int[] arr, int L, int M, int R) {
            int res = 0;
            int i = 0;
            int p1 = L;
            int p2 = M + 1;
            int[] help = new int[R - L + 1];

            int temp = M + 1;
            for (int j = L; j <= M; j++) {
                // while (temp <= R && (long) arr[j] > (long) (2 * arr[temp])) {
                while (temp <= R && (long) arr[j] > (long) arr[temp] * 2) {
                    temp++;
                }
                res += temp - p2;
            }

            while (p1 <= M && p2 <= R) {
                if (arr[p1] < arr[p2]) {
                    help[i++] = arr[p1++];
                } else {
                    help[i++] = arr[p2++];
                }
            }
            while (p1 <= M) {
                help[i++] = arr[p1++];
            }
            while (p2 <= R) {
                help[i++] = arr[p2++];
            }
            for (int j = 0; j < help.length; j++) {
                arr[L + j] = help[j];
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}