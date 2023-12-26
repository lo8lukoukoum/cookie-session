package com.hspedu.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserUIServlet", urlPatterns = "/userUI")

public class UserUIServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserUIServlet started");

        Cookie[] cookies = request.getCookies();
        Cookie loginuserCookie = CookieUtils.readCookieByName("loginuser", cookies);
        String username = null;
        if (loginuserCookie != null) {
            username = loginuserCookie.getValue();
        }else {
            username = "";
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>登录页面</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>用户登录界面</h1>\n" +
                "<form method=\"post\" action=\"/cs/login\">\n" +
                "    用户名:<input type=\"text\" value=\"" + username + "\" name=\"username\"><br><br>\n" +
                "    密码:<input type=\"password\" name=\"password\"><br><br>\n" +
                "    <input type=\"submit\" value=\"登录\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
