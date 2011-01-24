/**
 * 
 */
package com.frog4orcl.business.usual.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import com.frog4orcl.business.usual.biz.UsualMgrBiz;
import com.frog4orcl.framework.core.Frog4orclBaseMultiActionController;
import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.core.page.OraclePagination;
import com.frog4orcl.framework.core.page.Pagination;
import com.frog4orcl.framework.util.SystemConstant;

/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 18, 2011 6:35:16 PM
 * @version: 1.0
 */
public class UsualMgrAction extends Frog4orclBaseMultiActionController {
	private String initParameterUrl;// 显示初始化参数的页面
	private String sgaPageUrl;// 显示sga信息的url
	private String tablespacePageUrl;// 显示tablespace信息的url
	private String controlfilePageUrl;// 显示控制文件信息的url
	private UsualMgrBiz usualMgrBiz;

	public void setUsualMgrBiz(UsualMgrBiz usualMgrBiz) {
		this.usualMgrBiz = usualMgrBiz;
	}

	public String getInitParameterUrl() {
		return initParameterUrl;
	}

	public String getTablespacePageUrl() {
		return tablespacePageUrl;
	}

	public void setTablespacePageUrl(String tablespacePageUrl) {
		this.tablespacePageUrl = tablespacePageUrl;
	}

	public void setInitParameterUrl(String initParameterUrl) {
		this.initParameterUrl = initParameterUrl;
	}

	public String getSgaPageUrl() {
		return sgaPageUrl;
	}

	public void setSgaPageUrl(String sgaPageUrl) {
		this.sgaPageUrl = sgaPageUrl;
	}

	/**
	 * 查询初始化参数
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryInitParameter(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ProcessResult<String> result = new ProcessResult<String>();
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> ti = this.usualMgrBiz.queryInitParameter(
					request, response, dba.getData(), page);
			request.setAttribute(SystemConstant.OBJECT_DATA,
					(ProcessResult<TableInfo>) ti);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getInitParameterUrl());
		} catch (Exception e) {
			result.setMessage(e.getMessage());
			return sendErrorjsp(request, response, result);
		}
	}

	/**
	 * 查询SGA相关信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView querySomeSgaInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Map<String, String> map_sga = this.usualMgrBiz.getSgaJFC(request,
					response, dba.getData());
			Map<String, String> map_sgainfo = this.usualMgrBiz.getSgaInfoJFC(
					request, response, dba.getData());
			ProcessResult<TableInfo> ti = this.usualMgrBiz
					.querySgaDynamicComponents(request, response, dba.getData());
			request.setAttribute("filename1", map_sga.get("filename"));
			request.setAttribute("url1", map_sga.get("url"));
			request.setAttribute("filename2", map_sgainfo.get("filename"));
			request.setAttribute("url2", map_sgainfo.get("url"));
			request.setAttribute(SystemConstant.OBJECT_DATA,
					(ProcessResult<TableInfo>) ti);
			return new ModelAndView(this.getSgaPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询表空间情况
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryTablespaceInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			ProcessResult<TableInfo> tablespace1 = this.usualMgrBiz
					.queryTablespaceInfo(request, response, dba.getData());
			ProcessResult<TableInfo> tablespace2 = this.usualMgrBiz
					.queryTablespaceInfoIncludeDatafile(request, response, dba
							.getData());
			request.setAttribute("tablespace1", tablespace1);
			request.setAttribute("tablespace2", tablespace2);
			return new ModelAndView(this.getTablespacePageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询控制文件信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryControlFileInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			ProcessResult<TableInfo> controlfile1 = this.usualMgrBiz
					.queryControlInfo(request, response, dba.getData());
			ProcessResult<TableInfo> controlfile2 = this.usualMgrBiz
					.queryControlfileRecordSectionslInfo(request, response, dba
							.getData());
			request.setAttribute("controlfile1", controlfile1);
			request.setAttribute("controlfile2", controlfile2);
			return new ModelAndView(this.getControlfilePageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	public String getControlfilePageUrl() {
		return controlfilePageUrl;
	}

	public void setControlfilePageUrl(String controlfilePageUrl) {
		this.controlfilePageUrl = controlfilePageUrl;
	}

}
