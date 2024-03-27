package org.example;

import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Lock {

    public static void main(String[] args) throws InterruptedException {
//        testReadWriteLock();

        System.out.println(Integer.toBinaryString(-2145714176));
        System.out.println(Integer.toBinaryString(-2145714174));
    }

    public static void testReadWriteLock() throws InterruptedException {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        new Thread(()->{
            readLock.lock();
            readLock.unlock();
        }).start();
        Thread.sleep(1000);
        readLock.lock();
        readLock.unlock();
    }

    public static void testLock() throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "休眠了");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "被唤醒了");
            while (true){

            }
        });
        System.out.println("提前唤醒线程");
        LockSupport.unpark(thread);
        Thread.sleep(1000);
        thread.start();
        Thread.sleep(1000);
        System.out.println("唤醒线程");
        LockSupport.unpark(thread);

        Thread.sleep(1000);
        System.out.println("再次唤醒线程");
        LockSupport.unpark(thread);
        new Scanner(System.in).nextLine();
    }
}
