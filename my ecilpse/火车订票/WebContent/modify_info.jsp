<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改个人资料e</title>
    <link href="dzsw/style/style.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/layer.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/yuding.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="dzsw/scripts/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="dzsw/scripts/jquery.cookie.js"></script>
    <link href="dzsw/style/easyAlert.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/login.css" rel="stylesheet" type="text/css"/>
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
            href="personal_centre.jsp"><font color="red"> likui1314</font></a><a
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

        <div class="mright mt12 fr">
            <div class="tt">
                <h3>修改资料</h3>
            </div>
            <div class="cont">
                <h2>基本资料</h2>
                <div class="padding10">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td align="right">用&nbsp;&nbsp;户&nbsp;&nbsp;名 <span
                                    class="red">*</span>
                            </td>
                            <td>likui1314</td>
                        </tr>

                        <tr>
                            <td align="right">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名
                                <span class="red">*</span>
                            </td>
                            <td><input name="user.realname" type="text" class="inputU"
                                       value="李魁" id="realname"> <span id="nameErr"
                                                                       style="color: red;"></span></td>
                        </tr>

                        <tr>
                            <td align="right">证件类型 <span class="red">*</span>
                            </td>
                            <td><select name="user.cardtype" class="select27x110"
                                        id="cardtype" tabindex="6">
                                <option value="1" selected="selected">二代身份证</option>
                            </select></td>
                        </tr>
                        <tr>
                            <td align="right">证件号码 <span class="red">*</span>
                            </td>
                            <td><input name="user.realname" type="text" class="inputU"
                                       value="430821199604286019" onblur="checkIdcard()" id="idcard">

                                <span id="idcardErr" style="color: red;"></span></td>
                        </tr>

                        <tr>
                            <td align="right">手机号码<span class="red">*</span>
                            </td>
                            <td><input type="text" name="user.address" class="inputU"
                                       value="15071342913" id="phone" size="30" onblur="checkphone()"
                                       tabindex="10"> <span id="mobileErr" style="color: red;"></span>
                            </td>
                        </tr>

                        <tr>
                            <td align="right"></td>
                            <td><a class="sub_02" onclick="makesubst()">保存</a></td>
                        </tr>
                    </table>
                </div>

            </div>
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