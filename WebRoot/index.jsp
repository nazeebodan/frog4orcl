<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.frog4orcl.framework.util.SystemConstant"%>
<%
String path = request.getContextPath();
String message = (String)request.getAttribute(SystemConstant.INDEX_MSG);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
 	<title>Frog for Oracle | Sign In</title>
    <link rel="stylesheet" href="css/frog.css" type="text/css" media="screen"/>
</head>

<body id="login">
    <%if(message!=null){
        out.println(message);
    } %>
	<div id="loginlogo">
		<img src="image/login/crazy frog.jpg"/>
	</div>

 <form id="loginform" method="post" action="<%=path%>/login.do?method=login">
	<table align="center">
  		<tr>
			<td ><font size="2">IP地址</font></td>
			<td width="155px"><input type="text" name="ip" value="172.16.40.26"></td>
  		</tr>
  		<tr>
			<td><font size="2">端口号</font></td>
			<td><input type="text" name="port" value="1521"></td>
  		</tr>
  		<tr>
			<td align="left"><font size="2">SID</font></td>
			<td><input type="text" name="sid" value="orcl"></td>
  		</tr>
  		<tr>
			<td><font size="2">用户名</font></td>
			<td><input type="text" name="username" value="scott"></td>
  		</tr>
    	<tr align="left">
			<td align="left"><font size="2">密码</font></td>
			<td align="left"><input type="password" name="password" value="tiger"></td>
  		</tr>
  	</table>
  	<input class="button" type="reset" value="重置">
	<input class="button" type="submit" value="提交">
  </form>
 </body>
</html>
