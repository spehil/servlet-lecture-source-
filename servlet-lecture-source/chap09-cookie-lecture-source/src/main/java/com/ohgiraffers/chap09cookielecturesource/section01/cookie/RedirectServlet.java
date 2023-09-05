package com.ohgiraffers.chap09cookielecturesource.section01.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        /*redirect는 이 주소값으로 보내달라는 요청이므로 doGet을 사용해야한다.*/

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName : " + firstName);
        System.out.println("lastName : " + lastName);

        /*1.쿠키를 생성한다.
        * 2. 생성한 쿠기의 만료시간을 설정한다.
        * 3. 응답 헤더에 쿠키를 담는다.
        * 4. 응답을 보낸다
        *
        * 쿠키 제약 사항
        *  이름은 ascii 문자만을 사용해야 하며 한번 설정한 이름은 변경 불가
        * 이름에 공백 문자와 일부 특수 문자([] () = , " \ ? @ : ;) 사용불가*/


        /*Cookie라는 타입의 객체 생성
        * 파라미터 쿠키 attribute는 키 value의 형태로 값을 가진다.*/
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);
        /*초 단위의 값을 입력하여 만료시간을 설정한다(하루 만료시간으로 하는 예시)*/
        firstNameCookie.setMaxAge(60 * 60 * 24);
        lastNameCookie.setMaxAge(60 * 60 * 24);

        //응답헤더에 쿠키를 담는다.
        response.addCookie(firstNameCookie);
        response.addCookie(lastNameCookie);


        response.sendRedirect("redirect");


        /*1. request 에서 쿠키 목록을 쿠키 배열 형태로 꺼내온다.
         * 2. 쿠키의 getName과 getValue를 이용해 쿠키에 담긴 값을 사용한다.*/

        Cookie[] cookies = request.getCookies();

        for(Cookie cookie : cookies){
            //key와 value값으로 갖는다.

            //redirect로만 보냈을떄는 정보공유가 안됐는데 cookie를 이용해서는 가능하다!
            if("firstName".equals((cookie.getName()))){

            }else if("lastName".equals(cookie.getName()));
        }

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>your first name is ")
                .append(firstName)
                .append("and last name is ")
                .append(lastName)
                .append("</h1>\n")
                .append("</body>\n")
                .append("</html>");

        response.setContentType("text/html; charset= UTF-8");

        PrintWriter out = response.getWriter();
        out.print(responseBuilder.toString());
        out.close();

        /*쿠키는 텍스트 파일 형태로 클라이언트 컴퓨터에 저장된다
        * 개인PC는 크게 상관없지만 공용 PC등 다른 사용자와 함께 쓰는 PC면 (민감한 정보를 포함하는 경우)보안에 취약하다
        * 따라서 민감한 개인 정보를 취급하는 경우에는 쿠키보다 세션을 이용한다.
        * 세션은 쿠키와 유사한 형태로 Key=value  쌍으로 저장되지반 서버(톰캣)에서 관리되므로 보안에 더 우수하다는 장점을 가진다.*/


    }




}
