package com.ohgiraffers.chap02servicemethodlecturesource.section01.servicemethod.section01;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServiceMethodTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}



@WebServlet("/request-service")
public class ServiceMethodTestServlet  extends HttpServlet {
    /*나중에 HTTP를 대체할 프로토콜이 존재한다면 HttpServletRequest는 다른 클래스로 대체되어야 한다.
     * 따라서 ServletRequest라는 추상화된 타입으로 사용하고 실제 인스턴스는 HttpServlet Request로 사용하여
     * 나중에 service method의 인자 타입은 변경하지 않고 다른 프로토콜을 사용하는 Request로 변경이 가능하다(다형성)*/



    /*현재 사용되는 프로토콜은 HTTP프로토콜로, HttpServletRequest 타입이다.
    * HttpServletRequesr는 ServletRequesr를 상속 받아 구현했으며, HTTP 프로토콜의 정보를 담고 있으므로
    * 실제 사용시에는 다운 캐스팅해서 사용해야한다.*

    /
     */

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;//다운캐스팅을 해봄
        HttpServletResponse httpRepose = (HttpServletResponse) res;

        /*요청 받은 http 메소드가 어떤 메소드인지 판단한다.*/
        String httpMethod = httpRequest.getMethod();
        /*요청 내용 출력*/
        System.out.println("httpMethod : " + httpMethod);

        if ("GET".equals(httpMethod)) {
            /*GET 요청을 처리할 메소드로 요청과 등답 정보를 전달한다.*/
            doGet(httpRequest, httpRepose);
        } else {
            /*Post 요청을 처리할 메소드로 요청과 응답 정보를 전달한다*/
            doPost(httpRequest, httpRepose);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드호출");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출");
    }
}
