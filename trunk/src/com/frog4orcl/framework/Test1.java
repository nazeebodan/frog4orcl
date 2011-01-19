/**
 * 
 */
package com.frog4orcl.framework;

import com.frog4orcl.framework.util.TextUtils;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create date:Jan 5, 2011 2:29:35 PM
 * @version: 1.0
 */
public class Test1 {

	public static void main(String[] args) {
		String url = "http://127.0.0.1:8080/test1.do/test2.1";
		String url2 = TextUtils.checkSuffix(url);
        System.out.println(url2.indexOf(".jsp"));
        
	}
}
