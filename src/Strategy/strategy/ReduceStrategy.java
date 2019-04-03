package Strategy.strategy;

import Strategy.OrderForm;

import java.math.BigDecimal;

/**
 * Created by oahnus on 2018/12/25
 * 17:50.
 */
public abstract class ReduceStrategy {
    public abstract BigDecimal calReducePrice(OrderForm orderForm);
    public abstract boolean match(OrderForm form);
}
