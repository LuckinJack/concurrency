package com.zeromile5.concurrency.study.synchronized_study;


import com.zeromile5.concurrency.annoations.ThreadSafe;

/**
 * Created by ZhangMiao
 * Date : 2019/4/23
 * <p>
 * 对象锁实例三（方法锁形式）：synchronized修饰普通方法
 */
@ThreadSafe
public class Class3SynchronizedObjectMethodBlock implements Runnable {
    static Class3SynchronizedObjectMethodBlock instance = new Class3SynchronizedObjectMethodBlock();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
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

    private synchronized void method() {
        System.out.println("对象锁的普通方法形式，我是线程：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
