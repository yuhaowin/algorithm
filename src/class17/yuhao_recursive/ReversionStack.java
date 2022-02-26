package class17.yuhao_recursive;

import java.util.Stack;

/**
 * 使用 recursive 逆序一个 stack
 * <p>
 * 给你一个 stack，请你逆序这个 stack
 * <p>
 * - 不能申请额外的数据结构
 * <p>
 * - 只能使用递归函数
 */
public class ReversionStack {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    ReversionStack reversionStack = new ReversionStack();
    reversionStack.reverse1(stack);
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
    System.out.println("------------------");
    stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    reversionStack.reverse(stack);
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }

  private void reverse1(Stack<Integer> stack) {
    int size = stack.size();
    Stack<Integer> tempStack = new Stack<>();
    for (int i = size; i > 0; i--) {
      int topElement = stack.pop();
      for (int j = 1; j < i; j++) {
        tempStack.push(stack.pop());
      }
      stack.push(topElement);
      while (!tempStack.isEmpty()) {
        stack.push(tempStack.pop());
      }
    }
  }

  //------------------------------------------------------------------------------------------------

  private void reverse(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return;
    }
    int result = f(stack);
    reverse(stack);
    stack.push(result);
  }

  /**
   * 返回这个 stack 的 栈底元素
   * <p>
   * 其他元素依次往下移动 如 123 -> 12 返回 3
   */
  private int f(Stack<Integer> stack) {
    Integer result = stack.pop();
    if (stack.isEmpty()) {
      return result;
    }
    int last = f(stack);
    stack.push(result);
    return last;
  }
}
