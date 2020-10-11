package cn.hniu.sync;

/**
 * <p>
 *  所有的锁都应用在多线程并发访问中，当并发访问要求不能有数据冲突时，进行加锁
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/10
 */
public class SynchronizedTest {
    private int count = 0;
    private static int result = 0;
    private Object object = new Object();

    public void testSync() {
        // 锁的对象：临界资源，Object
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "  count = " + count);
        }
    }

    public void testSync2() {
        // 锁的对象：当前对象，this
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "  count = " + count);
        }
    }

    // 锁的对象：当前对象，this
    public synchronized void testSync3() {
        System.out.println(Thread.currentThread().getName() + "  count = " + count);
    }

    // 锁的对象：类对象，class（SynchronizedTest.class）
    public static synchronized void testSync4() {
        System.out.println(Thread.currentThread().getName() + "  result = " + result);
    }

    // 锁的对象：类对象，class
    public static void testSync5() {
        synchronized (SynchronizedTest.class) {
            System.out.println(Thread.currentThread().getName() + "  result = " + result);
        }
    }
}
