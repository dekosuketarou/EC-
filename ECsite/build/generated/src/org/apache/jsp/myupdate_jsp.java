package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ECsiteLogic.MenuHelper;

public final class myupdate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.print(MenuHelper.getInstance().getLogoutMenu());
      out.write("\r\n");
      out.write("        ");
      out.print(MenuHelper.getInstance().getMyDataMenu());
      out.write("\r\n");
      out.write("        ");
      out.print(MenuHelper.getInstance().getTopMenu());
      out.write("\r\n");
      out.write("        <hr>\r\n");
      out.write("        <form action=\"MyUpdateResult\" method=\"post\">\r\n");
      out.write("            <table width=\"80%\" >\r\n");
      out.write("                <tr><th>名前</th><td><input type=\"text\" name=\"name\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td></tr>\r\n");
      out.write("                <tr><th>パスワード</th><td><input type=\"text\" required=\"required\" name=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td></tr>\r\n");
      out.write("                <tr><th>メールアドレス</th><td><input type=\"email\" name=\"mail\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.mail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td></tr>\r\n");
      out.write("                <tr><th>住所</th><td><input type=\"text\" name=\"address\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td></tr>\r\n");
      out.write("                <tr><th colspan=\"2\"><input type=\"submit\" value=\"登録確認\">\r\n");
      out.write("                    </th></tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
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