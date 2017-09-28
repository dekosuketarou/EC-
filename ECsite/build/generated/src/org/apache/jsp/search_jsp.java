package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Data.ShopDataBeans;
import java.util.ArrayList;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        ");

            ArrayList<ShopDataBeans> AL = (ArrayList<ShopDataBeans>) request.getAttribute("searchResult");

        
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${hit.toString().replace(\"\\\"\",\"\")}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("件の検索結果がありました。</h1>\n");
      out.write("        ");
for (int i = 0; i < AL.size(); i++) {
                ShopDataBeans sdb = AL.get(i);
                String index = String.valueOf(i);
                request.setAttribute(index, sdb);
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <tr><td rowspan=\"2\"><img src=");
      out.print(sdb.getImageURL());
      out.write(" ></td><td><a href=\"Item?index=");
      out.print(index);
      out.write('"');
      out.write('>');
      out.print(sdb.getItem());
      out.write("</a></td></tr>\n");
      out.write("            <tr><td>");
      out.print(sdb.getPrice());
      out.write("円(税込み)</td></tr>\n");
      out.write("        </table>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </body>&itemcode=happyricejapan_kytg10\n");
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
