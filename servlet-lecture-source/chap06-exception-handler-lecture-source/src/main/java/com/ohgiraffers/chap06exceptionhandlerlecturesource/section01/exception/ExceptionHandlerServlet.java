package com.ohgiraffers.chap06exceptionhandlerlecturesource.section01.exception;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Enumeration<String> attrName = request.getAttributeNames();
        while(attrName.hasMoreElements()) {
            System.out.println(attrName.nextElement());
        }

        String forwardRequestURI = (String) request.getAttribute("javax.servlet.forward.request_uri");
        String contextPath = (String) request.getAttribute("javax.servlet.forward.context_path");
        String servletPath = (String) request.getAttribute("javax.servlet.forward.servlet_path");
        HttpServletMapping mapping = request.getHttpServletMapping();
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String message = (String) request.getAttribute("javax.servlet.error.message");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        String errorRequestURI = (String) request.getAttribute("javax.servlet.error.request_uri");

        System.out.println(forwardRequestURI);
        System.out.println(contextPath);
        System.out.println(servletPath);
        System.out.println(mapping);
        System.out.println(mapping.getServletName());
        System.out.println(mapping.getMatchValue());
        System.out.println(mapping.getPattern());
        System.out.println(mapping.getMappingMatch());
        System.out.println(statusCode);
        System.out.println(message);
        System.out.println(servletName);
        System.out.println(errorRequestURI);

        /*statusCode. message에 대한 내용*/
        /*에러가 발생했을때 톰캣에서 설정한 페이지가 아닌 우리가 설정한페이지로 가도록*/
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>")
                .append(statusCode)
                .append("-")
                .append("</h1>")
                .append(message)
                .append("</body>\n")
                .append("</html>");


        response.setContentType("text/html; charset = UTF-8");
        PrintWriter out = response.getWriter();//응답객체로부터 출력스트림을 가져온다.
        out.print(responseBuilder.toString());
        out.close();
    }
}
