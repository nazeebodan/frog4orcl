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
  <head>
  </head>
  
  <body>
    <br>
    <%
    TableInfo ti = result.getData();
    if(ti!=null&&ti.getColumns()!=null){
				int i =0;
				for(TableHeaderInfo column: ti.getColumns()){
					out.print(column.getName()+"   ");
				}
				out.println("<br>");
				List<Map<String, Object>> rows = ti.getData().getRows();
				if(rows!=null){
					for(Map<String, Object> map:rows ){
						i++;
						for(TableHeaderInfo column: ti.getColumns()){
							out.print(map.get(column.getName())+"   ");
						}
						out.println("<br>");
					}
				}
			}
     %>
     <input type="button" value="返回" onclick="history.go(-1);">
  </body>
</html>
