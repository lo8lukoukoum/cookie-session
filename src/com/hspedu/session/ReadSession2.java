package com.hspedu.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReadSession2", value = "/readSession2")
public class ReadSession2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ReadSession start");

        HttpSession session = request.getSession();
        System.out.println("ReadSession2 sid= " + session.getId());

        Object u = session.getAttribute("u");

        if (session == null) {
            System.out.println("读取到session属性 u= " + (String) u);
        } else {
            System.out.println("读取不到session属性 u 说明原来的session被销毁");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
