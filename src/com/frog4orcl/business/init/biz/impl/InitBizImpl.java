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
import com.frog4orcl.framework.util.SystemConstant;

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
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ProcessResult<DBManagerImpl> login(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> parameter = new HashMap<String, String>();
		String username = request.getParameter("username").trim();
		parameter.put("ip", request.getParameter("ip").trim());
		parameter.put("port", request.getParameter("port").trim());
		parameter.put("sid", request.getParameter("sid").trim());
		parameter.put("username", username);
		parameter.put("password", request.getParameter("password").trim());
		try {
			ProcessResult<DBManagerImpl> pr = this.initDao.login(parameter);
			pr.setSuccess(true);
			request.setAttribute(SystemConstant.LOGIN_USER_NAME, username);
			return pr;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}

	}

	public ProcessResult<TableInfo> test2(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba) {
		if (dba == null) {
			throw new DatabaseException("DBManagerImpl is null!");
		}
		String sql = request.getParameter("sqlText").trim();
		try {
			ProcessResult<TableInfo> ti = this.initDao.test2(dba, sql);
			return ti;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}

	}

	public ProcessResult<TableInfo> getAlertInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba) {
		return null;
	}

	public ProcessResult<TableInfo> getBannerInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM V$VERSION");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.initDao.query(dba);
			return ti;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> getDataBaseInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT T.DBID AS DBID,");
		sql.append("T.CREATED AS 数据库创建时间,");
		sql.append("T.FORCE_LOGGING AS 是否强制LOG,");
		sql.append("T.FLASHBACK_ON AS 是否开启数据库级闪回功能,");
		sql.append("T.PLATFORM_NAME AS 数据库所在平台信息");
		sql.append(" FROM V$DATABASE T");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.initDao.query(dba);
			return ti;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> getInstanceInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT T.INSTANCE_NUMBER AS 实例号,");
		sql.append("T.INSTANCE_NAME AS 实例名,");
		sql.append("T.HOST_NAME AS 主机名,");
		sql.append("T.STATUS AS 状态");
		sql.append(" FROM V$INSTANCE T");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.initDao.query(dba);
			return ti;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> getListenerInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ProcessResult<TableInfo> getOsInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT T.STAT_NAME AS 统计信息列表,");
		sql.append("T.VALUE AS 统计值, T.COMMENTS AS 说明");
		sql.append(" FROM V$OSSTAT T");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.initDao.query(dba);
			return ti;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

}
