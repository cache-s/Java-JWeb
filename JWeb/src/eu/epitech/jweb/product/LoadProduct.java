package eu.epitech.jweb.product;

import javax.servlet.http.HttpServletRequest;

import eu.epitech.jweb.beans.Product;
import eu.epitech.jweb.db.DatabaseAction;

public class LoadProduct {
	public Product load(HttpServletRequest request) {
		DatabaseAction db = new DatabaseAction();
		String[] tmp = request.getRequestURL().toString().split("/");
		String cat = tmp[tmp.length - 1];
		Product product = db.getProduct(cat);
		return product;
	}
}
