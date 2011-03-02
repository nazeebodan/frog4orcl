/**
 * 
 */
package com.frog4orcl.business.usual.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import com.frog4orcl.business.usual.biz.UsualMgrBiz;
import com.frog4orcl.framework.core.Frog4orclBaseMultiActionController;
import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.core.page.OraclePagination;
import com.frog4orcl.framework.core.page.Pagination;
import com.frog4orcl.framework.util.SystemConstant;

/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 18, 2011 6:35:16 PM
 * @version: 1.0
 */
public class UsualMgrAction extends Frog4orclBaseMultiActionController {
	private String initParameterUrl;// 显示初始化参数的页面
	private String sgaPageUrl;// 显示sga信息的url
	private String tablespacePageUrl;// 显示tablespace信息的url
	private String tempTablespacePageUrl;// 显示temp tablespace信息的url
	private String controlfilePageUrl;// 显示控制文件信息的url
	private String redologfilePageUrl;// 显示重做日志文件的url
	private String userInfoPageUrl;// 用户信息的url
	private String userPrivInfoPageUrl;// 用户权限信息的url
	private String userHaveObjectsPageUrl;// 用户拥有对象的url
	private String backupDataFilePageUrl;// 联机数据文件的备份状态的url
	private String rollbackSegPageUrl;// 回滚段信息的url
	private String jobPageUrl;// 老的job的url
	private String jobRunningPageUrl;// 正在运行的job信息的url
	private String schedulerJobPageUrl;// schedulers下的job信息的url
	private String schedulersPageUrl;// schedulers信息的url
	private String propServerPageUrl;// 字符集server端信息的url
	private String propClientPageUrl;// 字符集client端信息的url
	private String propSessionPageUrl;// 字符集session信息的url
	private String processAndSessionPageUrl;// processAndSession信息的url
	private String bgprocessPageUrl;// bgprocess信息的url
	private String directoriesPageUrl;//目录对象的url
	private String dbLinkPageUrl;//数据链的url
	private String archLogPageUrl;//归档日志的url

	private UsualMgrBiz usualMgrBiz;

	public void setUsualMgrBiz(UsualMgrBiz usualMgrBiz) {
		this.usualMgrBiz = usualMgrBiz;
	}

	public String getInitParameterUrl() {
		return initParameterUrl;
	}

	public String getTablespacePageUrl() {
		return tablespacePageUrl;
	}

	public void setTablespacePageUrl(String tablespacePageUrl) {
		this.tablespacePageUrl = tablespacePageUrl;
	}

	public void setInitParameterUrl(String initParameterUrl) {
		this.initParameterUrl = initParameterUrl;
	}

	public String getSgaPageUrl() {
		return sgaPageUrl;
	}

	public void setSgaPageUrl(String sgaPageUrl) {
		this.sgaPageUrl = sgaPageUrl;
	}

