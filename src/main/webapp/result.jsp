<%@ page language="java" import="java.util.*" import="javax.servlet.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<body>
<h2 align="result">result</h2>
<p>&nbsp;</p>

<%
String id=request.getParameter("id");
String name1=request.getParameter("name");
if(name1=="")
{
name="no such id!";
}
%>

<form name="loginform" id="loginform" action="/mercury/Delete" method="post" >
<table width="303" height="154"  border="0" cellpadding="0" cellspacing="0">
<tr>
<td width="32">id</td>
<td width="264"><input name="id" type="text" value=<%=id%> disabled="disabled"></td>

</tr>
<tr>
<td width="32"></td>
<td width="264"><input name="tid" type="hidden" value=<%=id%> ></td>
</tr>

<tr>
<td height="39">name</td>
<td><input name="name" type="text" value=<%=name%> disabled="disabled" ></td>
</tr>
<tr>
<td height="45"></td>
<td><div align="center">
  <input name=""  type="submit" value="delete"  onClick="alert("sure to delete?");">
</div></td>
<td width="264"><a href="/mercury/update.jsp?id=<%=id%>&name=<%=name%>">update</a> </td>
</tr>
</table>
</form>
<a href="index.jsp" >homepage</a>
</body>
</html>
