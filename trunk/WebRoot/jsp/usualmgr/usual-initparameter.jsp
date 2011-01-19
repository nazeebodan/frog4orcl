<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.frog4orcl.framework.core.ProcessResult"%>
<%@page import="com.frog4orcl.framework.util.SystemConstant"%>
<%@page import="com.frog4orcl.framework.core.db.TableInfo"%>
<%@page import="com.frog4orcl.framework.core.db.TableHeaderInfo"%>
<%
String path = request.getContextPath();
ProcessResult<TableInfo> result = (ProcessResult<TableInfo>)request.getAttribute(SystemConstant.OBJECT_DATA);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<link href="<%=path %>/jsp/init/css/all.css" rel="stylesheet" type="text/css">
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
     <div id="center-column">
			<div class="top-bar">
				<h1>Contents</h1>
				<div class="breadcrumbs"><a href="#">Contents</a></div>
			</div><br />
		  <div class="select-bar">
		    <label>
		    <input type="text" name="textfield" />
		    </label>
		    <label>
			<input type="submit" name="Submit" value="Search" />
			</label>
		  </div>
	<div class="table">
				<img src="<%=path %>/jsp/init/images/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="<%=path %>/jsp/init/images/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<table class="listing" cellpadding="0" cellspacing="0">
				<tr>
				<%
    				TableInfo ti = result.getData();
				    if(ti!=null&&ti.getColumns()!=null){
				        int size = ti.getColumns().size();
				        int i=0;
		    			for(TableHeaderInfo column: ti.getColumns()){
		    			i++;
		    			String headerName = column.getName();
		    	%>
		    			<%if(i==0){ %>
						<th class="first"><%=headerName %></th>
						<%}else if(i==size){ %>
						<th class="last"><%=headerName %></th>
						<% }else{%>
						<th><%=headerName %></th>
						<%} %>
					
				<%
						}
					}
				 %>
				 </tr>
					
					<tr>
						<td class="first style1">- Lorem Ipsum </td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td class="last"></td>
					</tr>
					<tr class="bg">
						<td class="first style2">- Lorem Ipsum </td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td class="last"></td>
					</tr>
					<tr>
						<td class="first style3">- Lorem Ipsum </td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td class="last"></td>
					</tr>
					<tr class="bg">
						<td class="first style1">- Lorem Ipsum </td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td class="last"></td>
					</tr>
					<tr>
						<td class="first style2">- Lorem Ipsum </td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td class="last"></td>
					</tr>
					<tr class="bg">
						<td class="first style3">- Lorem Ipsum </td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td class="last"></td>
					</tr>
					<tr>
						<td class="first style4">- Lorem Ipsum </td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td class="last"></td>
					</tr>
				</table>
				<div class="select">
					<strong>Other Pages: </strong>
					<select>
						<option>1</option>
					</select>
			  </div>
			</div>
</body>
  </body>
</html>
