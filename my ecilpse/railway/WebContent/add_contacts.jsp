<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="domain.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加联系人</title>

<link href="dzsw/style/style.css" rel="stylesheet" type="text/css" />
<link href="dzsw/style/layer.css" rel="stylesheet" type="text/css" />
<link href="dzsw/style/yuding.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="dzsw/scripts/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="dzsw/scripts/jquery.cookie.js"></script>
<link href="dzsw/style/easyAlert.css" rel="stylesheet" type="text/css" />
<link href="dzsw/style/login.css" rel="stylesheet" type="text/css" />
<%
User user = (User) request.getSession().getAttribute("User");
String idNumber = user.getIdNumber();
String idType = user.getIdType();
String name = user.getName();
String password = user.getPassword();
int role = user.getRole();
int userId = user.getUserId();
String userName = user.getUserName();
String telNumber = user.getTelNumber();
%>
<script type="text/javascript" src="dzsw/scripts/IdCard.js"></script>
<script type="text/javascript">
var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1];// 加权因子   
var ValideCode = [1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2];// 身份证验证位值.10代表X   
function IdCardValidate(idCard) {
    idCard = trim(idCard.replace(/ /g, ""));
    if (idCard.length == 15) {
        return isValidityBrithBy15IdCard(idCard);
    } else if (idCard.length == 18) {
        var a_idCard = idCard.split("");// 得到身份证数组   
        if (isValidityBrithBy18IdCard(idCard) && isTrueValidateCodeBy18IdCard(a_idCard)) {
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}
/**  
 * 判断身份证号码为18位时最后的验证位是否正确  
 * @param a_idCard 身份证号码数组  
 * @return  
 */
function isTrueValidateCodeBy18IdCard(a_idCard) {
    var sum = 0; // 声明加权求和变量   
    if (a_idCard[17].toLowerCase() == 'x') {
        a_idCard[17] = 10;// 将最后位为x的验证码替换为10方便后续操作   
    }
    for (var i = 0; i < 17; i++) {
        sum += Wi[i] * a_idCard[i];// 加权求和   
    }
    valCodePosition = sum % 11;// 得到验证码所位置   
    if (a_idCard[17] == ValideCode[valCodePosition]) {
        return true;
    } else {
        return false;
    }
}
/**  
 * 通过身份证判断是男是女  
 * @param idCard 15/18位身份证号码   
 * @return 'female'-女、'male'-男  
 */
function maleOrFemalByIdCard(idCard) {
    idCard = trim(idCard.replace(/ /g, ""));// 对身份证号码做处理。包括字符间有空格。   
    if (idCard.length == 15) {
        if (idCard.substring(14, 15) % 2 == 0) {
            return 'female';
        } else {
            return 'male';
        }
    } else if (idCard.length == 18) {
        if (idCard.substring(14, 17) % 2 == 0) {
            return 'female';
        } else {
            return 'male';
        }
    } else {
        return null;
    }
    //  可对传入字符直接当作数组来处理   
    // if(idCard.length==15){   
    // alert(idCard[13]);   
    // if(idCard[13]%2==0){   
    // return 'female';   
    // }else{   
    // return 'male';   
    // }   
    // }else if(idCard.length==18){   
    // alert(idCard[16]);   
    // if(idCard[16]%2==0){   
    // return 'female';   
    // }else{   
    // return 'male';   
    // }   
    // }else{   
    // return null;   
    // }   
}
/**  
 * 验证18位数身份证号码中的生日是否是有效生日  
 * @param idCard 18位书身份证字符串  
 * @return  
 */
function isValidityBrithBy18IdCard(idCard18) {
    var year = idCard18.substring(6, 10);
    var month = idCard18.substring(10, 12);
    var day = idCard18.substring(12, 14);
    var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
    // 这里用getFullYear()获取年份，避免千年虫问题   
    if (temp_date.getFullYear() != parseFloat(year)
          || temp_date.getMonth() != parseFloat(month) - 1
          || temp_date.getDate() != parseFloat(day)) {
        return false;
    } else {
        return true;
    }
}
/**  
 * 验证15位数身份证号码中的生日是否是有效生日  
 * @param idCard15 15位书身份证字符串  
 * @return  
 */
function isValidityBrithBy15IdCard(idCard15) {
    var year = idCard15.substring(6, 8);
    var month = idCard15.substring(8, 10);
    var day = idCard15.substring(10, 12);
    var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
    // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法   
    if (temp_date.getYear() != parseFloat(year)
            || temp_date.getMonth() != parseFloat(month) - 1
            || temp_date.getDate() != parseFloat(day)) {
        return false;
    } else {
        return true;
    }
}
//去掉字符串头尾空格   
function trim(str) {
    return str.replace(/(^\s*)|(\s*$)/g, "");
}
    function checkIdcard() {
	var idcard2 = document.getElementById("idcard").value;

	if (idcard2.length > 0) {
		if (IdCardValidate(idcard2) == false) {
			alert("身份证号码不符合规范,请检查之后再输入.");
			// document.getElementById("idcard").focus();
		}
	}
return ;
}
    function checkName() {
    	var true_name = document.getElementById("realname").value;
    	if (true_name.length <1 || true_name.length > 20) {
    		alert("用户姓名有问题,请重新输入..");
    		
    	}
    	return ;
    	}
function checkphone() {
	var phone = document.getElementById("phone").value;
	var re =/^1\d{10}$/
	if (re.test(phone)) {

	} else {
		alert("手机号码输入可能有问题,请您检查一下.");
	}
	return ;
}

function checkInfo() {
	var phone = document.getElementById("phone").value;
	var idcard2 = document.getElementById("idcard").value;
	var true_name = document.getElementById("realname").value;
	
	if (true_name.length <1 || true_name.length > 20) {
		alert("用户姓名有问题,请重新输入..");
		return ;
	}
	if (IdCardValidate(idcard2) == false) {
		alert("身份证号码不符合规范,请检查之后再输入.");
		return ;
	}

	var re =/^1\d{10}$/
	if (re.test(phone)) {
	} else {
		alert("手机号码输入可能有问题,请您检查一下.");
		return ;
	}

	document.form3.action = "Add_contacts";
	document.form3.submit();


}
</script>
</head>

<body>

	<div id="header">
		<div class="logo">
			<br>
			<br>
			<br>
			<br> <img style="float: left; width: 52px; height: 52px;"
				src="dzsw/images/icon.png" />
			<div align="left">

				<font size="6" face="黑体">网上火车订票系统</font>
			</div>
		</div>
		<!--logo与背景-->


		<div class="top" style="text-align: right;">
			<font size="4" face="楷体" color="blue"> <strong id="hello"></strong><strong
				class="red" id="islogin"><a href="personal_centre.jsp"><font
						color="red"> <%=userName%></font></a><a href="login.jsp"> 注销</a></strong></font>
		</div>
		<div class="nav">
			<ul>
				<li><a href="index.jsp">首 页</a></li>
				<li><a href="Auto_tickets.jsp">自助购票</a></li>
				<li><a href="login.jsp">个人中心</a></li>
				<li><a href="failure_orders.jsp">订单查询</a></li>
				<li><a href="help.jsp"> 帮助信息</a></li>
				<li class="date"><script src="dzsw/scripts/chdata.js"></script>
				</li>
			</ul>
		</div>


	</div>
	<!--头部结束-->
	<div class="clear"></div>


	<!--中部开始-->
	<div id="homeWrap">
		<div class="help bs1">


			<div class="mleft fl">

				<h3>
					<span class="mleft-li12">个人中心</span>
				</h3>
				<li><a href="modify_password.jsp">修改密码</a></li>
				<li><a href="modify_info.jsp">修改资料</a></li>

				<li><a href="ususal_contacts.jsp">常用联系人</a></li>
			</div>

			<div class="mright mt12 fr">
				<div class="tt">
					<h3>常用联系人信息</h3>
				</div>
				<div class="cont">
					<h2>联系人资料</h2>
					<div class="padding10">
						<form id="form3" name="form3" method="post">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="right">用&nbsp;&nbsp;户&nbsp;&nbsp;名
								 <span class="red">*</span>
								</td>
								<td><input id="userName" name="userName" type="text"
									style="border: 0px;" class="inputU" value=<%=userName%>
									readonly /></td>
							</tr>
							<tr>
								<td align="right">
									姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名 
									<span class="red">*</span>
								</td>
								<td><input name="item.name" type="text" class="inputU"
									onblur="checkName()"  id="realname">
									 <span id="nameErr" style="color: red;"></span></td>
							</tr>

							<tr>
								<td align="right">证件类型 <span class="red">*</span>
								</td>
								<td><select class="select27x110" id="cardtype" tabindex="6">
										<option value="1" selected="selected">二代身份证</option>
								</select></td>
							</tr>
							<tr>
								<td align="right">证件号码 <span class="red">*</span>
								</td>
								<td><input type="text" name="idNumber" class="inputU" onblur="checkIdcard()"  id="idcard"> 
									<span id="idcardErr" style="color: red;"></span></td>
							</tr>

							<tr>
								<td align="right">手机号码<span class="red">*</span>
								</td>
								<td><input type="text" class="inputU" name="telNumber" id="phone"
									size="30" onblur="checkphone()"  tabindex="10">
									 <span id="mobileErr" style="color: red;"></span></td>
							</tr>

							<tr>
								<td align="right"></td>
								<td><a class="sub_02" href="javascript:void(0);"
									onclick="checkInfo();">保存</a></td>
							</tr>
						</table>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

	<!--中部结束-->

	<div class="clear"></div>

	<!--尾部开始-->
	<div id="footer">

		<div class="Copyright">
			湖北省武汉理工大学 版权所有&copy; 2017 技术支持<a href="/dzsw/logger.aspx ">:</a><a
				href="http://www.zjeasy.com/" target="_blank">长沙最终幻想软件股份有限公司</a> <span>程序版本:
				2.0.16.329</span><br /> 购票服务电话:0574-63810109 ICP备案号：湘ICP备05064785
		</div>
	</div>
	<!--尾部结束-->


</body>
</html>


