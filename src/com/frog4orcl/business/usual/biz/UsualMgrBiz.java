/**
 * 
 */
package com.frog4orcl.business.usual.biz;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.core.page.Pagination;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 18, 2011 6:36:33 PM
 * @version: 1.0
 */
public interface UsualMgrBiz {
	/**
	 * 查询初始化参数
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> queryInitParameter(HttpServletRequest request,
			HttpServletResponse response,DBManagerImpl dba);
	/**
	 * 查询初始化参数,带分页的
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> queryInitParameter(HttpServletRequest request,
			HttpServletResponse response,DBManagerImpl dba,Pagination page);
	
	/**
	 * 查询v$sga的信息
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> querySga(HttpServletRequest request,
			HttpServletResponse response,DBManagerImpl dba);
	
	/**
	 * 查询v$sgaInfo的信息
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> querySgaInfo(HttpServletRequest request,
			HttpServletResponse response,DBManagerImpl dba);
	
	/**
	 * 查询v$SGA_DYNAMIC_COMPONENTS的信息
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> querySgaDynamicComponents(HttpServletRequest request,
			HttpServletResponse response,DBManagerImpl dba);
	
	/**
	 * 获取v$sga的jfreechart
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public Map<String, String> getSgaJFC(HttpServletRequest request,
			HttpServletResponse response,DBManagerImpl dba);
	
	/**
	 * 获取v$sgaInfo的jfreechart
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public Map<String, String> getSgaInfoJFC(HttpServletRequest request,
			HttpServletResponse response,DBManagerImpl dba);
	
	/**
	 * 查询表空间情况
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> queryTablespaceInfo(HttpServletRequest request,
			HttpServletResponse response,DBManagerImpl dba);
	
	/**
	 * 查询表空间情况包含数据文件信息
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> queryTablespaceInfoIncludeDatafile(HttpServletRequest request,
			HttpServletResponse response,DBManagerImpl dba);
	
	/**
	 * 查询control file信息
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> queryControlInfo(HttpServletRequest request,
			HttpServletResponse response,DBManagerImpl dba);

	/**
	 * 查询control file record section信息
	 * @param request
	 * @param response
	 * @param dba
	 * @return
	 */
	public ProcessResult<TableInfo> queryControlfileRecordSectionslInfo(HttpServletRequest request,
			HttpServletResponse response,DBManagerImpl dba);
}
