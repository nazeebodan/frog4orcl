<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.frog4orcl.framework.util.SystemConstant"%>
<%
String path = request.getContextPath();
String message = (String)request.getAttribute(SystemConstant.INDEX_MSG);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

 <body>
 <div>
 <%if(message!=null){
 	out.println(message);		
 } %>
 </div>
 <form method="post" action="<%=path%>/login.do?method=login">
  <table>
  <tr>
	<td>ip地址:</td>
	<td><input type="text" name="ip" value="172.16.40.26"></td>
  </tr>
  <tr>
	<td>端口号:</td>
	<td><input type="text" name="port" value="1521"></td>
  </tr>
  <tr>
	<td>sid:</td>
	<td><input type="text" name="sid" value="orcl"></td>
  </tr>
  <tr>
	<td>用户名:</td>
	<td><input type="text" name="username" value="scott"></td>
  </tr>
    <tr>
	<td>密码:</td>
	<td><input type="password" name="password" value="tiger"></td>
  </tr>
  </table>
  <input type="reset" value="重置"> <input type="submit" value="提交">
  </form>
 </body>
</html>
