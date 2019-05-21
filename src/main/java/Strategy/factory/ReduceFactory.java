package Strategy.factory;


import Strategy.OrderForm;
import Strategy.annotation.Order;
import Strategy.strategy.DefaultReduceStrategy;
import Strategy.strategy.ReduceStrategy;
import Strategy.strategy.reduce.CouponReduceStrategy;
import Strategy.strategy.reduce.FullReduceStrategy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by oahnus on 2018/12/25
 * 18:14.
 */
public class ReduceFactory extends SaleStrategyFactory {

    private static ReduceFactory reduceFactoryInstance = null;

    private List<Class<? extends ReduceStrategy>> strategies = null;

    private ReduceFactory() {
        init();
    }

    private void init() {
        // todo 反射 扫策略类所在包 注册reduce策略列表
        // 添加新的策略时， 需要在这里注册
        this.strategies = Arrays.asList(
                FullReduceStrategy.class,
                CouponReduceStrategy.class
        );
    }

    public static ReduceFactory getInstance() {
        if (reduceFactoryInstance == null) {
            return new ReduceFactory();
        }
        return reduceFactoryInstance;
    }

    @Override
    public ReduceStrategy buildStrategy(OrderForm orderForm) {

        // 1 按优先级从小到大排序 Order 值低的 优先级高
        strategies.sort(sortByOrderAnno());

        // 2 遍历策略列表, 查找策略
        for (Class<? extends ReduceStrategy> clazz : strategies) {
            if (!matchDateRange(clazz)) {
                continue;
            }

            try {
                ReduceStrategy cla = clazz.newInstance();
                if (cla.match(orderForm)) {
                    return cla;
                } else {
                    cla = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new DefaultReduceStrategy();
            }
        }
        // 3 无命中策略， 返回默认策略
        return new DefaultReduceStrategy();
    }
}
