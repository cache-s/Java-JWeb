package eu.epitech.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.epitech.jweb.beans.Product;
import eu.epitech.jweb.product.LoadProduct;

public class Products extends HttpServlet
{
	public static final String ATT_PRODUCT	= "product";
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LoadProduct lp = new LoadProduct();
		Product product = lp.load(request);
		request.setAttribute(ATT_PRODUCT, product);
		this.getServletContext().getRequestDispatcher("/WEB-INF/lightsabers.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}
}
