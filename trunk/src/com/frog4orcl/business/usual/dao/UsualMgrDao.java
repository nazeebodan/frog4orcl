/**
 * 
 */
package com.frog4orcl.business.usual.dao;

import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.exception.DatabaseException;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 19, 2011 12:22:05 PM
 * @version: 1.0
 */
public interface UsualMgrDao {
	public ProcessResult<TableInfo> query(DBManagerImpl dba,String sql) throws DatabaseException;
	
	public ProcessResult<TableInfo> query(DBManagerImpl dba) throws DatabaseException;
}
