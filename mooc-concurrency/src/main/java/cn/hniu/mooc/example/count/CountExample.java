package cn.hniu.mooc.example.count;

import cn.hniu.mooc.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/10/7
 */
@Slf4j
@ThreadSafe("线程安全的类，使用 AtomicInteger保证原子一致性")
public class CountExample {

    // 请求总数
    private static int clientTotal = 500;

    // 并发数
    private static int threadTotal = 20;

    // 保证原子一致性
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // 定义线程池，Executors.newCachedThreadPool：根据用户需求自动更改线程池大小
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 信号量，对操作属性进行控制
        final Semaphore semaphore = new Semaphore(threadTotal);

        // 定义计数器
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        // 请求
        for (int i = 0; i < 500; i++) {
            executorService.execute(() -> {
                try {
                    // 判断当前是否允许被执行
                    semaphore.acquire();

                    // count++
                    add();

                    // 信号量释放
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 每执行一次，计数器减一
                countDownLatch.countDown();
            });
        }

        // 阻塞当前线程，直至计数器为零
        countDownLatch.await();

        // 关闭线程池
        executorService.shutdown();

        log.info("count：{}", count.get());
    }

    // 计数的方法
    public static void add() {

        // incrementAndGet：i++
        count.incrementAndGet();

        // getAndIncrement：++i
        // count.getAndIncrement();
    }
}
