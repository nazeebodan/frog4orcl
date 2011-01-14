/**
 * 
 */
package com.frog4orcl.business.init.dao;

import java.util.Map;

import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.exception.DatabaseException;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 12, 2011 4:07:31 PM
 * @version: 1.0
 */
public interface InitDao {
	
	public ProcessResult<DBManagerImpl> login(Map<String, String> parameter) throws DatabaseException;
	
	public ProcessResult<TableInfo> test2(DBManagerImpl dba,String sql) throws DatabaseException;
	
}
