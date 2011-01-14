<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
 <body>
 <form action="<%=path%>/">
  <table>
  <tr>
	<td>ip地址:</td>
	<td><input type="text" name="ip"></td>
  </tr>
  <tr>
	<td>端口号:</td>
	<td><input type="text" name="port"></td>
  </tr>
  <tr>
	<td>sid:</td>
	<td><input type="text" name="sid"></td>
  </tr>
  <tr>
	<td>用户名:</td>
	<td><input type="text" name="username"></td>
  </tr>
    <tr>
	<td>密码:</td>
	<td><input type="password" name="password"></td>
  </tr>
  </table>
  <input type="reset" value="重置"> <input type="submit" value="提交">
  </form>
 </body>
</html>
