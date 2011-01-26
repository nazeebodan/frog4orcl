<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<head>
<title>tree panel</title>

<script src="<%=path %>/js/prototype.lite.js" type="text/javascript"></script>
<script src="<%=path %>/js/moo.fx.js" type="text/javascript"></script>
<script src="<%=path %>/js/moo.fx.pack.js" type="text/javascript"></script>
<style>

body {

	font:12px Arial, Helvetica, sans-serif;

	color: #000;

	background-color: #EEF2FB;

	margin: 0px;

}

#container {

	width: 182px;

}

H1 {

	font-size: 12px;

	margin: 0px;

	width: 182px;

	cursor: pointer;

	height: 30px;

	line-height: 20px;	

}

H1 a {

	display: block;

	width: 182px;

	color: #000;

	height: 30px;

	text-decoration: none;

	moz-outline-style: none;

	background-image: url(<%=path%>/jsp/init/images/menu_bgS.gif);

	background-repeat: no-repeat;

	line-height: 30px;

	text-align: center;

	margin: 0px;

	padding: 0px;

}

.content{

	width: 182px;

	height: 26px;

	

}

.MM ul {

	list-style-type: none;

	margin: 0px;

	padding: 0px;

	display: block;

}

.MM li {

	font-family: Arial, Helvetica, sans-serif;

	font-size: 12px;

	line-height: 26px;

	color: #333333;

	list-style-type: none;

	display: block;

	text-decoration: none;

	height: 26px;

	width: 182px;

	padding-left: 0px;

}

.MM {

	width: 182px;

	margin: 0px;

	padding: 0px;

	left: 0px;

	top: 0px;

	right: 0px;

	bottom: 0px;

	clip: rect(0px,0px,0px,0px);

}

.MM a:link {

	font-family: Arial, Helvetica, sans-serif;

	font-size: 12px;

	line-height: 26px;

	color: #333333;

	background-image: url(<%=path%>/jsp/init/images/menu_bg1.gif);

	background-repeat: no-repeat;

	height: 26px;

	width: 182px;

	display: block;

	text-align: center;

	margin: 0px;

	padding: 0px;

	overflow: hidden;

	text-decoration: none;

}

.MM a:visited {

	font-family: Arial, Helvetica, sans-serif;

	font-size: 12px;

	line-height: 26px;

	color: #333333;

	background-image: url(<%=path%>/jsp/init/images/menu_bg1.gif);

	background-repeat: no-repeat;

	display: block;

	text-align: center;

	margin: 0px;

	padding: 0px;

	height: 26px;

	width: 182px;

	text-decoration: none;

}

.MM a:active {

	font-family: Arial, Helvetica, sans-serif;

	font-size: 12px;

	line-height: 26px;

	color: #333333;

	background-image: url(<%=path%>/jsp/init/images/menu_bg1.gif);

	background-repeat: no-repeat;

	height: 26px;

	width: 182px;

	display: block;

	text-align: center;

	margin: 0px;

	padding: 0px;

	overflow: hidden;

	text-decoration: none;

}

.MM a:hover {

	font-family: Arial, Helvetica, sans-serif;

	font-size: 12px;

	line-height: 26px;

	font-weight: bold;

	color: #006600;

	background-image: url(<%=path%>/jsp/init/images/menu_bg2.gif);

	background-repeat: no-repeat;

	text-align: center;

	display: block;

	margin: 0px;

	padding: 0px;

	height: 26px;

	width: 182px;

	text-decoration: none;

}

</style>
<script type="text/javascript">
function doit(url){
	parent.I2.location='<%=path%>'+url;
}
</script>
</head>

<body>
<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top"><div id="container">
      <h1 class="type"><a href="javascript:void(0)">日常监控模块</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="<%=path%>/jsp/init/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>

        <ul class="MM">
          <li><a href="#" onclick="javascript:doit('/init.do?method=initIndex');" >首页</a></li>
          <li><a href="#" onclick="javascript:doit('/usualMgr.do?method=queryInitParameter');" >初始化参数</a></li>
          <li><a href="#" onclick="javascript:doit('/usualMgr.do?method=querySomeSgaInfo');">SGA组件</a></li>
          <li><a href="#" onclick="javascript:doit('/usualMgr.do?method=queryTablespaceInfo');">表空间</a></li>
          <li><a href="#" onclick="javascript:doit('/usualMgr.do?method=queryControlFileInfo');">控制文件</a></li>
          <li><a href="#" onclick="javascript:doit('/usualMgr.do?method=queryRedoLogInfo');">日志文件</a></li>
          <li><a href="#" onclick="javascript:doit('/usualMgr.do?method=queryUserInfo');">用户情况</a></li>
          <li><a href="#" onclick="javascript:doit('/usualMgr.do?method=queryBackupDataFileInfo');">备份情况</a></li>
          <li><a href="#" onclick="javascript:doit('/usualMgr.do?method=queryRollbackSegmentInfo');">回滚段情况</a></li>
          <li><a href="#" onclick="javascript:doit('/usualMgr.do?method=queryJobsInfo');">schedule/job</a></li>
          <li><a href="#" onclick="javascript:doit('/usualMgr.do?method=queryPropsServerInfo');">字符集</a></li>
          <li><a href="#" target="I2">其他</a></li>
        </ul>
      </div>

      <h1 class="type"><a href="javascript:void(0)">日常告警模块</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="<%=path%>/jsp/init/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
         <ul class="MM">
          <li><a href="#" onclick="javascript:doit('/jsp/init/test1.jsp');">初始化参数</a></li>
          <li><a href="#" target="I2">SGA组件</a></li>
          <li><a href="#" target="I2">表空间</a></li>
          <li><a href="#" target="I2">控制文件</a></li>
          <li><a href="#" target="I2">日志文件</a></li>
          <li><a href="#" target="I2">表和索引</a></li>
        </ul>
      </div>

      <h1 class="type"><a href="javascript:void(0)">优化管理模块</a></h1>

      <div class="content">

        <table width="100%" border="0" cellspacing="0" cellpadding="0">

          <tr>

            <td><img src="<%=path%>/jsp/init/images/menu_topline.gif" width="182" height="5" /></td>

          </tr>

        </table>

        <ul class="MM">
          <li><a href="#" onclick="javascript:doit('/jsp/init/test1.jsp');">初始化参数</a></li>
          <li><a href="#" target="I2">回滚段情况</a></li>
          <li><a href="#" target="I2">回滚段情况</a></li>
          <li><a href="#" target="I2">schedule/job</a></li>
          <li><a href="#" target="I2">字符集</a></li>
          <li><a href="#" target="I2">其他</a></li>
        </ul>

      </div>


      </div>

        <script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
	</script>

        </td>
  </tr>
</table>
</body>
</html>

