<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<link href="<%=path %>/jsp/init/css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<form method="post" action="<%=path%>/usualMgr.do?method=queryInitParameter">
<div id="center-column">
			<div class="top-bar">
				<h1>Contents</h1>
				<div class="breadcrumbs"></div>
			</div><br />
		  <div class="select-bar">
		    <label>
		    <span class="breadcrumbs">参数名:
		    <input type="text" name="parameterName" />
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
				<div class="select">
					<strong>Other Pages: </strong>
					<select>
						<option>1</option>
					</select>
			  </div>
			</div>
			</form>
</body>
</html>

