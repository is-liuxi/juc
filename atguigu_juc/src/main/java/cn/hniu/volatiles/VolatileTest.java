package cn.hniu.volatiles;

/**
 * <p>
 *  Volatile关键字
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/21
 */
public class VolatileTest {

    public static void main(String[] args) {
        // 子线程：操作共享数据 flag，修改值
        ThreadDemo threadDemo = new ThreadDemo();
        /**
         * 子线程调用 start方法，线程中执行的 run方法：
         *      1. 当子线程休眠两秒后，将 flag为 true
         *      2. 程序重上往下执行，子线程阻塞（休眠）时，执行主线程
         */
        new Thread(threadDemo).start();

        // 主线程：操作共享数据 flag，读取值
        while (true) {
            /**
             * 如果变量 flag值为 true，退出：
             *  3. 因为子线程处于阻塞状态，主线程执行这段程序时，flag还是为 false
             *  4. 当子线程休眠完时，这段程序已经执行完毕，所以一直处于死循环中
             */
            if (threadDemo.isFlag()) {
                System.out.println("----------end-------------");
                break;
            }
        }
    }
}
