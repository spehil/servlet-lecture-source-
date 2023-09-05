package com.ohgiraffers.chap07forward.section01.forward;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* doPost에서 한글값을 가져올때 데이터를 꺼내기전에 인코딩( request.setCharacterEncoding("UTF-8");을 해준다.)*/

        request.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        System.out.println("userId : "+ userId);
        System.out.println("password: "+ password);

        /*404에러가 뜬다면 WebServlet에 주소등록에 작성이 잘못됐는지 확인하고
        * 넘어온값에 대한 출력이 null이면 name속성의 작성이 잘되었는지 확인해주기!*/

        /*비지니스 로직은 성공이라는 가능하에 입력된 아이디를 이용해서 XXX님 환영합니다 라는 메세지를 출력하는 화면*/
        /*=>응답을 위한 전용 서블릿을 만들고 해당 서블릿에서 응답할수 있또록 위임한다.
        요청을 받아주는 서블릿 응답을 받아주는 서블릿으로 둘을 분리해서 작성해준다.*/

        /*어떤 서블릿으로 위임할것인지 대상 서블릿을 지정하는 RequestDispatcher 인스턴스를 경로를 넣어 지정하고
        * forward 메소드로 요청과 응답에 대한 정보를 전달하여 이후 작업을 수행하도록 위임한다.*/



        request.setAttribute("userId",userId);

        RequestDispatcher rd = request.getRequestDispatcher("print");
        rd.forward(request,response);//위임할때 request,response를 보낸다.


    }
}
