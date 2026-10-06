package com.zakaria;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.execute")
public class contextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public contextServlet() {
        super();
    }
	private MaFactory factory;

	@Override
	public void init() throws ServletException {
		factory = new MaFactory();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String provonce = request.getServletPath();
		String view = "/Login.jsp";
		
		Action action = factory.getMonAction(provonce);
		
		if (action != null) {
			view = action.perform(request, response);
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
