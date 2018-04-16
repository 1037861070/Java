<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>自助购票</title>
    <link href="dzsw/style/style.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/layer.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/yuding.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/easyAlert.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="dzsw/scripts/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="dzsw/scripts/jquery.cookie.js"></script>
    <link rel="stylesheet" href="dzsw/style/step-dc-style1.css" />
    
<script type="text/javascript" src="dzsw/scripts/jquery.min.js"></script>
<script type="text/javascript" src="dzsw/scripts/step-jquery-dc.js"></script>
    
    
</head>

<body >
<div id="header">
    <div class="logo"><br><br><br><br>
        <img style="float: left; width: 52px; height: 52px;"
             src="dzsw/images/icon.png"/>
        <div align="left">
            <font size="6" face="黑体">网上火车订票系统</font>
        </div>
    </div>
    <div class="top" style="text-align: right">
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
    <div class="container bs1">

   
        <div class="ydbox">
            <!--进度-->
            <div class="ydjd1">班次查询</div>
            <div class="ydfromcx">
                <ul>
                    <li><em>始发地</em><input type="text" style="color: #999999;"
                                           name="reachstationname" value="慈溪"
                                           onclick="GetCityList(this, 1);$('#city').val('');"
                                           onkeyup="selCity(event);" id="reachCity" tabindex="1"
                                           class="inputU"></li>
                    <li><em>目的地</em><input type="text" style="color: #999999;"
                                           value="--"
                                           onfocus="if(this.value=='请输入简拼/全拼/汉字'){this.value='';this.style.color='#333';}"
                                           onblur="if(!this.value){this.value='请输入简拼/全拼/汉字';this.style.color='#999999'}"
                                           name="s_cities" autocomplete="off"
                                           onclick="this.value = ''; GetEndstation(this);  "
                                           onkeyup="selCity(event)" id="city" tabindex="2" class="inputU"></li>

                    <li><em>发车时间</em><input type="text"
                                            onClick="WdatePicker({minDate:'2017-07-10 ',maxDate:'2017-07-17'})"
                                            id="starttime"
                                            onfocus="if(this.value=='例如：2014-08-14'){this.value='';this.style.color='#333';}"
                                            onblur="if(!this.value){this.value='例如：2014-08-14';this.style.color='#999999'}"
                                            tabindex="3" class="inputU"/></li>
                    <li style="width: 150px;">
                        <a onclick="showcomlogin();"
                           href="javascript:;" class="button1 input-cx1" id="search_sub1">立即查询</a></li>
                </ul>
            </div>
            <div class="clear"></div>
            <div class="datediv" id="datebag"></div>
            <div class="yddiv1">
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="200" align="left" style="text-indent: 2em;"
                            id="starttime2">出发时间：
                        </td>
                        <td width="150"><span> <input name="timeBucket"
                                                      type="checkbox" checked="checked" id="amcheck"
                                                      onclick="showcomlogin();"/> 上午
							</span> (00:00 - 12:00 )
                        </td>
                        <td width="150"><span> <input name="timeBucket"
                                                      type="checkbox" checked="checked" id="pmcheck"
                                                      onclick="showcomlogin();"/> 下午
							</span> ( 12:01 -23:59 )
                        </td>
                    </tr>
                </table>
            </div>
            <form id="form1" action="reg" method="post">
                <input name="__RequestVerificationToken" type="hidden"
                       value="3BsdkUe8LB3q8Zi77dPP30v9ri3g6LQ7eLRcAWnrotX_iZ2lTZzI7PCAUCsUv1rEM7xvb4BiyXnfdYC2poF_PQ2"/>
                <div class="yddiv2" id="bclist">


                    <table width="100%" border="1" cellspacing="0" cellpadding="0">
                        <tr id="rowinof" class="tt">
                            <th width="30" scope="col" align="center">序号</th>
                            <th width="80" scope="col" align="center">发车时间</th>
                            <th width="80" align="center">车次代码</th>
                            <th width="160" align="center" scope="col">线路名称</th>
                            <th width="119" scope="col" align="center">上车站</th>
                            <th width="119" scope="col" align="center">到达站</th>

                            <th width="65" scope="col" align="center">客别</th>
                            <th width="90" scope="col" align="center">车型</th>
                            <th width="120" scope="col" align="center">
                                <a id="pj"
                                   href="javascript:void(0)"
                                   onclick="scheduleStor('discountprice',this)"
                                   class="input-piaojia"><span>票价(全)</span> </a>
                            </th>
                            <th width="120" scope="col" align="center">余座(携)</th>
                            <th width="100" align="center" scope="col"></th>
                        </tr>


                    </table>

                </div>
            </form>

        </div>
    </div>
