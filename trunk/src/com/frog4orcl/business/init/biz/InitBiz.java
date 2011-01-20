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
	public ProcessResult<DBManagerImpl> login(HttpServletRequest request,
			HttpServletResponse response);

	/**
	 * 测试用
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> test2(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba);

	/**
	 * 获取数据库信息
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> getDataBaseInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba);
	
	/**
	 * 获取实例信息
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> getInstanceInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba);
	
	/**
	 * 获取监听信息
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> getListenerInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba);
	
	/**
	 * 获取数据库版本
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> getBannerInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba);
	
	/**
	 * 获取操作系统信息
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> getOsInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba);
	
	/**
	 * 获取告警信息
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> getAlertInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba); 
}
