package class19.yuhao_dp;

/**
 * 给定一个字符串 str，给定一个字符串类型的数组 arr，
 * <p>
 * 出现的字符都是小写英文, arr 每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，
 * <p>
 * 目的是拼出 str 来 返回需要至少多少张贴纸可以完成这个任务。
 * <p>
 * 例子：str="babac"，arr={"ba"，"c"，"abcd"}
 * <p>
 * 至少需要两张贴纸"ba"和"abcd"，因为使用这两张贴纸，把每一个字符单独剪开，含 有2个a、2个b、1个c。是可以拼出str的。所以返回2。
 */
public class StickersToSpellWord {

  public static void main(String[] args) {

    StickersToSpellWord stickersToSpellWord = new StickersToSpellWord();

    System.out.println(stickersToSpellWord.process(new String[]{"ba", "c", "abcd"}, "babac"));

    System.out.println(stickersToSpellWord.minus("abcd", "ac"));
  }


  public int process(String[] array, String target) {
    if (target.length() == 0) {
      return 0;
    }

    int result = Integer.MAX_VALUE;

    for (String item : array) {
      String rest = minus(target, item);
      if (target.length() != rest.length()) {
        result = Math.min(result, process(array, rest));
      }
    }

    if (result == Integer.MAX_VALUE) {
      return result;
    } else {
      return result + 1;
    }
  }

  private String minus(String target, String item) {
    int[] count = new int[26];
    char[] targetChars = target.toCharArray();
    char[] itemChars = item.toCharArray();

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

}
