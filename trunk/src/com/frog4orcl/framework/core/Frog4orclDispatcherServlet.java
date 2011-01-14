/**
 * 
 */
package com.frog4orcl.framework.core;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;


/**
 * @˵��说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 5, 2011 2:29:35 PM
 * @version: 1.0
 */
public class Frog4orclDispatcherServlet extends DispatcherServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 默认的构造函数
	 */
	public Frog4orclDispatcherServlet() {
		super();
	}

	public void init(ServletConfig servletconfig) throws ServletException {

		super.init(servletconfig);
		ApplicationContext cx = WebApplicationContextUtils
				.getWebApplicationContext(this.getServletContext());
		BeanManager.setApplicationContext(cx);
	}
}
