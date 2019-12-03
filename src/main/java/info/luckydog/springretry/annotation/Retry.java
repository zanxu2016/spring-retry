package info.luckydog.springretry.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Retry
 *
 * @author eric
 * @since 2019/12/3
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Retry {

    @AliasFor("value")
    String name() default "";

    @AliasFor("name")
    String value() default "";

    int times() default 0;

    int maxTimes() default 3;
}
