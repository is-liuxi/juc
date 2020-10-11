package cn.hniu.atomic;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *   i++原子性：
 *      i++的操作分为三个步骤：读 -> 改 -> 写
 *          例如：
 *              int i = 10;
 *              i = i++; // 10
 *          步骤：
 *              // 临时变量
 *              int temp = i;
 *              i = i + 1;
 *              i = temp;
 *  原子变量：
 *      jdk1.5后在 java.util.concurrent.atomic包下提供了常用的原子变量
 *          例如：
 *              AtomicInteger、AtomicBoolean等
 *      原子变量如何解决原子性问题的？
 *          1. 原子变量中封装的属性值都是用 volatile修饰的，保证了原子内存可见性
 *          2. 使用 CAS（Compare-And-Swap）算法保证数据的原子性
 *              CAS算法：
 *                  是硬件对于并发操作共享数据的支持
 *                  CAS包含三个操作数
 *                      内存值 V
 *                      预估值 A
 *                      更新值 B
 *                      当且仅当 V == A时，V = B，否则，将不做任何操作
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/21
 */
public class ThreadDemo implements Runnable {
    private int serialNum = 0;

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出线程名和自增值
        System.out.println(Thread.currentThread().getName() + " : " + getSerialNum());
    }

    // 自增
    public int getSerialNum() {
        return serialNum++;
    }
}
