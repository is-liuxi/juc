package cn.hniu.sync;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 原子性
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/10
 */
public class SynchronizedTest2 implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " count = " + count++);
    }

    public static void main(String[] args) {
        SynchronizedTest2 st = new SynchronizedTest2();
        for (int i = 0; i < 5; i++) {
            new Thread(st, "线程-->" + i).start();
        }

    }
}
