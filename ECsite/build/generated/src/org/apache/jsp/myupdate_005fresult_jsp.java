package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myupdate_005fresult_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"bootstrap/css/stylesheet.css\" rel=\"stylesheet\">\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("                <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n");
      out.write("                <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"base\">\n");
      out.write("            <div class=\"container-fluid text-center\"><a href=\"top.jsp\"><img src=\"かごゆめ.png\"></a></div>\n");
      out.write("            <hr>\n");
      out.write("            <div class=\"container-fluid text-center\">\n");
      out.write("                <div class=\"col-xs-4 center-block\"><a href=\"Logout\">ログアウト</a></div>\n");
      out.write("                <div class=\"col-xs-4 center-block\"><a href=\"MyData\">会員情報</a></div>\n");
      out.write("                <div class=\"col-xs-4 center-block\"><a href=\"Cart\">買い物カゴ</a></div>\n");
      out.write("            </div>\n");
      out.write("            <hr>\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"col-xs-6 col-xs-offset-3\">\n");
      out.write("                    <table class=\"container-fluid table\">\n");
      out.write("                        <tr><th>名前</th><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("                        <tr><th>パスワード</th><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("                        <tr><th>メールアドレス</th><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.mail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("                        <tr><th>住所</th><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("                        <tr><td colspan=\"2\">上記内容で更新いたしました</td></tr></table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
