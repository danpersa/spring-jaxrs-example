<%@page contentType="text/html" pageEncoding="UTF-8" import="org.springframework.web.context.ContextLoader,com.danix.example.spring.jaxrs.frontend.service.IndexService"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Example First Prime Numbers JSP Frontend</title>
    </head>
    <body>
        <h1>Example of first prime numbers JSP Frontend</h1>
        <%
        IndexService svc = (IndexService) ContextLoader.getCurrentWebApplicationContext().getBean(IndexService.class);
        %>
        <p>[GET] You got the next fortune cookie from the REST service:
            <strong><%= svc.getRandomFortuneCookie().getName() %></strong>
        </p>
        <p>[POST] We created a new Fortune Cookie using the REST service and we got the id:
            <strong><%= svc.createFortuneCookie() %></strong>
        </p>
    </body>
</html>
