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
    <textarea name="sqlText" rows="10" cols="50"></textarea>
    <br>
    <br>
    <br>
     <input type="submit" value="提交">
    </form>
  </body>
</html>
