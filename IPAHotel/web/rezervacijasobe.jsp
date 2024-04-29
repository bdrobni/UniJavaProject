
<%@page import="java.util.ArrayList"%>
<%@page import="modeli.Soba"%>
<%@page import="modeli.TipSobe"%>
<%@page import="modeli.Korisnik"%>
<%  
    Korisnik trenutni = (Korisnik) session.getAttribute("trenutni");
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
        <h1>PRIKAZ TIPOVA SOBA</h1>
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
            
        <br>
            
        <h1>PRIKAZ SOBA</h1>
        <table>
            <tr>  
                <td> ID </td>
                <td> TIP </td>
                <td> CENA </td>
            </tr>
            <% for (Soba s : sobe) {
            %>
            <tr>  
                <td> <%=s.getIdsobe()%> </td>
                <td> <%=s.getIdtipa()%> </td>
                <td> <%=s.getCena()%> </td>
            </tr>
            <%
                }
            %>

        </table>
            
            
        <h1>ODABIR SOBE</h1>
        <form method="POST" action="IzaberiSobuServlet">
            ID ZELJENE SOBE <input type="text" name="idsobe"/> <br>
            DATUM POČETKA REZERVACIJE <input type="text" name="datumod"/> <br>
            DATUM KRAJA REZERVACIJE <input type="text" name="datumdo"/> <br>
            TRENUTNI BROJ BODOVA: <%=trenutni.getBodovi()%> <br>
            DA LI ZELITE DA ISKORISTITE BODOVE <br>
            <input type="radio" name="koristibodove" value="yes"/><label for="yes">DA</label> <br> 
            <input type="radio" name="koristibodove" value="no" checked/><label for="no">NE</label> <br>
            <input type="submit" value="IZABERI SOBU"/>
        </form>
            
            <br>
             
             <h3><a href="index.jsp">Povratak na glavnu stranu</a></h3>
    </body>
</html>
