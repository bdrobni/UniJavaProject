<%-- 
    Document   : login
    Created on : 06-Sep-2023, 22:53:53
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
        <h1>PRIJAVA KORISNIKA</h1>
        <form method="POST" action="LoginServlet">
            EMAIL KORISNIKA: <input type="text" name="email"/> <br/>
            SIFRA: <input type="password" name="sifra"/> <br/>
            <input type="submit" value="Prijava"/>
        </form>
        
        <br>
        
        <h3><a href="index.jsp">Povratak na glavnu stranu</a></h3>

        <p style="color:red;"> 
            <%= request.getAttribute("poruka") != null
                    ? request.getAttribute("poruka") : ""%>
        </p>  
    </body>
</html>
