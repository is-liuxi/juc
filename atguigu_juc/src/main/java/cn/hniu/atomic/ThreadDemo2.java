package cn.hniu.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *  解决原子性，使用原子变量
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/22
 */
public class ThreadDemo2 implements Runnable{
    // 无参数构造表示从零开始自增，有参数表示从参数的位置开始自增。类似包装类
    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : " + getAtomicInteger());
    }

    public int getAtomicInteger() {
        // getAndIncrement()：获取变量值并自增，后自增
        // getAndDecrement()：获取变量值并自减，后自减
        // incrementAndGet()：前自增
        // decrementAndGet()：前自减
        return atomicInteger.getAndIncrement();
    }
}
