package org.example;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ConCollection {

    public static void main(String[] args) throws InterruptedException {
//        ConcurrentHashMap<Object, Object> conMap = new ConcurrentHashMap<>(8);
//
//        Object val = new Object();
//        for (int i = 0; i < 8; i++) {
//            conMap.put(new Node(i * 8 + 1), val);
//        }
//
//        new Scanner(System.in).nextLine();

//        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        map.compute("k", (k, v) -> map.compute("k", (m, n) -> "s"));
//        map.merge("", "", (v1,v2) -> {
//            return v1 + v2;
//        });
//        Semaphore semaphore = new Semaphore(3);
//        semaphore.acquire();
//        semaphore.acquire(1);
//        semaphore.tryAcquire();
//        semaphore.tryAcquire(1);
//        semaphore.tryAcquire(1, 100, TimeUnit.MILLISECONDS);
//        semaphore.acquireUninterruptibly();
//        semaphore.acquireUninterruptibly(1);

//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
//            System.out.println("a");
//        }).thenRun(() -> {
//            System.out.println("b");
//        });
//        new Thread().join();


        Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(1000);
                    System.out.println(i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        thread.setDaemon(true);
        thread.start();

    }

    static class Node{
        private int val;

        Node(int val){
            this.val = val;
        }

        public int hashCode(){
            return this.val;
        }

        public boolean equals(Object o){
            return ((Node) o).val == this.val;
        }

    }
}
