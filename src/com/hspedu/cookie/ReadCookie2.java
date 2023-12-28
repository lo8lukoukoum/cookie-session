package com.hspedu.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet(name = "ReadCookie2", value = "/readcookie2")
public class ReadCookie2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ReadCookie2 start");

        Cookie[] cookies = request.getCookies();
        Cookie companyCookie = CookieUtils.readCookieByName("company", cookies);
        String companyVal = companyCookie.getValue();
        System.out.println("CompanyVal= " + companyVal);

        companyVal = URLDecoder.decode(companyVal, "UTF-8");
        System.out.println("解码后 companyVal= " + companyVal);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>读取中文cookie解码成功~</h1>");
        writer.flush();
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
