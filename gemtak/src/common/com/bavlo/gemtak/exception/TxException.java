package com.bavlo.gemtak.exception;

@SuppressWarnings("serial")
public class TxException extends RuntimeException { 
	  
    /** 
     * �����µ�����ʱ�쳣 
     * @since 0.1 
     */ 
    public TxException() { 
        super(); 
    } 
 
    /** 
     * ��ָ������ϸ��Ϣ�����µ�����ʱ�쳣 
     * @param msg ��ϸ��Ϣ 
     * @since 0.1 
     */ 
    public TxException(String msg) { 
        super(msg); 
    } 
 
    /** 
     * ��ָ������ϸ��Ϣ��ԭ����һ���µ�����ʱ�쳣 
     * @param msg ��ϸ��Ϣ 
     * @param cause ԭ�� 
     * @since 0.1 
     */ 
    public TxException(String msg, Throwable cause) { 
        super(msg, cause); 
    } 
 
    /** 
     * ��ָ����ԭ�����ϸ��Ϣ����һ���µ�����ʱ�쳣 
     * @param cause ԭ�� 
     * @since 0.1 
     */ 
    public TxException(Throwable cause) { 
        super(cause); 
    } 
} 