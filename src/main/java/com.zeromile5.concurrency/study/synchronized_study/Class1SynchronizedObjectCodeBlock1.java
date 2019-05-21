package com.zeromile5.concurrency.study.synchronized_study;

import com.zeromile5.concurrency.annoations.ThreadSafe;

/**
 * Created by ZhangMiao
 * Date : 2019/4/23
 * <p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
 * 对象锁实例一（代码块形式1）：锁对象为this
 */
@ThreadSafe
public class Class1SynchronizedObjectCodeBlock1 implements Runnable {
    static Class1SynchronizedObjectCodeBlock1 instance = new Class1SynchronizedObjectCodeBlock1();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("执行完毕！");
    }
    
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("对象锁的代码块形式，我是线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }
}
