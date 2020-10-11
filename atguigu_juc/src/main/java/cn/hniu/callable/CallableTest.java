package cn.hniu.callable;

import java.util.concurrent.FutureTask;

/**
 * <p>
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/22
 */
public class CallableTest {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        // 实现 Callable接口创建线程使用时，需要 FutureTask支持
        FutureTask<Integer> futureTask = new FutureTask<>(threadDemo);
        // 启动线程
        new Thread(futureTask).start();
        // 接收线程运算回的结果
        // 当 futureTask.get()方法未执行完时，后边的代码都不会执行
        Integer result = null;
        try {
            result = futureTask.get();
            System.out.println(result);
            System.out.println("================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
