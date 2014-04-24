<%@ page language="java" import="java.util.*" import="javax.servlet.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
  function validate(){
   //获得文本框的节点
   var jqueryObj = $("#name");
   //获得节点的值
   var userName = jqueryObj.val();
   if(user=="")
   {
   jqueryObj[1].focus();
   }
   //将文本框中的值发送给服务器的servlet
   $.get("/mercury/TestName?name=" + userName,null,callback);
  }

//定义一个回调函数
  function callback(data){
  //找到保存结果的节点
   var resultObj = $("#result");
   //动态改变节点的内容
   resultObj.html(data);
  }
 </script>

<body>
<h2 align="update">result</h2>
<p>&nbsp;</p>
<%
String id=request.getParameter("id");
String name=request.getParameter("name");
%>
<form name="loginform" id="loginform" action="/mercury/Update" method="post" >
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
<td><input name="name" type="text" value=<%=name%>  onblur="validate()">
<div id="result"></div>
</td>
</tr>
<tr>
<td height="45"></td>
<td><div align="center">
  <input name=""  type="submit" value="update"  onClick="alert("sure to update?");">
</div></td>
</tr>
</table>
</form>
<a href="index.jsp" >homepage</a>
</body>
</html>
