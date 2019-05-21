package com.zeromile5.concurrency.study.synchronized_study;


import com.zeromile5.concurrency.annoations.ThreadSafe;

/**
 * Created by ZhangMiao
 * Date : 2019/5/7
 * 类锁实例一：static形式
 */
@ThreadSafe
public class Class4SynchronizedClassBlockStatic implements Runnable {
    static Class4SynchronizedClassBlockStatic instance1 = new Class4SynchronizedClassBlockStatic();
    static Class4SynchronizedClassBlockStatic instance2 = new Class4SynchronizedClassBlockStatic();


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
            //当thread1 和 thread2 在运行过程中时，不做事情，不打印下一行结束语句
        }
        System.out.println("finished！");
    }

    @Override
    public void run() {
        method();
    }

    private static synchronized void method() {
        System.out.println("类锁的第一种：静态方法形式。我是线程：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
