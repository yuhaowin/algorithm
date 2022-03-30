package class07.yuhao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定很多线段，每个线段都有两个数[start， end]，
 * <p>
 * 表示线段开始位置和结束位置，左右都是闭区间
 * <p>
 * 规定：
 * <p>
 * 1）线段的开始和结束位置一定都是整数值
 * <p>
 * 2)线段重合区域的长度必须>=1
 * <p>
 * 返回线段最多重合区域中，包含了几条线段
 */
public class CoverMax {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2},
                {1, 3},
                {1, 4},
                {1, 5},
                {2, 6},
                {2, 7},
                {2, 8},
                {2, 9},
                {2, 10},
        };
        CoverMax coverMax = new CoverMax();
        System.out.println(coverMax.searchMax(arr));
    }

    public int searchMax(int[][] arr) {
        List<Line> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            temp.add(new Line(arr[i][0], arr[i][1]));

        }
        temp.sort(Comparator.comparingInt(o -> o.start));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;

        for (Line line : temp) {
            while (!heap.isEmpty() && heap.peek() <= line.start) {
                heap.poll();
            }
            heap.add(line.end);
            max = Math.max(max, heap.size());
        }

        return max;
    }

    static class Line {
        public int start;
        public int end;

        public Line(int s, int e) {
            start = s;
            end = e;
        }
    }
}
