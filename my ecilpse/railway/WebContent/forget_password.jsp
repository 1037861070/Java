<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>忘记密码</title>
<link href="dzsw/style/style.css" rel="stylesheet" type="text/css" />
<link href="dzsw/style/layer.css" rel="stylesheet" type="text/css" />
<link href="dzsw/style/yuding.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="dzsw/scripts/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="dzsw/scripts/jquery.cookie.js"></script>
<link href="dzsw/style/easyAlert.css" rel="stylesheet" type="text/css" />
<link href="dzsw/style/login.css" rel="stylesheet" type="text/css" />
<style>
.clearfix canvas {
	width: 80px;
	height: 42px;
	padding: 3px;
}
</style>
<script type ="text/javascript" >
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
   	var true_name = document.getElementById("userid").value;
   	if (true_name.length <1 || true_name.length > 20) {
   		alert("用户姓名格式有问题,请重新输入..");		
   	}
   	return ;
   	}
function checkphone() {
	var phone = document.getElementById("phone").value;
	var re =/^1\d{10}$/
	if (re.test(phone)) {

	} else {
		alert("手机号码输入可能有问题,请您检查一下.");
		return ;
	}
return;
}
function showCheck(a){/* 显示验证码图片 */
	var c = document.getElementById("myCanvas");
 	var ctx = c.getContext("2d");
 	ctx.clearRect(0,0,c.width,c.height);	
	ctx.font = "80px Arial";
	ctx.fillText(a,0,100);
}
var code ; //在全局 定义验证码      
function createCode(){       
    code = "";      
    var codeLength = 4;//验证码的长度
    var selectChar = new Array(1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');      
          
    for(var i=0;i<codeLength;i++) {
       var charIndex = Math.floor(Math.random()*60);      
      code +=selectChar[charIndex];
    }      
    if(code.length != codeLength){      
      createCode();      
    }
    showCheck(code);
    vcode = 2;
}
function checkCode(str){
	var Code1=document.getElementById("fauthcode").value;
	
	if(Code1!=code)
		{
		alert("验证码输入错误！")
		return ;
		}
	
}
function checkpsw1(){
	 var password = document.getElementById("newpsw").value;
	
       var re =/(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{6,20}/
     
      	if (re.test(password)) {
      	} else {
      		alert("密码输入复杂度有问题,请您检查一下.");
      		return ;
      	}
	 if ((password.length > 20 || password.length < 6)&&  password.length!=0) {
       alert("新密码长度为6-20位!");
       return ;
   }
	 return;
}
function checkpsw(){
	 var password = document.getElementById("newpsw").value;
   var conform = document.getElementById("enterpsw").value;
   if (password.length > 20 || password.length<6 ) {
      alert("新密码长度为6-20位！");
       return ;
   }
   if (password != conform) {
      alert("两次密码输入不一致！");
       return ;
   }
return;
}
function checkInfo() {
	var phone = document.getElementById("phone").value;
	var idcard2 = document.getElementById("idcard").value;
	var true_name = document.getElementById("userid").value;
	 var password = document.getElementById("newpsw").value;
	 var Code1=document.getElementById("fauthcode").value;
	 var password = document.getElementById("newpsw").value;
	   var conform = document.getElementById("enterpsw").value;
       var re =/(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{6,20}/
      	if (re.test(password)) {
      	} else {
      		alert("密码输入复杂度有问题,请您检查一下.");
      		return ;
      	}
	   if (password.length > 20 || password.length<6 ) {
	      alert("新密码长度为6-20位！");
	       return ;
	   }
	   if (password != conform) {
	      alert("两次密码输入不一致！");
	       return ;
	   }

		if(Code1!=code)
			{
			alert("验证码输入错误！")
			return ;
			}
	 if ((password.length > 20 || password.length < 6)&&  password.length!=0) {
       alert("新密码长度为6-20位!");
       return ;
   }
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

	document.form4.action = "Forget_password";
	document.form4.submit();
}
function showCheck(a){/* 显示验证码图片 */
	var c = document.getElementById("myCanvas");
 	var ctx = c.getContext("2d");
 	ctx.clearRect(0,0,c.width,c.height);	
	ctx.font = "80px Arial";
	ctx.fillText(a,0,100);
}
var code ; //在全局 定义验证码      
function createCode(){       
    code = "";      
    var codeLength = 4;//验证码的长度
    var selectChar = new Array(1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','j','k','l',
    		'm','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E',
    		'F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');      
          
    for(var i=0;i<codeLength;i++) {
       var charIndex = Math.floor(Math.random()*60);      
      code +=selectChar[charIndex];
    }      
    if(code.length != codeLength){      
      createCode();      
    }
    showCheck(code);
}
</script>
<style>
	.clearfix canvas {
		width: 80px;
		height: 42px;
		padding: 3px;
	}
</style>
</head>
<body onload="createCode();">
	<div id="header">
		<div class="logo">
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
		</div>
		<div class="top" style="text-align: right;">
			<font size="4" face="楷体" color="blue"> <strong id="hello"></strong><strong
				class="red" id="islogin"><a href="login.jsp"> 请登录...</a></strong></font>
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

		<div class="login_page bs1">
			<div class="login_reg">
				<div class="regjd-sj "></div>
				<div class="regjd2-sj hide"></div>
				<form id="form4" name="form4" method="post">
					<input name="__RequestVerificationToken" type="hidden"
						value="3BsdkUe8LB3q8Zi77dPP30v9ri3g6LQ7eLRcAWnrotX_iZ2lTZzI7PCAUCsUv1rEM7xvb4BiyXnfdYC2poF_PQ2" />
					<ul class="regdiv">
						<li style="color: #FF0000; display: none;">您的账号或者密码错误，请核对后重新输入！</li>
						<li><label><em class="red">*</em>用户名：</label>
						<input id="userid" name="userid" type="text" class="inputU" onblur ="checkName()"
							 /><span id="usr_err"
							style="color: red;">长度为6-20位</span></li>
						<li><label><em class="red">*</em>二代身份证号码：</label><input
							id="idcard" name="idcard" type="text" class="inputU" onblur ="checkIdcard()"
							 style="width: 320px;" /><span>不能重复注册/注册后不能修改</span></li>

						<li><label><em class="red">*</em>手机号码：</label><input
							id="phone" name="phone" type="text" class="inputU"  onblur ="checkphone()"
							 /><span>不能重复注册/用于找回密码和接收订单信息</span></li>
							 <li><label><em class="red">*</em>设置新密码：</label>
                    <input id="newpsw" name="userpwd1" type="password" class="inputU" onblur="checkpsw1()"/> <span>密码长度为6-20位，建议使用混合密码
						</span></li>
						<li><label><em class="red">*</em>重复密码：</label>
                    <input id="enterpsw" name="userpwd2" type="password" class="inputU" onblur="checkpsw()"/> <span>请再次输入相同的密码
						</span></li>
						<li><label><em class="red">*</em>验证码：</label>
						<input name="fauthcode" id="fauthcode" type="text" class="inputU"  onblur ="checkCode()"
							>&nbsp;&nbsp;&nbsp;
							<canvas class="plogin_verifyimg" id = "myCanvas" onclick = "createCode();" style="height:40px;"></canvas>						
								<a href="javascript:createCode();" class="inputU">换一张</a>
						</li>

						<li style="padding-left: 107px;"><input type="checkbox"
							checked="checked" name="isAgree" id="isAgree"> 我已阅读并接受<a
							href="/dzsw/help/help6" target="_blank">《购票须知》</a></li>
						<li class="plogin_reg"><a onclick="javascript:checkInfo();"
							class="sub_02">提交</a></li>
					</ul>
				</form>
			</div>
		</div>
	</div>
	

<<!--中部结束-->
<div class="clear"></div>

<!--尾部开始-->
<div id="footer">

    <div class="Copyright">湖北省武汉理工大学 版权所有&copy; 2017 技术支持<a href="/dzsw/logger.aspx ">:</a><a
            href="http://www.zjeasy.com/" target="_blank">长沙最终幻想软件股份有限公司</a> <span>程序版本: 2.0.16.329</span><br/>
        购票服务电话:0574-63810109 ICP备案号：湘ICP备05064785
    </div>
</div>
<!--尾部结束-->


</body>
</html>
