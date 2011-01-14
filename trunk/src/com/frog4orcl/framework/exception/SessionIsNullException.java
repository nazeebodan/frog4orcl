/**
 * 
 */
package com.frog4orcl.framework.exception;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 14, 2011 3:25:00 PM
 * @version: 1.0
 */
public class SessionIsNullException extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public SessionIsNullException(){
		
	}

	public SessionIsNullException(String message) {
		super(message);
	}

	public SessionIsNullException(Throwable cause) {
		this(cause.toString(), cause);
	}

	public SessionIsNullException(String message, Throwable cause) {
		super(message, cause);
	}
}
