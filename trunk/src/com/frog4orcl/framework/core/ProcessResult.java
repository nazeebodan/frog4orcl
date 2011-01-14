/**
 * 
 */
package com.frog4orcl.framework.core;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 11, 2011 11:29:04 AM
 * @version: 1.0
 */
public class ProcessResult<T> {
	private boolean success = false;
	private String message = null;
	private T data = null;

	public ProcessResult() {
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public boolean isFailing() {
		return !success;
	}

	public void setFailing(boolean failing) {
		success = !failing;
	}
}
