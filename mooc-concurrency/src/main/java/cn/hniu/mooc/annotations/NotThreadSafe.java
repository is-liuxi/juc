package cn.hniu.mooc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 *  自定义注解：用来标记线程不安全的类或者写法
 * </p>
 *
 * @author: liuxi
 * @date: 2020/10/6
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {

    String value() default "";
}
