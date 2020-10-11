package cn.hniu.volatiles;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/21
 */
public class ThreadDemo implements Runnable {

    // 定义一个布尔值变量，为 false
    private volatile boolean flag = false;

    @Override
    public void run() {
        // 休眠两秒钟
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 将属性值改为 true
        flag = true;

        // 输出
        System.out.println("flag : " + isFlag());
    }

    // get/set方法
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
