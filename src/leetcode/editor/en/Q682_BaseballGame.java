package leetcode.editor.en;

public class Q682_BaseballGame {
    public static void main(String[] args) {
        Solution solution = new Q682_BaseballGame().new Solution();
        String[] ops = new String[]{"5", "2", "C", "D", "+"};
        System.out.println(solution.calPoints(ops));
        ops = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(solution.calPoints(ops));
        ops = new String[]{"-60", "D", "-36", "30", "13", "C", "C", "-33", "53", "79"};
        System.out.println(solution.calPoints(ops));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calPoints1(String[] ops) {
            int ans = 0;
            for (int i = 0; i < ops.length; i++) {
                if (ops[i].equals("C")) {
                    ops[i] = "#";
                    int count = 0;
                    int index = i - 1;
                    while (index >= 0 && count < 1) {
                        if (!ops[index].equals("#")) {
                            ops[index] = "#";
                            count++;
                        }
                        index--;
                    }
                }

                if (ops[i].equals("+")) {
                    int sum = 0;
                    int count = 0;
                    int index = i - 1;
                    while (index >= 0 && count < 2) {
                        if (!ops[index].equals("#")) {
                            sum += Integer.parseInt(ops[index]);
                            count++;
                        }
                        index--;
                    }
                    ops[i] = String.valueOf(sum);
                }

                if (ops[i].equals("D")) {
                    int sum = 0;
                    int count = 0;
                    int index = i - 1;
                    while (index >= 0 && count < 1) {
                        if (!ops[index].equals("#")) {
                            sum += Integer.parseInt(ops[index]) * 2;
                            count++;
                        }
                        index--;
                    }
                    ops[i] = String.valueOf(sum);
                }
            }

            for (int i = 0; i < ops.length; i++) {
                if (!ops[i].equals("#")) {
                    ans += Integer.parseInt(ops[i]);
                }
            }
            return ans;
        }

        //--------------------------------------------------------------------------------------------------------------

        public int calPoints(String[] ops) {
            int[] arr = new int[ops.length];
            int i = 0;
            int sum = 0;
            for (String s : ops) {
                if (s.equals("+")) {
                    arr[i] = arr[i - 1] + arr[i - 2];
                    sum += arr[i++];
                    continue;
                }
                if (s.equals("D")) {
                    arr[i] = 2 * arr[i - 1];
                    sum += arr[i++];
                    continue;
                }
                if (s.equals("C")) {
                    sum -= arr[i - 1];
                    arr[i - 1] = 0;
                    i--;
                    continue;
                }
                arr[i] = Integer.valueOf(s);
                sum += arr[i++];
            }
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}