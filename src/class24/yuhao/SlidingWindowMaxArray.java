package class24.yuhao;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 假设一个固定大小为 W 的窗口，依次划过 arr，
 * 返回每一次滑出状况的最大值
 * 例如：arr = [4,3,5,4,3,3,6,7], W=3
 * 返回：[5,5,5,4,6,7]
 */
public class SlidingWindowMaxArray {

    public static void main(String[] args) {
        int W = 3;
        int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        SlidingWindowMaxArray slidingWindowMaxArray = new SlidingWindowMaxArray();
        int[] result = slidingWindowMaxArray.process(arr, W);
        Arrays.stream(result).forEach(item -> System.out.print(item + " "));
    }

    public int[] process(int[] nums, int W) {
        if (nums == null || nums.length < W) {
            return null;
        }
        int N = nums.length;
        int index = 0;
        int[] result = new int[N - W + 1];
        // 存放的时数组的下标
        LinkedList<Integer> queue = new LinkedList<>();
        for (int R = 0; R < N; R++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[R]) {
                queue.pollLast();
            }
            queue.addLast(R);
            // 当队列头部的下标已经在窗口的左侧，需要淘汰掉
            if (queue.peekFirst() == R - W) {
                queue.pollFirst();
            }
            // 当右侧下标大于 2 时，窗口才形成。
            if (W - 1 <= R) {
                result[index++] = nums[queue.peekFirst()];
            }
        }
        return result;
    }
}
