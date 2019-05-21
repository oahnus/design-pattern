package Decorator;

/**
 * Created by oahnus on 2019/4/6
 * 1:19.
 */
public class DecoratorTest {
    public static void main(String... args) {
        Cake cake = new BasicCake();
        System.out.println("描述:" + cake.getDesc());
        System.out.println("总价格：" + cake.calPrice());

        Cake chocolateCake = new ChocolateCake(cake);
        System.out.println("描述:" + chocolateCake.getDesc());
        System.out.println("总价格：" + chocolateCake.calPrice());

        Cake fruitCake = new FruitCake(chocolateCake);
        System.out.println("描述:" + fruitCake.getDesc());
        System.out.println("总价格：" + fruitCake.calPrice());
    }
}
