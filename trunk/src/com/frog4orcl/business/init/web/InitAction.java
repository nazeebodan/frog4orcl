/**
 * 
 */
package com.frog4orcl.business.init.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.frog4orcl.business.init.biz.InitBiz;
import com.frog4orcl.framework.core.Frog4orclBaseMultiActionController;
import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.util.SystemConstant;

/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 11, 2011 4:07:37 PM
 * @version: 1.0
 */
public class InitAction extends Frog4orclBaseMultiActionController {

	private InitBiz initBiz;
	private String loginSuc;

	private String test2;

	public String getTest2() {
		return test2;
	}

	public void setTest2(String test2) {
		this.test2 = test2;
	}

	public void setInitBiz(InitBiz initBiz) {
		this.initBiz = initBiz;
	}

	public String getLoginSuc() {
		return loginSuc;
	}

	public void setLoginSuc(String loginSuc) {
		this.loginSuc = loginSuc;
	}

	/**
	 * 登陆
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ProcessResult<String> pr = new ProcessResult<String>();
		try {
			ProcessResult<DBManagerImpl> result = this.initBiz.login(request,
					response);
			request.getSession().setAttribute(SystemConstant.LOGIN_SUC_KEY,
					result);
			return new ModelAndView(this.getLoginSuc());
		} catch (Exception e) {
			pr.setMessage(e.getMessage());
			return sendErrorjsp(request, response, pr);
		}

	}

	/**
	 * 测试1
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView test(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ProcessResult<String> result = new ProcessResult<String>();
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			ProcessResult<TableInfo> test2 = this.initBiz.test2(request,
					response, dba.getData());
			request.setAttribute(SystemConstant.OBJECT_DATA, test2);
			return new ModelAndView(this.getTest2());
		} catch (Exception e) {
			result.setMessage(e.getMessage());
			return sendErrorjsp(request, response, result);
		}
	}

}
