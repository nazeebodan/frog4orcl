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
	private String loginSuc;// 登陆成功的首页
	private String indexPage;// 首页
	private String loingSucInitPage;//登录成功的首页的初始化页面

	public String getLoingSucInitPage() {
		return loingSucInitPage;
	}

	public void setLoingSucInitPage(String loingSucInitPage) {
		this.loingSucInitPage = loingSucInitPage;
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
	 * 退出登陆
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView exit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.getSession().removeAttribute(SystemConstant.LOGIN_SUC_KEY);
		return new ModelAndView(this.getIndexPage());
	}

	/**
	 * 初始化界面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView initIndex(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ProcessResult<String> result = new ProcessResult<String>();
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			ProcessResult<TableInfo> init_dbInfo = this.initBiz
					.getDataBaseInfo(request, response, dba.getData());
			ProcessResult<TableInfo> init_bannerInfo = this.initBiz
					.getBannerInfo(request, response, dba.getData());
			ProcessResult<TableInfo> init_instanceInfo = this.initBiz
					.getInstanceInfo(request, response, dba.getData());
			ProcessResult<TableInfo> init_osInfo = this.initBiz.getOsInfo(
					request, response, dba.getData());

			request.setAttribute("init_dbInfo", init_dbInfo);
			request.setAttribute("init_bannerInfo", init_bannerInfo);
			request.setAttribute("init_instanceInfo", init_instanceInfo);
			request.setAttribute("init_osInfo", init_osInfo);
			return new ModelAndView(this.getLoingSucInitPage());
		} catch (Exception e) {
			result.setMessage(e.getMessage());
			return sendErrorjsp(request, response, result);
		}
	}

	public String getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
	}

}
