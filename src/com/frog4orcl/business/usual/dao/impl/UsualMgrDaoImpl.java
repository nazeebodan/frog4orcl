/**
 * 
 */
package com.frog4orcl.business.usual.dao.impl;

import org.apache.log4j.Logger;

import com.frog4orcl.business.usual.dao.UsualMgrDao;
import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.exception.DatabaseException;

/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 19, 2011 12:22:24 PM
 * @version: 1.0
 */
public class UsualMgrDaoImpl implements UsualMgrDao {
	private static Logger logger = Logger.getLogger(UsualMgrDaoImpl.class);

	public ProcessResult<TableInfo> query(DBManagerImpl dba, String sql)
			throws DatabaseException {
		try {
			ProcessResult<TableInfo> result = new ProcessResult<TableInfo>();
			TableInfo ti = dba.getTableInfoByResultSet(sql);
			result.setData(ti);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> query(DBManagerImpl dba)
			throws DatabaseException {
		try {
			ProcessResult<TableInfo> result = new ProcessResult<TableInfo>();
			TableInfo ti = dba.getTableInfoByResultSet();
			result.setData(ti);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

}
