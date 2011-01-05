/**
 * 
 */
package com.dandan.framework.core;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @หตร๗
 * @author dandan
 * @email xrzp_dh@yahoo.com.cn
 * @create time 4:07:15 PM
 * @version 1.0
 */
public class CharacterFilter implements Filter {
	protected String encoding = null;
	protected FilterConfig filterConfig = null;
	protected boolean ignore = true;

	public void init(FilterConfig arg0) throws ServletException {
		this.encoding = arg0.getInitParameter("encoding");
		String value = arg0.getInitParameter("imnore");
		if (value == null) {
			this.ignore = true;
		} else if (value.equalsIgnoreCase("true")) {
			this.ignore = true;
		} else if (value.equalsIgnoreCase("yes")) {
			this.ignore = true;
		}

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// if (ignore || (arg0.getCharacterEncoding() == null)) {
		// String encoding = selectEncoding(arg0);
		// if (encoding != null)
		arg0.setCharacterEncoding("UTF-8");
		// }
		arg2.doFilter(arg0, arg1);
	}

	private String selectEncoding(ServletRequest arg0) {
		return (this.encoding);
	}

	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}

}
