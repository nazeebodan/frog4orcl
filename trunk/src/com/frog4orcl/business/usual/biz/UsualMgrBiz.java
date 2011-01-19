/**
 * 
 */
package com.frog4orcl.business.usual.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 18, 2011 6:36:33 PM
 * @version: 1.0
 */
public interface UsualMgrBiz {
	public ProcessResult<TableInfo> queryInitParameter(HttpServletRequest request,
			HttpServletResponse response,DBManagerImpl dba);
}
