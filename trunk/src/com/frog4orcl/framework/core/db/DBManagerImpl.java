/**
 * 
 */
package com.frog4orcl.framework.core.db;

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.RowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

import org.apache.log4j.Logger;

import com.frog4orcl.framework.core.page.Pagination;
import com.frog4orcl.framework.exception.DatabaseException;
import com.frog4orcl.framework.util.SQLTypeUtils;
import com.frog4orcl.framework.util.TextUtils;

/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 12, 2011 10:56:30 AM
 * @version: 1.0
 */
public class DBManagerImpl implements DBManager {

	private static final Logger log = Logger.getLogger(DBManagerImpl.class);
	private transient Connection conn;
	private PreparedStatement pstmtSql;
	protected String executeSql;
	private String loginUser;

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public DBManagerImpl(Map<String, String> parameter)
			throws ClassNotFoundException, SQLException {

		String ip = parameter.get("ip");// IP地址
		String port = parameter.get("port");// 端口
		String username = parameter.get("username");// 用户名
		String password = parameter.get("password");// 密码
		String sid = parameter.get("sid");// sid
		String url = "";
		String driver = "";
		try {
			Properties prop = DBProperties.getInstance().getDBConfig();
			url = prop.getProperty("url");
			driver = prop.getProperty("driver");
		} catch (Exception e) {
			log.error("Load db config fail:" + e.getMessage());
			throw new DatabaseException(e.getMessage());
		}

		url = url.replaceAll("<ip>", ip).replaceAll("<port>", port).replaceAll(
				"<dbname>", sid);

		Properties conProps = new Properties();
		conProps.put("user", username);
		conProps.put("password", password);
		if (username.equalsIgnoreCase("sys")) {
			conProps.put("internal_logon", "SYSDBA");
		}

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			log.error("Load JDBC Driver Class出错:" + driver);
			throw new ClassNotFoundException(e.getMessage());
		}

