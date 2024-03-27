package org.example;

import org.openjdk.jol.info.ClassLayout;

public class Sync {
    public static void main(String[] args) throws InterruptedException {
        // JVM默认启用延迟偏向锁，在JVM启动之后的五秒内不提供偏向锁的能力，在5秒时候才会启用偏向锁
        Thread.sleep(5100);
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        // 执行hashCode方法后会失去偏向锁的能力
//        o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        Thread.sleep(1000);
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        new Thread(()->{
            synchronized (o){
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();
        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                synchronized (o){
                    System.out.println("T" + finalI);
                    System.out.println(ClassLayout.parseInstance(o).toPrintable());
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}