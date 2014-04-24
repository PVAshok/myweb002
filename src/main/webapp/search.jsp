<%@ page language="java" import="java.util.*" import="javax.servlet.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<body>
<h2 align="center">Search student</h2>
<p>&nbsp;</p>
<form name="loginform" id="loginform" action="/mercury/Search" method="post" >
<table width="303" height="154"  border="0" cellpadding="0" cellspacing="0">
<tr>
<td height="39">id</td>
<td><input name="id" type="text"></td>
</tr>
<tr>
<td height="45"></td>
<td><div align="center">
  <input name="button"  type="submit" value="search student">
</div></td>
</tr>
</table>
</form>
<br>
<a href="index.jsp" >homepage</a>
</body>

</html>
