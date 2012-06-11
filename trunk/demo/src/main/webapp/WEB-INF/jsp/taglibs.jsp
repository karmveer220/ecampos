<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/scriptaculous/scriptaculous.js"></script>
<script type="text/javascript" src="js/overlibmws/overlibmws.js"></script>
<script type="text/javascript" src="js/ajaxtags.js"></script>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>

<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/calendar-es.js"></script>
<script type="text/javascript" src="js/calendar-setup.js"></script>

<link type="text/css" rel="stylesheet" href="css/calendar-system.css"></link>
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<link href="css/banner.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/displaytag.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="css/ajaxtags.css" ></link>

<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />

<style type="text/css">
.irgaleria {
	background-image: url("images/icon_galeria.jpg");
	height: 22px;
	display: block;
	width: 104px;
	margin-left: 480px;
	margin-top: 10px;
}
</style>

<script type="text/javascript">
function compare_dates(fecha, fecha2) {
		var xDay = fecha.substring(0, 2);
		var xMonth = fecha.substring(3, 5);
		var xYear = fecha.substring(6, 10);
		var yDay = fecha2.substring(0, 2);
		var yMonth = fecha2.substring(3, 5);
		var yYear = fecha2.substring(6, 10);

		if (xYear > yYear) {
			return (true)
		} else {
			if (xYear == yYear) {
				if (xMonth > yMonth) {
					return (true);
				} else {
					if (xMonth == yMonth) {
						if (xDay > yDay)
							return (true);
						else
							return (false);
					} else
						return (false);
				}
			} else
				return (false);
		}
	}
</script>

<script type="text/javascript">
   nombres_dias = new Array("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado")
   nombres_meses = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")
   fecha_actual = new Date();
   dia_mes = fecha_actual.getDate();		//dia del mes
   strdia_mes = (dia_mes <= 9) ? "0" + dia_mes : dia_mes;
   dia_semana = fecha_actual.getDay();		//dia de la semana
   mes = fecha_actual.getMonth() + 1;
   strmes = (mes <= 9) ? "0" + mes : mes;
   anio = fecha_actual.getYear();
   if (anio < 100) 
	   anio = "19" + anio;
   else if ( ( anio > 100 ) && ( anio < 999 ) ) {	//efecto 2000
      var cadena_anio = new String(anio);
      anio = "20" + cadena_anio.substring(1,3);
   }
</script>

<script type="text/javascript">
	$(document).ready(
			function() {
				$("#firstpane p.menu_head").click(
					function() {
						$(this).css({
							backgroundImage : "url(imgs/flecha-arriba.png)"
						}).next("div.menu_body").slideToggle(300).siblings(
								"div.menu_body").slideUp("slow");
						$(this).siblings().css({
							backgroundImage : "url(imgs/flecha-abajo.png)"
						});
					});

				$("#secondpane p.menu_head").mouseover(
					function() {
						$(this).css({
							backgroundImage : "url(imgs/flecha-arriba.png)"
						}).next("div.menu_body").slideDown(500).siblings(
								"div.menu_body").slideUp("slow");
						$(this).siblings().css({
							backgroundImage : "url(imgs/flecha-arriba.png)"
					});
				});
	});
</script>

<script type="text/javascript">

$(document).ready(function() {

	//Set Default State of each portfolio piece
	$(".paging").show();
	$(".paging a:first").addClass("active");
		
	//Get size of images, how many there are, then determin the size of the image reel.
	var imageWidth = $(".window").width();
	var imageSum = $(".image_reel img").size();
	var imageReelWidth = imageWidth * imageSum;
	
	//Adjust the image reel to its new size
	$(".image_reel").css({'width' : imageReelWidth});
	
	//Paging + Slider Function
	rotate = function(){	
		var triggerID = $active.attr("rel") - 1; //Get number of times to slide
		var image_reelPosition = triggerID * imageWidth; //Determines the distance the image reel needs to slide

		$(".paging a").removeClass('active'); //Remove all active class
		$active.addClass('active'); //Add active class (the $active is declared in the rotateSwitch function)
		
		//Slider Animation
		$(".image_reel").animate({ 
			left: -image_reelPosition
		}, 500 );
		
	}; 
	
	//Rotation + Timing Event
	rotateSwitch = function(){		
		play = setInterval(function(){ //Set timer - this will repeat itself every 3 seconds
			$active = $('.paging a.active').next();
			if ( $active.length === 0) { //If paging reaches the end...
				$active = $('.paging a:first'); //go back to first
			}
			rotate(); //Trigger the paging and slider function
		}, 5000); //Timer speed in milliseconds (3 seconds)
	};
	
	rotateSwitch(); //Run function on launch
	
	//On Hover
	$(".image_reel a").hover(function() {
		clearInterval(play); //Stop the rotation
	}, function() {
		rotateSwitch(); //Resume rotation
	});	
	
	//On Click
	$(".paging a").click(function() {	
		$active = $(this); //Activate the clicked paging
		//Reset Timer
		clearInterval(play); //Stop the rotation
		rotate(); //Trigger rotation immediately
		rotateSwitch(); // Resume rotation
		return false; //Prevent browser jump to link anchor
	});	
	
});
</script>
