<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
         <%@page import="domain.User"%>
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
</head>
<body >

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
            href="personal_center.jsp"><font color="red">  <%=userName%></font></a><a
            href="login.jsp"> 注销</a></strong></font>
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
    <div class="help bs1">


        <div class="mleft fl">

            <h3>
                <span class="mleft-li12">个人中心</span>
            </h3>
            <li><a href="modify_password.jsp">修改密码</a></li>
            <li><a href="modify_info.jsp">修改资料</a></li>

            <li><a href="/dzsw/member/contacts">常用联系人</a></li>
        </div>

        <div class="mright mt12 fr">
            <div class="tt">
                <h3>个人中心</h3>
            </div>
            <div class="cont">
                <div class="ht_s0 font16">
                    <span class="blue"><%=name %>></span>&nbsp;欢迎你购票:
                </div>
                <div class="ht_s1">
                    您当前有<a href="/dzsw/order/noOrder"><strong class="red">&nbsp;
                    0&nbsp;</strong></a>笔订单需要处理&nbsp;<br/> 今天已购买成功的订单有<a
                        href="/dzsw/order/sucorder"><strong class="red">&nbsp;
                    0&nbsp;</strong></a>笔。
                </div>

                <div class="ht_s2">
                    <strong class="red">购票前,你需要知道以下规定:</strong>
                    <p>
                        <span class="red">·</span> 每个会员帐号每日限成功的订单:&nbsp;2&nbsp;笔订单。
                    </p>
                    <p>
                        <span class="red">·</span> 每笔订单最多可以购买:&nbsp;3&nbsp;张票(不包括携童票)。
                    </p>
                    <p>
                        <span class="red">·</span> 每天最多限定:&nbsp;10&nbsp;笔废单.超出将不能购票。
                    </p>
                    <p>
                        <span class="red">·</span> 当前网站购票状态:&nbsp;可售&nbsp;。
                    </p>
                    <p>
                        <span class="red">·</span> 正常网站购票开放时间:&nbsp; 5:00
                        &nbsp;-&nbsp;22:00&nbsp;。
                    </p>
                </div>
            </div>
        </div>


    </div>
</div>

</div>
</div>
<!--中部结束-->

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
