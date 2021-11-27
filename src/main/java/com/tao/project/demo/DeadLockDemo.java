package com.tao.project.demo;

/**
 * @author YangTao
 * @date 2021-11-27 15:27
 * 死锁
 */
public class DeadLockDemo {
    private static String resource_a = "A";
    private static String resource_b = "B";

    public static void main(String[] args) {
        deadLock();
    }

    /**
     * 在这个demo中，开启了两个线程threadA，threadB，
     * 其中threadA占用了resource_a，并等待被threadB占用的resource_b。
     * threadB占用了resource_b正在等待被threadA占用的resource_a。
     * 因此threadA，threadB出现线程安全的问题，形成死锁。
     *
     * 如何避免死锁
     * 1.避免一个线程同时获取多个锁
     * 2.避免一个线程在锁内占用多个资源，尽量保证每个锁只占一个资源
     * 3.尝试使用定时锁，使用lock.tryLock(timeOut)，当超时等待时当前线程不会阻塞；
     * 4.对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败的情况。
     */
    private static void deadLock() {
        Thread threadA = new Thread(() -> {
            synchronized (resource_a) {
                System.out.println(Thread.currentThread().getName() + " get resource a");
                try {
                    Thread.sleep(3000);
                    synchronized (resource_b) {
                        System.out.println(Thread.currentThread().getName() + " get resource b");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "threadA");

       Thread threadB = new Thread(() -> {
            synchronized (resource_b) {
                System.out.println(Thread.currentThread().getName() + " get resource b");
                synchronized (resource_a) {
                    System.out.println(Thread.currentThread().getName() + " get resource a");
                }
            }
        }, "threadB");

       threadA.start();
       threadB.start();
    }
}
