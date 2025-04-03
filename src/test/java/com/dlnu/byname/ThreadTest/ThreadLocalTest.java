package com.dlnu.byname.ThreadTest;

/**
 * @author Tan Lianwang
 * @title: ThreadLocalTest
 * @date 2025/3/21 07:59
 */
public class ThreadLocalTest {

    public static ThreadLocal<String> threadLocal= new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("test");
        Thread thread1 = Thread.currentThread();
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("子线程" + threadLocal.get());
            }
        });
        thread.start();

        System.out.println("主线程"+threadLocal.get());
    }
}
