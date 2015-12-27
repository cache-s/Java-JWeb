package eu.epitech.jweb.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import eu.epitech.jweb.beans.User;
import eu.epitech.jweb.db.DatabaseAction;

public class Administration {
	private DatabaseAction db = new DatabaseAction();

	public List<User> getUserslist(HttpServletRequest request) {
		return (db.getUsers());
	}

	public void execUpdate(HttpServletRequest request, List<User> userList)
	{
		for (User user : userList) {
			if ((request.getParameter("set" + user.getEmail())) != null)
				setAdmin(user.getEmail());
			if ((request.getParameter("unset" + user.getEmail())) != null)
				unsetAdmin(user.getEmail());
		}
	}
	
	public void setAdmin(String user)
	{
		db.modifyAdmin(user, "1");
	}
	
	public void unsetAdmin(String user)
	{
		db.modifyAdmin(user, "0");
	}
}
