<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<style>
td { text-align:center;}
.style1 { font:12px "宋体"; color:#004C7E;}
a { color:#034C7E; text-decoration:none;}
a:hover { color:#1FFF; text-decoration:underline;}

body {
margin:0 auto; padding:0; border:0;
	background:#F3CC9D; font-size: 12px; margin-top:0px;

	SCROLLBAR-FACE-COLOR: #F3CC9D; SCROLLBAR-HIGHLIGHT-COLOR: #ffcc00; 

	SCROLLBAR-SHADOW-COLOR: #F3CC9D; SCROLLBAR-DARKSHADOW-COLOR: #FFCC00; 

	SCROLLBAR-3DLIGHT-COLOR: #F3CC9D; SCROLLBAR-ARROW-COLOR: #FFee00;

	SCROLLBAR-TRACK-COLOR: #F3CC9D;

}
</style>
<link href="<%=path %>/jsp/init/css/amcss.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
function show(i){     
if (i.style.display == "none") {     
		i.style.display = "";     
	}else{     
		i.style.display = "none";     
	}     
}

function doit(url){
   parent.window.I2.location="<%=path%>"+url;
}
</script>
<body>
<table width="162" border="0" cellpadding="0" cellspacing="1">
  <tr>
    <td width="160" height=38 align=right class=font><div align="center"><a href="#" ><img src="images/menu.gif" width="158" height="38" border="0"></a></div></td>
  </tr>
  <tr>
    <td valign=tip>
<!--=============-->
<table width="100%" border="0" align=center cellpadding="0" cellspacing="1">
  <tr>
          <td height=27 background="images/title.gif" style="cursor:hand" onClick="show(a1)"> 
            <div align="center"><strong>日常监控模块</strong></div></td></tr>
  <tr>
    <td>
<DIV id=a1 style="DISPLAY: none">
    <div align="left">
      <table width="156" border="0" cellspacing="1" cellpadding="1" align="center">
          <tr><td height=23 class="amrow"><a href="#" onclick="javascript:doit('/jsp/init/test1.jsp');">显示初始化参数</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >SGA各组件的使用情况</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >表空间的使用情况</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >Redo Log File的情况</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >用户及用户对表空间的使用及用户权限</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >备份的情况</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >回滚段情况</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >碎片/索引/表的分配比例</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >当前schedule/job等的查看</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >旗下网站管理</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >旗下网站管理</a></td></tr>
 </table>
    </div>
</div>	</td>
  </tr>
  <tr>
          <td height=27 background="images/title.gif" style="cursor:hand" onClick="show(a2)"> 
            <div align="center"><strong>警告模块</strong></div></td>
  </tr>
  <tr>
    <td>
<DIV id=a2 style="DISPLAY: none">
    <div align="left">
      <table width="156" border="0" cellspacing="1" cellpadding="1" align="center">
	      <tr><td height=23 class="amrow"><a href="#"  class="red">333</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#"  class="red">33311</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >31</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >32</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >33</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >34</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >35</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >36</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >37</a></td></tr>
          </table>
    </div>
</div>	</td>
  </tr>
  <tr>
          <td height=27 background="images/title.gif" style="cursor:hand" onClick="show(a3)"> 
            <div align="center"><strong>优化管理模块</strong></div></td>
  </tr>
  <tr>
    <td>
<DIV id=a3 style="DISPLAY: none">
    <div align="left">
      <table width="156" border="0" cellspacing="1" cellpadding="1" align="center">
          <tr><td height=23 class="amrow"><a href="#"  class="red">11</a></td></tr>
		  <tr><td height=23 class="amrow"><a href="#"  class="red">11</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >333</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >333</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >333历</a></td></tr>
          <tr><td height=23 class="amrow"><a href="#" >11</a></td></tr>
          </table>
    </div>
</div>	</td>
  </tr>
 
</table>
  </tr>
</table>
</body>
</html>

