/**
 * 
 */
package com.frog4orcl.framework.exception;

/**
 * @说明: 业务异常
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 21, 2011 12:05:38 PM
 * @version: 1.0
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BusinessException() {

	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		this(cause.toString(), cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
}
