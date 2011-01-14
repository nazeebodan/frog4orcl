/**
 * 
 */
package com.frog4orcl.framework.core.db;

import java.util.List;
import java.util.Map;

/**
 * @说明: 表数据的类
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 11, 2011 10:25:28 AM
 * @version: 1.0
 */
public class TableDataInfo {
	private long total;//记录数
	private List<Map<String, Object>> rows;

	public TableDataInfo(long total, List<Map<String, Object>> rows) {
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

}
