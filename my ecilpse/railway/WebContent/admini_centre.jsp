<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加联系人</title>

    <link href="dzsw/style/style.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/layer.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/yuding.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="dzsw/scripts/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="dzsw/scripts/jquery.cookie.js"></script>
    <link href="dzsw/style/easyAlert.css" rel="stylesheet" type="text/css"/>
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
    </div><!--logo与背景-->


    <div class="top" style="text-align: right;">
 <font size="4" face="楷体" color="blue">
        <strong id="hello"></strong><strong class="red" id="islogin"><a href=" admini_centre.jsp"><font color="red">管理员：
        likui1314</font></a><a href="login.jsp"> 注销</a></strong></font></div>
    <div class="nav">
        <ul>
            <li><a href="index.jsp">首 页</a></li>
     
            <li><a href="login.jsp">管理中心</a></li>
           
            <li><a href="help.jsp"> 帮助信息</a></li>
            <li class="date">
                <script src="dzsw/scripts/chdata.js"></script>
            </li>
        </ul>
    </div>


</div><!--头部结束-->
<div class="clear"></div>


<!--中部开始-->
<div id="homeWrap">
    <div class="help bs1">


        <div class="mleft fl">

            <h3><span class="mleft-li12">个人信息</span></h3>
            <li><a href="modify_password.jsp">修改密码</a></li>
            <li><a href="modify_info.jsp">修改资料</a></li>
<h3><span class="mleft-li12">业务管理</span></h3>
 <li><a href="modify_password.jsp">交易查询</a></li>
 <li><a href="modify_password.jsp">站点查询</a></li> 
  <li><a href="modify_password.jsp">添加车次</a></li>
   <li><a href="modify_password.jsp">修改车次</a></li> 
           
        </div>
 <div class="mright mt12 fr">
            <div class="tt">
                <h3>管理中心</h3>
            </div>
            <div class="cont">
                <div class="ht_s0 font16">
                    <span class="blue">李魁</span>&nbsp;welcome:
                </div>
                <div class="ht_s1">
                    您当前有<a href="/dzsw/order/noOrder"><strong class="red">&nbsp;
                    0&nbsp;</strong></a>笔订单已经更新&nbsp;<br/> 
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
</div><!--尾部结束-->


</body>
</html>


