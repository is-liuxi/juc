package cn.hniu.mooc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 *  自定义注解：用来标记线程安全的类或者写法
 * </p>
 *
 * @author: liuxi
 * @date: 2020/10/6
 */
// 声明注解定义的范围。TYPE：定义在类或者接口上
@Target(ElementType.TYPE)
// 注解存在的范围。
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {

    String value() default "";
}
