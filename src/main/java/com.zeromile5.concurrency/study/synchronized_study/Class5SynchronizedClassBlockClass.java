package com.zeromile5.concurrency.study.synchronized_study;


import com.zeromile5.concurrency.annoations.ThreadSafe;

/**
 * Created by ZhangMiao
 * Date : 2019/5/7
 * 类锁实例二：class对象形式
 */
@ThreadSafe
public class Class5SynchronizedClassBlockClass implements Runnable {
    static Class5SynchronizedClassBlockClass instance1 = new Class5SynchronizedClassBlockClass();
    static Class5SynchronizedClassBlockClass instance2 = new Class5SynchronizedClassBlockClass();


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

    private synchronized void method() {
        synchronized (Class5SynchronizedClassBlockClass.class) {
            System.out.println("类锁的第二种：sychronized(*.class)形式。我是线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
        
    }
}
