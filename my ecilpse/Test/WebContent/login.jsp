<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lucky House</title>
<script >
function change()
{  var str="";
for(var i=1;i<=4;i++)
	   str+=Math.floor(Math.random()*10);
  document.form1.pswtext2.value=str;
}

function checkpassword()
{
	var password1=document.form1.password.value;
	if(password1=="")
		{
		alert("请输入密码！")
		return false;
		}
	if(password1.length<5)
		{
		alert("密码必须大于6位！")
		return false;
		}
	if(password1.length>20)
		{
		alert("密码必须小于20位！")
		return false;
		}
		return true;
}

function checkyanzheng()
{
	var word1=document.form1.pswtext1.value;
	var word2=document.form1.pswtext2.value;
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

function checkusername()
{
	var username1=document.form1.username.value;
	if(username1=="")
		{
		alert("请输入用户名！")
		return false;
		}
	if(username1.length<2||username1.length>10)
		{
		alert("用户名必须超过2位或者小于11位！");
		return false;
		}
	return true;
}
function check()
{
	if(checkusername()&&checkpassword()&&checkyanzheng())
		return true;
	else
		return false;
}
</script>
</head>

<body background="image/bg2.jpg"> 

<br>
<center>
<font size="6" face="黑体">欢迎来到幸福之家！</font>
<marquee behavior="alternate" bgcolor="#aaeeaa" >Welcome to your home!</marquee><br>

<br><br>
<center>
<font face="楷体" size="4"> 
 <form id=form1 name="form1" action="_login" method="post" onsubmit="return check()">
       <table width="500" border="1" cellspacing="0" cellpadding="10" align="center">
       <caption>登陆酒店</caption>
            <tr>
              <td width="30%" align="right"  >姓名：</td>
              <td width="60%"><input type="text" name="username" id="textfield" size="10"></td>
            </tr>
            <tr>
              <td align="right" >密码：</td>
              <td><input type="password" name="password" id="pswd" size="20"></td>
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
              <td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="登录"> 
               &nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" name="reset" id="reset" value="重置" ></td>
            </tr>
       </table>
    </form><br>
    <input type="button"  name="button1" value="用户注册" onClick="window.location='register.jsp'"><br>
    </font>
    <br><br><br><br><br><br><br><br><br><br><br><br>
</body>

</html>