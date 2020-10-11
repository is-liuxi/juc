package cn.hniu.readWriteLock;

/**
 * <p>
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/23
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();

        new Thread(()->{
            threadDemo.set((int)(Math.random() * 101));
        }, "写锁").start();

        for (int i = 0; i < 100; i++){
            new Thread(() -> {
                threadDemo.get();
            }, "读锁" + i).start();
        }
    }
}
