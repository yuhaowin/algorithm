package class13.yuhao;

import java.util.ArrayList;
import java.util.List;

/**
 * 派对的最大快乐值
 * 员工信息的定义如下:
 * class Employee {
 * public int happy;// 这名员工可以带来的快乐值
 * List<Employee> subordinates;// 这名员工有哪些直接下级
 * }
 * 公司的每个员工都符合 Employee 类的描述。整个公司的人员结构可以看作
 * 一颗标准的没有环的多叉树。树的头节富是全司唯一的老板。除老板之
 * 外的每个员工都有唯一的直接上级。叶节点是没有任何下属的基层员主
 * (subordinates列表为空)，除基层员工外，每个员工都有一个或多个直接下级。
 * <p>
 * 这个公司现在要办 party，你可以决定哪些员工来，哪些员工不来，规则：
 * 1。如果某个员工来了，那么这个员工的所有直接下级都不能来
 * 2。派对的整体快乐值是所有到场员工快乐值的累加
 * 3。你的目标是让派对的整体快乐值尽量大
 * 给定一棵多叉树的头节点boss，请返回派对的最大快乐值。
 */
public class MaxHappy {

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxNexts = 4;
        int maxHappy = 100;
        int testTimes = 1000;
        MaxHappy happy = new MaxHappy();
        for (int i = 0; i < testTimes; i++) {
            Employee boss = genarateBoss(maxLevel, maxNexts, maxHappy);
            if (happy.maxHappy1(boss) != happy.maxHappy2(boss)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    // for test
    public static Employee genarateBoss(int maxLevel, int maxNexts, int maxHappy) {
        if (Math.random() < 0.02) {
            return null;
        }
        Employee boss = new Employee((int) (Math.random() * (maxHappy + 1)));
        genarateNexts(boss, 1, maxLevel, maxNexts, maxHappy);
        return boss;
    }

    // for test
    public static void genarateNexts(Employee e, int level, int maxLevel, int maxNexts, int maxHappy) {
        if (level > maxLevel) {
            return;
        }
        int nextsSize = (int) (Math.random() * (maxNexts + 1));
        for (int i = 0; i < nextsSize; i++) {
            Employee next = new Employee((int) (Math.random() * (maxHappy + 1)));
            e.subordinates.add(next);
            genarateNexts(next, level + 1, maxLevel, maxNexts, maxHappy);
        }
    }

    public int maxHappy1(Employee boss) {
        if (boss == null) {
            return 0;
        }
        return Math.max(process1(boss, true), process1(boss, false));
    }

    private int process1(Employee boss, boolean come) {
        if (come) {
            int result = boss.happy;
            for (Employee employee : boss.subordinates) {
                result += process1(employee, false);
            }
            return result;
        } else {
            int reuslt = 0;
            for (Employee employee : boss.subordinates) {
                reuslt += Math.max(process1(employee, true), process1(employee, false));
            }
            return reuslt;
        }
    }

    public int maxHappy2(Employee boss) {
        if (boss == null) {
            return 0;
        }
        return process2(boss, false);
    }

    private int process2(Employee cur, boolean up) {
        if (up) {
            int result = 0;
            for (Employee employee : cur.subordinates) {
                result += process2(employee, false);
            }
            return result;
        } else {
            int p1 = 0;
            int p2 = cur.happy;
            for (Employee employee : cur.subordinates) {
                p1 += process2(employee, false);
                p2 += process2(employee, true);
            }
            return Math.max(p1, p2);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    static class Employee {
        public int happy;
        public List<Employee> subordinates;

        public Employee(int happy) {
            this.happy = happy;
            this.subordinates = new ArrayList<>();
        }
    }
}
