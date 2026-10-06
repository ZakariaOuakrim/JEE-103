package com.zakaria;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Action {

    @Override
    public String perform(HttpServletRequest rq, HttpServletResponse rs) {
        String user = (String) rq.getSession().getAttribute("login");
        rq.getSession().invalidate();
        return "/GoodBye.jsp?login=" + (user != null ? user : "");
    }

}
