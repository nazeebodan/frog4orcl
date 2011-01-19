/**
 * 
 */
package com.frog4orcl.framework.exception;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 19, 2011 10:53:34 AM
 * @version: 1.0
 */
public class TextFormatException extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public TextFormatException(){
		
	}

	public TextFormatException(String message) {
		super(message);
	}

	public TextFormatException(Throwable cause) {
		this(cause.toString(), cause);
	}

	public TextFormatException(String message, Throwable cause) {
		super(message, cause);
	}
}