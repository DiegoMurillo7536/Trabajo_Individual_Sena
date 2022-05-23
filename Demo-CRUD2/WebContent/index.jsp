<%@page import="java.util.Iterator"%>
<%@page import="com.ecodeup.ciudades.model.Ciudad"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Artículos</title>
</head>
<body>
	<h1>Lista  Artículos</h1>
	<% List <Ciudad> listaCiudades; %>
<%
 try{
	 listaCiudades=(List<Ciudad>) request.getAttribute("lista");
    Iterator<Ciudad> item=listaCiudades.iterator();
%>
	<table>
		<tr>
			<td><a href="CiudadesServlet?action=index" >Ir al menú</a> </td>
		</tr>
	</table>
	
	<table border="1" width="100%">
		<tr>
		 <td> ID</td>
		 <td> CODIGO</td>
		 <td> NOMBRE</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
<% while(item.hasNext()){
         Ciudad ciudad = item.next();
         
      %>
       <tr>
            <th><%= ciudad.getId_ciudad() %></th>
            <th><%= ciudad.getId_departamento_fk()  %></th>
            <th><%= ciudad.getNom_ciudad()  %></th>
          </tr>
          <%}
 }catch(Exception e){
      e.printStackTrace();
 }
%>
		
	</table>
	
</body>
</html>