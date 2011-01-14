/**
 * 
 */
package com.frog4orcl.framework.core.db;

import java.util.List;

/**
 * @说明: 表的类
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 11, 2011 10:32:55 AM
 * @version: 1.0
 */
public class TableInfo {
	// 表名称
	private String tableName;
	// 列信息
	private List<TableHeaderInfo> columns;
	// 表数据信息
	private TableDataInfo data;
	
	public TableInfo() {
	}
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<TableHeaderInfo> getColumns() {
		return columns;
	}
	public void setColumns(List<TableHeaderInfo> columns) {
		this.columns = columns;
	}
	public TableDataInfo getData() {
		return data;
	}
	public void setData(TableDataInfo data) {
		this.data = data;
	}
}
