package class19.yuhao_dp;

/**
 * 给定一个字符串数组 arr，给定一个字符串 target。
 * 出现的字符都是英文小写, arr 每一个字符串，代表一种贴纸，每种贴纸的数量无数张，可以把单个字符剪开使用
 * 目的是拼出 target 来，返回需要至少多少张贴纸可以完成这个任务。
 * 例如：arr={"ba"，"c"，"abcd"}，target="babac"
 * 至少需要"ba"和"abcd"两张贴纸，因为使用这两张贴纸，把每一个字符单独剪开，含有2个a、2个b、1个c。是可以拼出 target 的。所以返回2。
 */
public class StickersToSpellWord {

    public static void main(String[] args) {
        StickersToSpellWord stickersToSpellWord = new StickersToSpellWord();
        String target = "babac";
        String[] array = {"ba", "c", "abcd"};
        System.out.println(stickersToSpellWord.process1(array, target));
        System.out.println(stickersToSpellWord.process2(array, target));
    }

    //------------------------------------------------------------------------------------------------------------------

    public int process1(String[] array, String target) {
        if (target.length() == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        // 所有贴纸每一个都尝试一次，求出后续 target 的使用数量
        for (String item : array) {
            String rest = minus(item, target);
            if (target.length() != rest.length()) {
                result = Math.min(result, process1(array, rest));
            }
        }
        if (result == Integer.MAX_VALUE) {
            return result;
        } else {
            // 当前使用了一张贴纸，数量加 1
            return result + 1;
        }
    }

    private String minus(String item, String target) {
        int[] count = new int[26];
        char[] itemChars = item.toCharArray();
        char[] targetChars = target.toCharArray();
        for (char it : targetChars) {
            count[it - 'a']++;
        }
        for (char it : itemChars) {
            count[it - 'a']--;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            int ss = count[i];
            for (int j = 0; j < ss; j++) {
                builder.append((char) (i + 'a'));
            }
        }
        return builder.toString();
    }

    //------------------------------------------------------------------------------------------------------------------

    public int process2(String[] array, String target) {
        int N = array.length;
        //用词频表替代贴纸数组
        int[][] table = new int[N][26];
        for (int i = 0; i < N; i++) {
            char[] temp = array[i].toCharArray();
            for (char ch : temp) {
                table[i][ch - 'a']++;
            }
        }
        int ans = recursive(table, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int recursive(int[][] table, String target) {
        if (target.length() == 0) {
            return 0;
        }
        // target 做出词频统计
        int[] targetTable = new int[26];
        char[] targetArr = target.toCharArray();
        for (char cha : targetArr) {
            targetTable[cha - 'a']++;
        }
        int N = table.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            // 获取每一种贴纸
            int[] item = table[i];
            // 最关键的优化(重要的剪枝!这一步也是贪心!)
            if (item[targetArr[0] - 'a'] <= 0) {
                continue;
            }
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (targetTable[j] > 0) {
                    int nums = targetTable[j] - item[j];
                    for (int k = 0; k < nums; k++) {
                        builder.append((char) (j + 'a'));
                    }
                }
            }
            String rest = builder.toString();
            min = Math.min(min, recursive(table, rest));
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }
}
