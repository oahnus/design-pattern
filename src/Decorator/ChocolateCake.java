package Decorator;

import java.math.BigDecimal;

/**
 * Created by oahnus on 2019/4/6
 * 1:18.
 */
public class ChocolateCake extends Cake {

    private Cake cake;

    public ChocolateCake(Cake cake) {
        this.cake = cake;
    }

    @Override
    String getDesc() {
        return cake.getDesc() + "加巧克力";
    }

    @Override
    BigDecimal calPrice() {
        return cake.calPrice().add(BigDecimal.valueOf(30));
    }
}