		try {
			Connection conn = DriverManager.getConnection(url, conProps);
			this.conn = conn;
		} catch (SQLException e) {
			String msg = "链接数据库出错：" + e.getMessage();
			log.error(msg);
			throw new SQLException(e.getMessage());
		}
	}

	public DBManagerImpl(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 返回一个Connection对象
	 * 
	 * @return 一个Connection对象
	 */
	public Connection getConnection() throws DatabaseException {
		return this.conn;
	}

	/**
	 * 为数据库封装设置需要执行的SQL语句 出现错误将返回一个DatabaseException异常
	 * 
	 * @param sql
	 *            需要预编译的语句
	 * @throws DatabaseException
	 */
	public void setSQL(String sql) throws DatabaseException {
		try {
			if (this.pstmtSql != null) {
				this.pstmtSql.close();
			}
			pstmtSql = this.conn.prepareStatement(sql);
			executeSql = sql;
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("设置预编译语句的时候出现错误:", e);
			throw new DatabaseException("设置预编译语句的时候出现错误！", e);
		}
	}

	/**
	 * 为可执行sql设置数组对象参数
	 * 
	 * @param index
	 *            参数下标索引
	 * @param arrayObj
	 *            设置的数组对象参数
	 * @throws DatabaseException
	 */
	public void setArray(int index, Array arrayObj) throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			this.pstmtSql.setArray(index, arrayObj);
		} catch (Exception ex) {
			log.error("为预编译对象设置数组参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为可执行sql设置大数值对象参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            大数值对象参数
	 * @throws DatabaseException
	 */
	public void setBigDecimal(int parameterIndex, BigDecimal x)
			throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			this.pstmtSql.setBigDecimal(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置大数值对象失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为可执行sql设置二进制流对象参数
	 * 
	 * @param index
	 *            参数下标索引
	 * @param blobObj
	 *            二进制流对象
	 * @throws DatabaseException
	 */
	public void setBlob(int index, Blob blobObj) throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			this.pstmtSql.setBlob(index, blobObj);
		} catch (Exception ex) {
			log.error("为预编译对象设置二进制流对象失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置布尔值参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            布尔值
	 * @throws DatabaseException
	 */
	public void setBoolean(int parameterIndex, boolean x)
			throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			// this.addParameterValue(parameterIndex, new Boolean(x));
			this.pstmtSql.setBoolean(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置布尔值参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置字节参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            字节参数
	 * @throws DatabaseException
	 */
	public void setByte(int parameterIndex, byte x) throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			this.pstmtSql.setByte(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置字节参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置字节数组参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            字节参数数组
	 * @throws DatabaseException
	 */
	public void setBytes(int parameterIndex, byte[] x) throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			this.pstmtSql.setBytes(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置字节数组参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置大文本对象参数
	 * 
	 * @param i
	 *            参数下标索引
	 * @param x
	 *            大文本对象参数
	 * @throws DatabaseException
	 */
	public void setClob(int i, Clob x) throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			this.pstmtSql.setClob(i, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置大文本对象参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置日期参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            日期参数
	 * @throws DatabaseException
	 */
	public void setDate(int parameterIndex, Date x) throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			// this.addParameterValue(parameterIndex, x);
			this.pstmtSql.setDate(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置日期参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置双精度数值参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            双精度参数
	 * @throws DatabaseException
	 */
	public void setDouble(int parameterIndex, double x)
			throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			// this.addParameterValue(parameterIndex, new Double(x));
			this.pstmtSql.setDouble(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置双精度数值参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置浮点数参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            浮点数参数
	 * @throws DatabaseException
	 */
	public void setFloat(int parameterIndex, float x) throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			// this.addParameterValue(parameterIndex, new Float(x));
			this.pstmtSql.setFloat(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置浮点数参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置整数参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            整数参数
	 * @throws DatabaseException
	 */
	public void setInt(int parameterIndex, int x) throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			// this.addParameterValue(parameterIndex, new Integer(x));
			this.pstmtSql.setInt(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置整数参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置长整数参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            长整形参数
	 * @throws DatabaseException
	 */
	public void setLong(int parameterIndex, long x) throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			// this.addParameterValue(parameterIndex, new Long(x));
			this.pstmtSql.setLong(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置长整数参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置字段为空
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param sqlType
	 *            字段数据类型
	 * @throws DatabaseException
	 */
	public void setNull(int parameterIndex, int sqlType)
			throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			// this.addParameterValue(parameterIndex, "null");
			this.pstmtSql.setNull(parameterIndex, sqlType);
		} catch (Exception ex) {
			log.error("为预编译对象设置字段为空失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置对象参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            对象参数
	 * @throws DatabaseException
	 */
	public void setObject(int parameterIndex, Object x)
			throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			// this.addParameterValue(parameterIndex, x);
			this.pstmtSql.setObject(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置对象参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置短整形参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            短整形参数
	 * @throws DatabaseException
	 */
	public void setShort(int parameterIndex, short x) throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			// this.addParameterValue(parameterIndex, new Short(x));
			this.pstmtSql.setShort(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置短整形参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置字符串参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            字符串参数
	 * @throws DatabaseException
	 */
	public void setString(int parameterIndex, String x)
			throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			this.pstmtSql.setString(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置字符串参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置数据流参数
	 * 
	 * @param parameterIndex
	 *            参数下表索引
	 * @param x
	 *            数据流
	 * @param length
	 *            长度
	 * @throws DatabaseException
	 */
	public void setBinaryStream(int parameterIndex, InputStream x, int length)
			throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			// this.addParameterValue(parameterIndex, "binary stream");
			this.pstmtSql.setBinaryStream(parameterIndex, x, length);
		} catch (Exception ex) {
			log.error("为预编译对象设置输入流参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置时间型参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            时间型参数
	 * @throws DatabaseException
	 */
	public void setTime(int parameterIndex, Time x) throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			// this.addParameterValue(parameterIndex, x);
			this.pstmtSql.setTime(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置时间型参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置日期戳型参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            日期戳型参数
	 * @throws DatabaseException
	 */
	public void setTimestamp(int parameterIndex, Timestamp x)
			throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			this.pstmtSql.setTimestamp(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置日期戳型参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * 为预编译对象设置URL型参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            URL型参数
	 * @throws DatabaseException
	 */
	public void setURL(int parameterIndex, URL x) throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			this.pstmtSql.setURL(parameterIndex, x);
		} catch (Exception ex) {
			log.error("为预编译对象设置URL型参数失败:", ex);
			throw new DatabaseException(ex);
		}
	}

	/**
	 * sql语句查询执行
	 * 
	 * @return 查询结果
	 * @throws DatabaseException
	 */
	public RowSet executeQuery() throws DatabaseException {
		RowSet crs = null;
		ResultSet rs = null;
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			rs = this.pstmtSql.executeQuery();
			crs = new OracleCachedRowSet();
			((OracleCachedRowSet) crs).populate(rs);
			if (log.isDebugEnabled()) {
				log.debug("execute sql:" + this.executeSql);
			}
			return crs;
		} catch (Exception ex) {
			log.error("sql语句查询执行失败:", ex);
			throw new DatabaseException(ex);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ex) {
				log.error("关闭数据结果集合失败:", ex);
			}
			try {
				if (this.pstmtSql != null) {
					this.pstmtSql.close();
				}
			} catch (Exception ex) {
				log.error("关闭预编译对象失败:", ex);
			}
		}
	}

	/**
	 * 直接执行一个查询SQL， 返回一个离线记录集，关闭连接后仍然存在 被执行的sql语句为非预编译型语句
	 * 
	 * @param sql
	 *            需要执行的sql语句
	 * @return 结果记录集合（离线）
	 * @throws DatabaseException
	 */
	public RowSet executeQuery(String sql) throws DatabaseException {
		RowSet crs = null;
		ResultSet rs = null;
		try {
			if (this.pstmtSql != null) {
				this.pstmtSql.close();
			}
			this.executeSql = sql;
			this.pstmtSql = this.conn.prepareStatement(sql);
			rs = this.pstmtSql.executeQuery();

			crs = new OracleCachedRowSet();
			((OracleCachedRowSet) crs).populate(rs);
			if (log.isDebugEnabled()) {
				log.debug("execute sql:" + sql);
			}
			return crs;
		} catch (Exception ex) {
			log.error("sql语句查询执行失败:" + ex.getMessage());
			throw new DatabaseException(ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ex) {
				log.error("关闭数据结果集合失败:", ex);
			}
			try {
				if (this.pstmtSql != null) {
					this.pstmtSql.close();
				}
			} catch (Exception ex) {
				log.error("关闭预编译对象失败:", ex);
			}
		}
	}

	/**
	 * 执行预编译查询，返回一个在线记录集， 关闭连接后就无法使用结果集。 因为连接的生命周期由框架控制，为了保证最大的可用性，
	 * 必须限制此方法的结果集的生命周期小于容器可管理的连接的最小周期， 既保证在一个方法内部调用和使用所得到的结果集。
	 * 
	 * @return 查询结果记录集合
	 * @throws DatabaseException
	 */
	public ResultSet executeOnlineQuery() throws DatabaseException {
		if (this.pstmtSql == null) {
			throw new DatabaseException("未设置可执行之sql语句");
		}
		try {
			if (log.isDebugEnabled()) {
				log.debug("execute sql:" + this.executeSql);
			}
			return this.pstmtSql.executeQuery();
		} catch (Exception ex) {
			log.error("execute sql fail:" + this.executeSql);
			log.error("sql语句查询执行失败:" + ex.getMessage());
			throw new DatabaseException(ex.getMessage());
		}
	}

	/**
	 * 直接执行一查询语句， 返回一在线记录集，关闭连接后无法使用。
	 * 
	 * @param sql
	 *            需要执行的sql语句
	 * @return 查询结果记录集合
	 * @throws DatabaseException
	 */
	public ResultSet executeOnlineQuery(String sql) throws DatabaseException {
		try {
			if (this.pstmtSql != null) {
				this.pstmtSql.close();
			}
			this.executeSql = sql;
			this.pstmtSql = this.conn.prepareStatement(sql);
			if (log.isDebugEnabled()) {
				log.debug("execute sql:" + sql);
			}
			return this.pstmtSql.executeQuery();
		} catch (Exception ex) {
			log.error("sql语句查询执行失败:" + ex.getMessage());
			throw new DatabaseException(ex.getMessage());
		}
	}

	/**
	 * 将结果集的头封装到TableHeaderInfo
	 * 
	 * @param rs
	 * @return
	 * @throws DatabaseException
	 */
	public List<TableHeaderInfo> getTableColumnInfoByResultSet(ResultSet rs)
			throws DatabaseException {
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int length = rsmd.getColumnCount();
			List<TableHeaderInfo> columns;
			columns = new ArrayList<TableHeaderInfo>(length);
			for (int i = 0; i < length; i++) {
				int idx = i + 1;
				String name = rsmd.getColumnName(idx);
				int type = rsmd.getColumnType(idx);
				int width = rsmd.getColumnDisplaySize(idx);
				columns.add(new TableHeaderInfo(name, type, width, true));
			}
			return columns;
		} catch (Exception e) {
			log.error("getTableColumnInfoByResultSet执行失败:" + e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	/**
	 * 将结果集封装到TableDataInfo对象中
	 * 
	 * @param rs
	 * @param limit
	 * @param columns
	 * @param total
	 * @return
	 * @throws SQLException
	 */
	public TableDataInfo getTableDataInfoByResultSet(ResultSet rs,
			List<TableHeaderInfo> columns) throws DatabaseException {
		try {
			List<Map<String, Object>> rows;
			rows = new ArrayList<Map<String, Object>>();

			while (rs.next()) {
				Map<String, Object> row = new HashMap<String, Object>();
				for (TableHeaderInfo column : columns) {
					Object value = readFieldValue(rs, column);
					row.put(column.getName(), value);
				}
				rows.add(row);
			}
			return new TableDataInfo(rows.size(), rows);
		} catch (Exception e) {
			log.error("getTableDataInfoByResultSet 执行失败:" + e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	/*
	 * 从ResultSet中读取 指定列的值
	 * 
	 * @param rs @param column @return @throws SQLException
	 */
	private Object readFieldValue(ResultSet rs, TableHeaderInfo column)
			throws SQLException {
		int type = column.getType();
		String field = column.getName();
		// 读取字段值
		Object value = null;
		if (SQLTypeUtils.isDateType(type)) {
			value = rs.getTimestamp(field);
		} else if (SQLTypeUtils.isNumberType(type)) {
			value = rs.getString(field);
		} else if (SQLTypeUtils.isStringType(type)) {
			value = rs.getString(field);
		} else if (SQLTypeUtils.isBlobType(type)) {
			value = "[LONGVARBINARY]";
		} else if (SQLTypeUtils.isClobType(type)) {
			value = "[LONGVARCHAR]";
		} else {
			value = "[" + SQLTypeUtils.getJdbcTypeName(type) + "]";
		}
		// 处理 NULL 值
		if (rs.wasNull() && !SQLTypeUtils.isNumberType(type)
				&& !SQLTypeUtils.isDateType(type)) {
			value = "[NULL]";
		} else {
			if (SQLTypeUtils.isStringType(type)) {
				if (TextUtils.isHTMLContent(value.toString())) {
					value = "[HTML]";
				}
			}
		}
		return value;
	}

	/**
	 * 获取tableinfo
	 * 
	 * @param sql
	 *            需要查询的sql
	 * @return
	 */
	public TableInfo getTableInfoByResultSet(String sql) {
		ResultSet rs = null;
		try {
			rs = this.executeOnlineQuery(sql);
			return getTableInfoByResultSet(rs);
		} catch (Exception e) {
			log.error("getTableInfoByResultSet 执行失败:", e);
			throw new DatabaseException(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.error("getTableInfoByResultSet时,关闭rs失败:", e);
					throw new DatabaseException(e.getMessage());
				}
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public TableInfo getTableInfoByResultSet() {
		ResultSet rs = null;
		try {
			rs = this.executeOnlineQuery();
			return getTableInfoByResultSet(rs);
		} catch (Exception e) {
			log.error("getTableInfoByResultSet 执行失败:", e);
			throw new DatabaseException(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.error("getTableInfoByResultSet时,关闭rs失败:", e);
					throw new DatabaseException(e.getMessage());
				}
			}
		}
	}

	/**
	 * 获取tableinfo
	 * 
	 * @param rs
	 *            结果集
	 * @return
	 */
	public TableInfo getTableInfoByResultSet(ResultSet rs) {
		try {
			TableInfo ti = new TableInfo();
			List<TableHeaderInfo> head = getTableColumnInfoByResultSet(rs);
			TableDataInfo data = getTableDataInfoByResultSet(rs, head);
			ti.setColumns(head);
			ti.setData(data);
			return ti;
		} catch (Exception e) {
			log.error("getTableInfoByResultSet 执行失败:" + e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}

	/**
	 * 获取结果集,带分页
	 * 
	 * @param page
	 * @return
	 */
	public TableInfo getTableInfoByResultSet(Pagination page,
			List<Object> parameters) {
		ResultSet rs = null;
		try {
			String sql = this.executeSql;
			page.init(this.getRecordsCnt(sql, parameters));

			int beginNum = page.getBeginElement();// 开始的条数
			int endNum = page.getEndElement();// 结束的条数

			StringBuffer wrapSql = new StringBuffer();
			wrapSql.append("SELECT * FROM (");
			wrapSql.append("SELECT A.*, ROWNUM RN FROM (");
			wrapSql.append(sql);
			wrapSql.append(") A WHERE ROWNUM <= ").append(endNum);
			wrapSql.append(") WHERE RN >= ").append(beginNum);
			this.setSQL(wrapSql.toString());
			if (parameters != null && parameters.size() > 0) {
				int i = 0;
				for (Object obj : parameters) {
					this.setObject(++i, obj);
				}
			}
			rs = this.executeOnlineQuery();
			return getTableInfoByResultSet(rs);
		} catch (Exception e) {
			log.error("getTableInfoByResultSet 执行失败:", e);
			throw new DatabaseException(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.error("getTableInfoByResultSet时,关闭rs失败:", e);
					throw new DatabaseException(e.getMessage());
				}
			}
		}
	}

	/**
	 * 获取SQL的记录数
	 * 
	 * @param sql
	 * @return
	 */
	public int getRecordsCnt(String sql, List<Object> parameters) {
		try {
			// 获取最大记录数
			StringBuffer cntSql = new StringBuffer();
			cntSql.append("SELECT COUNT(*) CNT FROM (");
			cntSql.append(sql).append(")");
			this.setSQL(cntSql.toString());
			if (parameters != null && parameters.size() > 0) {
				int i = 0;
				for (Object obj : parameters) {
					this.setObject(++i, obj);
				}
			}
			ResultSet rs = this.executeOnlineQuery();
			int cnt = 0;
			if (rs != null) {
				while (rs.next()) {
					cnt = Integer.parseInt(String.valueOf(rs.getObject(1)));
				}
			}
			return cnt;
		} catch (Exception e) {
			log.error("获取sql记录数失败:", e);
			throw new DatabaseException(e.getMessage());
		}
	}
}
