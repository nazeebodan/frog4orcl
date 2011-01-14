/**
 * 
 */
package com.frog4orcl.framework.exception;

/**
 * @说明:异常的总类,其他异常都应该继承该类
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 12, 2011 10:59:51 AM
 * @version: 1.0
 */
public class Frog4orclException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public Frog4orclException(){
		
	}

	public Frog4orclException(String message) {
		super(message);
	}

	public Frog4orclException(Throwable cause) {
		this(cause.toString(), cause);
	}

	public Frog4orclException(String message, Throwable cause) {
		super(message, cause);
	}

}
