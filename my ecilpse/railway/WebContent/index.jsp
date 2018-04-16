<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>订票系统</title>
    <link href="dzsw/style/index.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/nbgy.css" rel="stylesheet" type="text/css"/>
    <script src="dzsw/scripts/jquery-1.7.1.min.js"></script>
</head>
<body>
<header id="header" class="header" style="height: 166px">
    <div id="logo" class="logo" style="width: 100%">
        <br><br><br><br>
        <img style="float: left; width: 52px; height: 52px;"
             src="dzsw/images/icon.png"/>
        <div align="left">
            <font size="6" face="黑体">网上火车订票系统</font>
        </div>
    </div>
    <div class="top" style="text-align: right; width: 100%">
    <font size="4" face="楷体" color="blue">
        <strong id="hello"></strong><strong class="red" id="islogin"><a
            href="login.jsp"> 请登录...</a></strong></font>
    </div>

    <nav id="nav" class="nav">
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
    </nav>
</header>
<div id="homeWrap">
    <div class="search">
        <ul>
            <li>
                <em>出发站</em>
                <input style="color: #999999;" name="reachstationname" class="input-cs inputCity" value="请输入简拼/全拼/汉字"
                       onfocus="if(this.value=='请输入简拼/全拼/汉字'){this.value='';this.style.color='#333';}"
                       onblur="if(!this.value){this.value='请输入简拼/全拼/汉字';this.style.color='#999999'}" name="s_cities"
                       onclick=" GetCityList(this, 1);" onkeyup="selCity(event);" id="reachCity" tabindex="1"
                       type="text">
            </li>
            <li>
                <em>目的站</em>
                <input style="color: #999999;" value="请输入简拼/全拼/汉字"
                       onfocus="if(this.value=='请输入简拼/全拼/汉字'){this.value='';this.style.color='#333';}"
                       onblur="if(!this.value){this.value='请输入简拼/全拼/汉字';this.style.color='#999999'}" name="s_cities"
                       class="input-cs inputCity" autocomplete="off" onclick=" GetEndstation(this);  "
                       onkeyup="selCity(event)" id="city" tabindex="2" type="text">
            </li>
            <li>
                <em>出发日期</em>
                <input style="color: #999999;" value="2017-07-10" id="starttime"
                       onfocus="if(this.value=='例如：2014-08-14'){this.value='';this.style.color='#333';}"
                       onblur="if(!this.value){this.value='例如：2014-08-14';this.style.color='#999999'}" tabindex="4"
                       class="input-cs" onclick="WdatePicker({minDate:'2017-07-10',maxDate:'2017-07-17'})" type="date">
            </li>
            <li>
                <button class="search_button" onclick="showcomlogin();" href="javascript:void%200;"
                        class="search_button" id="search_sub1">查 询
                </button>
            </li>
            <img src="dzsw/images/gplc.jpg" alt="订票流程">
        </ul>
    </div>
    <img src="dzsw/images/4.jpg" width="630" height="295"/>
</div>
<div class="Copyright">湖北省武汉理工大学 版权所有&copy; 2017 技术支持<a href="/dzsw/logger.aspx ">:</a><a href="http://www.zjeasy.com/"
                                                                                          target="_blank">长沙最终幻想软件股份有限公司</a>
    <span>程序版本: 2.0.16.329</span><br/>
    购票服务电话:0574-63810109 ICP备案号：湘ICP备05064785
</div>
</body>
</html>