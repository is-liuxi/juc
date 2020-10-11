package cn.hniu.callable;

import java.util.concurrent.Callable;

/**
 * <p>
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/22
 */
public class ThreadDemo implements Callable<Integer> {

    // 与实现 Runnable接口不同，Callable接口带有泛型，返回为抽象方法返回值类型
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        // futureTask.get()未执行完时，后边代码都不会执行，可用于闭锁
        for (int i = 0; i < Integer.MAX_VALUE; i++){
            sum += i;
        }
        return sum;
    }
}
