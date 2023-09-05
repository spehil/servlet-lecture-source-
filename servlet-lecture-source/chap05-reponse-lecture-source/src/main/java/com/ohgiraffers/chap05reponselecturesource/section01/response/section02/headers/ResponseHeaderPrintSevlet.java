package com.ohgiraffers.chap05reponselecturesource.section01.response.section02.headers;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet("/headers")
public class ResponseHeaderPrintSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset= UTF-8");
       // response.setHeader("Refresh","1");

        PrintWriter out = response.getWriter();//출력스트림은 reponse에서 가져옴.

        long currentTime = System.currentTimeMillis();

        out.print("<h1>" + currentTime + "</h1>");

        out.close();//close()를 하면 flush를 해주지 않아도 자동으로 flush해준다.


        Collection<String> responseHeader = response.getHeaderNames();
        Iterator<String> iter = responseHeader.iterator();
        while (iter.hasNext()){
            String headerName = iter.next();
            System.out.println(headerName + " :" +response.getHeader(headerName));


        }




    }




}
