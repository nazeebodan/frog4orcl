<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%
String path = request.getContextPath();
String parameterName = (String)request.getAttribute("parameterName");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link href="<%=path %>/jsp/init/css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<form method="post" action="<%=path%>/usualMgr.do?method=queryTablespaceInfo">
<div id="center-column">
			<div class="top-bar">
				<a href="#" class="button"> </a>
				<h1>表空间</h1>
				<div class="breadcrumbs"></div>
			</div><br />
		 <div class="select-bar">
		    <label>
		    <span class="breadcrumbs">表空间名:
		    <input type="text" name="parameterName" value="<%=parameterName %>"/>
		    </label>
		    <label>
			<input type="submit" name="Submit" value="Search" />
			</label>
			</span>
		  </div>
		  <br /><HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>
			<b>表空间使用情况(总):</b><div class="table">
				<img src="<%=path %>/jsp/init/images/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<c:if test="${tablespace1.data!= null}">
							<c:forEach var="columns" items="${tablespace1.data.columns}" varStatus="s">
								<c:if test="${s.first}">
									<th class="first"><c:out value="${columns.name}"/></th>
								</c:if>
								<c:if test="${!s.first}">
									<th><c:out value="${columns.name}"/></th>
								</c:if>
							</c:forEach>
						</c:if>						
					</tr>					
					<c:if test="${tablespace1.data!=null}">
						<c:if test="${tablespace1.data.data!=null}">
							<c:forEach var="rowMap" items="${tablespace1.data.data.rows}">
							<tr>
								<c:forEach var="columns" items="${tablespace1.data.columns}" >
									<td><c:out value="${rowMap[columns.name]}"></c:out></td>
								</c:forEach>
							</tr>
							</c:forEach>
						</c:if>
					</c:if>
				</table>
			</div>
			
			<br /> <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>
			<b>表空间使用情况(喊数据文件位置):</b> <div class="table">
				<img src="<%=path %>/jsp/init/images/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<c:if test="${tablespace2.data!= null}">
							<c:forEach var="columns" items="${tablespace2.data.columns}" varStatus="s">
								<c:if test="${s.first}">
									<th class="first"><c:out value="${columns.name}"/></th>
								</c:if>
								<c:if test="${!s.first}">
									<th><c:out value="${columns.name}"/></th>
								</c:if>
							</c:forEach>
						</c:if>						
					</tr>					
					<c:if test="${tablespace2.data!=null}">
						<c:if test="${tablespace2.data.data!=null}">
							<c:forEach var="rowMap" items="${tablespace2.data.data.rows}">
							<tr>
								<c:forEach var="columns" items="${tablespace2.data.columns}" >
									<td><c:out value="${rowMap[columns.name]}"></c:out></td>
								</c:forEach>
							</tr>
							</c:forEach>
						</c:if>
					</c:if>
				</table>
			</div>
			</div>
			</form>
</body>
</html>

