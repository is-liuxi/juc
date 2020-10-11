package cn.hniu.sync;

/**
 * <p>
 *  同步方法和非同步方法调用
 *      同步方法只影响锁定同一个锁对象的同步方法。不影响其它线程调用非同步方法，或调用其它资源的同步方法
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/10
 */
public class SynchronizedTest3 {
    Object o = new Object();

    // 锁的是 this
    public synchronized void m1() {
        System.out.println("public synchronized void m1() start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("public synchronized void m1() end");
    }

    public void m3() {
        // 锁的是临界资源对象。两个锁的对象不一样，不会影响
        synchronized (o) {
            System.out.println("public void m3() start");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("public void m3() end");
        }
    }

    public void m2() {
        System.out.println("public void m2() start");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("public void m2() end");
    }

    public static class MyThread01 implements Runnable {
        int i;
        SynchronizedTest3 t;

        public MyThread01(int i, SynchronizedTest3 t) {
            this.i = i;
            this.t = t;
        }

        public void run() {
            if (i == 0) {
                t.m1();
            } else if (i > 0) {
                t.m2();
            } else {
                t.m3();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedTest3 t = new SynchronizedTest3();
        new Thread(new SynchronizedTest3.MyThread01(0, t)).start();
        new Thread(new SynchronizedTest3.MyThread01(1, t)).start();
        new Thread(new SynchronizedTest3.MyThread01(-1, t)).start();
    }
}
