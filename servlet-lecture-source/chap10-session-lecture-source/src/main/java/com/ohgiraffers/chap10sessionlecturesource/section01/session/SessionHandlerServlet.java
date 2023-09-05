package com.ohgiraffers.chap10sessionlecturesource.section01.session;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");



        //session서블릿에서의 firstName과 lastName을 여기 서블릿에서도 사용할수 있도록 해보자!

        /*쿠키의 보안상 단점과 지원하지 않는 브라우저 문제 등으로 상태 유지 매커니즘에 적합하지 않은 경우가 다수 있따.
         * 특히 회원 정보를 이용해서 해당 회원의 로그인 상태를 지속적으로 유지해야 하는 경우가 그렇다
         * 따라서 서버 쪽에서 보다 안전하게 관리되는 세션이라는 인스턴스를 통해 상태 유지 매커니즘을 제공한다.
         * HttpSession은 직접 생성할수는 없고 request에 있는 getSession메소드를 이용해서 리턴 받는다*/

        HttpSession session = request.getSession();

        /*세션은 브라우저당 한개씩 고유한 아이디를 가지고 있는 하나의 인스턴스를 이용한다.
        * 매번 반복 요청시 동일한 session id를 반환한다.*/

        System.out.println("session id : " + session.getId());


        /*세션 강제 만료 기능도 있지만 만료시간을 설정해주는 것이 좋다.
         * 설정 기본 시간은 30분이며 필요에 따라 늘이거나 줄일수 있다.*/

        System.out.println("session default 유지 시간 : " + session.getMaxInactiveInterval());//기본시간을 알려준다.

        session.setMaxInactiveInterval(60*10);//get으로 시간을 변경해줌

        System.out.println("변경 후 유지시간 : " + session.getMaxInactiveInterval());


        /*세션은 redirect를 해도 값을 유지할수 있으므로 , request보다 더 넓은 범위의 공유 영역이라고 표현할수 있다.
         * 세션에 값을 담을때는 setAttribute(String key, Object value)형태로 담을수 있고,
         * 값을 꺼낼때는 key를 통해 getAttribute(key)로 꺼낼수 있다.*/
        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        response.sendRedirect("redirect");




    }
}
