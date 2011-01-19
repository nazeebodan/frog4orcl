/**
 * 
 */
package com.frog4orcl.framework.exception;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 19, 2011 10:23:37 AM
 * @version: 1.0
 */
public class CheckLoginException extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public CheckLoginException(){
		
	}

	public CheckLoginException(String message) {
		super(message);
	}

	public CheckLoginException(Throwable cause) {
		this(cause.toString(), cause);
	}

	public CheckLoginException(String message, Throwable cause) {
		super(message, cause);
	}
}
