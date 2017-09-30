package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ECsiteLogic.MenuHelper;

public final class mydelete_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.print(MenuHelper.getInstance().getLogoutMenu());
      out.write("\n");
      out.write("        ");
      out.print(MenuHelper.getInstance().getTopMenu());
      out.write("\n");
      out.write("        <hr>\n");
      out.write("        <table>\n");
      out.write("            <tr><td>ユーザーID</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.getUserID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("            <tr><td>ユーザー名</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("            <tr><td>パスワード</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.getPassword()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("            <tr><td>メールアドレス</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.getMail()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("            <tr><td>住所</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.getAddress()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("            <tr><td>総購入金額</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.getTotal()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("            <tr><td>登録日時</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login.getNewDate()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("\n");
      out.write("            <tr><td colspan=\"2\"><h2>このユーザーをマジで削除しますか？</h2></td></tr>\n");
      out.write("            <tr><td>\n");
      out.write("                    <a href=\"MyDeleteResult\">はい</a>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <a href=\"top.jsp\">いいえ</a>\n");
      out.write("                </td></tr>\n");
      out.write("        </table>\n");
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
