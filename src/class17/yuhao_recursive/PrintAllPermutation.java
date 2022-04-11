package class17.yuhao_recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的全排列，假设一个字符串为：abcdef
 * 0 位置有 6 种可能，1 位置有 5 种可能，2 位置有 4 种可能
 * <p>
 * 涉及到递归中深度优先遍历中的恢复现场
 */
public class PrintAllPermutation {

    public static void main(String[] args) {
        String str = "acc";
        PrintAllPermutation printAllPermutation = new PrintAllPermutation();
        List<String> result = printAllPermutation.process1(str);
        result.forEach(item -> System.out.println(item));
        System.out.println("--------------------------");
        result = printAllPermutation.process2(str);
        result.forEach(item -> System.out.println(item));
        System.out.println("--------------------------");
        result = printAllPermutation.process3(str);
        result.forEach(item -> System.out.println(item));
    }

    //------------------------------------------------------------------------------------------------------------------

    private List<String> process1(String string) {
        char[] chars = string.toCharArray();
        List<String> answer = new ArrayList<>();
        String path = "";
        ArrayList<Character> characters = new ArrayList<>();
        for (char b : chars) {
            characters.add(b);
        }
        test1(characters, path, answer);
        return answer;
    }

    private void test1(ArrayList<Character> rest, String path, List<String> answer) {
        if (rest.isEmpty()) {
            answer.add(path);
            return;
        }
        int N = rest.size();
        for (int i = 0; i < N; i++) {
            //选择当前字符作为下一个字符
            Character cur = rest.get(i);
            //剩下的集合中就应该移除这个已经选择的字符
            rest.remove(i);
            test1(rest, path + cur, answer);
            //选择下一个字符之前需要把移除的字符加回来，恢复现场
            rest.add(i, cur);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    private List<String> process2(String string) {
        char[] chars = string.toCharArray();
        List<String> answer = new ArrayList<>();
        test2(chars, 0, answer);
        return answer;
    }

    private void test2(char[] chars, int index, List<String> answer) {
        if (index == chars.length) {
            answer.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            test2(chars, index + 1, answer);
            swap(chars, index, i);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    // 去重版本
    private List<String> process3(String string) {
        char[] chars = string.toCharArray();
        List<String> answer = new ArrayList<>();
        test3(chars, 0, answer);
        return answer;
    }

    private void test3(char[] chars, int index, List<String> answer) {
        if (index == chars.length) {
            answer.add(new String(chars));
            return;
        }
        // 统计已经处理过的字符
        boolean[] table = new boolean[256];
        for (int i = index; i < chars.length; i++) {
            if (!table[chars[i]]) {
                table[chars[i]] = true;
                swap(chars, index, i);
                test3(chars, index + 1, answer);
                swap(chars, index, i);
            }
        }
    }

    private void swap(char[] chars, int from, int to) {
        char temp = chars[from];
        chars[from] = chars[to];
        chars[to] = temp;
    }
}
