/**
 * 
 */
package com.frog4orcl.business.alert.biz.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.frog4orcl.business.alert.biz.LockMgrBiz;
import com.frog4orcl.business.alert.dao.AlertMgrMKDao;
import com.frog4orcl.business.usual.biz.impl.UsualMgrBizImpl;
import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.core.page.Pagination;
import com.frog4orcl.framework.exception.DatabaseException;

/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Feb 11, 2011 3:59:51 PM
 * @version: 1.0
 */
public class LockMgrBizImpl implements LockMgrBiz {

	private static Logger logger = Logger.getLogger(UsualMgrBizImpl.class);
	private AlertMgrMKDao alertMgrMKDao;

	public void setAlertMgrMKDao(AlertMgrMKDao alertMgrMKDao) {
		this.alertMgrMKDao = alertMgrMKDao;
	}

	public ProcessResult<TableInfo> queryLockInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba, Pagination page) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT SN.USERNAME,M.SID,SN.SERIAL#,M.TYPE,");
		sql.append("DECODE(M.LMODE,0,'NONE',1,'NULL',2,'ROW SHARE',");
		sql.append("3,'ROW EXCL.',4,'SHARE',5,'S/ROW EXCL.',6,'EXCLUSIVE',");
		sql.append("DECODE(M.REQUEST,0,'NONE',1,'NULL',2,'ROW SHARE',");
		sql.append("3,'ROW EXCL.',4,'SHARE',5,'S/ROW EXCL.',6,'EXCLUSIVE',");
		sql.append("REQUEST,LTRIM(TO_CHAR(M.REQUEST,'990'))))REQUEST,");
		sql.append("M.ID1,M.ID2 FROM V$SESSION SN,V$LOCK M");
		sql.append(" WHERE(SN.SID = M.SID AND M.REQUEST != 0)");
		sql.append(" OR(SN.SID = M.SID AND M.REQUEST = 0 AND LMODE != 4");
		sql.append(" AND(ID1, ID2) IN (SELECT S.ID1,S.ID2 FROM V$LOCK S");
		sql.append(" WHERE REQUEST != 0 AND S.ID1 = M.ID1 AND S.ID2 = M.ID2))");
		sql.append(" ORDER BY ID1,ID2,M.REQUEST");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.alertMgrMKDao.query(dba, page,
					null);
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> queryLockObjectInfo(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba, Pagination page) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT RPAD(ORACLE_USERNAME,10) USERNAME,SESSION_ID SID,");
		sql.append("DECODE(LOCKED_MODE,0,'NONE',1,'NULL',2,'ROW SHARE',");
		sql.append("3,'ROW EXCLUSIVE',4,'SHARE',5,'SHARE ROW EXCLUSIVE',");
		sql.append("6,'EXCLUSIVE') LOCK_TYPE,OBJECT_NAME,XIDUSN,XIDSLOT,XIDSQN");
		sql.append(" FROM V$LOCKED_OBJECT,ALL_OBJECTS");
		sql.append(" WHERE V$LOCKED_OBJECT.OBJECT_ID=ALL_OBJECTS.OBJECT_ID");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.alertMgrMKDao.query(dba, page,
					null);
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

}
