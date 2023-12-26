package com.hspedu.cookie;

import sun.plugin.viewer.LifeCycleManager;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateCookie", urlPatterns = "/updateCookie")

public class UpdateCookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("UpdateCookie started");

        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtils.readCookieByName("email", cookies);

        Cookie UserNameCookie = new Cookie("username", "hahaha");

        if (cookie == null) {
            System.out.println("当前访问 服务端 的浏览器没有该cookie ");
        } else {
            cookie.setValue("hsp-hi");
        }

        System.out.println("======修改后的cookie信息======");
        for (Cookie cookie1 : cookies) {
            System.out.println("cookie name: " + cookie1.getName() + " cookie value: " + cookie1.getValue());
        }

        response.setContentType("text/html;charset=UTF-8");
        if (cookie != null) {
            response.addCookie(cookie);
        }

        if (UserNameCookie != null) {
            response.addCookie(UserNameCookie);
        }

        PrintWriter writer = response.getWriter();
        writer.print("<h1>完成修改cookie的任务~</h1>");

        writer.flush();
        writer.close();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
