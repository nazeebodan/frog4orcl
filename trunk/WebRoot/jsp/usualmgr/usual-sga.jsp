<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%
String path = request.getContextPath();
String filename1 = (String)request.getAttribute("filename1");
String url1 = (String)request.getAttribute("url1");
String filename2 = (String)request.getAttribute("filename2");
String url2 = (String)request.getAttribute("url2");
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
				<h1>Sga</h1>
				<div class="breadcrumbs"></div>
			</div><br />
		  <div class="select-bar">
		    <label>
		    </label>
		    <label>
			</label>
			</span>
		  </div>
		  <br/><HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>
			<b>sga 信息:</b>
			<div class="table">
				<img src="<%= url1 %>"width=500 height=300 border=0 usemap="<%=filename1 %>"
			</div>
			<br/> <br/> <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>
			<b>sga各组件信息:</b>
			<div class="table">
				<img src="<%= url2 %>"width=500 height=300 border=0 usemap="<%=filename2 %>"
			</div>
			<br/> <br/> <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color=#987cb9 SIZE=3>
			<b>sga各动态组件信息:</b><div class="table">
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
			</div>
			</form>
</body>
</html>

