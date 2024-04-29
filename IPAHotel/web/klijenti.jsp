<%@page import="database.Queries"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modeli.Korisnik"%>
<% 
    Korisnik trenutni = (Korisnik) session.getAttribute("trenutni");
    if(!trenutni.getTipkorisnika().equals("A")) {RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);}
    ArrayList<Korisnik> korisnici = (ArrayList<Korisnik>) Queries.getKorisnici();
%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>PRIKAZ KORISNIKA</h1>
        <table>
            <tr>  
                <td> ID </td>
                <td> IME </td>
                <td> PREZIME </td>
                <td> EMAIL </td>
                <td> BODOVI </td>
                <td> TIP KORISNIKA </td>
            </tr>
            <% for (Korisnik k : korisnici) {
            %>
            <tr>  
                <td> <%=k.getId()%> </td>
                <td> <%=k.getIme()%> </td>
                <td> <%=k.getPrezime()%> </td>
                <td> <%=k.getEmail()%> </td>
                <td> <%=k.getBodovi()%> </td>
                <td> <%=k.getTipkorisnika()%> </td>
            </tr>
            <%
                }
            %>
        </table>
            <h1>IZMENA KLIJENTA</h1>
        <form method="POST" action="IzmeniKlijentaServlet">
            ID <input type="text" name="id"/> <br/>
            BODOVI <input type="text" name="bodovi"/> <br/>
            <input type="submit" value="PROMENI BODOVE"/>
        </form>
        
        <p style="color:red;"> 
            <%= request.getAttribute("poruka")!=null
            ? request.getAttribute("poruka") : "" %>
        </p>
        
          <h1>BRISANJE KLIJENTA</h1>
        <form method="POST" action="ObrisiKlijentaServlet">
            ID <input type="text" name="id"/> <br/>
            <input type="submit" value="OBRISI KLIJENTA"/>
        </form>
        
        <p style="color:red;"> 
            <%= request.getAttribute("poruka")!=null
            ? request.getAttribute("poruka") : "" %>
        </p>
        
        <br>
        
        <h3><a href="index.jsp">Povratak na glavnu stranu</a></h3>
    </body>
</html>
