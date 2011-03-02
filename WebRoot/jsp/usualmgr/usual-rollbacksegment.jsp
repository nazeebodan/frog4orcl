<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.frog4orcl.framework.util.SystemConstant"%>
<%@page import="com.frog4orcl.framework.core.page.Pagination"%>
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

</head>

<body>
<form method="post" action="<%=path%>/usualMgr.do?method=queryBackupDataFileInfo">
<div id="center-column">
			<div class="top-bar">
				<a href="#" class="button"> </a>
				<h1>回滚段信息</h1>
				<div class="breadcrumbs"></div>
			</div><br />
		  <div class="select-bar">
		    <label>
		    </label>
		    <label>
			</label>
			
		  </div>
		  <br /><HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>
			<b>undo参数情况:</b><div class="table">
				<img src="<%=path %>/jsp/init/images/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<c:if test="${undoInfo.data!= null}">
							<c:forEach var="columns" items="${undoInfo.data.columns}" varStatus="s">
								<c:if test="${s.first}">
									<th class="first"><c:out value="${columns.name}"/></th>
								</c:if>
								<c:if test="${!s.first}">
									<th><c:out value="${columns.name}"/></th>
								</c:if>
							</c:forEach>
						</c:if>						
					</tr>					
					<c:if test="${undoInfo.data!=null}">
						<c:if test="${undoInfo.data.data!=null}">
							<c:forEach var="rowMap" items="${undoInfo.data.data.rows}">
							<tr>
								<c:forEach var="columns" items="${undoInfo.data.columns}" >
									<td><c:out value="${rowMap[columns.name]}"></c:out></td>
								</c:forEach>
							</tr>
							</c:forEach>
						</c:if>
					</c:if>
				</table>
			</div>
		  
		  <br /><HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>
			<b>回滚段创建时物理存储情况:</b><div class="table">
				<img src="<%=path %>/jsp/init/images/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<c:if test="${rollbackSegmentInfo.data!= null}">
							<c:forEach var="columns" items="${rollbackSegmentInfo.data.columns}" varStatus="s">
								<c:if test="${s.first}">
									<th class="first"><c:out value="${columns.name}"/></th>
								</c:if>
								<c:if test="${!s.first}">
									<th><c:out value="${columns.name}"/></th>
								</c:if>
							</c:forEach>
						</c:if>						
					</tr>					
					<c:if test="${rollbackSegmentInfo.data!=null}">
						<c:if test="${rollbackSegmentInfo.data.data!=null}">
							<c:forEach var="rowMap" items="${rollbackSegmentInfo.data.data.rows}">
							<tr>
								<c:forEach var="columns" items="${rollbackSegmentInfo.data.columns}" >
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
			</div>
			</form>
</body>
</html>

