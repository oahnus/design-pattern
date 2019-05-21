package Strategy.strategy.reduce;

import Strategy.OrderForm;
import Strategy.annotation.Order;
import Strategy.strategy.ReduceStrategy;

import java.math.BigDecimal;

/**
 * Created by oahnus on 2018/12/25
 * 18:13.
 */
@Order(1)
public class CouponReduceStrategy extends ReduceStrategy {
    @Override
    public BigDecimal calReducePrice(OrderForm orderForm) {
        BigDecimal reducePrice = BigDecimal.valueOf(5);
        System.out.println("使用优惠券策略, 减" + reducePrice.doubleValue() + "元");
        return reducePrice;
    }

    @Override
    public boolean match(OrderForm form) {
        return form.getWithCoupon();
    }
}
