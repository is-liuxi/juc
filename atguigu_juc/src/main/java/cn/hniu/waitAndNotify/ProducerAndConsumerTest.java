package cn.hniu.waitAndNotify;

/**
 * <p>
 *  生产者与消费者案例（等待唤醒）
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/22
 */
public class ProducerAndConsumerTest {
    public static void main(String[] args) {
        // 店员
        Clerk clerk = new Clerk();
        // 生产者
        Producer producer = new Producer(clerk);
        // 消费者
        Consumer consumer = new Consumer(clerk);

        new Thread(producer, "生产者一").start();
        new Thread(producer, "生产者二").start();
        new Thread(consumer, "消费者一").start();
        new Thread(consumer, "消费者二").start();
    }
}
