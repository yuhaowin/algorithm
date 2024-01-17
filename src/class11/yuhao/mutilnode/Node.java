package class11.yuhao.mutilnode;

import java.util.List;

public class Node {

    public List<Node> children;
    public int val;

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
