package cn.hniu.sync;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  锁与异常：
 *      当同步方法中发生异常时，自动释放锁
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/10
 */
public class SynchronizedTest5 {
    int i = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " - start");
        while (true) {
            i++;
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 5) {
                // 抛出异常，自动释放锁。线程 t2开始
                i = 1 / 0;
            }
        }
    }

    public static void main(String[] args) {
        final SynchronizedTest5 t = new SynchronizedTest5();
        new Thread(() -> {
            t.m();
        }, "t1").start();

        new Thread(() -> {
            t.m();
        }, "t2").start();
    }
}
