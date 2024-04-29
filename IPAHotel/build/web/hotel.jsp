<%-- 
    Document   : hotel
    Created on : 06-Sep-2023, 22:51:51
    Author     : B
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modeli.Soba"%>
<%@page import="modeli.TipSobe"%>
<% 
    ArrayList<Soba> sobe = (ArrayList<Soba>) request.getAttribute("sobe");
    ArrayList<TipSobe> tipovisoba = (ArrayList<TipSobe>) request.getAttribute("tipovisoba");
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
        <h1>ADMINISTRACIJA HOTELA</h1>
         <h2>PRIKAZ SOBA</h2>
        <table>
            <tr>  
                <td> ID </td>
                <td> TIP </td>
                <td> BROJ </td>
                <td> CENA </td>
            </tr>
            <% for (Soba s : sobe) {
            %>
            <tr>  
                <td> <%=s.getIdsobe()%> </td>
                <td> <%=s.getIdtipa()%> </td>
                <td> <%=s.getBrojsobe()%> </td>
                <td> <%=s.getCena()%> </td>
            </tr>
            <%
                }
            %>

        </table>
            
            <h2>DODAVANJE SOBE</h2>
        <form method="POST" action="DodajSobuServlet">
            TIP <input type="text" name="tipsobe"/> <br/>
            BROJ <input type="text" name="broj"/> <br/>
            CENA <input type="text" name="cena"/> <br/>
            <input type="submit" value="UNESI NOVU SOBU"/>
        </form>
            
            <h2>IZMENA SOBE</h2>
        <form method="POST" action="IzmeniSobuServlet">
            ID SOBE <input type="text" name="idsobe"/> <br/>
            ID TIPA <input type="text" name="idtipa"/> <br/>
            CENA <input type="text" name="cena"/> <br/>
            <input type="submit" value="IZMENI SOBU"/>
        </form>
            
             <h2>BRISANJE SOBE</h2>
        <form method="POST" action="ObrisiSobuServlet">
            ID <input type="text" name="idsobe"/> <br/>
            <input type="submit" value="OBRISI SOBU"/>
        </form>
            
            <h2>PRIKAZ TIPOVA SOBA</h2>
        <table>
            <tr>  
                <td> ID </td>
                <td> NAZIV TIPA </td>
            </tr>
            <% for (TipSobe t : tipovisoba) {
            %>
            <tr>  
                <td> <%=t.getIdtipa()%> </td>
                <td> <%=t.getNazivTipa()%> </td>
            </tr>
            <%
                }
            %>

        </table>
            
            <h2>DODAVANJE TIPA</h2>
        <form method="POST" action="DodajTipServlet">
            TIP <input type="text" name="tipsobe"/> <br/>
            HOTEL <input type="text" name="idhotela"/> <br/>
            <input type="submit" value="UNESI NOVI TIP"/>
        </form>
            
            <h2>IZMENA TIPA</h2>
        <form method="POST" action="IzmeniTipServlet">
            ID <input type="text" name="idtipa"/> <br/>
            TIP <input type="text" name="tipsobe"/> <br/>
            <input type="submit" value="IZMENI TIP"/>
        </form>
            
             <h2>BRISANJE TIPA</h2>
        <form method="POST" action="ObrisiTipServlet">
            ID <input type="text" name="idtipa"/> <br/>
            <input type="submit" value="OBRISI TIP"/>
        </form>
            
             <br>
             
             <h3><a href="index.jsp">Povratak na glavnu stranu</a></h3>
    </body>
</html>
