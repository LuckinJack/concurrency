package com.zeromile5.concurrency.study.synchronized_study;

import com.zeromile5.concurrency.annoations.NotRecommend;

/**
 * Created by ZhangMiao
 * Date : 2019/4/23
 * <p>
 * 对象锁实例二（代码块形式2）：手动指定锁对象
 * <p>
 * 多个synchronized共用同一个自定义对象的lock锁时，线程互斥，同步执行
 * 多个synchronized使用同一个类的不同自定义对象作为lock锁时，线程是异步执行的(如下，Thread0和Thread1都会交替执行)
 */
@NotRecommend
public class Class2SynchronizedObjectCodeBlock2 implements Runnable {
    static Class2SynchronizedObjectCodeBlock2 instance = new Class2SynchronizedObjectCodeBlock2();
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private static int count = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
            //当thread1 和 thread2 在运行过程中时，不做事情，不打印下一行结束语句
        }
        System.out.println("finished！count = " + count);
    }

    @Override
    public void run() {
        
        synchronized (lock2) {
            System.out.println("我是线程：" + Thread.currentThread().getName() + " 进入了 lock2");
            count++;
            System.out.println(Thread.currentThread().getName() + "运行 lock2 结束");
        }
        synchronized (lock1) {
            System.out.println("我是线程：" + Thread.currentThread().getName() + " 进入了 lock1");
            count--;
            System.out.println(Thread.currentThread().getName() + "运行 lock1 结束");
        }
    }


}
