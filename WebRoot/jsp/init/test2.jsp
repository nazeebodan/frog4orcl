<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.frog4orcl.framework.core.ProcessResult"%>
<%@page import="com.frog4orcl.framework.util.SystemConstant"%>
<%@page import="com.frog4orcl.framework.core.db.TableInfo"%>
<%@page import="com.frog4orcl.framework.core.db.TableHeaderInfo"%>
<%
ProcessResult<TableInfo> result = (ProcessResult<TableInfo>)request.getAttribute(SystemConstant.OBJECT_DATA);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <body>
    <%
    TableInfo ti = result.getData();
    if(ti!=null&&ti.getColumns()!=null){
    			out.println("<table>");
				out.println("<tr style=\"text-align: center; COLOR: #0076C8; BACKGROUND-COLOR: #F4FAFF; font-weight: bold\">");
				for(TableHeaderInfo column: ti.getColumns()){
					out.println("<td nowrap=\"nowrap\">");
					out.print(column.getName());
					out.println("</td>");
				}
				out.println("</tr>");
				List<Map<String, Object>> rows = ti.getData().getRows();
				if(rows!=null){
					for(Map<String, Object> map:rows ){
						out.println("<tr bgcolor='#F4FAFE'>");
						for(TableHeaderInfo column: ti.getColumns()){
							Object obj = map.get(column.getName());
							if(obj==null){
								out.println("<td nowrap=\"nowrap\" bgcolor=\"red\">");
								out.print(obj);
								out.println("</td>");
							}else{
								out.println("<td nowrap=\"nowrap\">");
								out.print(obj);
								out.println("</td>");
							}
							
						}
						out.println("</tr>");
					}
				}
				out.println("</table>");
			}
     %>
     <input type="button" value="返回" onclick="history.go(-1);">
  </body>
</html>
