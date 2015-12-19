package eu.epitech.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Disconnect extends HttpServlet {
    public static final String URL_REDIRECTION = "http://localhost:8080/JWeb/index";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(URL_REDIRECTION);
    }
}