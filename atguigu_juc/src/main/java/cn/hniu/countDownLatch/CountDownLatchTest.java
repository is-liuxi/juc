package cn.hniu.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/22
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        // 参数：计数器大小
        final CountDownLatch latch = new CountDownLatch(10);
        ThreadDemo threadDemo = new ThreadDemo(latch);

        // 获取当前时间
        long start = System.currentTimeMillis();

        // 循环次数与 CountDownLatch的计算器大小一致
        for (int i = 0; i < 10; i++){
            new Thread(threadDemo).start();
        }

        try {
            // 使主线程阻塞
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出程序执行时间（多线程状态下）
        System.out.println("程序耗时：" + (System.currentTimeMillis() -start));

    }
}
