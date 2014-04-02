/*
 * Contador para destruir graficos 
 * Cada vez que se crea el grafico se asigna un id autoincremental 
 * Este contador se incrementa a la vez que se crean los
 * graficos lo cual me permite acceder al grafico actual y destruilo para poder
 * crear uno con los nuevos valores
 */
var cantGrafico = 1;

$(function () {

	// 	aqui todo 
	
});

function ejecutaPorOficinas(){
	
	var tr = "";
	var tr2 = "";
	if( $("#fechaIngreso").val() != '' ||  $("#fechaIngreso2").val() != ''  ){
	
		var url = 'fechaIngreso='+ $("#fechaIngreso").val()+ '&'
				+ 'fechaIngreso2='+ $("#fechaIngreso2").val() ;				
		url = 'consultaPorOficinas.htm?' + url ; 
		$.getJSON( url , function(data) {
			
			// Armo la tabla con los nuevos valores
			$("#myTable").find("tr:gt(0)").remove();
			$("#myTable").find("thead").empty();
			
			tr +="<tr id='fe2'><th>ff </th>";
			tr2 +="<tr id='fe3'>";
			$.each(data.lista, function(i, item) {
				tr += "<th>"+ item.oficina +"</th>" ;
				tr2 += "<td>"+ item.cantidad +"</td>" ;
			});
			tr +="</tr>";
			tr2 +="</tr>";
			
			$("#myTable").find("thead").append( tr );
			$("#myTable").append( tr2);
			
			// Vuelvo a crear el grafico
			jQuery('#gvChartDiv'+cantGrafico).remove();
			cantGrafico++;
			
			//PieChart
			$('#myTable').gvChart({
				chartType: 'PieChart',
				gvSettings: {
				vAxis: {title: 'No de Documentos recibidos'},
				hAxis: {title: 'Oficinas'},
				width: 900,
				height: 300,
				}
				});
			
			
		});
			
	}
	
	
}