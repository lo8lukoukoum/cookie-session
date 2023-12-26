package com.hspedu.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("LoginServlet start");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        if ("hspedu".equals(username) && "123456".equals(password)) {
            Cookie loginuserCookie = new Cookie("loginuser", username);
            loginuserCookie.setMaxAge(3600 * 24 * 3);
            response.addCookie(loginuserCookie);
            writer.println("<h1>登录OK</h1>");
        } else {
            writer.println("<h1>登录失败</h1>");
        }
        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
