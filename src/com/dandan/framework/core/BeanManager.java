/**
 * 
 */
package com.dandan.framework.core;

import org.springframework.context.ApplicationContext;

/**
 * @˵�� ����ʹ��Spring�ṩ��ApplicationContext�������ʽ��Bean��ȡ
 * @author dandan
 * @email xrzp_dh@yahoo.com.cn
 * @create time 3:23:30 PM
 * @version 1.0
 */
public class BeanManager {

	private static ApplicationContext ac = null;

	/**
	 * ����Springʵ������ʽ����ע�룬����ֱ�ӻ�ȡbean����
	 */
	public static ApplicationContext getApplicationContext() {
		return ac;
	}

	/**
	 * ����Spring��ApplicationContext����
	 * 
	 * @return
	 */
	public static void setApplicationContext(ApplicationContext acObj) {
		ac = acObj;
	}

	/**
	 * ����ָ����bean��������ȡbean
	 * 
	 * @param key
	 * @return
	 */
	public static Object getBean(String key) {
		return ac.getBean(key);
	}
}
