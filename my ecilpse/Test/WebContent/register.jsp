<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script>
function checkusername()
{
	var username1=document.form3.reg_username.value;
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

function checkpassword()
{
	var password1=document.form3.reg_pswd.value;
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

function checktel()
{
	var tel1=document.form3.tel.value;
	if(tel1=="")
	{
		alert("请输入电话号码！")
		return false;
	}
	if(tel1.length!=11)
	{
		alert("电话号码格式输入不正确！")
		return false;
	}
	else
		return true;
	}

function checkall()
{
	if(checkusername()&&checkpassword()&&checktel())
		return true;
	else
		return false;
	}
</script>
</head>
<body background="image/bg1.jpg">

<font face="楷体" size="4">
<h2 align="center">注册信息</h2>
    <form id="form3" name="form3" action="register" method="post" onsubmit="return checkall()">
       <table width="500" border="1" cellspacing="0" cellpadding="10" align="center" >
            <tr>
              <td width="30%" align="right">姓名：</td>
              <td width="70%"><input type="text" name="reg_username" id="textfield"></td>
            </tr>
            <tr>
              <td align="right">密码：</td>
              <td><input type="password" name="reg_pswd" id="pswd"></td>
            </tr>
             <tr>
              <td align="right">性别：</td>
              <td><input type="radio" name="radio" checked value="man">男
                  <input type="radio" name="radio" value="woman">女</td>
            </tr>
             <tr>
              <td align="right">备注：</td>
              <td><input type="text" name="beizhu" id="beizhu" ></td>
            </tr>
            <tr>
              <td align="right">联系电话：</td>
              <td><input type="text" name="tel" id="tel"></td>
            </tr>
          
            <tr>
              <td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="注册"> 
               &nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" name="reset" id="reset" value="重置"></td>
            </tr>
       </table>
    </form>
</font>
<br><br><br><br><br><br><br><br>
</body>
</html>