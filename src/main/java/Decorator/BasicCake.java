package Decorator;

import java.math.BigDecimal;

/**
 * Created by oahnus on 2019/4/6
 * 1:12.
 */
public class BasicCake extends Cake {
    @Override
    String getDesc() {
        return "普通蛋糕";
    }

    @Override
    BigDecimal calPrice() {
        return BigDecimal.valueOf(100);
    }
}
