/**
 * 
 */
package com.frog4orcl.business.usual.biz.impl;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

import com.frog4orcl.business.usual.biz.UsualMgrBiz;
import com.frog4orcl.business.usual.dao.UsualMgrDao;
import com.frog4orcl.framework.core.ProcessResult;
import com.frog4orcl.framework.core.db.DBManagerImpl;
import com.frog4orcl.framework.core.db.TableInfo;
import com.frog4orcl.framework.core.page.Pagination;
import com.frog4orcl.framework.exception.BusinessException;
import com.frog4orcl.framework.exception.DatabaseException;
import com.frog4orcl.framework.util.TextUtils;

/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 19, 2011 12:31:50 PM
 * @version: 1.0
 */
public class UsualMgrBizImpl implements UsualMgrBiz {

	private static Logger logger = Logger.getLogger(UsualMgrBizImpl.class);
	private UsualMgrDao usualMgrDao;

	public void setUsualMgrDao(UsualMgrDao usualMgrDao) {
		this.usualMgrDao = usualMgrDao;
	}

	public ProcessResult<TableInfo> queryInitParameter(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba) {
		String parameterName = request.getParameter("parameterName");
		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT T.NAME AS 参数名,");
//		sql.append("T.VALUE AS 参数值,");
//		sql.append("T.TYPE AS 参数类型,");
//		sql.append("T.ISDEFAULT AS 是否缺省值");
//		sql.append(" FROM V$PARAMETER T");

		sql.append("SELECT T.NAME,");
		sql.append("T.VALUE,");
		sql.append("T.TYPE,");
		sql.append("T.ISDEFAULT");
		sql.append(" FROM V$PARAMETER T");
		
		try {
			if (parameterName != null && !parameterName.equals("")) {
				parameterName = parameterName.trim();
				// sql.append(" WHERE T.NAME LIKE ?");
				// dba.setSQL(sql.toString());
				// StringBuffer tmp = new StringBuffer();
				// tmp.append("'%").append(parameterName).append("%'");
				// dba.setString(1, tmp.toString());

				sql.append(" WHERE T.NAME LIKE '%").append(parameterName)
						.append("%'");
				dba.setSQL(sql.toString());
				request.setAttribute("parameterName", parameterName);
			} else {
				dba.setSQL(sql.toString());
			}

			ProcessResult<TableInfo> ti = this.usualMgrDao.query(dba);
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> querySga(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM V$SGA");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.usualMgrDao.query(dba);
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> querySgaInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT T.NAME,T.BYTES FROM V$SGAINFO T");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.usualMgrDao.query(dba);
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> querySgaDynamicComponents(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT T.COMPONENT AS 组件名称,");
//		sql.append("T.CURRENT_SIZE AS \"当前值(byte)\",");
//		sql.append("T.MIN_SIZE AS \"最小值(byte)\",");
//		sql.append("T.MAX_SIZE AS \"最大值(byte)\",");
//		sql.append("T.GRANULE_SIZE AS \"粒度大小(byte)\"");
//		sql.append(" FROM V$SGA_DYNAMIC_COMPONENTS T");
		
		sql.append("SELECT T.COMPONENT,");
		sql.append("T.CURRENT_SIZE,");
		sql.append("T.MIN_SIZE,");
		sql.append("T.MAX_SIZE,");
		sql.append("T.GRANULE_SIZE");
		sql.append(" FROM V$SGA_DYNAMIC_COMPONENTS T");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.usualMgrDao.query(dba);
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public Map<String, String> getSgaInfoJFC(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT T.NAME,T.BYTES FROM V$SGAINFO T");
			dba.setSQL(sql.toString());

			Map<String, Object> map = this.usualMgrDao.query4Map(dba);
			double[][] data = new double[map.size()][1];
			String[] rowKeys = new String[map.size()];
			String[] columnKeys = { "" };
			int i = 0;
			for (Map.Entry<String, Object> entry : map.entrySet()) {

				data[i][0] = TextUtils.parseDouble(entry.getValue(), 0.0d);
				rowKeys[i] = entry.getKey();
				i++;
			}
			CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
					rowKeys, columnKeys, data);

			// 通过工厂类生成JFreeChart对象
			JFreeChart chart = ChartFactory.createBarChart3D(
					"SGA 各组件使用分布图(单位byte)", "组件名称", "数值", dataset,
					PlotOrientation.VERTICAL, true, false, false);
			CategoryPlot plot = chart.getCategoryPlot();
			plot.setBackgroundPaint(Color.white);
			plot.setDomainGridlinePaint(Color.pink);
			plot.setRangeGridlinePaint(Color.pink);

			BarRenderer3D renderer = new BarRenderer3D();
			renderer
					.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer.setBaseItemLabelsVisible(true);
			renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
					ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
			renderer.setItemLabelAnchorOffset(10D);
			plot.setRenderer(renderer);
			plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
			plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

			String filename = ServletUtilities.saveChartAsPNG(chart, 500, 300,
					null, null);
			String graphURL = request.getContextPath()
					+ "/DisplayChart?filename=" + filename;
			Map<String, String> result = new HashMap<String, String>();
			result.put("filename", filename);
			result.put("url", graphURL);
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	public Map<String, String> getSgaJFC(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba) {
		try {
			DefaultPieDataset dataset = new DefaultPieDataset();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM V$SGA");
			dba.setSQL(sql.toString());
			Map<String, Object> map = this.usualMgrDao.query4Map(dba);
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				dataset.setValue(entry.getKey(), TextUtils.parseLong(entry
						.getValue(), 0));
			}

			// 通过工厂类生成JFreeChart对象
			JFreeChart chart = ChartFactory.createPieChart3D(
					"SGA使用分布图(单位byte)", dataset, true, false, false);
			PiePlot pieplot = (PiePlot) chart.getPlot();
			pieplot.setLabelFont(new Font("宋体", 0, 12));

			// 没有数据的时候显示的内容
			pieplot.setNoDataMessage("无数据显示");
			pieplot.setCircular(false);
			pieplot.setLabelGap(0.02D);
			pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator(
					"{0} ={1}"));

			String filename = ServletUtilities.saveChartAsPNG(chart, 500, 300,
					null, null);
			String graphURL = request.getContextPath()
					+ "/DisplayChart?filename=" + filename;
			Map<String, String> result = new HashMap<String, String>();
			result.put("filename", filename);
			result.put("url", graphURL);
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}

	}

	public ProcessResult<TableInfo> queryTablespaceInfo(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT A.TABLESPACE_NAME \"表空间名\",");
//		sql.append("TOTAL/1024/1024 表空间大小_M,FREE/1024/1024 表空间剩余大小_M,");
//		sql.append("(TOTAL - FREE)/1024/1024 表空间使用大小_M,");
//		sql.append("ROUND((TOTAL - FREE) / TOTAL, 4) * 100 \"使用率 %\"");
//		sql.append(" FROM (SELECT TABLESPACE_NAME, SUM(BYTES) FREE");
//		sql.append(" FROM DBA_FREE_SPACE");
//		sql.append(" GROUP BY TABLESPACE_NAME) A,");
//		sql.append("(SELECT TABLESPACE_NAME, SUM(BYTES) TOTAL");
//		sql.append(" FROM DBA_DATA_FILES GROUP BY TABLESPACE_NAME) B");
//		sql.append(" WHERE A.TABLESPACE_NAME = B.TABLESPACE_NAME");
//		sql.append(" ORDER BY A.TABLESPACE_NAME");
		
		sql.append("SELECT A.TABLESPACE_NAME,");
		sql.append("TOTAL/1024/1024 TOTAL_m,FREE/1024/1024 FREE_M,");
		sql.append("(TOTAL - FREE)/1024/1024 USED_M,");
		sql.append("ROUND((TOTAL - FREE) / TOTAL, 4) * 100 \"USED_%\"");
		sql.append(" FROM (SELECT TABLESPACE_NAME, SUM(BYTES) FREE");
		sql.append(" FROM DBA_FREE_SPACE");
		sql.append(" GROUP BY TABLESPACE_NAME) A,");
		sql.append("(SELECT TABLESPACE_NAME, SUM(BYTES) TOTAL");
		sql.append(" FROM DBA_DATA_FILES GROUP BY TABLESPACE_NAME) B");
		sql.append(" WHERE A.TABLESPACE_NAME = B.TABLESPACE_NAME");
		sql.append(" ORDER BY A.TABLESPACE_NAME");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.usualMgrDao.query(dba);
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> queryTablespaceInfoIncludeDatafile(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT B.TABLESPACE_NAME 表空间,");
//		sql.append("B.FILE_NAME 物理文件名,B.BYTES 总字节数,");
//		sql.append("(B.BYTES - SUM(NVL(A.BYTES, 0))) 已使用,");
//		sql.append("SUM(NVL(A.BYTES, 0)) 剩余,");
//		sql.append("ROUND(SUM(NVL(A.BYTES, 0)) / (B.BYTES) * 100,2) as \"剩余百分比(%)\"");
//		sql.append(" FROM DBA_FREE_SPACE A,DBA_DATA_FILES B");
//		sql.append(" WHERE A.FILE_ID = B.FILE_ID");
//		sql.append(" GROUP BY B.TABLESPACE_NAME, B.FILE_NAME,B.FILE_ID,B.BYTES");
//		sql.append(" ORDER BY B.TABLESPACE_NAME");
		
		sql.append("SELECT B.TABLESPACE_NAME,");
		sql.append("B.FILE_NAME,B.BYTES,");
		sql.append("(B.BYTES - SUM(NVL(A.BYTES, 0))) USED,");
		sql.append("SUM(NVL(A.BYTES, 0)) FREE,");
		sql.append("ROUND(SUM(NVL(A.BYTES, 0)) / (B.BYTES) * 100,2) as \"FREE(%)\"");
		sql.append(" FROM DBA_FREE_SPACE A,DBA_DATA_FILES B");
		sql.append(" WHERE A.FILE_ID = B.FILE_ID");
		sql.append(" GROUP BY B.TABLESPACE_NAME, B.FILE_NAME,B.FILE_ID,B.BYTES");
		sql.append(" ORDER BY B.TABLESPACE_NAME");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.usualMgrDao.query(dba);
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> queryControlInfo(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT T.NAME AS 控制文件名称位置,");
//		sql.append("T.IS_RECOVERY_DEST_FILE 是否在快速回复区被创建,");
//		sql.append("T.BLOCK_SIZE 块大小");
//		sql.append(" FROM V$CONTROLFILE T");
//		
		sql.append("SELECT T.NAME,");
		sql.append("T.IS_RECOVERY_DEST_FILE");
//		sql.append("T.\\\");
		sql.append(" FROM V$CONTROLFILE T");


		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.usualMgrDao.query(dba);
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> queryControlfileRecordSectionslInfo(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT T.TYPE AS 每个section的类型,");
//		sql.append("T.RECORD_SIZE AS 每条记录占用的空间,");
//		sql.append("T.RECORDS_TOTAL AS 所能保留的最大记录数,");
//		sql.append("T.RECORDS_USED AS 当前已占用的记录数");
//		sql.append(" FROM V$CONTROLFILE_RECORD_SECTION T");
		
		sql.append("SELECT T.TYPE,");
		sql.append("T.RECORD_SIZE,");
		sql.append("T.RECORDS_TOTAL,");
		sql.append("T.RECORDS_USED");
		sql.append(" FROM V$CONTROLFILE_RECORD_SECTION T");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.usualMgrDao.query(dba);
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> queryInitParameter(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba, Pagination page) {
		String parameterName = request.getParameter("parameterName");
		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT T.NAME AS 参数名,");
//		sql.append("T.VALUE AS 参数值,");
//		sql.append("T.TYPE AS 参数类型,");
//		sql.append("T.ISDEFAULT AS 是否缺省值");
//		sql.append(" FROM V$PARAMETER T");
		
		sql.append("SELECT T.NAME,");
		sql.append("T.VALUE,");
		sql.append("T.TYPE,");
		sql.append("T.ISDEFAULT");
		sql.append(" FROM V$PARAMETER T");

		try {
			if (parameterName != null && !parameterName.equals("")) {
				parameterName = parameterName.trim();
				// sql.append(" WHERE T.NAME LIKE ?");
				// dba.setSQL(sql.toString());
				// StringBuffer tmp = new StringBuffer();
				// tmp.append("'%").append(parameterName).append("%'");
				// dba.setString(1, tmp.toString());

				sql.append(" WHERE T.NAME LIKE '%").append(parameterName)
						.append("%'");
				dba.setSQL(sql.toString());
				
			} else {
				dba.setSQL(sql.toString());
			}

			ProcessResult<TableInfo> ti = this.usualMgrDao.query(dba,page);
			request.setAttribute("parameterName", TextUtils.nvl(parameterName));
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> queryRedoLogInfo(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT A.GROUP#, B.BYTES/1024/1024 AS SIZE_M,");
		sql.append("A.MEMBER, B.STATUS");
		sql.append(" FROM V$LOGFILE A, V$LOG B");
		sql.append(" WHERE A.GROUP# = B.GROUP#");
		sql.append(" ORDER BY A.GROUP#,B.THREAD#");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.usualMgrDao.query(dba);
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> queryUserInfo(HttpServletRequest request,
			HttpServletResponse response, DBManagerImpl dba) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT T.USERNAME,T.ACCOUNT_STATUS AS STATUS,");
		sql.append("T.DEFAULT_TABLESPACE,T.TEMPORARY_TABLESPACE");
		sql.append(" FROM DBA_USERS T ORDER BY USERNAME");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.usualMgrDao.query(dba);
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	public ProcessResult<TableInfo> queryUserPrivInfo(
			HttpServletRequest request, HttpServletResponse response,
			DBManagerImpl dba,Pagination page) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT A.USERNAME, B.PRIVILEGE WHAT_GRANTED,B.ADMIN_OPTION");
		sql.append(" FROM SYS.DBA_USERS A, SYS.DBA_SYS_PRIVS B");
		sql.append(" WHERE  A.USERNAME = B.GRANTEE");
		sql.append(" AND USERNAME NOT IN ('SYSTEM','SYS') ORDER BY 1,2");

		try {
			dba.setSQL(sql.toString());
			ProcessResult<TableInfo> ti = this.usualMgrDao.query(dba,page);
			return ti;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

}
