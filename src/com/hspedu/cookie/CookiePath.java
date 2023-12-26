package com.hspedu.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookiePath", urlPatterns = "/cookiePath")

public class CookiePath extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CookiePath start");

        Cookie cookie = new Cookie("address", "bj");
        Cookie cookie2 = new Cookie("salary", "20000");

        cookie.setPath(request.getContextPath());
        cookie2.setPath(request.getContextPath() + "/aaa");

        response.addCookie(cookie);
        response.addCookie(cookie2);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>设置cookie有效路径成功</h1>");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
