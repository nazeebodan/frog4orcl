<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.frog4orcl.framework.util.SystemConstant"%>
<%
String path = request.getContextPath();
String username = request.getParameter("username");
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<script language=JavaScript>
function logout(){
	if (confirm("您确定要退出控制面板吗？"))
	parent.window.location.href = "<%=path%>/login.do?method=exit";
}
</script>
<style>
.login_top_bg {
	background-image: url(login-top-bg.gif);
	background-repeat: repeat-x;
}
.body {
	background-color: #EEF2FB;
	left: 0px;
	top: 0px;
	right: 0px;
	bottom: 0px;
}

.login-buttom-bg {
	background-image: url(login-buttom-bg.gif);
	background-repeat: repeat-x;
}
.login-buttom-txt {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 10px;
	color: #ABCAD3;
	text-decoration: none;
	line-height: 20px;
}
.login_txt {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 25px;
	color: #333333;
}
.Submit {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #629DAE;
	text-decoration: none;
	background-image: url(Submit_bg.gif);
	background-repeat: repeat-x;
}
.login_bg {
	background-image: url(login_bg.jpg);
	background-repeat: repeat-x;
}
.login_bg2 {
	background-image: url(login-content-bg.gif);
	background-repeat: no-repeat;
	background-position: right;
}

.admin_txt {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #FFFFFF;
	text-decoration: none;
	height: 38px;
	width: 100%;
	position: 固定;
	line-height: 38px;
}
.login_txt_bt {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	line-height: 25px;
	color: #666666;
	font-weight: bold;
}
.admin_topbg {
	background-image: url(<%=path%>/jsp/init/images/top-right.gif);
	background-repeat: repeat-x;
}
.txt_bt {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 25px;
	font-weight: bold;
	color: #000000;
	text-decoration: none;
}
.left_topbg {
	background-image: url(content-bg.gif);
	background-repeat: repeat-x;
}
.admin_toptxt {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #4A8091;
	height: 18px;
	width: 100%;
	overflow: hidden;
	position: 固定;
}

.left_bt {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	font-weight: bold;
	color: #395a7b;
}
.left_bt2 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 25px;
	font-weight: bold;
	color: #333333;
}
.titlebt {
	font-size: 12px;
	line-height: 26px;
	font-weight: bold;
	color: #000000;
	background-image: url(top_bt.jpg);
	background-repeat: no-repeat;
	display: block;
	text-indent: 15px;
	padding-top: 5px;
}

.left_txt {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 25px;
	color: #666666;
}
.left_txt2 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 25px;
	color: #000000;
}
.nowtable {
	background-color: #e1e5ee;
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-top-color: #bfc4ca;
	border-right-color: #bfc4ca;
	border-bottom-color: #bfc4ca;
	border-left-color: #bfc4ca;
}
.left_txt3 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 25px;
	color: #003366;
	text-decoration: none;
}



.left_ts {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 25px;
	font-weight: bold;
	color: #FF6600;
}
.line_table {
	border: 1px solid #CCCCCC;
}
.sec1 {
	CURSOR: hand;
	COLOR: #000000;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 25px;
	border: 1px solid #B5D0D9;
	background-image: url(right_smbg.jpg);
	background-repeat: repeat-x;
}
.sec2 {
	FONT-WEIGHT: bold;
	CURSOR: hand;
	COLOR: #000000;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 25px;
	background-color: #e2e7ed;
	border: 1px solid #e2e7ed;
}
.main_tab {
	COLOR: #000000;
	BACKGROUND-COLOR: #e2e7ed;
	border: 1px solid #e2e7ed;
}
.MM a {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #666666;
	background-image: url(menu_bg.gif);
	background-repeat: no-repeat;
	list-style-type: none;
	list-style-image: none;
}
a:link {
	font-size: 12px;
	line-height: 25px;
	color: #333333;
	text-decoration: none;
}
a:hover {
	font-size: 12px;
	line-height: 25px;
	color: #666666;
	text-decoration: none;
}
a:visited {
	font-size: 12px;
	line-height: 25px;
	color: #333333;
	text-decoration: none;
}


.MM a:link {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #666666;
	background-image: url(menu_bg.gif);
	background-repeat: no-repeat;
	list-style-type: none;
	list-style-image: none;
}
</style>

</head>
<body leftmargin="0" topmargin="0">
<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="admin_topbg">
  <tr>
    <td width="61%" height="64"><img src="images/logo.gif" width="262" height="64"></td>
    <td width="39%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="74%" height="38" class="admin_txt">当前登录用户为：<b><%=username %></b> </td>
        <td width="22%"><a href="#" onClick="logout();"><img src="images/out.gif" alt="安全退出" width="46" height="20" border="0"></a></td>
        <td width="4%">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="3">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
</table>
</body>
</html>

