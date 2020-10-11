package cn.hniu.alternate;

/**
 * <p>
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/23
 */
public class AlternateABCTest {
    public static void main(String[] args) {
        AlternateDemo alternateDemo = new AlternateDemo();

        new Thread(()->{
            for (int i = 1; i <= 20; i++){
                alternateDemo.loopA(i);
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 1; i <= 20; i++){
                alternateDemo.loopB(i);
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 1; i <= 20; i++){
                alternateDemo.loopC(i);
                System.out.println("============================");
            }
        }, "C").start();
    }
}
