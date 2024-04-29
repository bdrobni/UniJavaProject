<%-- 
    Document   : uspesnarezervacija
    Created on : 06-Sep-2023, 22:58:17
    Author     : B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>USPESNO STE REZERVISALI SOBU</h1>
        <p>
            <%= request.getAttribute("poruka")!=null
            ? request.getAttribute("poruka") : "" %> <br/>
            <br>
             
             <h3><a href="index.jsp">Povratak na glavnu stranu</a></h3>
        </p>
    </body>
</html>
