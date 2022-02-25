package abc.yuhaowin.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的全排列
 * <p>
 * 假设一个字符串：abcdef
 * <p>
 * 0 位置有6种可能，1 位置有5种可能，2位置有4种可能
 * <p>
 * 涉及到递归中深度优先遍历中的恢复现场
 */
public class PrintAllPermutation {

  public static void main(String[] args) {

    PrintAllPermutation printAllPermutation = new PrintAllPermutation();
    List<String> result = printAllPermutation.process("abc");
    result.forEach(item -> System.out.println(item));
    System.out.println("-----------------------");
    result = printAllPermutation.process1("abc");
    result.forEach(i -> System.out.println(i));
    System.out.println("-----------------------");
    result = printAllPermutation.process2("acc");
    result.forEach(i -> System.out.println(i));
  }

  private List<String> process(String string) {
    char[] chars = string.toCharArray();
    List<String> answer = new ArrayList<>();
    String path = "";
    ArrayList<Character> characters = new ArrayList<>();
    for (char b : chars) {
      characters.add(b);
    }
    test(characters, path, answer);
    return answer;
  }

  private void test(ArrayList<Character> rest, String path, List<String> answer) {
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
      test(rest, path + cur, answer);
      //选择下一个字符之前需要把移除的字符加回来，恢复现场
      rest.add(i, cur);
    }
  }

  //================================================================================================

  private List<String> process1(String string) {
    char[] chars = string.toCharArray();
    List<String> answer = new ArrayList<>();
    test1(chars, 0, answer);
    return answer;
  }

  private void test1(char[] chars, int index, List<String> answer) {
    if (index == chars.length) {
      answer.add(new String(chars));
      return;
    }
    for (int i = index; i < chars.length; i++) {
      swap(chars, index, i);
      test1(chars, index + 1, answer);
      swap(chars, index, i);
    }
  }

  private void swap(char[] chars, int from, int to) {
    char temp = chars[from];
    chars[from] = chars[to];
    chars[to] = temp;
  }

  //------------------------------------------------------------------------------------------------


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
    boolean[] table = new boolean[256];
    for (int i = index; i < chars.length; i++) {
      if (!table[chars[i]]) {
        table[chars[i]] = true;
        swap(chars, index, i);
        test2(chars, index + 1, answer);
        swap(chars, index, i);
      }
    }
  }
}
