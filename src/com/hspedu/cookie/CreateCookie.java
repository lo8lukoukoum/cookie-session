package com.hspedu.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CreateCookie", urlPatterns = "/createCookie")

public class CreateCookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CreateCookie started");

        Cookie cookie = new Cookie("username", "tom");
        Cookie cookie2 = new Cookie("email", "tom@souhu.com");
        response.setContentType("text/html;charset=UTF-8");

        response.addCookie(cookie);
        response.addCookie(cookie2);

        PrintWriter writer = response.getWriter();
        writer.println("<h1>创建cookie成功~");

        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
