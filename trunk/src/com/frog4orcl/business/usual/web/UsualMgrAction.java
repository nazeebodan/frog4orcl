/**
 * 
 */
package com.frog4orcl.business.usual.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.frog4orcl.business.usual.biz.UsualMgrBiz;
import com.frog4orcl.framework.core.Frog4orclBaseMultiActionController;
import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.util.SystemConstant;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 18, 2011 6:35:16 PM
 * @version: 1.0
 */
public class UsualMgrAction extends Frog4orclBaseMultiActionController {
	private String initParameterUrl;
	private UsualMgrBiz usualMgrBiz;

	public void setUsualMgrBiz(UsualMgrBiz usualMgrBiz) {
		this.usualMgrBiz = usualMgrBiz;
	}

	public String getInitParameterUrl() {
		return initParameterUrl;
	}

	public void setInitParameterUrl(String initParameterUrl) {
		this.initParameterUrl = initParameterUrl;
	}
	
	/**
	 * 查询初始化参数
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
			ProcessResult<TableInfo> test2 = this.usualMgrBiz.queryInitParameter(request,
					response, dba.getData());
			request.setAttribute(SystemConstant.OBJECT_DATA, test2);
			return new ModelAndView(this.getInitParameterUrl());
		} catch (Exception e) {
			result.setMessage(e.getMessage());
			return sendErrorjsp(request, response, result);
		}
	}

}
