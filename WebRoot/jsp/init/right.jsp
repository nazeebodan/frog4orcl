<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<link href="<%=path %>/jsp/init/css/all.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="center-column">
			<div class="top-bar">
				<a href="#" class="button"> </a>
				<h1>Contents</h1>
				<div class="breadcrumbs"></div>
			</div><br />
		  <div class="select-bar">
		    <label>
		    </label>
		    <label>
			</label>
		  </div>
		  <br /><HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>
			<b>数据库信息:</b><div class="table">
				<img src="<%=path %>/jsp/init/images/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<c:if test="${init_dbInfo.data!= null}">
							<c:forEach var="columns" items="${init_dbInfo.data.columns}" varStatus="s">
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
					<c:if test="${init_dbInfo.data!=null}">
						<c:if test="${init_dbInfo.data.data!=null}">
							<c:forEach var="rowMap" items="${init_dbInfo.data.data.rows}">
							<tr>
								<c:forEach var="columns" items="${init_dbInfo.data.columns}" >
									<td><c:out value="${rowMap[columns.name]}"></c:out></td>
								</c:forEach>
							</tr>
							</c:forEach>
						</c:if>
					</c:if>
				</table>
			</div>
			
			<br /> <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>
			<b>Oracle及工具 Tools 版本信息:</b> <div class="table">
				<img src="<%=path %>/jsp/init/images/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<c:if test="${init_bannerInfo.data!= null}">
							<c:forEach var="columns" items="${init_bannerInfo.data.columns}" varStatus="s">
								<c:if test="${s.first}">
									<th class="first"><c:out value="${columns.name}"/></th>
								</c:if>
								<c:if test="${!s.first&&!s.last}">
									<th><c:out value="${columns.name}"/></th>
								</c:if>
							</c:forEach>
						</c:if>						
					</tr>					
					<c:if test="${init_bannerInfo.data!=null}">
						<c:if test="${init_bannerInfo.data.data!=null}">
							<c:forEach var="rowMap" items="${init_bannerInfo.data.data.rows}">
							<tr>
								<c:forEach var="columns" items="${init_bannerInfo.data.columns}" >
									<td><c:out value="${rowMap[columns.name]}"></c:out></td>
								</c:forEach>
							</tr>
							</c:forEach>
						</c:if>
					</c:if>
				</table>
			</div>
			
			<br/> <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>
			<b>实例信息:</b><div class="table">
				<img src="<%=path %>/jsp/init/images/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<c:if test="${init_instanceInfo.data!= null}">
							<c:forEach var="columns" items="${init_instanceInfo.data.columns}" varStatus="s">
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
					<c:if test="${init_instanceInfo.data!=null}">
						<c:if test="${init_instanceInfo.data.data!=null}">
							<c:forEach var="rowMap" items="${init_instanceInfo.data.data.rows}">
							<tr>
								<c:forEach var="columns" items="${init_instanceInfo.data.columns}" >
									<td><c:out value="${rowMap[columns.name]}"></c:out></td>
								</c:forEach>
							</tr>
							</c:forEach>
						</c:if>
					</c:if>
				</table>
			</div>
			
			<br /><HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>
			<b>操作系统统计信息:</b><div class="table">
				<img src="<%=path %>/jsp/init/images/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<c:if test="${init_osInfo.data!= null}">
							<c:forEach var="columns" items="${init_osInfo.data.columns}" varStatus="s">
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
					<c:if test="${init_osInfo.data!=null}">
						<c:if test="${init_osInfo.data.data!=null}">
							<c:forEach var="rowMap" items="${init_osInfo.data.data.rows}">
							<tr>
								<c:forEach var="columns" items="${init_osInfo.data.columns}" >
									<td><c:out value="${rowMap[columns.name]}"></c:out></td>
								</c:forEach>
							</tr>
							</c:forEach>
						</c:if>
					</c:if>
				</table>
			</div>
</body>
</html>

