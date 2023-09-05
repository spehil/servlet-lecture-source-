package com.ohgiraffers.chap08redirectlecturesource.section01.othersite.section02.otherservlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*redirect는 이 주소로 다시 요청하라는 의미로 doGet메소드를 이용해서 작성해야한다.*/
        System.out.println("이 서블릿으로 redirect 성공!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>이 서블릿으로 redirect 성공!</h1>")
                .append("</body>\n")
                .append("</html>");


    }
}
