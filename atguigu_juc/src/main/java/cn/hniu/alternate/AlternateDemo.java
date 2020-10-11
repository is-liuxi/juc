package cn.hniu.alternate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 线程间中通信
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/23
 */
public class AlternateDemo {
    private int number = 1;

    private Lock lock = new ReentrantLock();

    // 与 wait、notify和 notifyAll方法对应的分别是 await、signal和 signalAll
    private Condition condition = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    // 参数：第几轮打印
    public void loopA(int totalLoop) {
        lock.lock();

        try {
            // 判断
            if (number != 1)
                // 阻塞一
                condition.await();

            // 打印
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            // 唤醒二
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int totalLoop) {
        lock.lock();

        try {
            // 判断
            if (number != 2)
                // 阻塞二
                condition2.await();

            // 打印
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            // 唤醒三
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int totalLoop) {
        lock.lock();

        try {
            // 判断
            if (number != 3)
                // 阻塞三
                condition3.await();

            // 打印
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            // 唤醒一
            number = 1;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
