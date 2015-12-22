package eu.epitech.jweb.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import eu.epitech.jweb.beans.User;
import eu.epitech.jweb.db.DatabaseAction;

public class Administration
{
	private DatabaseAction		db = new DatabaseAction();
	public List<User> getUserslist(HttpServletRequest request)
	{
		return (db.getUsers());
	}

}
