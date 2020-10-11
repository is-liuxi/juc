package cn.hniu.waitAndNotify;

/**
 * <p>
 *  消费者
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/22
 */
public class Consumer implements Runnable{
    // 关联店员
    private Clerk clerk;

    // 初始化
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        // 消费商品
        for (int i = 0; i < 20; i++){
            clerk.sale();
        }
    }
}
