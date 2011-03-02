/**
 * 
 */
package com.frog4orcl.business.alert.biz.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.frog4orcl.business.alert.biz.StoreMgrBiz;
import com.frog4orcl.business.alert.dao.AlertMgrMKDao;
import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.core.page.Pagination;
import com.frog4orcl.framework.exception.DatabaseException;
import com.frog4orcl.framework.util.TextUtils;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Feb 11, 2011 5:26:48 PM
 * @version: 1.0
 */
public class StoreMgrBizImpl implements StoreMgrBiz{
	
	private static Logger logger = Logger.getLogger(StoreMgrBizImpl.class);
	private AlertMgrMKDao alertMgrMKDao;

	public void setAlertMgrMKDao(AlertMgrMKDao alertMgrMKDao) {
		this.alertMgrMKDao = alertMgrMKDao;
	}

	public ProcessResult<TableInfo> queryOverXExtentsInfo(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba, Pagination page) {
		StringBuffer sql = new StringBuffer();
		String parameterName = request.getParameter("parameterName");
		
		sql.append("SELECT OWNER,SEGMENT_TYPE,SEGMENT_NAME,BLOCKS");
		sql.append(" FROM DBA_SEGMENTS A");
		sql.append(" Where blocks > ?");

		try {
			List<Object> parameter = new ArrayList<Object>();
			parameter.add(0, TextUtils.parseInt(parameterName,20));
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.alertMgrMKDao.query(dba, page,
					parameter);
			request.setAttribute("parameterName", TextUtils.nvl(parameterName));
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> queryOverXBlocksInfo(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba, Pagination page) {
		StringBuffer sql = new StringBuffer();
		String parameterName = request.getParameter("parameterName");
		
		sql.append("SELECT X.SEGMENT_NAME,X.SEGMENT_TYPE,");
		sql.append("SUM(X.BYTES/1024/1024) TOTAL_M,");
		sql.append("COUNT(X.BYTES) COUNT,X.TABLESPACE_NAME");
		sql.append(" FROM DBA_EXTENTS X");
		sql.append(" GROUP BY X.OWNER,X.SEGMENT_NAME,");
		sql.append("X.SEGMENT_TYPE,X.TABLESPACE_NAME");
		sql.append(" HAVING COUNT(X.BYTES)>=? ORDER BY 1,2");

		try {
			List<Object> parameter = new ArrayList<Object>();
			parameter.add(0, TextUtils.parseInt(parameterName,102400));
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.alertMgrMKDao.query(dba, page,
					parameter);
			request.setAttribute("parameterName", TextUtils.nvl(parameterName));
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

}
