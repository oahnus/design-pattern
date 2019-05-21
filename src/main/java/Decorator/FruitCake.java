package Decorator;

import java.math.BigDecimal;

/**
 * Created by oahnus on 2019/4/6
 * 1:14.
 */
public class FruitCake extends Cake {

    private Cake cake;

    public FruitCake(Cake cake) {
        this.cake = cake;
    }

    @Override
    String getDesc() {
        return cake.getDesc() + "+水果";
    }

    @Override
    BigDecimal calPrice() {
        return cake.calPrice().add(BigDecimal.valueOf(30));
    }
}
