<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  </head>
  <body>
    <br>
    <form method="post" action="<%=path%>/login.do?method=test">

    <table>
    	<tr>
    		<textarea name="sqlText" rows="20" cols="80"></textarea>
    	</tr>
    	<br>
    	<tr align="center">
    		<input type="submit" value="提交">
    	</tr>
    </table>
     
    </form>
  </body>
</html>
