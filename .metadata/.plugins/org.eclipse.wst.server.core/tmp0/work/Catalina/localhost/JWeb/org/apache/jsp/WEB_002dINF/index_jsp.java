/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2015-12-27 20:07:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\" />\r\n");
      out.write("\t\t<title>SaberForge - Index</title>\r\n");
      out.write("\t\t<link href=\"ressources/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"ressources/css/style.css\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t    <link rel=\"stylesheet\" href=\"ressources/css/ui-lightness/jquery-ui-1.9.2.custom.css\">\r\n");
      out.write("\r\n");
      out.write("\t    <script src=\"ressources/js/jquery-1.10.2.js\"></script>\r\n");
      out.write("    \t<script src=\"ressources/js/jquery-ui-1.9.2.custom.js\"></script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"mainIndex\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"position1 col-lg-12\">\r\n");
      out.write("                <div id=\"myCarousel\" class=\"carousel slide\">\r\n");
      out.write("                    <ol class=\"carousel-indicators\">\r\n");
      out.write("                        <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"\"></li>\r\n");
      out.write("                        <li data-target=\"#myCarousel\" data-slide-to=\"1\" class=\"\"></li>\r\n");
      out.write("                        <li data-target=\"#myCarousel\" data-slide-to=\"2\" class=\"active\"></li>\r\n");
      out.write("                    </ol>\r\n");
      out.write("                    <div class=\"carousel-inner\">\r\n");
      out.write("                        <div class=\"item\">\r\n");
      out.write("                            <div class=\"fill slide1\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"item\">\r\n");
      out.write("                            <div class=\"fill slide2\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"item active\">\r\n");
      out.write("                            <div class=\"fill slide3\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"indexLayout\">\r\n");
      out.write("            \t<div class=\"product\">\r\n");
      out.write("            \t\t<a class=\"lightsaber1\" href=\"lightsabers\"></a>\r\n");
      out.write("            \t\t<p>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"lightsaber1Name\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.lightsaber.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("            \t\t\t<span class=\"lightsaber1Description\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.lightsaber.description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("            \t\t\t<span class=\"lightsaber1Price\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.lightsaber.price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" SFC</span>\r\n");
      out.write("            \t\t</p>\r\n");
      out.write("            \t</div>\r\n");
      out.write("\r\n");
      out.write("            \t<div class=\"product\">\r\n");
      out.write("\t\t\t\t\t<a class=\"blaster1\" href=\"blasters\"></a>\r\n");
      out.write("            \t\t<p>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"blaster1Name\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.blaster.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("            \t\t\t<span class=\"blaster1Description\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.blaster.description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("            \t\t\t<span class=\"blaster1Price\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.blaster.price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" SFC</span>\r\n");
      out.write("            \t\t</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("            \t<div class=\"product\">\r\n");
      out.write("\t\t\t\t\t<a class=\"spaceship1\" href=\"spaceships\"></a>\r\n");
      out.write("            \t\t<p>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"spaceship1Name\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.spaceship.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("            \t\t\t<span class=\"spaceship1Description\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.spaceship.description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("            \t\t\t<span class=\"spaceship1Price\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.spaceship.price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" SFC</span>\r\n");
      out.write("            \t\t</p>\r\n");
      out.write("            \t</div>\r\n");
      out.write("            </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"ressources/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$('.carousel').carousel({\r\n");
      out.write("\t\tinterval: 5000\r\n");
      out.write("\t\t})\r\n");
      out.write("\t</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}