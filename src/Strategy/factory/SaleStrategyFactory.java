package Strategy.factory;


import Strategy.OrderForm;
import Strategy.annotation.DateRange;
import Strategy.annotation.Order;
import Strategy.strategy.ReduceStrategy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by oahnus on 2018/12/25
 * 18:13.
 */
public abstract class SaleStrategyFactory {
    public abstract ReduceStrategy buildStrategy(OrderForm orderForm);
    private List<Class<? extends ReduceStrategy>> strategies = null;

    final long ONE_DAY = 1000 * 24 * 60 * 60;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    DateRange getDateRange(Class<? extends ReduceStrategy> clazz) {
        DateRange annotation = clazz.getAnnotation(DateRange.class);
        return annotation;
    }

    /**
     * 计算 策略设定的起始时间是否匹配当前时间
     * @param strategyClass 策略类实例
     * @return
     */
    Boolean matchDateRange(Class<? extends ReduceStrategy> strategyClass) {
        long todayTime = new Date().getTime();
        DateRange dateRange = getDateRange(strategyClass);
        // 不加DateRange 默认永久有效
        if (dateRange == null) {
            return true;
        }

        Date startDate = new Date(), endDate = new Date();
        try {
            startDate = dateFormat.parse(dateRange.startDate());
            endDate = dateFormat.parse(dateRange.endDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 时间范围为左右闭合区间 [startDate, endDate]
        return todayTime > startDate.getTime() && (todayTime + ONE_DAY) < endDate.getTime();
    }

    /**
     * 根据策略类上的Order注解设定策略优先级
     * @return
     */
    Comparator<Class<? extends ReduceStrategy>> sortByOrderAnno() {
        return (aClazz, bClazz) -> {
            Order orderA = aClazz.getAnnotation(Order.class);
            Order orderB = bClazz.getAnnotation(Order.class);
            return orderA.value() - orderB.value();
        };
    }
}
