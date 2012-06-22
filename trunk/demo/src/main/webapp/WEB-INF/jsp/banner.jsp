<%@page import="pe.gob.mininter.entities.SiminImagen"%>
<%@page import="java.util.List"%>

<% SiminImagen listaBanner1 = (SiminImagen)session.getAttribute("listaBanner1");%>
<% SiminImagen listaBanner2 = (SiminImagen)session.getAttribute("listaBanner2");%>
<% SiminImagen listaBanner3 = (SiminImagen)session.getAttribute("listaBanner3");%>
<% SiminImagen listaBanner4 = (SiminImagen)session.getAttribute("listaBanner4");%>

<div class="container">	
    <div class="folio_block" align="center">
        <div class="main_view" style="padding: 5;">
          <div class="window">	
             <div class="image_reel">
                 <a href="avisosUno.htm"><img alt="<%=listaBanner1.getNaImgNombre() %>" src="img.htm?id=<%=listaBanner1.getCoImgCodigo()%>" width="180" height="160"></a>
                 <a href="avisosDos.htm"><img alt="<%=listaBanner2.getNaImgNombre() %>" src="img.htm?id=<%=listaBanner2.getCoImgCodigo()%>" width="180" height="160"></a>
                 <a href="avisosTres.htm"><img alt="<%=listaBanner3.getNaImgNombre() %>" src="img.htm?id=<%=listaBanner3.getCoImgCodigo()%>" width="180" height="160"></a>
                 <a href="avisosCuatro.htm"><img alt="<%=listaBanner4.getNaImgNombre() %>" src="img.htm?id=<%=listaBanner4.getCoImgCodigo()%>" width="180" height="160"></a>
             </div>
          </div>
          <div style="display: block;" class="paging">
          	<a class="active" href="#" rel="1">1</a>&nbsp;&nbsp;
            <a href="#" rel="2">2</a>&nbsp;&nbsp;
            <a href="#" rel="3">3</a>&nbsp;&nbsp;
            <a href="#" rel="4">4</a>
           
          </div>
      </div>
      <p style="color: rgb(255, 255, 255); margin: 10px 0pt; float: left; width: 100%;">
      	<a href="http://www.sohtanaka.com/web-design/automatic-image-slider-w-css-jquery/" style="color: rgb(255, 255, 255); padding: 10px 0pt;"></a>
      </p>
    </div>	

</div>