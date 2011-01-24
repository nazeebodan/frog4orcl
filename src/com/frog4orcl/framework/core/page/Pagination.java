/**
 * 
 */
package com.frog4orcl.framework.core.page;

/**
 * @说明: 分页的接口
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 24, 2011 10:35:56 AM
 * @version: 1.0
 */
public interface Pagination {
	/**
	 * 判断当前页是否为第一页
	 * 
	 * @return
	 */
	public boolean isFirst();

	/**
	 * 判断当前页是否为最后一页
	 * 
	 * @return
	 */
	public boolean isLast();

	/**
	 * 判断是否有下一页
	 * 
	 * @return
	 */
	public boolean hasNext();

	/**
	 * 判断是否还有上一页
	 * 
	 * @return
	 */
	public boolean hasPrevious();

	/**
	 * 返回当前分页的总记录数
	 * 
	 * @return
	 */
	public int getMaxElements();

	/**
	 * 返回当前分页的总分页数
	 * 
	 * @return
	 */
	public int getMaxPages();

	/**
	 * 获取下一页的页码
	 * 
	 * @return
	 */
	public int getNext();

	/**
	 * 获取上一页的页码
	 * 
	 * @return
	 */
	public int getPrevious();

	/**
	 * 返回每一页的条数
	 * 
	 * @return
	 */
	public int getPageSize();

	/**
	 * 返回当前页的页码
	 * 
	 * @return
	 */
	public int getPageNumber();

	/**
	 * 设定分页的大小
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize);

	/**
	 * 设定当前显示的页面的页码 比如说,要显示第X页,就调用这个方法
	 * 
	 * @param pageNumber
	 */
	public void setPageNumber(int pageNumber);

	public String getToolsMenu();

	public int getEndElement();

	public int getBeginElement();

	public void init(int maxElements);
}
