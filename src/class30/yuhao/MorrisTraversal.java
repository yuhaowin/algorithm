package class30.yuhao;

/**
 * 二叉树，递归遍历，每一个节点都会到达 3 次，时间为 O(N)
 * 空间复杂度为，O(M) M 为数的高度
 * Morris 遍历的时间复杂度为 O(N),空间复杂度为 O(1)
 */

/**
 * Morris遍历细节
 * 假设来到当前节点 cur,开始时 cur 来到头节点位置
 * 1、如果 cur 没有左孩子,cur 向右移动(cur = cur.right)
 * 2、如果 cur 有左孩子,找到左子树上最右的节点 mostRight:
 * a、如果 mostRight 的右指针指向空，让其指向 cur， 然后 cur 向左移动(cur = cur.left)
 * b、如果 mostRight 的右指针指向 cur，让其指向 null， 然后 cur 向右移动(cur = cur.right)
 * 3、cur 为空时遍历停止
 */
public class MorrisTraversal {

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);

        MorrisTraversal traversal = new MorrisTraversal();
        traversal.morrisPre(head);
        System.out.println();
        traversal.morrisIn(head);
    }

    //------------------------------------------------------------------------------------------------------------------

    public void morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                    cur = cur.right;
                    continue;
                }
            }
            cur = cur.right;
        }
    }

    /**
     * 如果一个节点无左数，遍历到这个节点就打印
     * 如果一个节点有左数，第一次遍历到这个节点就打印
     */
    public void morrisPre(Node head) {
        System.out.print("Morris PreOrder Traversal: ");
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    System.out.print(cur.value + " ");
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                    cur = cur.right;
                    continue;
                }
            } else {
                System.out.print(cur.value + " ");
            }
            cur = cur.right;
        }
    }

    /**
     * 如果一个节点只能到自己一次，直接打印
     * 如果一个节点可以到自己两次，在第二次的时候打印
     */
    public void morrisIn(Node head) {
        System.out.print("Morris InOrder Traversal: ");
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostRight.right == cur) {
                    System.out.print(cur.value + " ");
                    mostRight.right = null;
                    cur = cur.right;
                    continue;
                }
            } else {
                System.out.print(cur.value + " ");
            }
            cur = cur.right;
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }
}
