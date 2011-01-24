/**
 * 
 */
package com.frog4orcl.business.init.dao.impl;

import java.util.Map;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.frog4orcl.business.init.dao.InitDao;
import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.exception.DatabaseException;


// import junit.framework.TestCase;
/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 12, 2011 4:07:21 PM
 * @version: 1.0
 */
public class InitDaoImpl extends TestCase implements InitDao {

	private static Logger log = Logger.getLogger(InitDaoImpl.class);

	public ProcessResult<DBManagerImpl> login(Map<String, String> parameter)
			throws DatabaseException {
		ProcessResult<DBManagerImpl> pr = new ProcessResult<DBManagerImpl>();
		DBManagerImpl db = null;
		try {
			db = new DBManagerImpl(parameter);
			pr.setData(db);
			pr.setSuccess(true);
			return pr;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

//	public static void main(String[] args) {
//		InitDaoImpl test = new InitDaoImpl();
//		Map<String, String> parameter = new HashMap<String, String>();
//		parameter.put("ip", "172.16.40.26");
//		parameter.put("port", "1521");
//		parameter.put("sid", "orcl");
//		parameter.put("username", "scott");
//		parameter.put("password", "tiger");
//
//		String sql = "select * from emp";
//		try {
//			ProcessResult<DBManagerImpl> pr = test.login(parameter);
//			TableInfo ti = pr.getData().getTableInfoByResultSet(sql);
//			if (ti.getColumns() != null) {
//				int i = 0;
//				for (TableHeaderInfo column : ti.getColumns()) {
//					System.out.print(column.getName() + "   ");
//				}
//				System.out.println();
//				List<Map<String, Object>> rows = ti.getData().getRows();
//				if (rows != null) {
//					for (Map<String, Object> map : rows) {
//						i++;
//						for (TableHeaderInfo column : ti.getColumns()) {
//							System.out.print(map.get(column.getName()) + "   ");
//						}
//						System.out.println();
//					}
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public ProcessResult<TableInfo> test2(DBManagerImpl dba, String sql)
			throws DatabaseException {
		try {
			ProcessResult<TableInfo> result = new ProcessResult<TableInfo>();
			TableInfo ti = dba.getTableInfoByResultSet(sql);
			result.setData(ti);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}

	}

	public ProcessResult<TableInfo> query(DBManagerImpl dba, String sql)
			throws DatabaseException {
		try {
			ProcessResult<TableInfo> result = new ProcessResult<TableInfo>();
			TableInfo ti = dba.getTableInfoByResultSet(sql);
			result.setData(ti);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			log.error(e.getMessage());
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
			log.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}
}
