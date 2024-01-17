package base;

import java.nio.ByteBuffer;

/**
 * -XX:MaxDirectMemorySize=10m
 * -Xlog:gc
 * -XX:+DisableExplicitGC
 * https://hllvm-group.iteye.com/group/topic/27945
 */
public class DisableExplicitGCDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            ByteBuffer.allocateDirect(128);
        }
        System.out.println("Done");
    }
}
