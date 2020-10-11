package cn.hniu.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/22
 */
public class ThreadDemo implements Runnable {
    private Integer tick = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            // 上锁
            lock.lock();

            while (tick > 0) {
                // 是线程阻塞
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName() + "正在售卖第：" + tick-- + "张票");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁，必须执行，所以放在 finally中
            lock.unlock();
        }
    }

}
