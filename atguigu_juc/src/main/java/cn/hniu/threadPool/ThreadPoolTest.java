package cn.hniu.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/23
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();

        // 使用线程池，创建 10个线程
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

        // 为线程池中的线程分配任务
        for (int i = 0; i < 10; i++){
            fixedThreadPool.submit(threadPoolDemo);
        }

        // 关闭线程池。shutdown：等待线程中所有的任务完成后再关闭
        fixedThreadPool.shutdown();
    }
}
