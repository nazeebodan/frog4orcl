/**
 * 
 */
package com.frog4orcl.framework.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.exception.DatabaseException;
import com.frog4orcl.framework.exception.SessionIsNullException;
import com.frog4orcl.framework.util.SystemConstant;

/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 11, 2011 11:26:49 AM
 * @version: 1.0
 */
public class Frog4orclBaseMultiActionController extends MultiActionController {

	private static Logger logger = Logger
			.getLogger(Frog4orclBaseMultiActionController.class);
	private String errorJsp;

	public ProcessResult<DBManagerImpl> checkLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session == null) {
			logger.error("session is null");
			throw new SessionIsNullException("session is null");
		}
		ProcessResult<DBManagerImpl> result = current(session);
		result.getData().getConnection();

		if (result == null) {
			logger.error("dbconnect is null!");
			throw new DatabaseException("dbconnect is null!");
		}
		result.setSuccess(true);
		return result;
	}
	
	
	
	
	public ProcessResult<DBManagerImpl> current(HttpSession sess) {
		Object obj = sess.getAttribute(SystemConstant.LOGIN_SUC_KEY);
		if (obj == null) {
			return null;
		} else {
			return (ProcessResult<DBManagerImpl>) obj;
		}
	}
	
	public ModelAndView sendErrorjsp(HttpServletRequest request,
		    HttpServletResponse response,ProcessResult<String> result) {
		request.setAttribute(SystemConstant.ERR_MSG_JSP, result.getMessage());
		return new ModelAndView(this.getErrorJsp());
	}

	public String getErrorJsp() {
		return errorJsp;
	}

	public void setErrorJsp(String errorJsp) {
		this.errorJsp = errorJsp;
	}

}
