package com.hspedu.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CreateSession2", value = "/createSession2")
public class
CreateSession2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CreateSession2 start");

        HttpSession session = request.getSession();
        System.out.println("CreateSession2 sid= " + session.getId());

        session.setMaxInactiveInterval(60);
        session.setAttribute("u", "jack");

        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>创建session成功，设置生命周期60s</h1>");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
