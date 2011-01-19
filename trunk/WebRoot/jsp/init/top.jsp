<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
</head>
<link href="<%=path %>/jsp/init/css/all.css" rel="stylesheet" type="text/css">
<style> 
	
/* header tabs */
#top-navigation {
	position:absolute;
	top:35px;
	left:200px;
	margin:0;
	padding:0;
	list-style:none;
	}
	
	body {
	margin:0;
	padding:0;
	background:#A3CDEB;
  	color:#000;
	font-family:tahoma,arial,sans-serif;
	font-size:11px;
	}

</style>


<body>
	<div id="header">

		<a href="#" class="logo"><img src="<%=path %>/jsp/init/images/logo.gif" width="101" height="29" alt="" /></a>

		<ul id="top-navigation">

			<li><span><span><a href="#">Homepage</a></span></span></li>

			<li><span><span><a href="#">Users</a></span></span></li>

			<li><span><span><a href="#">Orders</a></span></span></li>

			<li><span><span><a href="#">Settings</a></span></span></li>

			<li><span><span><a href="#">Statistics</a></span></span></li>

			<li><span><span><a href="#">Design</a></span></span></li>

			<li><span><span><a href="#">Contents</a></span></span></li>

		</ul>
</div>
</body>
</html>
