package com.ohgiraffers.chap08redirectlecturesource.section01.othersite.section02.otherservlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/otherservlet")
public class OtherServletRedirectTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("get 요청 정상 수락");
        response.sendRedirect("redirect");/* */
    }


}
