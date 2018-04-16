<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="domain.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改密码</title>
    <link href="dzsw/style/style.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/layer.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/yuding.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="dzsw/scripts/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="dzsw/scripts/jquery.cookie.js"></script>
    <link href="dzsw/style/easyAlert.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/login.css" rel="stylesheet" type="text/css"/>
    
     <% 
	User user = (User)request.getSession().getAttribute("User");
	String idNumber = user.getIdNumber();
	String idType=user.getIdType();
	String name=user.getName();
	String password=user.getPassword();
	int role=user.getRole();
	int userId=user.getUserId();
	String userName=user.getUserName();
	String telNumber=user.getTelNumber();
%>  
<script type ="text/javascript" >
function checkpsw1(){
	var re =/(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{6,20}/
	 var password = document.getElementById("newpsw").value;
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
function checkpsw2(){
	var password = document.getElementById("oldpsw").value;
	if ((password.length > 20 || password.length < 6)&&  password.length!=0) {
        alert("原密码长度为6-20位!");
        return ;
    }
	 return;
	
}
        function checkInfo() {
    
        	//var orginpsw="${session.User.password}";
        	
          var password = document.getElementById("oldpsw").value;
            var newpsw = document.getElementById("newpsw").value;
            var enterpsw = document.getElementById("enterpsw").value;
            var re =/(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{6,20}/  
           	if (re.test(newpsw)) {
           	} else {
           		alert("密码输入复杂度有问题,请您检查一下.");
           		return ;
           	}
            if(password==newpsw){
            	alert("原密码与新密码一致,请检查密码.");
            	return;
            }
            
        	if ((password.length > 20 || password.length < 6)&&  password.length!=0) {
                alert("原密码长度为6-20位!");
                return ;
            }
            if (newpsw != enterpsw) {
                alert("两次新密码输入不一致,请检查密码.");
                return;
            }
            if (newpsw.length<6||newpsw.length>20) {
                alert("新密码不符合规范.长度应该是6~20 个字符范围.请重新输入.");
                return;
            }
            document.form1.action="Modify_password";
            document.form1.submit();
            
        }
 
    </script>
</head>
<body>
<div id="header">
    <div class="logo">
        <br><br><br><br>
        <img style="float: left; width: 52px; height: 52px;"
             src="dzsw/images/icon.png"/>
        <div align="left">
            <font size="6" face="黑体">网上火车订票系统</font>
        </div>
    </div>
    <div class="top" style="text-align: right;">
 <font size="4" face="楷体" color="blue">
        <strong id="hello"></strong><strong class="red" id="islogin"><a
            href="personal_centre.jsp"><font color="red"> <%=userName%></font></a><a
            href="login.jsp"> 注销</a></strong></font>
    </div>
    <div class="nav">
        <ul>
            <li><a href="index.jsp">首 页</a></li>
            <li><a href="Auto_tickets.jsp">自助购票</a></li>
            <li><a href="login.jsp">个人中心</a></li>
            <li><a href="personal_certre.jsp">订单查询</a></li>
            <li><a href="help.jsp"> 帮助信息</a></li>
            <li class="date">
                <script src="dzsw/scripts/chdata.js"></script>
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

        <div class="mright mt12 fr" id="pswdiv">
            <div class="tt">
                <h3>修改密码</h3>
            </div>
          
            <form id="form1" name="form1" method="post"  >
            <div class="login_page login_Pwd" style="width: 80%;">
                <ul>   
                 <li><label><em class="red">*</em>用户名：</label>
                 <input id="userName" name="userName" type="text" style="border:0px;" 
                 class="inputU" value=<%=userName%> readonly /></li>                 
                    <li><label><em class="red">*</em>原密码：</label>
                    <input id="oldpsw" name="userpwd" type="password" class="inputU" onblur="checkpsw2()"/></li>
                    <li><label><em class="red">*</em>新密码：</label>
                    <input id="newpsw" name="userpwd1" type="password" class="inputU" onblur="checkpsw1()"/> <span>密码长度为6-20位，建议使用混合密码
						</span></li>
                    <li><label><em class="red">*</em>重复密码：</label>
                    <input id="enterpsw" name="userpwd2" type="password" class="inputU" onblur="checkpsw()"/> <span>请再次输入相同的密码
						</span></li>
				 
					<li><a class="sub_02"  href="javascript:void(0);"  onclick="checkInfo();">提交</a> </li>	
                </ul>
            </div>
            </form>
        </div>
    </div>
</div>




<!--中部结束-->
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