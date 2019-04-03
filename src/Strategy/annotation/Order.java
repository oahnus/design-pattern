package Strategy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by oahnus on 2018/12/26
 * 10:44.
 */

/**
 * 活动策略优先级 优先级 从小到大
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {
    // 优先级从小到达
    int value() default 10;
}
