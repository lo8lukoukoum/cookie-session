package com.hspedu.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReadSession", value = "/readSession")
public class ReadSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("ReadSession start");
        HttpSession session = request.getSession();
        Object email = session.getAttribute("email");
        if (email != null) {
            System.out.println("session属性 email= " + (String) email);
        } else {
            System.out.println("session中没有 email属性 ");
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>读取session成功...</h1>");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
