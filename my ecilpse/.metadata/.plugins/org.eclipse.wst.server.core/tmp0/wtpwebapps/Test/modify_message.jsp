<%@page import="domain.User"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>

<script>
function change()
{  var str="";
for(var i=1;i<=4;i++)
	   str+=Math.floor(Math.random()*10);
  document.form2.pswtext2.value=str;
}
function checkyanzheng()
{
	var word1=document.form2.pswtext1.value;
	var word2=document.form2.pswtext2.value;
	if(word2.length!=4)
		{
		alert("还没有生成验证码！")
		return false;
		}
	if(word1!=word2)
		{
		alert("验证码不正确！")
		return false;
		}
		return true;
}

function check_all()
{
	if(checkyanzheng())
		return true;
	else
		return false;
	}
</script>
</head>
<body background="image/22.jpg">
<% 
	User user = (User)request.getSession().getAttribute("User");
	String name = user.getName();
	String password=user.getPassword();
	String beizhu=user.getBeizhu();
	String tel=user.getTel();
	String sex=user.getSex();
%>
<br><br>
<font face="楷体" size="4"> 
 <form id=form2 name="form2"  action="modify" method="post" onsubmit="return check_all()">
       <table border="1" width="500"  cellspacing="0" cellpadding="10" align="center">
       <caption>修改个人信息</caption>
            <tr>
              <td width="30%" align="right"  >姓名：</td>
              <td width="60%"><input type="text" name="username" id="textfield" size="10" value=<%=name%> readonly></td>
            </tr>
            <tr>
              <td align="right" >密码：</td>
              <td><input type="text" name="password" id="pswd" size="20" value=<%=password %>></td>
            </tr>
             <tr>
              <td align="right">性别：</td>
              <td><input type="radio" name="radio"  checked value="man" >男
                  <input type="radio" name="radio" value="woman" >女</td>
            </tr>
             <tr>
              <td align="right">备注：</td>
              <td><input type="text" name="beizhu" id="beizhu" value=<%=beizhu %>></td>
            </tr>
            <tr>
              <td align="right">联系电话：</td>
              <td><input type="text" name="tel" id="tel" value=<%=tel %>></td>
            </tr>
            <tr>
            <td align="right" >验证码：</td>
            <td><input type="text" name="pswtext1" id="pswtext1" size="6"></td>
            </tr>
            <tr>
             <td align="right"><input type="button" name="button" id="button" 
            value="生成4位验证码" onClick="change()" >
            </td>
             <td><input name="pswtext2" type="text" id="pswtext2" size="6" maxlength="4"  disabled>
             </td>
            </tr>
            <tr>
              <td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="修改"> 
               &nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" name="reset" id="reset" value="取消" 
               onClick="window.location='homepage.jsp'"></td>
            </tr>
       </table>
    </form>
    <br><br><br><br><br>
</body>
</html>