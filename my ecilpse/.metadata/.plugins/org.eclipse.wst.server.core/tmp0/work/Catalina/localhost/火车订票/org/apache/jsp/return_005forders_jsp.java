/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.42
 * Generated at: 2017-07-12 02:05:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class return_005forders_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>订单查询</title>\r\n");
      out.write("\r\n");
      out.write("    <link href=\"dzsw/style/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    <link href=\"dzsw/style/layer.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    <link href=\"dzsw/style/yuding.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"dzsw/scripts/jquery-1.7.1.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"dzsw/scripts/jquery.cookie.js\"></script>\r\n");
      out.write("    <link href=\"dzsw/style/easyAlert.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"hello()\">\r\n");
      out.write("\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("    <div class=\"logo\">\r\n");
      out.write("        <br> <br> <br> <br>\r\n");
      out.write("        <img style=\"float: left; width: 52px; height: 52px;\"\r\n");
      out.write("             src=\"dzsw/images/icon.png\"/>\r\n");
      out.write("        <div align=\"left\">\r\n");
      out.write("            <font size=\"6\" face=\"黑体\">网上火车订票系统</font>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"top\" style=\"text-align: right;\">\r\n");
      out.write(" <font size=\"4\" face=\"楷体\" color=\"blue\">\r\n");
      out.write("        <strong id=\"hello\"></strong><strong class=\"red\" id=\"islogin\"><a\r\n");
      out.write("            href=\"personal_centre.jsp\"><font color=\"red\"> likui1314</font></a><a\r\n");
      out.write("            href=\"login.jsp\"> 注销</a></strong></font>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"nav\">\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"index.jsp\">首 页</a></li>\r\n");
      out.write("            <li><a href=\"Auto_tickets.jsp\">自助购票</a></li>\r\n");
      out.write("            <li><a href=\"login.jsp\">个人中心</a></li>\r\n");
      out.write("            <li><a href=\"personal_certre.jsp\">订单查询</a></li>\r\n");
      out.write("            <li><a href=\"help.jsp\"> 帮助信息</a></li>\r\n");
      out.write("            <li class=\"date\">\r\n");
      out.write("                <script src=\"dzsw/scripts/chdata.js\"></script>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!--头部结束-->\r\n");
      out.write("<div class=\"clear\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--中部开始-->\r\n");
      out.write("<div id=\"homeWrap\">\r\n");
      out.write("    <div class=\"help bs1\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"mleft fl\">\r\n");
      out.write("            <h3>\r\n");
      out.write("                <span class=\"mleft-li11\">我的订单</span>\r\n");
      out.write("            </h3>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"failure_orders.jsp\">未完成订单</a></li>\r\n");
      out.write("                <li><a href=\"success_orders.jsp\">成功的订单</a></li>\r\n");
      out.write("\r\n");
      out.write("                <li><a href=\"return_orders.jsp\">已退票订单</a></li>\r\n");
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"mright mt12 fr\">\r\n");
      out.write("            <div class=\"tt\">\r\n");
      out.write("                <h3>已退票订单</h3>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"cssOrder\">\r\n");
      out.write("                <div class=\"seach\">\r\n");
      out.write("                    <table width=\"\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td align=\"center\">开始时间：<input type=\"text\" id=\"beginTime\"\r\n");
      out.write("                                                           style=\"color: #000;\" value=\"2017-06-10\" class=\"inputU\"\r\n");
      out.write("                                                           onClick=\"WdatePicker()\"/> 结束时间：<input type=\"text\"\r\n");
      out.write("                                                                                                 id=\"endTime\"\r\n");
      out.write("                                                                                                 style=\"color: #000;\"\r\n");
      out.write("                                                                                                 value=\"2017-07-10\"\r\n");
      out.write("                                                                                                 class=\"inputU\"\r\n");
      out.write("                                                                                                 onfocus=\"this.style.color='#333';\"\r\n");
      out.write("                                                                                                 onClick=\"WdatePicker()\"/>\r\n");
      out.write("                                <button id=\"search-btn\" class=\"btn_search\"\r\n");
      out.write("                                        onclick=\"javascript:goPage(1);\">搜索\r\n");
      out.write("                                </button>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"cssOrder\" id=\"cssOrder\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"clear\"></div>\r\n");
      out.write("                <div class=\"page\">\r\n");
      out.write("                    <span>订单数:0 条</span>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--中部结束-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--中部结束-->\r\n");
      out.write("<div class=\"clear\"></div>\r\n");
      out.write("\r\n");
      out.write("<!--尾部开始-->\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"Copyright\">湖北省武汉理工大学 版权所有&copy; 2017 技术支持<a href=\"/dzsw/logger.aspx \">:</a><a\r\n");
      out.write("            href=\"http://www.zjeasy.com/\" target=\"_blank\">长沙最终幻想软件股份有限公司</a> <span>程序版本: 2.0.16.329</span><br/>\r\n");
      out.write("        购票服务电话:0574-63810109 ICP备案号：湘ICP备05064785\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--尾部结束-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
