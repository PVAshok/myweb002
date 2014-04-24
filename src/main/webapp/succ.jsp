<%@ page language="java" import="java.util.*" import="javax.servlet.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String info=request.getParameter("info");
%>
<html>
<body>
<h2 align="center"><%=info%></h2>
<p>&nbsp;</p>

<br>
<a href="index.jsp" >homepage</a>
</body>
</html>
