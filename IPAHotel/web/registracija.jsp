<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>REGISTRACIJA KORISNIKA</h1>
        <form method="POST" action="RegistracijaServlet">
            IME: <input type="text" name="ime"/> <br/>
            PREZIME: <input type="text" name="prezime"/> <br/>
            EMAIL: <input type="text" name="email"/> <br/><br/>
            SIFRA: <input type="password" name="sifra"/> <br/>
            POTVRDI SIFRU: <input type="password" name="sifra_potvrda"/> <br/>           
            <input type="submit" value="REGISTRUJ KORISNIKA"/>
        </form>
         
         <br>
             
             <h3><a href="index.jsp">Povratak na glavnu stranu</a></h3>
        
        <p style="color:red;"> 
            <%= request.getAttribute("poruka")!=null
            ? request.getAttribute("poruka") : "" %>
        </p>
    </body>
</html>
