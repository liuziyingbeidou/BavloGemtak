package com.bavlo.counter.exception;

@SuppressWarnings("serial")
public class JException extends RuntimeException { 
	  
    /** 
     * �����µ�����ʱ�쳣 
     * @since 0.1 
     */ 
    public JException() { 
        super(); 
    } 
 
    /** 
     * ��ָ������ϸ��Ϣ�����µ�����ʱ�쳣 
     * @param msg ��ϸ��Ϣ 
     * @since 0.1 
     */ 
    public JException(String msg) { 
        super(msg); 
    } 
 
    /** 
     * ��ָ������ϸ��Ϣ��ԭ����һ���µ�����ʱ�쳣 
     * @param msg ��ϸ��Ϣ 
     * @param cause ԭ�� 
     * @since 0.1 
     */ 
    public JException(String msg, Throwable cause) { 
        super(msg, cause); 
    } 
 
    /** 
     * ��ָ����ԭ�����ϸ��Ϣ����һ���µ�����ʱ�쳣 
     * @param cause ԭ�� 
     * @since 0.1 
     */ 
    public JException(Throwable cause) { 
        super(cause); 
    } 
} 