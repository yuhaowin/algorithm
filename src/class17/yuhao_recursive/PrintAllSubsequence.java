package class17.yuhao_recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串所有子序列
 * 例如：字符串 - 123456 子序列：12，13，14，123，124，125... 要求从前往后
 * <p>
 * 可以看作是否要某一位的数
 */
public class PrintAllSubsequence {

    public static void main(String[] args) {
        PrintAllSubsequence printAllSubsequence = new PrintAllSubsequence();
        List<String> result = printAllSubsequence.process("123");
        result.forEach(item -> System.out.println(item));
    }

    //------------------------------------------------------------------------------------------------------------------

    private List<String> process(String str) {
        char[] chars = str.toCharArray();
        List<String> answer = new ArrayList<>();
        subsequence(chars, 0, "", answer);
        return answer;
    }

    /**
     * @param chars       所有的字符
     * @param index       当前来到 chars[index] 位置做决策
     * @param subsequence 0 到 index-1 位置上决策的结果
     */
    private void subsequence(char[] chars, int index, String subsequence, List<String> answer) {
        if (index == chars.length) {
            answer.add(subsequence);
            return;
        }
        subsequence(chars, index + 1, subsequence, answer);
        subsequence(chars, index + 1, subsequence + chars[index], answer);
    }
}
