package com.hspedu.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReadCookies", urlPatterns = "/readCookies")

public class ReadCookies extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ReadCookies started");

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                System.out.println("Cookie name= " + cookie.getName() + " value= " + cookie.getValue());
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        writer.println("<h1>读取cookie信息成功</h1>");

        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
