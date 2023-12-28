package com.hspedu.session.homework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginCheck", value = "/loginCheck")
public class
LoginCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("666666".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("loginuser", username);


            request.getRequestDispatcher("/manage").forward(request, response);
        } else {
            request.getRequestDispatcher("error.html").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
