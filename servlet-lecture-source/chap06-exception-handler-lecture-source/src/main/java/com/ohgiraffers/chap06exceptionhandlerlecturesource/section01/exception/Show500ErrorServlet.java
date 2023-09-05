package com.ohgiraffers.chap06exceptionhandlerlecturesource.section01.exception;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show500error")//이 서블릿클래스의 주소를 같게 해서 여러 서버클래스에 등록하면 매핑중복으로 허용되지 않는다.
public class Show500ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(500, "500번에러는 누구잘못? 개발자! 개발자는 누구?? 여러분!!");
/*sendError로 에러를 일으킴*/

    }


}
