package com.bavlo.counter.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: 宝珑Counter
 * @ClassName: Description 
 * @Description: 自定义注释注解
 * @author liuzy
 * @date 2015-9-20 下午03:58:28
 */
@Documented  
@Target({ ElementType.TYPE, ElementType.METHOD,ElementType.FIELD })  
@Retention(RetentionPolicy.RUNTIME)  
@Inherited  
public @interface Description {
	public String name();
}
