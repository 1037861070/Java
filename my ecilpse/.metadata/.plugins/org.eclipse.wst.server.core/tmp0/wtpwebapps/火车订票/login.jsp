<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人中心</title>
    <link href="dzsw/style/style.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/layer.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/yuding.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="dzsw/scripts/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="dzsw/scripts/jquery.cookie.js"></script>
    <link href="dzsw/style/easyAlert.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/login.css" rel="stylesheet" type="text/css"/>
</head>


<body onload="hello()">
<div id="header">
    <div class="logo">
        <div class="logo">
            <br><br><br><br>
            <img style="float: left; width: 52px; height: 52px;"
                 src="dzsw/images/icon.png"/>
            <div align="left">

                <font size="6" face="黑体">网上火车订票系统</font>
            </div>
        </div>
    </div>
    <!--logo与背景-->
    <div class="tel">

    </div>
    <div class="top" style="text-align: right;">
        <font size="4" face="楷体" color="blue">
            <strong id="hello"></strong><strong class="red" id="islogin"><a
                href="login.jsp"> 请登录...</a></strong></font>
    </div>
    <div class="nav">
        <ul>
            <li><a href="index.jsp">首 页</a></li>
            <li><a href="Auto_tickets.jsp">自助购票</a></li>
            <li><a href="login.jsp">个人中心</a></li>
            <li><a href="failure_orders.jsp">订单查询</a></li>
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
    <div class="login_page mt12">
        <div class="login_img fl">
            <img src="dzsw/images/111.jpg"/>
        </div>
        <div class="login_Tag fr">
            <h3>会员登录</h3>
            <ul>
                <li style="color: #FF0000; display: none;">您的账号或者密码错误，请核对后重新输入！</li>
                <li><label>会员名：</label><input name="fusername" id="fusername"
                                              type="text" value="会员名/手机号"
                                              onfocus="if(this.value=='会员名/手机号'){this.value='';this.style.color='#333';}"
                                              onblur="if(!this.value){this.value='会员名/手机号';this.style.color='#999999'}"
                                              class="username"/></li>
                <li><label>密码：</label><input name="fuserpwd" type="password"
                                             class="userpwd" id="fuserpwd" onkeydown="javascript:fastLogin();"/></li>
                <li><label>验证码：</label><input name="fauthcode" id="fauthcode"
                                              type="text" class="useryzm" value="验证码"
                                              onfocus="if(this.value=='验证码'){this.value='';this.style.color='#333';}"
                                              onkeydown="javascript:fastLogin();"
                                              onblur="if(!this.value){this.value='验证码';this.style.color='#999999'}"/>
                    <img src="dzsw/images/Validate.ashx" id="vcode_img" alt="验证码图片"
                         width="62" height="31" class="plogin_verifyimg"
                         onclick="this.src='dzsw/images/Validate.ashx?' + Math.random();"/><em>
                        <a href="javascript:check_code();">换一张</a>
                    </em></li>
                <li style="text-align: center;"><input name="user.autologin"
                                                       id="autologin" type="checkbox" value="0"
                                                       style="vertical-align: middle; display: none;">&nbsp;自动登录<em
                        style="padding-left: 30px;"><a href="/dzsw/forgetpwd/index">忘记密码？</a></em></li>

                <li><a class="sub01" href="personal_centre.jsp"/> 登录</a></li>
                <li class="clear"></li>
                <li class="plogin_reg">还未注册账号？<a href="register.jsp"
                                                 class="blue">立即注册</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!--中部结束-->
<div class="clear"></div>


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
