package eu.epitech.jweb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.epitech.jweb.beans.Product;
import eu.epitech.jweb.beans.Review;
import eu.epitech.jweb.db.DatabaseAction;
import eu.epitech.jweb.product.LoadProduct;
import eu.epitech.jweb.product.NewReview;

public class Products extends HttpServlet {
	public static final String ATT_PRODUCT = "product";
	public static final String ATT_REVIEW = "reviewsList";
	public static final String URL_REDIRECTION = "http://localhost:8080/JWeb/lightsabers";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseAction db = new DatabaseAction();
		LoadProduct lp = new LoadProduct();
		Product product = lp.load(request);
		List<Review> reviewList = null;
		reviewList = db.getReviews(getCurId(request));
		request.setAttribute(ATT_REVIEW, reviewList);
		request.setAttribute(ATT_PRODUCT, product);
		this.getServletContext().getRequestDispatcher("/WEB-INF/lightsabers.jsp").forward(request, response);
	}

	private int getCurId(HttpServletRequest request) {
		String[] tmp = request.getRequestURL().toString().split("/");
		if (tmp[tmp.length - 1].equals("lightsabers"))
			return 1;
		if (tmp[tmp.length - 1].equals("blasters"))
			return 2;
		if (tmp[tmp.length - 1].equals("spaceships"))
			return 3;
		return 0;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewReview rw = new NewReview();

		if ((request.getParameter("reviewlightsabers")) != null) {
			rw.create(request, 1);
		}
		if ((request.getParameter("reviewblasters")) != null)
			rw.create(request, 2);
		if ((request.getParameter("reviewspaceships")) != null)
			rw.create(request, 3);
		response.sendRedirect(URL_REDIRECTION);
	}
}
