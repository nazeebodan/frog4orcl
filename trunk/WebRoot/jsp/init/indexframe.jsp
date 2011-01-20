<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.frog4orcl.framework.util.SystemConstant"%>
<%
String path = request.getContextPath();
String username = (String)request.getAttribute(SystemConstant.LOGIN_USER_NAME);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>frog4orcl index</title>
<style>
* { margin:0 auto; padding:0; border:0;}
</style>
</head>
<frameset rows="58,*" frameborder="0" border="0" framespacing="0">
  <frame src="<%=path%>/jsp/init/top.jsp?username=<%=username %>" name="top" scrolling="No" noresize="noresize" id="top" />
  <frame src="<%=path%>/jsp/init/centerframe.jsp" name="center" id="center" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
