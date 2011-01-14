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
    <%=message %><br>
  </body>
</html>
