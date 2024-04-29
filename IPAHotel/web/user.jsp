<%@page import="java.util.ArrayList"%>
<%@page import="modeli.Korisnik"%>
<%@page import="modeli.Rezervacija"%>
<%@page import="database.Queries"%>
<%     
    Korisnik t = (Korisnik)session.getAttribute("trenutni");
    if(t == null){{RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);}}
    Korisnik trenutni = Queries.getSingleKorisnik(t.getId());
    ArrayList<Rezervacija> rezervacije = Queries.getRezervacijaPoKorisniku(trenutni.getId());
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
        <body>
        <h1>PRIKAZ KORISNIKA</h1>
        <table>
            <tr>  
                <td> ID </td>
                <td> IME </td>
                <td> PREZIME </td>
                <td> EMAIL </td>
                <td> BODOVI </td>
            </tr>
            
            <tr>  
                <td> <%=trenutni.getId()%> </td>
                <td> <%=trenutni.getIme()%> </td>
                <td> <%=trenutni.getPrezime()%> </td>
                <td> <%=trenutni.getEmail()%> </td>
                <td> <%=trenutni.getBodovi()%> </td>
            </tr>
           
        </table>
       
        <h1>VAŠA REZERVACIJA</h1>
         <table>
            <tr>  
                <td> ID </td>
                <td> BROJ SOBE </td>
                <td> DATUM OD </td>
                <td> DATUM DO </td>
            </tr>
       
        <% for (Rezervacija r : rezervacije) {
            %>
            <tr>  
                <td> <%=r.getIdrez() %> </td>
                <td> <%=r.getSifrasobe() %> </td>
                <td> <%=r.getDatumod() %> </td>
                <td> <%=r.getDatumdo() %> </td>
            </tr>
            
         
            <%
                }
            %>
        
          </table>
            
            <h1>OTKAZIVANJE REZERVACIJE</h1>
        <form method="POST" action="OtkaziRezervacijuServlet">
            ID <input type="text" name="idrez"/> <br/>
            <input type="submit" value="OTKAŽI REZERVACIJU"/>
        </form>
                                          
        <p style="color:red;"> 
            <%= request.getAttribute("poruka")!=null
            ? request.getAttribute("poruka") : "" %>
        </p>
        
        <br>
             
             <h3><a href="index.jsp">Povratak na glavnu stranu</a></h3>
    </body>
</html>
