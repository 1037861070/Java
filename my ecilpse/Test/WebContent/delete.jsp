<%@page import="domain.User"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注销用户</title>
<script>
function check()
{
	var word1=document.form2.username.value;
	if(word1="")
		{
		alert("注销失败！")
		return false;}
	else
		return true;
	}
</script>
</head>
<body background="image/image-4.jpg">
<% 
	User user = (User)request.getSession().getAttribute("User");
	String name = user.getName();
	String password=user.getPassword();
	String beizhu=user.getBeizhu();
	String tel=user.getTel();
%>
<br><br>
<font face="楷体" size="4"> 
 <form id=form2 name="form2"  action="detele" method="post" onsubmit="return check()">
       <table border="1" width="500"  cellspacing="0" cellpadding="10" align="center">
       <caption>注销用户</caption>
            <tr>
              <td width="30%" align="right"  >姓名：</td>
              <td width="60%"><input type="text" name="username" id="textfield" size="10" value=<%=name%> readonly></td>
            </tr>
            <tr>
              <td align="right" >密码：</td>
              <td><input type="text" name="password" id="pswd" size="20" value=<%=password %>  readonly></td>
            </tr>
             <tr>
              <td align="right" >备注：</td>
              <td><input type="text" name="beizhu" id="pswd" size="20" value=<%=beizhu %>  readonly></td>
            </tr>
             <tr>
              <td align="right" >电话：</td>
              <td><input type="text" name="tel" id="pswd" size="20" value=<%=tel %>  readonly></td>
            </tr>
            <tr>
              <td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="注销"> 
               &nbsp;&nbsp;&nbsp;&nbsp; <input type="button" name="reset" id="reset" value="取消" 
               onClick="window.location='homepage.jsp'"></td>
            </tr>
       </table>
    </form>
    <br><br><br><br><br><br><br><br><br>
</body>
</html>