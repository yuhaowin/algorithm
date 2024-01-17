package class11.yuhao.mutilnode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        Node node_5 = new Node(5, new ArrayList<>());
        Node node_6 = new Node(6, new ArrayList<>());
        Node node_7 = new Node(7, new ArrayList<>());
        Node node_8 = new Node(8, new ArrayList<>());
        Node node_9 = new Node(9, new ArrayList<>());


        Node node_2 = new Node(2, Arrays.asList(node_5, node_6));
        Node node_3 = new Node(3, Arrays.asList(node_7));
        Node node_4 = new Node(4, Arrays.asList(node_8, node_9));


        Node node_1 = new Node(1, Arrays.asList(node_2, node_3, node_4));

        Test test = new Test();

        String serialize = test.serialize(node_1);
        System.out.println(serialize);

        Node node = test.deserialize(serialize);

        System.out.println();

    }


    // 含义：将一个Node序列化为"parent[child_1,child_2...child_n]"的形式
    public String serialize(Node root) {
        // 边界
        if (root == null) return "";

        // 将parent加入
        StringBuilder ans = new StringBuilder();
        ans.append(root.val);
        if (root.children.isEmpty()) {
            return ans.toString();
        }

        // 将children都加入，children的两侧用[]包裹
        ans.append("[");
        for (Node c : root.children) {
            // 重新利用serialize()函数的含义，把每一个child Node都序列化即可
            ans.append(serialize(c));
            ans.append(",");
        }
        ans.deleteCharAt(ans.length() - 1);
        ans.append("]");

        return ans.toString();
    }

    // 含义：将一个形为"parent[child_1,child_2...child_n]"的字符串反序列化为Node
    public Node deserialize(String data) {
        // 边界
        if (data.isEmpty()) return null;

        // 找到parent
        int idx = data.indexOf("[");
        // 如果没有children则返回
        if (idx == -1) return new Node(Integer.parseInt(data), new ArrayList<>());

        // 如果有children
        String val = data.substring(0, data.indexOf("["));
        Node root = new Node(Integer.parseInt(val), new ArrayList<>());
        // 解析紧跟着parent的[]中的字符串，将其分为一个个代表child的字符串
        List<String> cData = parse(data.substring(idx + 1, data.length() - 1));
        for (String c : cData) {
            // 重新利用deserialize()函数的含义，把每一个child的字符串都反序列化再加入parent的children中即可
            root.children.add(deserialize(c));
        }
        return root;
    }

    // 解析形为"child_1,child_2...child_n"的字符串
    // 将其分为多个字符串，分别代表child_1,child_2...child_n
    List<String> parse(String data) {
        List<String> ans = new ArrayList<>();
        int leftBracket = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (c == '[') leftBracket++;
            else if (c == ']') leftBracket--;
            else if (c == ',') {
                if (leftBracket == 0) {
                    ans.add(sb.toString());
                    sb.setLength(0);
                    continue;
                }
            }
            sb.append(c);
        }
        ans.add(sb.toString());
        return ans;
    }
}

