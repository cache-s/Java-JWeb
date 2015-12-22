package eu.epitech.jweb.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.epitech.jweb.beans.User;

public class AdminFilter implements Filter
{
    public static final String PUBLIC_ACCESS	= "/index.jsp";
    public static final String ATT_SESSION_USER	= "userSession";

	public void init(FilterConfig config) throws ServletException {
	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException
	{
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession();

        if ((session.getAttribute(ATT_SESSION_USER) == null) || (((User)session.getAttribute(ATT_SESSION_USER)).getAdmin().equals("0"))) {
            response.sendRedirect(request.getContextPath() + PUBLIC_ACCESS);
        } else {
            chain.doFilter(request, response);
        }
	}
	public void destroy() {
	}
}
