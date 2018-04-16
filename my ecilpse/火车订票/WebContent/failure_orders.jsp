<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="dzsw/style/style.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/layer.css" rel="stylesheet" type="text/css"/>
    <link href="dzsw/style/yuding.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="dzsw/scripts/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="dzsw/scripts/jquery.cookie.js"></script>
    <link href="dzsw/style/easyAlert.css" rel="stylesheet" type="text/css"/>
</head>
<body onload="hello()">

<div id="header">
    <div class="logo"><br><br><br><br>
        <img style="float: left; width: 52px; height: 52px;"
             src="dzsw/images/icon.png"/>
        <div align="left">
            <font size="6" face="黑体">网上火车订票系统</font>
        </div>
    </div><!--logo与背景-->


    <div class="top" style="text-align: right;">
 <font size="4" face="楷体" color="blue">
        <strong id="hello"></strong><strong class="red" id="islogin"><a href="personal_centre.jsp"><font color="red">
        likui1314</font></a><a href="login.jsp"> 注销</a></strong></font></div>
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


</div><!--头部结束-->
<div class="clear"></div>


<!--中部开始-->
<div id="homeWrap">
    <div class="help bs1">


        <div class="mleft fl">
            <h3><span class="mleft-li11">我的订单</span></h3>
            <ul>
                <li><a href="failure_orders.jsp">未完成订单</a></li>
                <li><a href="success_orders.jsp">成功的订单</a></li>

                <li><a href="return_orders.jsp">已退票订单</a></li>

            </ul>

        </div>

        <div class="mright mt12 fr">
            <div class="tt">
                <h3>未完成订单</h3>
            </div>
            <div class="cssOrder" id="cssOrder">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr class="ddthead0">
                        <td colspan="5"> 订单号：20170710000173 &nbsp;&nbsp;订单时间：2017-07-10</td>
                        <td align="right">
                            <div align="right">张数：<span class="yellow">1 </span>&nbsp;张</div>
                        </td>
                    </tr>

                    <tr class="ddthead">
                        <td align="center">班次</td>
                        <td align="center">线路</td>
                        <td align="center">发车时间</td>
                        <td align="center">上车站</td>
                        <td align="center">下车站</td>
                        <td align="center">订单状态</td>
                    </tr>
                    <tr class="ddtheadh">
                        <td align="center"><span id="scheduleNum">5001       </span></td>
                        <td align="center"><span id="seatType">余姚-店口                                         </span>
                        </td>
                        <td align="center"><span id="departTime">2017/7/11 7:50:00</span></td>
                        <td align="center"><span id="startStation">周巷站</span></td>
                        <td align="center"><span id="endStation">店口                </span></td>
                        <td align="center"><font color="red">座位锁定,等待付款</font></td>

                    </tr>
                    <tr>
                        <td colspan="6" align="center">
                            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="ppzx">
                                <tr class="ddtheadzx">
                                    <th>座席</th>
                                    <th width="180">票种</th>
                                    <th width="180">单价</th>
                                    <th width="120">张数</th>
                                    <th width="120">票款</th>
                                </tr>
                                <tr>
                                    <td rowspan="2" align="center">普座</td>


                                    <td align="center">全票</td>
                                    <td align="center"><strong>39.00 </strong></td>
                                    <td align="center">1<span class="zi">张</span></td>
                                    <td align="center"><strong class="Orange">39.00 元</strong></td>
                                </tr>

                                <tr>
                                    <td align="center">座位号:</td>
                                    <td align="center">19</td>
                                    <td align="center">合计：<strong class="red">1</strong>张</td>
                                    <td align="center"><strong class="blue">39.00 元</strong></td>
                                </tr>
                                <tr>
                                    <td colspan="5" align="right" class="hj2" style="text-align:right;">
                                        实付：<span class="red">￥<span id="sumTicketPrice"><font
                                            size="+1">39.00 元</font></span></span>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6">
                            <div class="stop_pay">
                                <a class="btn_stoppay" href="javascript:cancelOrder('20170710000173');">取消订单</a>
                                <a class="btn_stoppay" href="javascript:payOrder('20170710000173');">继续支付</a>
                        </td>
                    </tr>
                </table>


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
</div><!--尾部结束-->


</body>
</html>
