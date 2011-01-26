<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.frog4orcl.framework.core.page.Pagination"%>
<%@page import="com.frog4orcl.framework.util.SystemConstant"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%
String path = request.getContextPath();
Pagination pageObj = (Pagination)request.getAttribute(SystemConstant.PAGE_OBJECT_DATA);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link href="<%=path %>/jsp/init/css/all.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function secBoard(v){
   var url;
   if(v==0){
      url = "/usualMgr.do?method=queryUserInfo";
   }else if(v==1){
      url = "/usualMgr.do?method=queryUserPrivInfo"
   }else if(v==2){
      url = "/usualMgr.do?method=queryUserHaveObjectsInfo";
   }
   window.location='<%=path%>'+url;
}
</script>
</head>

<body>
<form method="post" action="<%=path%>/usualMgr.do?method=queryUserPrivInfo">
<div id="center-column">
			<div class="top-bar">
				<a href="#" class="button"> </a>
				<h1>用户综合信息</h1>
				<div class="breadcrumbs"></div>
			</div><br />
		  <div class="select-bar">
		    <label>
		    </label>
		    <label>
			</label>
			<TABLE width=72% border=0 cellPadding=0 cellSpacing=0 id=secTable>
                <TBODY>
                  <TR align=middle height=20>
                    <TD align="center" onclick=secBoard(0)>用户信息</TD>
                    <TD align="center" onclick=secBoard(1) style="background-color:#F7EFF1;">用户权限</TD>
                    <TD align="center" onclick=secBoard(2)>用户所含对象</TD>
                  </TR>
                </TBODY>
              </TABLE>
		  </div>
		  <br /><HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>
			<b>用户权限情况:</b><div class="table">
				<img src="<%=path %>/jsp/init/images/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<th class="first">用户名</th>	
						<th>所授予权限</th>	
						<th>ADMIN_OPTION</th>	
					</tr>					
					<c:if test="${userPrivInfo.data!=null}">
						<c:if test="${userPrivInfo.data.data!=null}">
							<c:forEach var="rowMap" items="${userPrivInfo.data.data.rows}">
							<tr>
								<td><c:out value="${rowMap['USERNAME']}"></c:out></td>
								<td><c:out value="${rowMap['WHAT_GRANTED']}"></c:out></td>
								<td><c:out value="${rowMap['ADMIN_OPTION']}"></c:out></td>
							</tr>
							</c:forEach>
						</c:if>
					</c:if>
				</table>
				<div align="right">
					<br />
					<%=pageObj.getToolsMenu() %>
			  	</div>
			</div>
			</form>
</body>
</html>

