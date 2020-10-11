package cn.hniu.sync;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  锁可重入：
 *      同一个线程，多次调用同步代码块，锁定同一个锁对象
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/10
 */
public class SynchronizedTest4 {

    // 锁 this
    synchronized void m1() {
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 同一个线程，锁的是同一个对象
        m2();
        System.out.println("m1 end");
    }

    // 锁this
    synchronized void m2() {
        System.out.println("m2 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 end");
    }

    public static void main(String[] args) {

        new SynchronizedTest4().m1();

    }
}
