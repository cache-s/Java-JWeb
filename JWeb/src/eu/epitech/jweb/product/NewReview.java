package eu.epitech.jweb.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import eu.epitech.jweb.beans.Review;
import eu.epitech.jweb.beans.User;
import eu.epitech.jweb.db.DatabaseAction;

public class NewReview {
	public static final String ATT_USER_SESSION = "userSession";
	private static final String CONTENT_INPUT = "reviewContent";

	public void create(HttpServletRequest request, int id) {
		DatabaseAction db = new DatabaseAction();
		Review review = new Review();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(ATT_USER_SESSION);
		review.setAuthor(user.getUserName());
		review.setContent(getFromRequest(request, CONTENT_INPUT));
		review.setProductId(id);
		db.addReview(review);
	}

	private static String getFromRequest(HttpServletRequest request, String input) {
		String ret = request.getParameter(input);
		if (ret == null || ret.trim().length() == 0) {
			return null;
		} else {
			return ret.trim();
		}
	}
}