package base;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        String aa = map.getOrDefault("aa", "222");
        map.get("");
        map.containsKey("");
        System.out.println(songDecoder("RWUBWUBWUBLWUB"));
        String s = songDecoder("RWUBWUBWUBLWUB");
        System.out.println("R L".equals(s));

        Test test = new Test();
        System.out.println(test.testReturn4());
    }

    private int testReturn1() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
        return i;
    }


    private int testReturn4() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            //return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
            //return i;
        }
        return i;
    }

    private int testReturn3() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            int x = i / 0 ;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
        return i;
    }

    public static String songDecoder(String song) {
        String term = "WUB";
        // 在这⾥写代码
        String[] res = song.split(term);

        String ans = "";

        boolean first = true;

        for (String test : res) {
            if (test != "") {
                if (first) {
                    ans = test;
                    first = false;
                } else {
                    ans = ans + "434" + test;
                }
            }
        }

        return ans;
    }
}
