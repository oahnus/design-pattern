package Strategy;

import Strategy.factory.ReduceFactory;
import Strategy.factory.SaleStrategyFactory;
import Strategy.strategy.ReduceStrategy;

import java.math.BigDecimal;

/**
 * Created by oahnus on 2019/4/4
 * 0:19.
 */
public class StrategyTest {
    public static void main(String... args) {
        // 打折满减
        OrderForm orderForm = new OrderForm(BigDecimal.valueOf(130), false);
        SaleStrategyFactory factory = ReduceFactory.getInstance();
        ReduceStrategy reduceStrategy = factory.buildStrategy(orderForm);

        BigDecimal reducePrice = reduceStrategy.calReducePrice(orderForm);
        System.out.println("抵扣金额" + reducePrice.doubleValue());

        // 打折满减 与 优惠券 同时存在  优惠券优先级高于满减 返回优惠券策略
        System.out.println();
        orderForm = new OrderForm(BigDecimal.valueOf(130), true);
        reduceStrategy = factory.buildStrategy(orderForm);

        reducePrice = reduceStrategy.calReducePrice(orderForm);
        System.out.println("抵扣金额" + reducePrice.doubleValue());

        // 返回默认策略
        System.out.println();
        orderForm = new OrderForm(BigDecimal.valueOf(10), false);
        reduceStrategy = factory.buildStrategy(orderForm);

        reducePrice = reduceStrategy.calReducePrice(orderForm);
        System.out.println("抵扣金额" + reducePrice.doubleValue());

    }
}
