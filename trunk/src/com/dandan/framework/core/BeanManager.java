/**
 * 
 */
package com.dandan.framework.core;

import org.springframework.context.ApplicationContext;

/**
 * @说明 用于使用Spring提供的ApplicationContext类进行显式的Bean获取
 * @author dandan
 * @email xrzp_dh@yahoo.com.cn
 * @create time 3:23:30 PM
 * @version 1.0
 */
public class BeanManager {

	private static ApplicationContext ac = null;

	/**
	 * 利用Spring实现声明式依赖注入，便于直接获取bean对象
	 */
	public static ApplicationContext getApplicationContext() {
		return ac;
	}

	/**
	 * 返回Spring的ApplicationContext对象
	 * 
	 * @return
	 */
	public static void setApplicationContext(ApplicationContext acObj) {
		ac = acObj;
	}

	/**
	 * 根据指定的bean名字来获取bean
	 * 
	 * @param key
	 * @return
	 */
	public static Object getBean(String key) {
		return ac.getBean(key);
	}
}
