<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Centro"%>

<jsp:include page="/plantillas/cabecera.jsp"></jsp:include>

<% Centro centro = (Centro) request.getAttribute("centro"); 
	if (centro == null ) {
		response.sendRedirect("centros");
	}
%>

<!--  incio del cuerpo de la p�gina -->
<h1>Nuevo Libro</h1>
<form action="centros" method="post">
	<input type="hidden" name="opcion" value="editar" />
	
	<div>
		<label for="codCentro">C�digo Centro: </label>
		<input type="text" name="codCentro" id="codCentro" value="<%=centro.getCodCentro() %>" />
	</div>
	<div>
		<label for="nombre">T�tulo: </label>
		<input type="text" name="nombre" id="nombre" value="<%=centro.getNombre()%>"/>
	</div>
	<div>
		<label for="direccion">Direcci�n: </label>
		<input type="text" name="direccion" id="direccion" value="<%=centro.getDireccion() %>" />
	</div>
	<input type="submit" value="enviar">
</form>




<jsp:include page="/plantillas/pie.jsp"></jsp:include>