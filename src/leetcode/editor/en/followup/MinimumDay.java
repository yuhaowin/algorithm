package leetcode.editor.en.followup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有K个城市和N天。一家旅行社将在第n天向你展示k市。你应该找出你能参观所有城市的最少天数你也可以多次访问城市，但理想情況下，你不想这样做，因为你想尽量减少天数。
 * 输入：给出了一个日期和城市的列表，其中天是索引，城市是值。
 * 如：A=[7,4,7,3,4,1,7]，因此A[0]=7意味着旅行社将在第0天向您展示城市7，在第1天向您展示城市4等。
 * 因此，如果你从第0天開始，你将在第5天访问所有城市，但你也可以从第2天开始，在第5天结束。
 * 你至少需要花了4天的时间去参观所有的城市至少一次，那么答案就为 4
 */
public class MinimumDay {

    public static void main(String[] args) {
        MinimumDay day = new MinimumDay();
        int[] arr = new int[]{7, 4, 7, 3, 4, 1, 7};
        arr = new int[]{7, 7, 7, 7, 7, 7, 7};
        System.out.println(day.process(arr));
    }

    public int process(int[] arr) {
        int[] target = getTarget(arr);
        Map<Integer, Integer> table = new HashMap<>();
        for (int c : target) {
            table.put(c, 1);
        }
        //[L,R)
        int L = 0;
        int R = 0;
        int min = arr.length;
        int total = target.length;
        while (R < arr.length) {
            Integer temp = table.get(arr[R]) - 1;
            table.put(arr[R], temp);
            if (temp >= 0) {
                total--;
            }
            if (total == 0) {
                Integer temp1 = table.get(arr[L]);
                while (temp1 < 0) {
                    table.put(arr[L++], ++temp1);
                    temp1 = table.get(arr[L]);
                }
                min = Math.min(min, R - L + 1);
                table.put(arr[L++], ++temp1);
                total++;
            }
            R++;
        }
        return min;
    }

    private int[] getTarget(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int item : arr) {
            set.add(item);
        }
        int[] target = new int[set.size()];
        int index = 0;
        for (Integer item : set) {
            target[index++] = item;
        }
        return target;
    }
}


