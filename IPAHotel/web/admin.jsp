<%@page import="database.Queries"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modeli.Hotel"%>
<%@page import="modeli.Korisnik"%>
<% 
    Korisnik trenutni = (Korisnik) session.getAttribute("trenutni");
    if(session.getAttribute("trenutni")==null || !trenutni.getTipkorisnika().equals("A")) {RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);}
    ArrayList<Hotel> hoteli = (ArrayList<Hotel>) Queries.getHoteli();
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
        <h1>PRIKAZ HOTELA</h1>
        <table>
            <tr>  
                <td> ID </td>
                <td> NAZIV </td>
                <td> MESTO </td>
            </tr>
            <% for (Hotel h : hoteli) {
            %>
            <tr>  
                <td> <%=h.getId()%> </td>
                <td> <%=h.getNaziv()%> </td>
                <td> <%=h.getLokacija()%> </td>
            </tr>
            <%
                }
            %>

        </table>
        
         <h1>DODAVANJE HOTELA</h1>
        <form method="POST" action="DodajHotelServlet">
            NAZIV <input type="text" name="naziv"/> <br/>
            LOKACIJA: <input type="text" name="lokacija"/> <br/>
            <input type="submit" value="UNESI NOVI HOTEL"/>
        </form>
        
        <p style="color:red;"> 
            <%= request.getAttribute("poruka")!=null
            ? request.getAttribute("poruka") : "" %>
        </p>
          <h1>IZMENA HOTELA</h1>
        <form method="POST" action="IzmeniHotelServlet">
            ID <input type="text" name="hotelid"/> <br/>
            NAZIV <input type="text" name="naziv"/> <br/>
            <input type="submit" value="PROMENI HOTEL"/>
        </form>
        
        <p style="color:red;"> 
            <%= request.getAttribute("poruka")!=null
            ? request.getAttribute("poruka") : "" %>
        </p>
        
          <h1>BRISANJE HOTELA</h1>
        <form method="POST" action="ObrisiHotelServlet">
            ID <input type="text" name="idhotel"/> <br/>
            <input type="submit" value="OBRISI HOTEL"/>
        </form>
        
        <p style="color:red;"> 
            <%= request.getAttribute("poruka")!=null
            ? request.getAttribute("poruka") : "" %>
        </p>
        
        <hr>
        
        <h1>PREGLEDAJ HOTEL</h1>
        <form method="POST" action="GetHotelServlet">
            ID HOTELA <input type="text" name="idhotel"/> <br/>
            <input type="submit" value="PREGLEDAJ HOTEL"/>
        </form>
        
        <hr>
        
        <h1>KLIJENTI</h1>
        <form method="POST" action="klijenti.jsp">
            <input type="submit" value="PREGLEDAJ KLIJENTE"/>
        </form>
        
        <br>
             
             <h3><a href="index.jsp">Povratak na glavnu stranu</a></h3>
        
    </body>
</html>
