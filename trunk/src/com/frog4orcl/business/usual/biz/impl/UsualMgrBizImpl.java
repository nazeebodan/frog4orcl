/**
 * 
 */
package com.frog4orcl.business.usual.biz.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.frog4orcl.business.usual.biz.UsualMgrBiz;
import com.frog4orcl.business.usual.dao.UsualMgrDao;
import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.exception.DatabaseException;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 19, 2011 12:31:50 PM
 * @version: 1.0
 */
public class UsualMgrBizImpl implements UsualMgrBiz {

	private static Logger logger = Logger.getLogger(UsualMgrBizImpl.class);
	private UsualMgrDao usualMgrDao;
	
	public void setUsualMgrDao(UsualMgrDao usualMgrDao) {
		this.usualMgrDao = usualMgrDao;
	}

	public ProcessResult<TableInfo> queryInitParameter(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT T.NAME AS 参数名,");
		sql.append("T.VALUE AS 参数值,");
		sql.append("T.TYPE AS 参数类型,");
		sql.append("T.ISDEFAULT AS 是否缺省值");
		sql.append(" FROM V$PARAMETER T");
		try{
			ProcessResult<TableInfo> ti = this.usualMgrDao.query(dba, sql.toString());
			return ti;
		}catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

}
