package Strategy.strategy.reduce;

import Strategy.OrderForm;
import Strategy.annotation.DateRange;
import Strategy.annotation.Order;
import Strategy.strategy.ReduceStrategy;

import java.math.BigDecimal;

/**
 * Created by oahnus on 2018/12/25
 * 18:13.
 */
@Order(2)
@DateRange(startDate = "2019-04-02", endDate = "2019-04-09")
public class FullReduceStrategy extends ReduceStrategy {
    @Override
    public BigDecimal calReducePrice(OrderForm orderForm) {
        System.out.println("使用满减策略, 满20元打9折");
        return orderForm.getTotalPrice().multiply(BigDecimal.valueOf(0.1));
    }

    @Override
    public boolean match(OrderForm form) {
        return form.getTotalPrice().compareTo(BigDecimal.valueOf(20)) > 0;
    }
}
