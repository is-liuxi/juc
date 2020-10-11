package cn.hniu.atomic;

/**
 * <p>
 *  原子性
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/21
 */
public class AtomicTest {
    public static void main(String[] args) {
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        for (int i = 0; i < 10; i++){
            new Thread(threadDemo2).start();
        }
    }
}
