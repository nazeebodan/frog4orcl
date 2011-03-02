<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.frog4orcl.framework.util.SystemConstant"%>
<%
String message = (String)request.getAttribute(SystemConstant.ERR_MSG_JSP);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
<body text="#000000" leftmargin="0" marginwidth="0" marginheight="0">
   <br>
   <br>
   <table border=1 bordercolor=#aaaaaa bordercolordark=#ffffff cellpadding=3 cellspacing=0 width="90%" align="center">
      <tr> 
         <td class="refer_table_td_title" colspan="3" bgcolor="#EDEDbe" height="26"> 
            <div align="center">
               <font color="#000000">
                  <font color="#043B9C"> 
                     <b>::: 出 错 信 息 ::: </b>                     
                  </font>
               </font>
            </div>
         </td>
      </tr>
      <tbody> 
         <tr> 
            <td colspan="3" class="refer_table_td_title"> 
               <table width="96%" border="0" align="center">
                  <tr> 
                     <td valign="top"> 
                        <p>
                        <br>
                        您访问的页面出错，可能原因为：<br>
                        <br>
                        <div align="center">
                           <font color="red">                     
                              <%
                                 if (message != null){
                              %>  
                              <%=message%>               
                              <%
                                 }else if (message != null){
							  		out.print(message);                                 	
                                } else 
                                {
                              %>
                              未知错误原因
                              <%
                                 }
                              %>
                           </font>
                        </div>
                        <p>
                           若您不能接受给出的错误原因，请联系或者报告系统管理员！
                        </p>
                        <p>感谢您对我们的支持！<br>                           
                           <br>
                           <br>
                        </p>
                        <p align="right">      
                           <br>
                           <br>
                        </p>
                     </td>
                  </tr>
               </table>
            </td>
         </tr>
        
      </tbody> 
   </table>
</body>
</html>
