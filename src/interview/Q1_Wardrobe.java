package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://image.yuhaowin.com/2022/05/30/230035.pdf
 */
public class Q1_Wardrobe {

    public static void main(String[] args) {
        int[] zs = new int[]{50, 60, 1000};
        zs = new int[]{50, 600, 700, 1000};
        int n = zs.length;
        Q1_Wardrobe q1Wardrobe = new Q1_Wardrobe();
        List<LinkedList<Integer>> result = q1Wardrobe.execute(n, zs);
        result.stream().forEach(ans -> {
            ans.stream().forEach(it -> System.out.print (it + " "));
            System.out.println();
        });
    }

    public List<LinkedList<Integer>> execute(int n, int[] zs) {
        if (zs == null || n != zs.length) {
            throw new IllegalArgumentException("数据异常");
        }
        return process(2000, n, zs);
    }

    private List<LinkedList<Integer>> process(int height, int n, int[] source) {
        int count = n + 1;
        int average = height / count;
        // 每个隔板目标位置
        int[] target = new int[source.length];
        target[0] = average;
        for (int i = 1; i < source.length; i++) {
            target[i] = target[i - 1] + average;
        }
        List<LinkedList<Integer>> result = new ArrayList<>();
        doProcess(0, source.length - 1, source, target, new LinkedList<>(), result);
        return result;
    }

    /**
     * 计算从 start 到 end 位置调整的结果保存至 ans,所有结果保存至 result
     */
    private void doProcess(int start, int end, int[] source, int[] target, LinkedList<Integer> ans, List<LinkedList<Integer>> result) {
        if (start == end) {
            //拷贝 ans 到 temp 中，并保存至 result 中。
            LinkedList<Integer> temp = new LinkedList<>();
            for (Integer item : ans) {
                temp.add(item);
            }
            // 最后一个需要调整的隔板
            temp.add(start + 1);
            result.add(temp);
            return;
        }

        // start 位置的隔板是否可以移动
        boolean startCanMove = (source[start] > target[start])// 可以向下移动
                // 可以向上移动
                || (source[start] < target[start] && source[start + 1] > target[start]);
        if (startCanMove) {
            ans.add(start + 1);
            swap(source, target, start);
            doProcess(start + 1, end, source, target, ans, result);
            // 恢复现场
            ans.removeLast();
            swap(source, target, start);
        }

        // end 位置的隔板是否可以移动
        boolean endCanMove = (source[end] < target[end])// 可以向上移动
                // 可以向下移动
                || (source[end] > target[end] && source[end - 1] < target[end]);
        if (endCanMove) {
            ans.add(end + 1);
            swap(source, target, end);
            doProcess(start, end - 1, source, target, ans, result);
            // 恢复现场
            ans.removeLast();
            swap(source, target, end);
        }
    }

    private void swap(int[] source, int[] target, int index) {
        int temp = source[index];
        source[index] = target[index];
        target[index] = temp;
    }
}
