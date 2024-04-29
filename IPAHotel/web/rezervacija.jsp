<%@page import="database.Queries"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modeli.Hotel"%>
<% 
    ArrayList<Hotel> hoteli = Queries.getHoteli();
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
            
             <h2>ODABIR HOTELA</h2>
        <form method="POST" action="GetHotelServlet">
            UNESITE ID HOTELA <input type="text" name="idhotel"/> <br/>
            <input type="submit" value="ODABERITE HOTEL"/>
        </form>
             
             <br>
             
             <h3><a href="index.jsp">Povratak na glavnu stranu</a></h3>
            
    </body>
</html>