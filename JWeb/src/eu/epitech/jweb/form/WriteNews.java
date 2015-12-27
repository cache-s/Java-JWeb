package eu.epitech.jweb.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import eu.epitech.jweb.beans.News;
import eu.epitech.jweb.beans.User;
import eu.epitech.jweb.db.DatabaseAction;

public class WriteNews {
	private static final String TITLE_INPUT = "title";
	private static final String CONTENT_INPUT = "newsContent";
	public static final String ATT_USER_SESSION = "userSession";
	
	public void newNews(HttpServletRequest request)
	{
		DatabaseAction db = new DatabaseAction();
		News news = new News();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(ATT_USER_SESSION);
		news.setAuthor(user.getUserName());
		news.setTitle(getFromRequest(request, TITLE_INPUT));
		news.setContent(getFromRequest(request, CONTENT_INPUT));
		db.addNews(news);
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
