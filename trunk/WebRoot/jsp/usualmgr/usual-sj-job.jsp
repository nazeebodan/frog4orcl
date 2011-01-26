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
      url = "/usualMgr.do?method=queryJobsInfo";
   }else if(v==1){
      url = "/usualMgr.do?method=queryRunningJobsInfo"
   }else if(v==2){
      url = "/usualMgr.do?method=querySchedulerJobsInfo";
   }else if(v==3){
      url = "/usualMgr.do?method=querySchedulersInfo";
   }
   window.location='<%=path%>'+url;
}
</script>
</head>

<body>
<form method="post" action="<%=path%>/usualMgr.do?method=queryJobsInfo">
<div id="center-column">
			<div class="top-bar">
				<a href="#" class="button"> </a>
				<h1>scheduler/job综合信息</h1>
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
                    <TD align="center" onclick=secBoard(0) style="background-color:#F7EFF1;">job信息</TD>
                    <TD align="center" onclick=secBoard(1)>正在运行的job信息</TD>
                    <TD align="center" onclick=secBoard(2)>Scheduler下的job信息</TD>
                    <TD align="center" onclick=secBoard(3)>Scheduler信息</TD>
                  </TR>
                </TBODY>
              </TABLE>
		  </div>
		  <br /><HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>
			<b>用户权限情况:</b><div class="table">
				<img src="<%=path %>/jsp/init/images/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<c:if test="${info.data!= null}">
							<c:forEach var="columns" items="${info.data.columns}" varStatus="s">
								<c:if test="${s.first}">
									<th class="first"><c:out value="${columns.name}"/></th>
								</c:if>
								<c:if test="${!s.first&&!s.last}">
									<th><c:out value="${columns.name}"/></th>
								</c:if>
								<c:if test="${s.last}">
									<th class="last"><c:out value="${columns.name}"/></th>
								</c:if>
								
							</c:forEach>
						</c:if>						
					</tr>					
					<c:if test="${info.data!=null}">
						<c:if test="${info.data.data!=null}">
							<c:forEach var="rowMap" items="${info.data.data.rows}">
							<tr>
								<c:forEach var="columns" items="${info.data.columns}" >
									<td><c:out value="${rowMap[columns.name]}"></c:out></td>
								</c:forEach>
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

