/**
 * 
 */
package com.frog4orcl.business.alert.dao;

import java.util.List;
import java.util.Map;

import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.core.page.Pagination;
import com.frog4orcl.framework.exception.DatabaseException;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Feb 11, 2011 3:55:46 PM
 * @version: 1.0
 */
public interface AlertMgrMKDao {
	public ProcessResult<TableInfo> query(DBManagerImpl dba,String sql) throws DatabaseException;
	public ProcessResult<TableInfo> query(DBManagerImpl dba) throws DatabaseException;
	public ProcessResult<TableInfo> query(DBManagerImpl dba,Pagination page,List<Object> parameter) throws DatabaseException;
	public Map<String, Object> query4Map(DBManagerImpl dba) throws DatabaseException;

}
