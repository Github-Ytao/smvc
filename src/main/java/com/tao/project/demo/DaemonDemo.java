package com.tao.project.demo;

/**
 * @author YangTao
 * @date 2021-11-27 17:27
 *
 * 守护线程:随JVM结束而结束
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("i am alive");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("finally block");
                }
            }
        }, "daemonThread");

        // 必须在start()之前
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
