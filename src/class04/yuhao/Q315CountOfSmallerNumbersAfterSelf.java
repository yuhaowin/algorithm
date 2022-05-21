package class04.yuhao;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 * 315: https://leetcode.com/problems/count-of-smaller-numbers-after-self
 */
public class Q315CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new Q315CountOfSmallerNumbersAfterSelf().new Solution();
        int[] nums = new int[]{0, 2, 1};
        List<Integer> result = solution.countSmaller(nums);
        for (Integer temp : result) {
            System.out.print(temp + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] index;
        private int[] help;
        private int[] tempIndex;
        private int[] ans;

        public List<Integer> countSmaller(int[] nums) {
            this.help = new int[nums.length];
            this.index = new int[nums.length];
            this.tempIndex = new int[nums.length];
            this.ans = new int[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                index[i] = i;
            }
            mergeSort(nums, 0, nums.length - 1);
            List<Integer> list = new ArrayList<>();
            for (int num : ans) {
                list.add(num);
            }
            return list;
        }

        public void mergeSort(int[] arr, int L, int R) {
            if (L >= R) {
                return;
            }
            int mid = (L + R) >> 1;
            mergeSort(arr, L, mid);
            mergeSort(arr, mid + 1, R);
            merge(arr, L, mid, R);
        }

        public void merge(int[] arr, int L, int M, int R) {
            int i = L;
            int p1 = L;
            int p2 = M + 1;
            while (p1 <= M && p2 <= R) {
                if (arr[p1] < arr[p2]) {
                    help[i] = arr[p1];
                    tempIndex[i] = index[p1];
                    ans[index[p1]] += (p2 - M - 1);
                    ++p1;
                    ++i;
                } else {
                    help[i] = arr[p2];
                    tempIndex[i] = index[p2];
                    ++p2;
                    ++i;
                }
            }
            while (p1 <= M) {
                help[i] = arr[p1];
                tempIndex[i] = index[p1];
                ans[index[p1]] += (p2 - M - 1);
                ++p1;
                ++i;
            }
            while (p2 <= R) {
                help[i] = arr[p2];
                tempIndex[i] = index[p2];
                ++p2;
                ++i;
            }
            for (int k = L; k <= R; ++k) {
                index[k] = tempIndex[k];
                arr[k] = help[k];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}