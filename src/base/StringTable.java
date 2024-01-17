package base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 字符串常量池 StringTable
 * 创建对象是一个昂贵的操作，对于像 Integer，Long String 这种 Immutable 类，可以使用缓存。
 * StringTable 就是字符串的缓存，JVM 内部使用 HashTable 进行缓存，是数组+链表，(hotspot17)支持动态扩容,支持 rehash
 * 但是当字符串的数量过多，单个链表过长，也是影响性能的。
 * -XX:StringTableSize=65536
 * -XX:+PrintStringTableStatistics 启动参数来帮助我们获取统计数据。
 * http://xmlandmore.blogspot.com/2013/05/understanding-string-table-size-in.html
 */
public class StringTable {
    public static void main(String[] args) throws InterruptedException {
        String str1 = "abc";
        // 如果之前 StringTable 没有 abc 这一步会创建2个对象：
        // 先在 StringTable 创建一个，再在堆上创建一个。
        String str2 = new String("abc");
        System.out.println(str1 == str2);
        test(4000_000);
        TimeUnit.SECONDS.sleep(4);

        //创建几个对象? 一个 abcdef
        String str = "abc" + "def";

        // str3 创建了 5 个对象 123,456,new String("456"),new String("123456"),StringBuilder
        String str3 = "123" + new String("456");
        // str3 会被优化为下面两行代码
        //String s = new String("123");
        //new StringBuilder().append("456").append(s).toString();

        String str4 = "123456";
        System.out.println(str3 == str4);
    }

    private static void test(int cnt) {
        final List<String> lst = new ArrayList<>(1024);
        long start = System.currentTimeMillis();
        for (int i = 0; i < cnt; ++i) {
            final String str = "very very very very very very very very very very very very very very very long string: " + i;
            lst.add(str.intern());
            if (i % 200000 == 0) {
                System.out.println(i + 200000 + "\t time = " + (System.currentTimeMillis() - start) / 1000.0 + " sec");
                start = System.currentTimeMillis();
            }
        }
        System.out.println("Total length =" + lst.size());
    }
}
