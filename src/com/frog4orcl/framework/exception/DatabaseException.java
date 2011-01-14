/**
 * 
 */
package com.frog4orcl.framework.exception;

/**
 * @说明:数据库异常类
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 12, 2011 11:00:49 AM
 * @version: 1.0
 */
public class DatabaseException extends Frog4orclException {

	private static final long serialVersionUID = 1L;

	public DatabaseException() {
	}

	public DatabaseException(String message) {
		super(message);
	}

	public DatabaseException(String message, Throwable newNested) {
		super(message, newNested);
	}

	public DatabaseException(Throwable newNested) {
		super(newNested);
	}
}
