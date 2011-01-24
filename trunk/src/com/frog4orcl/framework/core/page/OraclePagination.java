/**
 * 
 */
package com.frog4orcl.framework.core.page;

import javax.servlet.http.HttpServletRequest;

import com.frog4orcl.framework.util.TextUtils;

/**
 * @说明: 分页对象的实现
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 24, 2011 10:37:27 AM
 * @version: 1.0
 */
public class OraclePagination implements Pagination {

	// 默认的每页最大记录数
	private final int DEFAULT_PAGE_SIZE = 20;
	// 每页最大的记录数
	private int pageSize;
	// 默认的当前页码数
	private final int DEFAULT_PAGE_NUMBER = 1;
	// 当前的页码
	private int pageNumber;
	// 最大页数
	private int maxPages = 1;
	// 最大记录数
	private int maxElements;

	/**
	 * 构造方法
	 */
	public OraclePagination() {

	}

	/**
	 * 构造方法 初始化pageSize和pageNumber 如果不能传request作为参数,可以考虑使用该构造方法
	 * 
	 * @param pageSize
	 * @param pageNumber
	 * @throws Exception
	 */
	public OraclePagination(int pageSize, int pageNumber) throws Exception {
		if (pageSize > 0) {
			setPageSize(pageSize);
		} else {
			setPageSize(DEFAULT_PAGE_SIZE);
		}
		if (pageNumber > 1) {
			setPageNumber(pageNumber);
		} else {
			setPageNumber(DEFAULT_PAGE_NUMBER);
		}
	}

	/**
	 * 构造方法 初始化pageSize和pageNumber
	 * 
	 * @param request
	 */
	public OraclePagination(HttpServletRequest request) {
		int pageSize = Integer.parseInt(TextUtils.nvlNum(request
				.getParameter("pageSize")));
		int pageNumber = Integer.parseInt(TextUtils.nvlNum(request
				.getParameter("pages")));
		if (pageSize > 0) {
			setPageSize(pageSize);
		} else {
			setPageSize(DEFAULT_PAGE_SIZE);
		}
		if (pageNumber > 1) {
			setPageNumber(pageNumber);
		} else {
			setPageNumber(DEFAULT_PAGE_NUMBER);
		}
	}

	/**
	 * 初始化参数 初始化最大记录数和最大页数, 在获取了Pagination对象之后 ,记得调用该方法
	 * 
	 * @param maxElements
	 */
	public void init(int maxElements) {
		setMaxElements(maxElements);
		setMaxPages();
	}

	/**
	 * 设置最大记录数
	 * 
	 * @param total
	 */
	private void setMaxElements(int total) {
		this.maxElements = total;
	}

	/**
	 * 设置最大页码数
	 */
	private void setMaxPages() {
		if (maxElements != 0 && (maxElements % pageSize == 0)) {
			maxPages = maxElements / pageSize;
		} else {
			maxPages = maxElements / pageSize + 1;
		}
	}

	// @SuppressWarnings("unchecked")
	// public List<Object> getList() {
	// List list = null;
	// Map<String, Integer> map = null;
	// map = new HashMap<String, Integer>();
	// map.put("beginElement", this.getBeginElement());
	// map.put("endElement", this.getEndElement());
	// try {
	// list = pageHelper.queryForList(this.statementName, map);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return list;
	// }
	//
	// public List<Object> getListForxxxx() {
	// List list = null;
	// Map<String, Integer> map = null;
	// map = new HashMap<String, Integer>();
	// map.put("beginElement", this.getBeginElement());
	// map.put("endElement", this.getEndElement());
	//
	// try {
	// this.pageHelper.initialize();
	// this.pageHelper.setEnablePage(true);
	// System.out.println("=====进入到查询list翻页的类=====");
	// list = pageHelper.queryForList(this.statementName, map, 5, 10);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return list;
	// }

	/**
	 * 获取分页的结束的记录数范围
	 */
	public int getEndElement() {
		int endElement = pageNumber * pageSize;
		if (endElement >= maxElements) {
			return maxElements;
		} else {
			return endElement;
		}
	}

	/**
	 * 获取分页的开始的记录数范围
	 */
	public int getBeginElement() {
		return (pageNumber - 1) * pageSize + 1;
	}

	/**
	 * 获取最大的记录数
	 */
	public int getMaxElements() {
		return maxElements;
	}

	/**
	 * 获取最大的分页数
	 */
	public int getMaxPages() {
		return maxPages;
	}

