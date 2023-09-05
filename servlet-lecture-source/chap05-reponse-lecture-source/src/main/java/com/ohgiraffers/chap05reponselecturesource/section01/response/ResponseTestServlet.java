package com.ohgiraffers.chap05reponselecturesource.section01.response;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*서블릿이 하는 역할은 크게 3가지 이다.
        1. 요청받기 = HTTP method GET/POST 요청에 따라 parameter로 전달 받은 테이터를 꺼내올수 있다.
        2. 비지니스 로직 처리 - DB접속과 CRUD에 대한 로직처리
        3. 응답하게- 문자열로 동적인 웹 (HTML태그) 페이지를 만들고 스트림을 이용해 내보낸다.
        * */


        /*사용자 브라우저에 응답하기 위해서는 HttpServletResponse의 getWriter method로 PrintWriter 인스턴스를 반환받는다
        * PrintWriter는 BufferedWriter와 형제격인 클래스 이지만 더 많은 형태의 생성자를 제공하는 범용성으로 인해 더 많이 사용된다.*/


        /* 문자열을 이용해 사용자에게 내보낼 페이지를 작성한다.*/
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>안녕 servlet response</h1>\n")
                .append("</body>\n")
                .append("</html>");


        /*브라우저로 내보낼 데이터 타입을 응답 헤더에 설정해준다.
        * content-type 헤더의 값은 null이 기본값이며 명시하지 않은 text/plain 으로 설정한다.*/
        System.out.println("dafault response type : " + response.getContentType());

        /*기본값은 text/plain이지만 html태그를 사용하면 요청시 text/html도 응답으로 수락 가능하도록
        * 헤더 설정이 되어있어 자동으로 text/html로 인식한다. 하지만 명시적으로 text/plain으로 설정하게 되면
        * html태그를 태그로 인식하지 않고 문자열로 인식한다.*/

        response.setContentType("text/html");//html태그가 태그로 인식하지 않고 문자열로 인식하게된다.
        /* response 객체 설정이후에 스트림을 가져온다.*/


        /*응답시에도 별도 인코딩 지정이 없을 경우 설정된 인코딩 방식을 따른다.(ISO_8859-1)
        * */
        System.out.println("default response encoding" +response.getCharacterEncoding());

        /*응답할 인코딩 방식이 UTF-8임을 응답 헤더에 설정하면 이를 해석할때 브라우저가 UTF-8로 인식하고 해석한다.*/
        response.setCharacterEncoding("UTF-8");

        /*참고로 위의 두설정을 한번에 처리할수도 있다.*/

        response.setContentType("text/html; charset=UTF-8");

        /*response 객체 설정이후에 스트림을 가져온다.*/
        PrintWriter out = response.getWriter();


        /*스트림을 이용해 내보낸다*/
        out.print(responseBuilder.toString());

        /*버퍼에 잔류한 데이터를 내보낸다.*/
        out.flush();

        /*스트림을 닫아준다.*/
        out.close();


    }


    }

