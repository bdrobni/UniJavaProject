<%@page import="modeli.Korisnik"%>
<% 
    Korisnik trenutni = (Korisnik) session.getAttribute("trenutni");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Hotel Index</title>
    </head>
    <body>
        <div>
        <h1>DOBRODOŠLI</h1>
        <h3><a href="login.jsp">Prijava</a></h3>
        <h3><a href="registracija.jsp">Registracija</a></h3>
        <h3><a href="user.jsp">Vaš profil</a></h3>
        <h3><a href="rezervacija.jsp">Pregled hotela i rezervacija soba</a></h3>
        <% if(session.getAttribute("trenutni")!=null && trenutni.getTipkorisnika().equals("A")) { %>
        <h3><a href="admin.jsp">Administracija</a></h3>
        <% } %>
        <% if(session.getAttribute("trenutni")!=null && trenutni.getTipkorisnika().equals("M")) { %>
        <h3><a href="GetHotelServlet">Vaš hotel</a></h3>
        <% } %>
        <h3><a href="LogoutServlet">Odjava</a> </h3> 
        </div>
    </body>
</html>
