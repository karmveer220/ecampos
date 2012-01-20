<%@page import="pe.org.notarios.web.model.Imagenes"%>
<%@page import="java.util.List"%>
<%@ page contentType="application/json" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
[
  
  <%
  	List<Imagenes> lista = (List<Imagenes>)request.getAttribute("limagenes");
    	int status = 0 ; 
    	for(Imagenes img : lista){
   			status++;
   			out.println(status>1 ? "," : "");
   			out.println("{");
   			out.println("\"name\":\"" + img.getNombre() + "\",");
   			out.println("\"size\":\"" + img.getSize() + "\",");
   			out.println("\"url\":\"imgdw.htm?id="+ img.getIdImagen() +"\",");
   			out.println("\"thumbnail_url\":\"imgth.htm?id="+ img.getIdImagen() +"\",");
   			out.println("\"delete_url\":\"del.htm?id="+ img.getIdImagen() +"\",");
   			out.println("\"delete_type\":\"DELETE\"");
   			out.println("}");
   		}
    %>
]