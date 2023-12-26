package com.hspedu.cookie;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieLive", urlPatterns = "/cookieLive")

public class CookieLive extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("CookieLive started");

        Cookie cookie = new Cookie("job", "java");
        cookie.setMaxAge(60); //cookie survival time

        response.addCookie(cookie); //save cookie to browser

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>设置cookie生命周期成功</h1>");
        writer.flush();
        writer.close();

        //remove cookie
        Cookie[] cookies = request.getCookies(); //get all cookies
        Cookie usernameCookie = CookieUtils.readCookieByName("username", cookies); //get the cookie of username
        if (usernameCookie != null) {
            usernameCookie.setMaxAge(0);
            response.addCookie(usernameCookie); //save again cookie to browser
            System.out.println("find");
        } else {
            System.out.println("没有找到该cookie，无法删除...");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
