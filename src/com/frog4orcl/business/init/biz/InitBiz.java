/**
 * 
 */
package com.frog4orcl.business.init.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;

/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 11, 2011 4:11:07 PM
 * @version: 1.0
 */
public interface InitBiz {

	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @return
	 */
	public ProcessResult<DBManagerImpl> login(HttpServletRequest request,HttpServletResponse response);
	
	public ProcessResult<TableInfo> test2(HttpServletRequest request,HttpServletResponse response,DBManagerImpl dba);
}
