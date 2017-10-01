package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mydata_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"bootstrap/css/stylesheet.css\" rel=\"stylesheet\">\r\n");
      out.write("        <!--[if lt IE 9]>\r\n");
      out.write("                <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\r\n");
      out.write("                <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"base\">\r\n");
      out.write("            <div class=\"container-fluid text-center\"><a href=\"top.jsp\"><img src=\"かごゆめ.png\"></a></div>\r\n");
      out.write("            <hr>\r\n");
      out.write("            <div class=\"container-fluid text-center\">\r\n");
      out.write("                <div class=\"col-xs-4 center-block\"><a href=\"Logout\">ログアウト</a></div>\r\n");
      out.write("                <div class=\"col-xs-4 center-block\"><a href=\"Cart\">買い物カゴ</a></div>\r\n");
      out.write("                <div class=\"col-xs-4 center-block\"><a href=\"top.jsp\">検索ページ</a></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <hr>\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"col-xs-6 col-xs-offset-3\">\r\n");
      out.write("                    <div style=\"width: 350px;margin: auto;\">\r\n");
      out.write("                    <table class=\"container-fluid table\">\r\n");
      out.write("                        <tr><td class=\"text-right\" style=\"width: 175px;\">ユーザー名</td><td style=\"width: 175px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\r\n");
      out.write("                        <tr><td class=\"text-right\">パスワード</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.getPassword()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\r\n");
      out.write("                        <tr><td class=\"text-right\">メールアドレス</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.getMail()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\r\n");
      out.write("                        <tr><td class=\"text-right\">住所</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.getAddress()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\r\n");
      out.write("                        <tr><td class=\"text-right\">総購入金額</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.getTotal()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\r\n");
      out.write("                        <tr><td class=\"text-right\">登録日時</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.getNewDate()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\r\n");
      out.write("                        <tr><td class=\"text-center\"><a href=\"myupdate.jsp\">会員情報変更</a></td><td class=\"text-center\"><a href=\"MyHistory\">購入履歴</a></td></tr>\r\n");
      out.write("                        <tr><td colspan=\"2\" class=\"text-center\"><a href=\"mydelete.jsp\">退会申請ページ</a></td></tr>     \r\n");
      out.write("                    </table>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
