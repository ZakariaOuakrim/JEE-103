package com.zakaria;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Action{

	@Override
	public String perform(HttpServletRequest rq, HttpServletResponse rs) {
		String login = rq.getParameter("login");
		String pass = rq.getParameter("password");
		
		if ("ali".equals(login) && "baba".equals(pass)) {
			rq.getSession().setAttribute("login", login);
			return "/Page1.jsp";
		} else {
			return "/erreur.jsp";
		}
	}

}
