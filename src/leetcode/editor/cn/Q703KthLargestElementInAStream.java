package leetcode.editor.cn;

public class Q703KthLargestElementInAStream {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = new int[]{4, 5, 8, 2};
        KthLargest solution = new Q703KthLargestElementInAStream().new KthLargest(k, nums);
        System.out.println(solution.add(3) == 4);
        System.out.println(solution.add(5) == 5);
        System.out.println(solution.add(10) == 5);
        System.out.println(solution.add(9) == 8);
        System.out.println(solution.add(4) == 8);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {
        int[] heap;
        int limit;
        int heapSize;

        public KthLargest(int k, int[] nums) {
            limit = k + 1;
            heap = new int[k + 1];
            heapSize = 0;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            heap[heapSize] = val;
            shiftUp(heap, heapSize);
            heapSize++;
            if (heapSize == limit) {
                heapSize--;
                swap(heap, 0, heapSize);
                shiftDown(heap, 0, heapSize);
            }
            return heap[0];
        }

        private void shiftUp(int[] heap, int index) {
            int p = (index - 1) / 2;
            while (heap[index] < heap[p]) {
                swap(heap, index, p);
                index = p;
                p = (index - 1) / 2;
            }
        }

        private void shiftDown(int[] heap, int index, int heapSize) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            while (left < heapSize) {
                int small = right < heapSize && heap[right] < heap[left] ? right : left;
                small = heap[small] < heap[index] ? small : index;
                if (small == index) {
                    break;
                }
                swap(heap, small, index);
                index = small;
                left = 2 * index + 1;
                right = 2 * index + 2;
            }
        }

        private void swap(int[] heap, int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }
    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}
