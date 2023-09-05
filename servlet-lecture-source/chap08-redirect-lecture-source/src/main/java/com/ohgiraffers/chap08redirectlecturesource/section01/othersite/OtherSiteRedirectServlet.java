package com.ohgiraffers.chap08redirectlecturesource.section01.othersite;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/othersite")
public class OtherSiteRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*a태그로 보냈으니까 get방식인걸 알수있음.*/

        System.out.println("get요청 후 naver사이트로 redirect");
        response.sendRedirect("https://www.naver.com");
    }



}
