package com.hspedu.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReadCookieByNameServlet", urlPatterns = "/readCookieByName")

public class ReadCookieByNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ReadCookieByNameServlet started");
        Cookie[] cookies = request.getCookies();
        Cookie emailCookie = CookieUtils.readCookieByName("email", cookies);

        if (emailCookie != null) {
            System.out.println("Cookie name = " + emailCookie.getName() + " value = " + emailCookie.getValue());
        } else {
            System.out.println("sorry, no email cookie...");
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        writer.println("<h1>完成读取cookie任务</h1>");

        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
