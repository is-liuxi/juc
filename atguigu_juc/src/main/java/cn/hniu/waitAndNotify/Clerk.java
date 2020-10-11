package cn.hniu.waitAndNotify;

/**
 * <p>
 * 等待唤醒机制，生产者与消费者
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/22
 */
// 店员
public class Clerk {

    // 商品
    private int product;

    // 进货方法
    public synchronized void get() {
        // 最多只能进十个货物。
        // 有虚假唤醒问题，wait()方法应该使用在循环中，不使用 if判断
        while (product >= 1) {
            System.out.println(Thread.currentThread().getName() + "商品已满，无法添加！");

            try {
                // 当添加的商品已满，等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "正在进货第: " + (++product) + "个商品");
        // 如果生产者成功生产了一个产品，供于销售。唤醒所有线程，可以卖货了
        this.notifyAll();
    }

    // 卖货方法
    public synchronized void sale() {
        // 有虚假唤醒问题，wait()方法应该使用在循环中，不使用 if判断
        while (product <= 0) {
            System.out.println(Thread.currentThread().getName() + "商品不足，缺货！");

            try {
                // 当发现商品缺货时，等待生产者线程唤醒
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "正在售卖第：" + (product--) + "个商品");
        // 当卖出商品时(有空位时)，唤醒所有线程，通知生产者生产商品
        this.notifyAll();
    }
}
