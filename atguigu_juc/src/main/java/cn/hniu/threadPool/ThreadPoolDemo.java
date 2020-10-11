package cn.hniu.threadPool;

/**
 * <p>
 *  线程池
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/23
 */
public class ThreadPoolDemo implements Runnable{
    private int number = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
