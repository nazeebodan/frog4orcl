/**
 * 
 */
package com.frog4orcl.business.alert.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.frog4orcl.business.alert.biz.LockMgrBiz;
import com.frog4orcl.framework.core.Frog4orclBaseMultiActionController;
import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.core.page.OraclePagination;
import com.frog4orcl.framework.core.page.Pagination;
import com.frog4orcl.framework.util.SystemConstant;

/**
 * @说明: 被锁的对象管理
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Feb 11, 2011 3:54:44 PM
 * @version: 1.0
 */
public class LockMgrAction  extends Frog4orclBaseMultiActionController {
	private String lockInfoPageUrl;//锁的显示url
	private String lockObjInfoPageUrl;//锁的对象的显示的url
	
	private LockMgrBiz lockMgrBiz;

	public String getLockInfoPageUrl() {
		return lockInfoPageUrl;
	}

	public void setLockInfoPageUrl(String lockInfoPageUrl) {
		this.lockInfoPageUrl = lockInfoPageUrl;
	}

	public void setLockMgrBiz(LockMgrBiz lockMgrBiz) {
		this.lockMgrBiz = lockMgrBiz;
	}

	/**
	 * 查询锁的信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryLockInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.lockMgrBiz
					.queryLockInfo(request, response, dba.getData(), page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getLockInfoPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}
	
	/**
	 * 查询锁的对象信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryLockObjectInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.lockMgrBiz
					.queryLockObjectInfo(request, response, dba.getData(), page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getLockObjInfoPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	public String getLockObjInfoPageUrl() {
		return lockObjInfoPageUrl;
	}

	public void setLockObjInfoPageUrl(String lockObjInfoPageUrl) {
		this.lockObjInfoPageUrl = lockObjInfoPageUrl;
	}
}
