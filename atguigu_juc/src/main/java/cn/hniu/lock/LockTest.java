package cn.hniu.lock;

/**
 * <p>
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/22
 */
public class LockTest {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo, "窗口一").start();
        new Thread(threadDemo, "窗口二").start();
        new Thread(threadDemo, "窗口三").start();
    }
}
