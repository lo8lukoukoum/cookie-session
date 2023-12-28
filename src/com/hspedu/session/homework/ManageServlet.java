package com.hspedu.session.homework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ManageServlet", value = "/manage")
public class ManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("ManageServlet start");

        HttpSession session = request.getSession();
        Object loginuser = session.getValue("loginuser");
        if (loginuser == null) {
//            response.sendRedirect("/cs/userlogin.html");
            response.sendRedirect(request.getContextPath() + "/userlogin.html");
            return;
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println("<h1>用户管理页面</h1>");
            writer.println("欢迎你，管理员：" + loginuser.toString());
            writer.flush();
            writer.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
