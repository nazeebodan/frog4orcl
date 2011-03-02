/**
 * 
 */
package com.frog4orcl.business.alert.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.frog4orcl.business.alert.biz.StoreMgrBiz;
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
 * @create: Feb 11, 2011 5:19:46 PM
 * @version: 1.0
 */
public class StoreMgrAction extends Frog4orclBaseMultiActionController {

	private String overXExtentsPageurl;
	private String overXBlocksPageurl;
	
	private StoreMgrBiz storeMgrBiz;

	public String getOverXExtentsPageurl() {
		return overXExtentsPageurl;
	}

	public void setOverXExtentsPageurl(String overXExtentsPageurl) {
		this.overXExtentsPageurl = overXExtentsPageurl;
	}

	public String getOverXBlocksPageurl() {
		return overXBlocksPageurl;
	}

	public void setOverXBlocksPageurl(String overXBlocksPageurl) {
		this.overXBlocksPageurl = overXBlocksPageurl;
	}

	public void setStoreMgrBiz(StoreMgrBiz storeMgrBiz) {
		this.storeMgrBiz = storeMgrBiz;
	}
	
	/**
	 * 查询存在的超过某范围区的对象
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryOverXExtentsInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.storeMgrBiz
					.queryOverXExtentsInfo(request, response, dba.getData(), page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getOverXExtentsPageurl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}
	
	/**
	 * 查询存在的超过某范围块的对象
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryOverXBlocksInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.storeMgrBiz
					.queryOverXBlocksInfo(request, response, dba.getData(), page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getOverXBlocksPageurl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}
}
