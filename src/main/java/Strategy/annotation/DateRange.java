package Strategy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by oahnus on 2018/12/25
 * 18:07.
 */

/**
 * 活动时间范围 strategy上不加默认 永久
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateRange {
    String startDate();
    String endDate();
}
