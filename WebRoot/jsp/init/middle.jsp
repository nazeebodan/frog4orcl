<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<link href="<%=path %>/jsp/init/css/all.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body { margin:0 auto; padding:0;}
-->
</style>
<style> 
.navPoint { 
color:white; cursor:hand; font:12px "宋体";FONT-FAMILY: Webdings;} 

</style>
<script>
function switchSysBar(){ 
	if (switchPoint.innerText==3){
		switchPoint.innerText=4;
		document.all("frmTitle").style.display="none";	
	}else{
		switchPoint.innerText=3;	
		document.all("frmTitle").style.display="";
	}
} 
</script>
</head>
<body style="overflow:hidden">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed;">
  <tr>
    <td width="162" id=frmTitle noWrap name="fmTitle" align="center" valign="top">
 
 	<iframe name="I1" height="100%" width="162" src="<%=path%>/jsp/init/left2.jsp" border="0" frameborder="0" scrolling="no"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
    </td>
    <td width="4" style="width:8px;"valign="middle" bgcolor="004C7E" onclick=switchSysBar()><span class=navPoint 
		id=switchPoint title="打开/关闭左栏">3</span></td>
    <td width="5"></td>
    <td align="center" valign="top">
      <iframe name="I2" height="100%" width="100%" frameborder="0" src="<%=path%>/jsp/init/right.jsp"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
    </td>
  </tr>
</table>
</body>
</html>

