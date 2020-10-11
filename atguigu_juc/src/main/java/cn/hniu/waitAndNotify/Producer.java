package cn.hniu.waitAndNotify;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  生产者
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/22
 */
// 可能有多个
public class Producer implements Runnable{

    // 关联店员
    private Clerk clerk;

    // 初始化
    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        // 生产商品
        for (int i = 0; i < 20; i++){
            try {
                // 阻塞 200毫秒
                TimeUnit.MILLISECONDS.sleep(200);
                clerk.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