	/**
	 * 获取下一些的页码
	 */
	public int getNext() {
		if (pageNumber + 1 >= this.getMaxPages()) {
			return getMaxPages();
		}
		return pageNumber + 1;
	}

	/**
	 * 获取当前页的页码
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * 获取每页的最大记录数
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 获取上一页的页码数
	 */
	public int getPrevious() {
		if (pageNumber - 1 <= 1) {
			return 1;
		} else {
			return pageNumber - 1;
		}
	}

	/**
	 * 是否有下一页
	 */
	public boolean hasNext() {
		return pageNumber < maxPages;
	}

	/**
	 * 是否有下一页
	 */
	public boolean hasPrevious() {
		return pageNumber > 1;
	}

	/**
	 * 是否首页
	 */
	public boolean isFirst() {
		return pageNumber == 1;
	}

	/**
	 * 是否末页
	 */
	public boolean isLast() {
		return pageNumber >= this.getMaxPages();
	}

	/**
	 * 设置当前页码数
	 * 
	 * @param pageNumber
	 */
	public void setPageNumber(int pageNumber) {
		if (pageNumber < 1) {
			this.pageNumber = 1;
		} else {
			this.pageNumber = pageNumber;
		}
	}

	/**
	 * 设置每页的记录数
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获取分页的脚本
	 * 
	 */
	public String getToolsMenu() {
		StringBuffer str = new StringBuffer("");
		int next, prev;
		prev = pageNumber - 1;
		next = pageNumber + 1;

		if (pageNumber > 1) {
			str
					.append("<a href=\"#\" onclick=\"document.forms(0).pages.value=1;document.forms(0).submit();\">首页</a>&nbsp;");
		} else {
			str.append("<a href=\"#\">首页</a>&nbsp;");
		}
		if (pageNumber > 1) {
			str.append("<a href=\"#\" onclick='document.forms(0).pages.value="
					+ prev + ";document.forms(0).submit();'>上页</a>&nbsp;");
		} else {
			str.append("<a href=\"#\">上页</a>&nbsp;");
		}
		if (pageNumber < getMaxPages()) {
			str.append("<a href=\"#\" onclick='document.forms(0).pages.value="
					+ next + ";document.forms(0).submit();'>下页</a>&nbsp;");
		} else {
			str.append("<a href=\"#\" >下页</a>&nbsp;");
		}
		if (getMaxPages() > 1 && pageNumber != getMaxPages()) {
			str.append("<a href=\"#\"  onclick='document.forms(0).pages.value="
					+ getMaxPages()
					+ ";document.forms(0).submit();'>末页</a>&nbsp;&nbsp;");
		} else {
			str.append("<a href=\"#\" >末页</a>&nbsp;&nbsp;");
		}
		str.append(" 共" + getMaxElements() + "条记录");
		str
				.append("  每页<SELECT size=1 name=pagesize onchange='this.form.pages.value=1;this.form.pageSize.value=this.value;this.form.submit();'>");

		if (pageSize == 3) {
			str.append("<OPTION value=3 selected>3</OPTION>");
		} else {
			str.append("<OPTION value=3>3</OPTION>");
		}

		if (pageSize == 10) {
			str.append("<OPTION value=10 selected>10</OPTION>");
		} else {
			str.append("<OPTION value=10>10</OPTION>");
		}
		if (pageSize == 20) {
			str.append("<OPTION value=20 selected>20</OPTION>");
		} else {
			str.append("<OPTION value=20>20</OPTION>");
		}
		if (pageSize == 50) {
			str.append("<OPTION value=50 selected>50</OPTION>");
		} else {
			str.append("<OPTION value=50>50</OPTION>");
		}
		if (pageSize == 100) {
			str.append("<OPTION value=100 selected>100</OPTION>");
		} else {
			str.append("<OPTION value=100>100</OPTION>");
		}
		str.append("</SELECT>");
		str.append("条 分" + pageSize + "页显示 转到");
		str
				.append("<SELECT size=1 name=Pagelist onchange='this.form.pages.value=this.value;this.form.submit();'>");
		for (int i = 1; i < getMaxPages() + 1; i++) {
			if (i == pageNumber) {
				str.append("<OPTION value=" + i + " selected>" + i
						+ "</OPTION>");
			} else {
				str.append("<OPTION value=" + i + ">" + i + "</OPTION>");
			}
		}
		str.append("</SELECT>页");
		str.append("<INPUT type=hidden  value=" + pageNumber
				+ " name=\"pages\" > ");
		str.append("<INPUT type=hidden  value=" + pageSize
				+ " name=\"pageSize\"> ");
		return str.toString();
	}

}
