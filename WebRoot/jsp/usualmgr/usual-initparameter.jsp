<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.frog4orcl.framework.core.page.Pagination"%>
<%@page import="com.frog4orcl.framework.util.SystemConstant"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%
String path = request.getContextPath();
String parameterName = (String)request.getAttribute("parameterName");
Pagination pageObj = (Pagination)request.getAttribute(SystemConstant.PAGE_OBJECT_DATA);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link href="<%=path %>/jsp/init/css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<form method="post" action="<%=path%>/usualMgr.do?method=queryInitParameter">
<div id="center-column">
			<div class="top-bar">
				<h1>初始化参数</h1>
				<div class="breadcrumbs"></div>
			</div><br />
		  <div class="select-bar">
		    <label>
		    <span class="breadcrumbs">参数名:
		    <input type="text" name="parameterName" value="<%=parameterName %>"/>
		    </label>
		    <label>
			<input type="submit" name="Submit" value="Search" />
			</label>
			</span>
		  </div>
<div class="table">
				<img src="<%=path %>/jsp/init/images/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<c:if test="${OBJECT_DATA.data!= null}">
							<c:forEach var="columns" items="${OBJECT_DATA.data.columns}" varStatus="s">
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
					<c:if test="${OBJECT_DATA.data!=null}">
						<c:if test="${OBJECT_DATA.data.data!=null}">
							<c:forEach var="rowMap" items="${OBJECT_DATA.data.data.rows}">
							<tr>
								<c:forEach var="columns" items="${OBJECT_DATA.data.columns}" >
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

