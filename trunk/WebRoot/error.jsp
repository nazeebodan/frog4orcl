<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.frog4orcl.framework.util.SystemConstant"%>
<%
String path = request.getContextPath();
String message = (String)request.getAttribute(SystemConstant.ERR_MSG_JSP);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
  <table >
  	<tr style="text-align: center; COLOR: #0076C8; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
  		<td nowrap="nowrap">
  			<%=message %>
  		</td>
  	</tr>
  </table>
  </body>
</html>