	/**
	 * 查询初始化参数
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryInitParameter(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ProcessResult<String> result = new ProcessResult<String>();
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> ti = this.usualMgrBiz.queryInitParameter(
					request, response, dba.getData(), page);
			request.setAttribute(SystemConstant.OBJECT_DATA,
					(ProcessResult<TableInfo>) ti);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getInitParameterUrl());
		} catch (Exception e) {
			result.setMessage(e.getMessage());
			return sendErrorjsp(request, response, result);
		}
	}

	/**
	 * 查询SGA相关信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView querySomeSgaInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Map<String, String> map_sga = this.usualMgrBiz.getSgaJFC(request,
					response, dba.getData());
			Map<String, String> map_sgainfo = this.usualMgrBiz.getSgaInfoJFC(
					request, response, dba.getData());
			ProcessResult<TableInfo> ti = this.usualMgrBiz
					.querySgaDynamicComponents(request, response, dba.getData());
			request.setAttribute("filename1", map_sga.get("filename"));
			request.setAttribute("url1", map_sga.get("url"));
			request.setAttribute("filename2", map_sgainfo.get("filename"));
			request.setAttribute("url2", map_sgainfo.get("url"));
			request.setAttribute(SystemConstant.OBJECT_DATA,
					(ProcessResult<TableInfo>) ti);
			return new ModelAndView(this.getSgaPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询表空间情况
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryTablespaceInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			ProcessResult<TableInfo> tablespace1 = this.usualMgrBiz
					.queryTablespaceInfo(request, response, dba.getData());
			ProcessResult<TableInfo> tablespace2 = this.usualMgrBiz
					.queryTablespaceInfoIncludeDatafile(request, response, dba
							.getData());
			request.setAttribute("tablespace1", tablespace1);
			request.setAttribute("tablespace2", tablespace2);
			return new ModelAndView(this.getTablespacePageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}
	
	/**
	 * 查询临时表空间情况
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryTempTablespaceInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			ProcessResult<TableInfo> tablespace2 = this.usualMgrBiz
					.queryTempTablespaceInfoIncludeDatafile(request, response, dba
							.getData());
			request.setAttribute("tablespace2", tablespace2);
			return new ModelAndView(this.getTempTablespacePageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询控制文件信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryControlFileInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			ProcessResult<TableInfo> controlfile1 = this.usualMgrBiz
					.queryControlInfo(request, response, dba.getData());
			ProcessResult<TableInfo> controlfile2 = this.usualMgrBiz
					.queryControlfileRecordSectionslInfo(request, response, dba
							.getData());
			request.setAttribute("controlfile1", controlfile1);
			request.setAttribute("controlfile2", controlfile2);
			return new ModelAndView(this.getControlfilePageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询重做日志文件信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryRedoLogInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			ProcessResult<TableInfo> redolog = this.usualMgrBiz
					.queryRedoLogInfo(request, response, dba.getData());

			request.setAttribute("redolog", redolog);
			return new ModelAndView(this.getRedologfilePageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询用户信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryUserInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			ProcessResult<TableInfo> userinfo = this.usualMgrBiz.queryUserInfo(
					request, response, dba.getData());

			request.setAttribute("userinfo", userinfo);
			return new ModelAndView(this.getUserInfoPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询用户权限信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryUserPrivInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> userPrivInfo = this.usualMgrBiz
					.queryUserPrivInfo(request, response, dba.getData(), page);

			request.setAttribute("userPrivInfo", userPrivInfo);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getUserPrivInfoPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询用户所含对象信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryUserHaveObjectsInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> userHaveObjectsInfo = this.usualMgrBiz
					.queryUserHaveObjectsInfo(request, response, dba.getData(),
							page);

			request.setAttribute("userHaveObjectsInfo", userHaveObjectsInfo);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getUserHaveObjectsPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询联机数据文件的备份状态
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryBackupDataFileInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> backupDataFileInfo = this.usualMgrBiz
					.queryBackupDataFileInfo(request, response, dba.getData(),
							page);

			request.setAttribute("backupDataFileInfo", backupDataFileInfo);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getBackupDataFilePageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询回滚段创建时物理存储情况
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryRollbackSegmentInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> undoInfo = this.usualMgrBiz.queryUndoInfo(
					request, response, dba.getData());
			ProcessResult<TableInfo> rollbackSegmentInfo = this.usualMgrBiz
					.queryRollbackSegmentInfo(request, response, dba.getData(),
							page);

			request.setAttribute("undoInfo", undoInfo);
			request.setAttribute("rollbackSegmentInfo", rollbackSegmentInfo);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getRollbackSegPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询老版本的job信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryJobsInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.usualMgrBiz.queryJobsInfo(
					request, response, dba.getData(), page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getJobPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询老版本正在执行的job信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryRunningJobsInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.usualMgrBiz
					.queryRunningJobsInfo(request, response, dba.getData(),
							page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getJobRunningPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询scheduler下的job信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView querySchedulerJobsInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.usualMgrBiz
					.querySchedulerJobsInfo(request, response, dba.getData(),
							page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getSchedulerJobPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询scheduler的信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView querySchedulersInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.usualMgrBiz
					.querySchedulersInfo(request, response, dba.getData(), page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getSchedulersPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询数据库服务器字符集的信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryPropsServerInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info1 = this.usualMgrBiz
					.queryPropsServerInfo(request, response, dba.getData());
			ProcessResult<TableInfo> info = this.usualMgrBiz
					.queryPropsServerInfo(request, response, dba.getData(),
							page);

			request.setAttribute("info1", info1);
			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getPropServerPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询数据库client字符集的信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryPropsClientInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.usualMgrBiz
					.queryPropsClientInfo(request, response, dba.getData(),
							page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getPropClientPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询数据库session字符集的信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryPropsSessionInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.usualMgrBiz
					.queryPropsSessionInfo(request, response, dba.getData(),
							page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getPropSessionPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询进程和session(与ORACLE相关的所有进程信息(包括后台进程和服务器进程))
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryProcessAndSessionInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.usualMgrBiz
					.queryProcessAndSessionInfo(request, response, dba
							.getData(), page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getProcessAndSessionPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}

	/**
	 * 查询后台进程详细信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryBGProcessInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.usualMgrBiz
					.queryBGProcessInfo(request, response, dba.getData(), page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getBgprocessPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}
	
	/**
	 * 查询目录对象信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryDirectoriesInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.usualMgrBiz
					.queryDirectoriesInfo(request, response, dba.getData(), page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getDirectoriesPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}
	
	/**
	 * 查询数据链
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryDBLinkInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.usualMgrBiz
					.queryDBLinkInfo(request, response, dba.getData(), page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getDbLinkPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}
	
	/**
	 * 查询归档日志信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView queryArchLogInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ProcessResult<DBManagerImpl> dba = super.checkLogin(request);
			Pagination page = new OraclePagination(request);
			ProcessResult<TableInfo> info = this.usualMgrBiz
					.queryArchLogInfo(request, response, dba.getData(), page);

			request.setAttribute("info", info);
			request.setAttribute(SystemConstant.PAGE_OBJECT_DATA, page);
			return new ModelAndView(this.getArchLogPageUrl());
		} catch (Exception e) {
			return sendErrorjsp(request, response, e.getMessage());
		}
	}
	
	
	
	public String getControlfilePageUrl() {
		return controlfilePageUrl;
	}

	public void setControlfilePageUrl(String controlfilePageUrl) {
		this.controlfilePageUrl = controlfilePageUrl;
	}

	public String getRedologfilePageUrl() {
		return redologfilePageUrl;
	}

	public void setRedologfilePageUrl(String redologfilePageUrl) {
		this.redologfilePageUrl = redologfilePageUrl;
	}

	public String getUserInfoPageUrl() {
		return userInfoPageUrl;
	}

	public void setUserInfoPageUrl(String userInfoPageUrl) {
		this.userInfoPageUrl = userInfoPageUrl;
	}

	public String getUserPrivInfoPageUrl() {
		return userPrivInfoPageUrl;
	}

	public void setUserPrivInfoPageUrl(String userPrivInfoPageUrl) {
		this.userPrivInfoPageUrl = userPrivInfoPageUrl;
	}

	public String getUserHaveObjectsPageUrl() {
		return userHaveObjectsPageUrl;
	}

	public void setUserHaveObjectsPageUrl(String userHaveObjectsPageUrl) {
		this.userHaveObjectsPageUrl = userHaveObjectsPageUrl;
	}

	public String getBackupDataFilePageUrl() {
		return backupDataFilePageUrl;
	}

	public void setBackupDataFilePageUrl(String backupDataFilePageUrl) {
		this.backupDataFilePageUrl = backupDataFilePageUrl;
	}

	public String getRollbackSegPageUrl() {
		return rollbackSegPageUrl;
	}

	public void setRollbackSegPageUrl(String rollbackSegPageUrl) {
		this.rollbackSegPageUrl = rollbackSegPageUrl;
	}

	public String getJobPageUrl() {
		return jobPageUrl;
	}

	public void setJobPageUrl(String jobPageUrl) {
		this.jobPageUrl = jobPageUrl;
	}

	public String getJobRunningPageUrl() {
		return jobRunningPageUrl;
	}

	public void setJobRunningPageUrl(String jobRunningPageUrl) {
		this.jobRunningPageUrl = jobRunningPageUrl;
	}

	public String getSchedulerJobPageUrl() {
		return schedulerJobPageUrl;
	}

	public void setSchedulerJobPageUrl(String schedulerJobPageUrl) {
		this.schedulerJobPageUrl = schedulerJobPageUrl;
	}

	public String getSchedulersPageUrl() {
		return schedulersPageUrl;
	}

	public void setSchedulersPageUrl(String schedulersPageUrl) {
		this.schedulersPageUrl = schedulersPageUrl;
	}

	public String getPropServerPageUrl() {
		return propServerPageUrl;
	}

	public void setPropServerPageUrl(String propServerPageUrl) {
		this.propServerPageUrl = propServerPageUrl;
	}

	public String getPropClientPageUrl() {
		return propClientPageUrl;
	}

	public void setPropClientPageUrl(String propClientPageUrl) {
		this.propClientPageUrl = propClientPageUrl;
	}

	public String getPropSessionPageUrl() {
		return propSessionPageUrl;
	}

	public void setPropSessionPageUrl(String propSessionPageUrl) {
		this.propSessionPageUrl = propSessionPageUrl;
	}

	public String getProcessAndSessionPageUrl() {
		return processAndSessionPageUrl;
	}

	public void setProcessAndSessionPageUrl(String processAndSessionPageUrl) {
		this.processAndSessionPageUrl = processAndSessionPageUrl;
	}

	public String getBgprocessPageUrl() {
		return bgprocessPageUrl;
	}

	public void setBgprocessPageUrl(String bgprocessPageUrl) {
		this.bgprocessPageUrl = bgprocessPageUrl;
	}

	public String getDirectoriesPageUrl() {
		return directoriesPageUrl;
	}

	public void setDirectoriesPageUrl(String directoriesPageUrl) {
		this.directoriesPageUrl = directoriesPageUrl;
	}

	public String getTempTablespacePageUrl() {
		return tempTablespacePageUrl;
	}

	public void setTempTablespacePageUrl(String tempTablespacePageUrl) {
		this.tempTablespacePageUrl = tempTablespacePageUrl;
	}

	public String getDbLinkPageUrl() {
		return dbLinkPageUrl;
	}

	public void setDbLinkPageUrl(String dbLinkPageUrl) {
		this.dbLinkPageUrl = dbLinkPageUrl;
	}

	public String getArchLogPageUrl() {
		return archLogPageUrl;
	}

	public void setArchLogPageUrl(String archLogPageUrl) {
		this.archLogPageUrl = archLogPageUrl;
	}
}
