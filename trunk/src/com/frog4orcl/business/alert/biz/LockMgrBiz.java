/**
 * 
 */
package com.frog4orcl.business.alert.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.core.page.Pagination;

/**
 * @说明: 被锁的对象管理的biz
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Feb 11, 2011 3:55:09 PM
 * @version: 1.0
 */
public interface LockMgrBiz {
	/**
	 * 查询是否存在告警信息
	 * @param request
	 * @param response
	 * @param dba
	 * @param page
	 * @return
	 */
	public ProcessResult<TableInfo> queryLockInfo(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba, Pagination page);
	
	/**
	 * 查询是否存在告警信息及对象
	 * @param request
	 * @param response
	 * @param dba
	 * @param page
	 * @return
	 */
	public ProcessResult<TableInfo> queryLockObjectInfo(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba, Pagination page);

}
