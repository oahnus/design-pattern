package Strategy;

import java.math.BigDecimal;

/**
 * Created by oahnus on 2019/4/4
 * 0:09.
 * 订单 Entity
 */
public class OrderForm {
    private BigDecimal totalPrice;
    private Boolean withCoupon;

    public OrderForm(BigDecimal totalPrice, Boolean withCoupon) {
        this.totalPrice = totalPrice;
        this.withCoupon = withCoupon;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getWithCoupon() {
        return withCoupon;
    }

    public void setWithCoupon(Boolean withCoupon) {
        this.withCoupon = withCoupon;
    }
}
