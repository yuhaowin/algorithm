package class20.yuhao_dp;

import java.util.HashMap;

/**
 * @作者：yuhao
 * @时间：2022年02月27日 23:14
 * @说明：TODO
 */
public class Test {

  public static void main(String[] args) {
    Test test = new Test();
    int[] ints = test.twoSum(new int[]{2, 7, 11, 15}, 9);
    System.out.println();
  }

  public int[] twoSum(int[] nums, int target) {

    HashMap<Integer, Integer> cache = new HashMap();
    for (int index = 0; index < nums.length; index++) {
      int minus = target - nums[index];
      if (cache.containsKey(minus)) {
        return new int[]{index, cache.get(minus)};
      }
      cache.put(nums[index], index);
    }
    return null;
  }

}
