package cn.hniu.mooc.test;

import cn.hniu.mooc.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/10/6
 */
@Slf4j
// 线程不安全的测试类
@NotThreadSafe("线程不安全的测试类")
public class ConcurrencyTest {

    // 请求总数
    private static int clientTotal = 500;

    // 同时并发执行的线程数
    private static int threadTotal = 20;

    // 用户计数
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        // 定义线程池。newCachedThreadPool根据需求自动的更改数量
        ExecutorService executors = Executors.newCachedThreadPool();

        // 信号量，对操作属进行控制
        final Semaphore semaphore = new Semaphore(threadTotal);

        // 定义计数器
        final CountDownLatch cdl = new CountDownLatch(clientTotal);

        // 请求
        for (int i = 0; i < clientTotal; i++) {
            executors.execute(() -> {

                try {
                    // 判断当前是否允许被执行
                    semaphore.acquire();

                    add();

                    // 释放
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.info("Exception", e.getMessage());
                }

                // 没执行一次，减一
                cdl.countDown();
            });
        }

        // 阻塞当前线程，直至计数器为零
        cdl.await();

        // 关闭线程池
        executors.shutdown();
        log.info("count：{}", count);
    }

    // 计数的方法
    private static void add() {

        count++;
    }
}