</div>
<!--中部结束-->
<div class="clear"></div>


<!--中部结束-->
<div class="clear"></div>




<div id="layer1" style="z-index: 19891016; display: none;">
    <div times="1" id="xubox_shade2" class="xubox_shade"
         style="z-index: 19891016; background-color: #000; opacity: 0.3; filter: alpha(opacity = 30);"></div>
    <div times="1" showtime="0"
         style="z-index: 19891016; left: 50%; top: 121.5px; width: 380px; height: 300px; margin-left: -190px;"
         id="xubox_layer1" class="xubox_layer" type="page">
        <div style="background-color: #fff; z-index: 19891015"
             class="xubox_main">
            <div class="xubox_page" style="top: 36px;">
                <div style="" id="touch_lo" class="layer_pageContent">
                    <div class="Pop-up_logoin" style="background: none">
                        <form target="supportiframe"
                              action="index.php?m=login&amp;c=loginsave" method="post">
                            <div class="Pop-up_logoin_list">
                                <span>用户名：</span> <input type="text" id="username" value=""
                                                         tabindex="91" name="username" class="ajax_login_input">
                            </div>
                            <div class="Pop-up_logoin_list">
                                <span>密 码：</span> <input type="password" id="password"
                                                         tabindex="92" name="password" value=""
                                                         class="ajax_login_input" onkeydown="javascrip:fastLogin()">
                            </div>
                            <div class="Pop-up_logoin_list">
                                <span>验证码：</span> <input id="authcode" type="text"
                                                         tabindex="93" style="width: 60px;" maxlength="4"
                                                         name="authcode" class="ajax_login_input w60"
                                                         onkeydown="javascrip:fastLogin()"> <img
                                    src="/dzsw/Validate.ashx" name="vcode_img" width="60"
                                    height="30" id="vcode_img"
                                    style="margin-right: 5px; margin-left: 5px;">&nbsp;<a
                                    href="javascript:check_code();">换一张</a>
                            </div>
                            <div class="Pop-up_logoin_list">
                                <div id="msg"></div>
                            </div>
                            <div class="Pop-up_logoin_list">
                                <span>&nbsp;</span>
                                <!--<input id="loginsubmit" class="login_button" type="button" name="loginsubmit" onclick="checkcomlogin()">-->
                                <a id="loginsubmit" class="login_button"
                                   href="javascript:checklogin();">登录</a> <a
                                    href="/dzsw/forgetpwd/index" class="lh65">忘记密码？</a>
                            </div>
                        </form>
                        <div class="Pop-up_logoin_bot">
                            <span>&nbsp;</span> 还没有账号？<a href="/dzsw/register/index"
                                                         target="_blank" class="Orange">免费注册</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="xubox_title" move="ok" style="cursor: move;">
                <em>快速登录</em>
            </div>
            <span class="xubox_setwin"><a
                    class="xubox_close xulayer_png32 xubox_close0" id="xubox_close1"
                    href="javascript:;" style=""></a></span><span class="xubox_botton"></span>
        </div>
        <div id="xubox_border1" class="xubox_border"
             style="z-index: 19891014; background-color: rgb(0, 0, 0); opacity: 0.3; top: -10px; left: -10px; width: 400px; height: 320px;"></div>
    </div>
</div>

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