package Strategy.strategy;



import Strategy.OrderForm;

import java.math.BigDecimal;

/**
 * Created by oahnus on 2018/12/25
 * 18:12.
 * 默认的优惠政策
 */
public class DefaultReduceStrategy extends ReduceStrategy {
    @Override
    public BigDecimal calReducePrice(OrderForm orderForm) {
        return BigDecimal.ZERO;
    }

    @Override
    public boolean match(OrderForm orderForm) {
        return true;
    }

}
