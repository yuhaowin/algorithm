package class27.yuhao;

/**
 * 1、字符串当前下标之前的字符串，前缀串和后缀串相等的最长的长度,要求前缀和后缀不能到达整体.
 * abcabck，k 之前的字符串是 abcabc，前缀串和后缀串相等最长的长度是 abc 3,那么 k 位置的信息就记为 3,每一个字符串都求出这样的信息，组成的数组叫 next 数组
 * 前缀：a ab abc abca abcab
 * 后缀：c bc abc cabc bcabc
 * next: [-1,0]
 * <p>
 * leetcode 28 134
 * <p>
 * 往右推
 * 1、j 位置开始寻找字串
 * 2、0-j 不可能有匹配的字串
 */
public class KMP {

    public static void main(String[] args) {
        KMP kmp = new KMP();
        int strSize = 20;
        int matchSize = 5;
        int possibilities = 5;
        int testTimes = 100000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            String match = getRandomString(possibilities, matchSize);
            if (kmp.indexOf(str, match) != str.indexOf(match)) {
                System.out.println(String.format("Oops!, str: %s, match: %s", str, match));
            }
        }
        System.out.println("test finish");

        int[] next1 = kmp.getNext("ababc".toCharArray());
        int[] next2 = kmp.getNext1("ababc".toCharArray());

        System.out.println();
    }

    public int indexOf(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < s2.length()) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int x = 0, y = 0;

        int[] next = getNext1(str2);

        while (x < str1.length && y < str2.length) {
            if (str1[x] == str2[y]) {
                x++;
                y++;
            } else if (next[y] == -1) { // 表现 y == 0 ,进一步表现 str1[x] 和 str2[0] 不相等 x 要加一
                x++;
            } else {
                y = next[y];
            }
        }
        return y == str2.length ? x - y : -1;
    }

    private int[] getNext(char[] strs) {
        if (strs.length == 1) {
            return new int[]{-1};
        }
        if (strs.length == 2) {
            return new int[]{-1, 0};
        }

        int[] next = new int[strs.length];
        next[0] = -1;
        next[1] = 0;

        // 目前在哪个位置上求 next 数组的值
        int index = 2;
        // 当前是哪个位置的值再和 index-1 位置的字符比较
        // index-1 位置 在 next 数组上的值
        int x = 0;
        while (index < strs.length) {
            if (strs[index - 1] == strs[x]) {
                next[index++] = ++x;
            } else if (x > 0) {
                x = next[x];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }

    private int[] getNext1(char[] strs) {
        int[] text = new int[strs.length];
        text(strs, strs.length - 1, text);
        return text;
    }

    private void text(char[] strs, int index, int[] next) {
        if (index == 0) {
            next[0] = -1;
            return;
        }
        if (index == 1) {
            next[0] = -1;
            next[1] = 0;
            return;
        }
        text(strs, index - 1, next);
        int x = next[index - 1];

        if (strs[index - 1] == strs[x]) {
            next[index++] = ++x;
        } else if (x > 0) {
            while (x > 0) {
                x = next[x];
                if (strs[index - 1] == strs[x]) {
                    next[index++] = ++x;
                    break;
                }
            }
        } else {
            next[index++] = 0;
        }
    }


    //------------------------------------------------------------------------------------------------------------------

    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }
}
