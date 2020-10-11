package cn.hniu.threadPool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * <p>
 * 线程调度
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/23
 */
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) throws Exception {
        // 创建固定大小的线程，可以延迟或定时的执行任务
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        // 线程池中创建了五个线程，执行十次，循环使用
        for (int i = 0; i < 10; i++){
            // 参数：Callable接口，延迟时间，延迟时间单位
            Future<Integer> schedule = pool.schedule(() -> {
                // 生成一百以内的整数
                int number = new Random().nextInt(100);
                System.out.println(Thread.currentThread().getName() + " : " + number);
                return number;
            }, 100, TimeUnit.MILLISECONDS);

            // 获取结果
            System.out.println(schedule.get());
        }

        // 释放线程池
        pool.shutdown();
    }
}
