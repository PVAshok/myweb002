<%@ page language="java" import="java.util.*" import="com.xplusz.mercury.services.DButil" import="javax.servlet.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
DButil db=new DButil();
int id=db.getid()+1;

%>

<html>
 <script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
  function validate(){
   //获得文本框的节点
   var jqueryObj = $("#name");
   //获得节点的值
   var userName = jqueryObj.val();
   
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
<h2 align="center">Add student</h2>
<p>&nbsp;</p>
<form name="loginform" id="loginform" action="/mercury/Addstudent" method="post" >
<table width="303" height="154"  border="0" cellpadding="0" cellspacing="0">


<tr>
<td height="39">name</td>
<td><input name="name" id="name" type="text" onblur="validate()"></td>
<div id="result"></div>
</tr>


</tr>
<td height="45"></td>
<td><div align="center">
  <input name="id"  type="submit" value="add student">
</div></td>
</tr>
</table>
</form>

<a href="search.jsp" >search</a>
<br>

</body>
</html>
