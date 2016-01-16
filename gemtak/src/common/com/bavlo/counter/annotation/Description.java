package com.bavlo.counter.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: ����Counter
 * @ClassName: Description 
 * @Description: �Զ���ע��ע��
 * @author liuzy
 * @date 2015-9-20 ����03:58:28
 */
@Documented  
@Target({ ElementType.TYPE, ElementType.METHOD,ElementType.FIELD })  
@Retention(RetentionPolicy.RUNTIME)  
@Inherited  
public @interface Description {
	public String name();
}
