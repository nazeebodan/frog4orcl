/**
 * 
 */
package com.frog4orcl.business.init.biz.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.frog4orcl.business.init.biz.InitBiz;
import com.frog4orcl.business.init.dao.InitDao;
import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.exception.DatabaseException;

/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 12, 2011 4:08:47 PM
 * @version: 1.0
 */
public class InitBizImpl implements InitBiz {
	
	private static Logger log = Logger.getLogger(InitBizImpl.class);

	private InitDao initDao;

	public void setInitDao(InitDao initDao) {
		this.initDao = initDao;
	}

	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @return
	 */
	public ProcessResult<DBManagerImpl> login(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("ip", request.getParameter("ip"));
		parameter.put("port", request.getParameter("port"));
		parameter.put("sid", request.getParameter("sid"));
		parameter.put("username", request.getParameter("username"));
		parameter.put("password", request.getParameter("password"));
		try{
			ProcessResult<DBManagerImpl> pr = this.initDao.login(parameter);
			pr.setSuccess(true);
			return pr;
		}catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public ProcessResult<TableInfo> test2(HttpServletRequest request,
			HttpServletResponse response,DBManagerImpl dba) {
		if(dba==null){
			throw new DatabaseException("DBManagerImpl is null!");
		}
		String sql = request.getParameter("sqlText").trim();
		try{
			ProcessResult<TableInfo> ti = this.initDao.test2(dba, sql);
			return ti;
		}catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
		
	}

}
