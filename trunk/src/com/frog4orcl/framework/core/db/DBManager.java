/**
 * 
 */
package com.frog4orcl.framework.core.db;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;

import javax.sql.RowSet;

import com.frog4orcl.framework.exception.DatabaseException;

/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 13, 2011 11:21:53 AM
 * @version: 1.0
 */
public interface DBManager {

	/**
	 * 为数据库封装设置需要执行的SQL语句<br>
	 * 出现错误将返回一个DatabaseException异常<br>
	 * 
	 * @param sql
	 *            需要预编译的语句
	 * @throws DatabaseException
	 */
	public abstract void setSQL(String sql) throws DatabaseException;

	/**
	 * 为可执行sql设置数组对象参数
	 * 
	 * @param index
	 *            参数下标索引
	 * @param arrayObj
	 *            设置的数组对象参数
	 * @throws DatabaseException
	 */
	public abstract void setArray(int index, Array arrayObj)
			throws DatabaseException;

	/**
	 * 为可执行sql设置二进制流对象参数
	 * 
	 * @param index
	 *            参数下标索引
	 * @param blobObj
	 *            二进制流对象
	 * @throws DatabaseException
	 */
	public abstract void setBlob(int index, Blob blobObj)
			throws DatabaseException;

	/**
	 * 为预编译对象设置整数参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            整数参数
	 * @throws DatabaseException
	 */
	public abstract void setInt(int parameterIndex, int x)
			throws DatabaseException;

	/**
	 * 为预编译对象设置字节参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            字节参数
	 * @throws DatabaseException
	 */
	public abstract void setByte(int parameterIndex, byte x)
			throws DatabaseException;

	/**
	 * 为预编译对象设置长整数参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            长整形参数
	 * @throws DatabaseException
	 */
	public abstract void setLong(int parameterIndex, long x)
			throws DatabaseException;

	/**
	 * 为预编译对象设置字符串参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            字符串参数
	 * @throws DatabaseException
	 */
	public abstract void setString(int parameterIndex, String x)
			throws DatabaseException;

	/**
	 * 为预编译对象设置字节数组参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            字节参数数组
	 * @throws DatabaseException
	 */
	public abstract void setBytes(int parameterIndex, byte[] x)
			throws DatabaseException;

	/**
	 * 为预编译对象设置大文本对象参数
	 * 
	 * @param i
	 *            参数下标索引
	 * @param x
	 *            大文本对象参数
	 * @throws DatabaseException
	 */
	public abstract void setClob(int i, Clob x) throws DatabaseException;

	/**
	 * 为预编译对象设置布尔值参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            布尔值
	 * @throws DatabaseException
	 */
	public abstract void setBoolean(int parameterIndex, boolean x)
			throws DatabaseException;

	/**
	 * 为预编译对象设置对象参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            对象参数
	 * @throws DatabaseException
	 */
	public abstract void setObject(int parameterIndex, Object x)
			throws DatabaseException;

	/**
	 * 为预编译对象设置短整形参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            短整形参数
	 * @throws DatabaseException
	 */
	public abstract void setShort(int parameterIndex, short x)
			throws DatabaseException;

	/**
	 * 为预编译对象设置字段为空
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param sqlType
	 *            字段数据类型
	 * @throws DatabaseException
	 */
	public abstract void setNull(int parameterIndex, int sqlType)
			throws DatabaseException;

	/**
	 * 为预编译对象设置日期参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            日期参数
	 * @throws DatabaseException
	 */
	public abstract void setDate(int parameterIndex, Date x)
			throws DatabaseException;

	/**
	 * 为可执行sql设置大数值对象参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            大数值对象参数
	 * @throws DatabaseException
	 */
	public abstract void setBigDecimal(int parameterIndex, BigDecimal x)
			throws DatabaseException;

	/**
	 * 为预编译对象设置浮点数参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            浮点数参数
	 * @throws DatabaseException
	 */
	public abstract void setFloat(int parameterIndex, float x)
			throws DatabaseException;

	/**
	 * 为预编译对象设置双精度数值参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            双精度参数
	 * @throws DatabaseException
	 */
	public abstract void setDouble(int parameterIndex, double x)
			throws DatabaseException;

	/**
	 * 为预编译对象设置时间型参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            时间型参数
	 * @throws DatabaseException
	 */
	public abstract void setTime(int parameterIndex, Time x)
			throws DatabaseException;

	/**
	 * 为预编译对象设置日期戳型参数
	 * 
	 * @param parameterIndex
	 *            参数下标索引
	 * @param x
	 *            日期戳型参数
	 * @throws DatabaseException
	 */
	public abstract void setTimestamp(int parameterIndex, Timestamp x)
			throws DatabaseException;
	
	/**
	    * 执行预编译查询,返回一个ResultSet数据集<br>
	    * 出现错误将会抛出一个DatabaseException异常<br>
	    * 注意本方法返回的是一个离线记录集，关闭连接后仍然存在
	    * 
	    * @return 查询结果记录集合(离线)
	    * @throws DatabaseException
	    */
	   public abstract RowSet executeQuery() throws DatabaseException;

	   /**
	    * 直接执行一个查询SQL，<br>
	    * 返回一个离线记录集，关闭连接后仍然存在<br>
	    * 被执行的sql语句为非预编译型语句
	    * 
	    * @param sql 需要执行的sql语句
	    * @return 结果记录集合（离线）
	    * @throws DatabaseException
	    */
	   public abstract RowSet executeQuery(String sql) throws DatabaseException;

	   /**
	    * 执行预编译查询，返回一个在线记录集，<br>
	    * 关闭连接后就无法使用结果集。<br>
	    * 因为连接的生命周期由框架控制，为了保证最大的可用性，<br>
	    * 必须限制此方法的结果集的生命周期小于容器可管理的连接的最小周期，<br>
	    * 既保证在一个方法内部调用和使用所得到的结果集。
	    * 
	    * @return 查询结果记录集合
	    * @throws DatabaseException
	    */
	   public abstract ResultSet executeOnlineQuery() throws DatabaseException;

	   /**
	    * 直接执行一查询语句，<br>
	    * 返回一在线记录集，关闭连接后无法使用。
	    * 
	    * @param sql 需要执行的sql语句
	    * @return 查询结果记录集合
	    * @throws DatabaseException
	    */
	   public abstract ResultSet executeOnlineQuery(String sql)
	         throws DatabaseException;
	   
	   /**
	    * 得到当前数据库操作封装中的数据库连接
	    * 
	    * @return 数据库连接
	    * @throws DatabaseException
	    */
	   public abstract Connection getConnection() throws DatabaseException;

}
