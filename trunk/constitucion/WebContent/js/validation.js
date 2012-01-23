/****************************
VALIDA TECLA
******************************/
/* realiza el calculo de conversion */
	function pulgadasCentimetros(event,caja,resultado, form ){
		
		var medi = "";
		for (i=0; i < document.forms[0].length; i++){
			if (document.forms[0].elements[i].type=="radio"){
				if (document.forms[0].elements[i].checked){
					medi = document.forms[0].elements[i].value;
				}
			}
		}
		var pulgada = 1;
		var centimetro = 2.54;	
		if(event.keyCode==13 || event.which==13 ){
		  if( document.getElementById(caja) != null){
			if(medi=='cm'){
					str =  "&nbsp;&nbsp;&nbsp;"+ ( document.getElementById(caja).value * centimetro)+"&nbsp;"+medi+"&nbsp;&nbsp;&nbsp;";	
			}else{
				str =  "&nbsp;&nbsp;&nbsp;"+ ( document.getElementById(caja).value / centimetro)+"&nbsp;"+medi+"&nbsp;&nbsp;&nbsp;";
			}
			
			
			document.getElementById(resultado).innerHTML = str ;
			document.getElementById(resultado).style.display='inline';
		  }
	   }
		
		return false;
	}
/* Firefox necesita recibir como parametro el objeto event,en cambio IE no lo necesita
 * function enter(event){
 *   var tecla; 
 *   if(navigator.appName.indexOf("Netscape") != -1)
 *       tecla= event.which; //esto es para firefox y demas
 *   else 
 *   	tecla= event.keyCode; //solo para IE
 * 
 */
        function validatecla(event,tipo,textbox){
        	
        	
        	
            var tecla; 
            if(navigator.appName.indexOf("Netscape")!= -1){
                tecla= event.which;    
            }else{
                tecla= event.keyCode;
            }

            var key = String.fromCharCode(tecla);
            
            /*---Mayuscula---*/
            key = key.toUpperCase();
            
            var telefonos = "-/#";
            var numeros = "0123456789";
            var especiales="'#ï¿½()_;:ï¿½[]{}!ï¿½/?ï¿½``ï¿½ï¿½+ï¿½=&%$*";
            var letras = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnÃ‘n??OoPpQqRrSsTtUuVvWwXxYyZz??????????";
            
            //if ( tecla == 127) return true; Esta validacion es para que acepte tecla suprimir
            //if ( tecla == 8) return true; Esta validacion es para que acepte tecla Retroceso
            //if ( tecla == 32 ) return true; Esta validacion es para que acepte espacios
         
            if ( tecla == 8 ) return true;
            if ( tecla == 127 ) return true;
            if ( tecla == 0 ) return true;
            
            
            if (tipo == 'letras'){
               if ( tecla == 32 ) return true;
               if ( letras.indexOf( key ) != -1 ) return true; 
               return false;
            }

            if (tipo == 'enteros'){
            	
                if ( numeros.indexOf( key ) != -1   ) return true;
                return false; 
            }

            if (tipo == 'ruc'){            	
                if ( numeros.indexOf( key ) != -1   ){
                	return true;
                }
                //TODO: agregar mas validaciones
                return false; 
            }
            
           if (tipo == 'decimales'){
               if ( numeros.indexOf( key ) != -1 ) return true;
               var cadena = textbox.value;
               if ( cadena.indexOf( '.' ) != -1 ) return false; 
               if ( tecla == 46 ) return true;
               return false; 
           }
           
           if (tipo == 'decimales2'){
        	   
               if ( numeros.indexOf( key ) != -1 ){            	  
            	   if(textbox.value.length == 5){            		   
                       if ( textbox.value.indexOf( '.' ) == -1 ){	                	  
	                	   textbox.value = textbox.value + '.';
                       }
            	   }
            	   
            	   return true;
               }   
            	   
               var cadena = textbox.value;
               if ( cadena.indexOf( '.' ) != -1 ) return false; 
               if ( tecla == 46 ) return true;
               
               return false; 
           }
           
           if (tipo == 'decimales3'){
        	   
               if ( numeros.indexOf( key ) != -1 ){            	  
            	   if(textbox.value.length == 6){            		  
                       if ( textbox.value.indexOf( '.' ) == -1 ){	                	   
	                	   textbox.value = textbox.value + '.';
                       }
            	   }
            	   
            	   return true;
               }   
            	   
               var cadena = textbox.value;
               if ( cadena.indexOf( '.' ) != -1 ) return false; 
               if ( tecla == 46 ) return true;
               
               return false; 
           }
        
           if (tipo == 'docoficial'){
               if ( numeros.indexOf( key ) != -1 ) return true;
               var cadena = textbox.value;
               if ( cadena.indexOf( '-' ) != -1 ) return true; 
               if ( tecla == 46 ) return true;
               return false; 
           }
           
             if (tipo == 'NoNumeros'){
                if ( tecla == 32 ) return true;  
                if ( numeros.indexOf( key ) != -1 || especiales.indexOf( key ) != -1 ) return false; 
                return true;
            }

            if (tipo == 'especiales'){
                if ( tecla == 32 ) return true;  
                if ( especiales.indexOf( key ) != -1 ) return false; 
                return true;
            }
            
            if (tipo == 'num_letras'){
                if ( tecla == 32 ) return true;  
                if ( numeros.indexOf( key ) != -1 || letras.indexOf( key ) != -1 ) return true; 
                return false;
            }

            if (tipo == 'telefonos'){
            	if ( tecla == 32 ) return true;
                if ( numeros.indexOf( key ) != -1 || telefonos.indexOf( key ) != -1 ) return true;
                return false; 
            }
            
            if (tipo == 'todo'){
                if ( tecla == 32 ) return true;  
                if ( numeros.indexOf( key ) != -1 || especiales.indexOf( key ) != -1 || letras.indexOf( key ) != -1 ) return false; 
                return true;
            }
            
            

  }



/****************************
ENTER => Submit Form
******************************/
function enter(form_name){
    var tecla; 
    if(navigator.appName.indexOf("Netscape") != -1)
        tecla= event.which; 
    else tecla= event.keyCode;
	var key = String.fromCharCode(tecla);
    if (tecla== 13){	
          document.forms[form_name].submit();
    }            	
}

/****************************
ENTER => Next Element
******************************/
function isEnter(nextTab){
    if(event.keyCode==13){
		if(null!=document.all[nextTab])
			document.all[nextTab].focus();
    }
}
/****************************
VALIDA BLANCOS
******************************/
function trim ( inputStringTrim ){ 
        fixedTrim = ""; 
        lastCh = " "; 
        for (x=0; x < inputStringTrim.length; x++){ 
            ch = inputStringTrim.charAt(x); 
            if ((ch != " ") || (lastCh != " ")){ 
                    fixedTrim += ch;        
            } 
            lastCh = ch; 
        } 
        if (fixedTrim.charAt(fixedTrim.length - 1) == " "){ 
            fixedTrim = fixedTrim.substring(0, fixedTrim.length - 1); 
        } 
        return fixedTrim ;
} 

/****************************
MAXIMISAR PANTALLA
******************************/
function maximize(){
  if (window.screen) {
    var aw = screen.availWidth;
    var ah = screen.availHeight;
    window.moveTo(0, 0);
    window.resizeTo(aw, ah);
  }
}

function maximizeParent(){
  if (parent.window.screen) {
    var aw = screen.availWidth;
    var ah = screen.availHeight;
    parent.window.moveTo(0, 0);
    parent.window.resizeTo(aw, ah);
  }
}


function heightScreen(){
	return window.screen.height;
}

function widthScreen(){
	return window.screen.width;
}

function maximize(){
  if (window.screen) {
    var aw = screen.availWidth;
    var ah = screen.availHeight;
    window.moveTo(0, 0);
    window.resizeTo(aw, ah);
  }
}

function maximizeParent(){
  if (parent.window.screen) {
    var aw = screen.availWidth;
    var ah = screen.availHeight;
    parent.window.moveTo(0, 0);
    parent.window.resizeTo(aw, ah);
  }
}

function submitEnter(objeto,evento){
	var keycode;
	if (window.event) keycode = window.event.keyCode;
	else if (evento) keycode = evento.which;
		else return true;

	if (keycode == 13){
		objeto.form.submit();
		return false;
	} else 
		return true;
}

function submitEnter1(form_name,metodo){
    var keycode;
    if (window.event) keycode = window.event.keyCode;
    if (keycode == 13){

    document.forms[form_name].method.value = metodo;
    document.forms[form_name].submit();

    return false;	

    } else 
    return true;
} 

function convertirMayusculas(event){
	
	var caracter = String.fromCharCode(event.keyCode);
	caracter = caracter.toUpperCase();
	event.keyCode = caracter.charCodeAt(0);

	return true;	
}

/*
 Estilo puede ser: 0.- Indistinto (Default); 1.- Mayusculas; 2.- Minusculas
*/
function soloLetras(objeto,keyCode,estilo){
	if(estilo == null) estilo = 0;
	if(estilo < 0) estilo = 0;
	if(estilo > 2) estilo = 0;

	var retornar = true;
    switch(keyCode){
	    case 8: break;
	    default:
			var caracter = String.fromCharCode(keyCode);
			caracter = caracter.toUpperCase();
			var ascii = caracter.charCodeAt(0);
	        if((ascii >= 65 && ascii <= 90) || ascii == 209 || ascii == 32){
	            if(estilo != 1){
	            	if(estilo == 2){
	            	    caracter = caracter.toLowerCase();
	            	} else {
	            	    caracter = String.fromCharCode(keyCode);
	            	}
	            }
	            retornar = true;
	        } else {
				caracter = '';
	        	retornar = false;
	        }
    }
    event.keyCode = caracter.charCodeAt(0);
    //objeto.value += (typeof(caracter) == 'string')?caracter:'';
    return retornar;
}

function permitirSoloLetras(e){
	tecla = (document.all) ? e.keyCode : e.which;	
    if (tecla==8) return true; //Tecla de retroceso (para poder borrar)
    patron =/[A-Z a-z]/; // Solo acepta letras
    te = String.fromCharCode(tecla);
    return patron.test(te);
}

function soloNumeros(valor,keyCode,decimal){
	if(decimal == null) decimal = false;
    switch(keyCode){
	    case 8: break;
	    default:
			var caracter = String.fromCharCode(keyCode);
			var numeros  = ".1234567890";
			var indice = numeros.indexOf(caracter);
			if(indice == -1){
				return false;
			} else {
				indice = valor.indexOf('.');
				if((caracter == '.' && !decimal) || (caracter == '.' && decimal && indice > 0)){
					return false;
				} else {
					return true;
				}
			}
	}
}


function soloFecha(valor,keyCode,decimal){
	if(decimal == null) decimal = false;
    switch(keyCode){
	    case 8: break;
	    default:
			var caracter = String.fromCharCode(keyCode);
			var numeros  = "/1234567890";
			var indice = numeros.indexOf(caracter);
			if(indice == -1){
				return false;
			} else {
				indice = valor.indexOf('/');
				var indice2= valor.lastIndexOf('/');
				if((caracter == '/' && !decimal) || (caracter == '/' && decimal && indice != indice2)){
					return false;
				} else {
					return true;
				}
			}
	}
}

function esEntero(numero){
	tokens = StringTokenizer(numero, '.');
	if (tokens.length > 1){
		return false;
	}
	return true;
}

function validaDecimal(numero, dec){
	tokens = StringTokenizer(numero, '.');
	if ( tokens.length>1 ){
		if ( !(tokens[tokens.length-1].length > 0 && tokens[tokens.length-1].length <= dec) ){
			return false;
		}
	}
	return true;
}

function esDecimal(valor){
	var pattern = "/\\b(^(\\d+)(\\.\\d+)$)\\b/gi";
	var rpt = valor.match(eval(pattern));
	if (!rpt) {
 		return false;
	} else {
 		return true;
	}
}

function validacorreo(caja) {
	var myString = caja.value;
	var newString = myString.match(/\b(^(\S+@).+((\.gob)|(\.com)|(\.net)|(\.edu)|(\.mil)|(\.gov)|(\.org)|(\..{2,2}))$)\b/gi);
	if (!newString) {
		alert('Correo mal formado. Debe tener la forma: ejemplo@dominio.com');
 		return false;
	} else {
 		return true;
	}
}

/*
  Recibe el nombre del archivo y la extension a validar
  Retorna un True o False dependiendo si el nombre el valido o No
*/
function validanombrearchivo(nombre, ext){
  var pattern = "/\\b(^(((\\S)|(\\s))+)(\\."+ext+")$)\\b/gi";
	var rpt = nombre.match(eval(pattern));
	if (!rpt) {
 		return false;
	}	else {
 		return true;
	}
}

/*
  Recibe una cadena y la separa basado en el caracter de la variable delim.
  Retorna un Array de cadenas
*/
function StringTokenizer(cad, delim){
  var cads = new Array();
  var n = cad.length;
  var j = 0;
  var ic = 0;
  for (i=0;i<n;i++){
    if ( cad.charAt(i)==delim ){
      cads[j] = cad.substring(ic, i);
      ic = i+1;
      j++;
    }
  }
  cads[j] = cad.substring(ic, n);
  return cads;
}

/*
  Retorna el mes en Letras
  Donde mes es el numero del mes en el rango 1 hasta al 12
        may 1 o 0 para MAYUSCULAS o minusculas
        cap 1 o 0 para poner en mayusculas la primera letra o no
*/
function mesenletras(mes, may, cap){
	var imes = parseInt(mes, 10);
	var tmes = "-";
	if ( imes == 1 ){
		tmes = "enero";
	} else if ( imes == 2 ){
		tmes = "febrero";
	} else if ( imes == 3 ){
		tmes = "marzo";
	} else if ( imes == 4 ){
		tmes = "abril";
	} else if ( imes == 5 ){
		tmes = "mayo";
	} else if ( imes == 6 ){
    	tmes = "junio";
	} else if ( imes == 7 ){
    	tmes = "julio";
	} else if ( imes == 8 ){
    	tmes = "agosto";
	} else if ( imes == 9 ){
    	tmes = "setiembre";
	} else if ( imes == 10 ){
    	tmes = "octubre";
	} else if ( imes == 11 ){
    	tmes = "noviembre";
	} else if ( imes == 12 ){
    	tmes = "diciembre";
	}

	if ( may == 1){
    	tmes = tmes.toUpperCase();
	}

	if ( cap == 1){
    	tmes = tmes.substring(0,1).toUpperCase() + tmes.substring(1, tmes.length);
	}

	return tmes;
}

/*
  Retorna
   -1: en caso de errores de formatos
    1: en caso de que fecha1 sea mayor a la fecha2
    2: en caso de que fecha1 sea menor a la fecha2
    0: en caso de que fecha1 sea igual a la fecha2
*/
function comparafecha(fecha1, fecha2){
  if ( !checkdate(fecha1) || !checkdate(fecha2) ){
    return -1;
  }
  dia = fecha1.substring(0,2); //dia
  mes = fecha1.substring(3,5); //mes
  anho = fecha1.substring(6,10); //anho
  fecha1x = anho + mes + dia;

  dia = fecha2.substring(0,2); //dia
  mes = fecha2.substring(3,5); //mes
  anho = fecha2.substring(6,10); //anho
  fecha2x = anho + mes + dia;
  
  if ( fecha1x > fecha2x ){
    return 1;
  } else if ( fecha1x < fecha2x ){
    return 2;
  } else {
    return 0;
  }
}

function nada(){
}

function corta(campo, longitud, cars) {
  if (campo.value.length>longitud)
   campo.value=campo.value.substring(0,longitud);
  cuenta(campo, cars);
}

function cuenta(campo, cars) {
  cars.value=campo.value.length;
}

/*
*/
function rellena(dato, caracter, tamanho){
  dato_trim = trim(dato);
  len = dato_trim.length;
  dato_fill = "";
  for (var i=0;i<tamanho-len;i++){
    dato_fill = dato_fill + caracter;
  }
  dato_fill = dato_fill + dato_trim;
  return dato_fill;
}

/*
-------------------------------
Validacion de fecha
-------------------------------
-------------------------------
*/

function checkdate(fecha){
  var err=0;
  if (fecha.length != 10) err=1;
  dia = fecha.substring(0,2); //dia
  slash1 = fecha.substring(2,3); // '/'
  mes = fecha.substring(3,5); //mes
  slash2 = fecha.substring(5,6); // '/'
  anho = fecha.substring(6,10); //anho

  // chequeo de errores basicos
  if ( dia<1 || dia>31) err = 1;
  if ( slash1 != '/' ) err = 1;
  if ( mes<1 || mes>12) err = 1;
  if ( slash1 == '/' && slash2 != '/' ) err = 1;
  if ( anho < 1900 || anho > 2100 ) err = 1;

  // verificacion avanzada
  // meses con 30 dias
  if ( mes == 4 || mes == 6 || mes == 9 || mes == 11 ){
    if (dia==31) err=1;
  }
  // febrero
  if (mes == 2){
    var g = parseInt(anho/4);
    if (isNaN(g)){
      err = 1;
    }
    if (dia >29) err =1;
    if (dia ==29 && ((anho/4)!=parseInt(anho/4))) err=1;
  }
  if (err==1){
    return false;
  } else {
    return true;
  }
}


/*
-------------------------------
Validacion de fecha
-------------------------------
-------------------------------
*/

function IsNumeric(valor) 
{ 
var log=valor.length; var sw="S"; 
for (x=0; x<log; x++) 
{ v1=valor.substr(x,1); 
v2 = parseInt(v1); 
//Compruebo si es un valor numérico 
if (isNaN(v2)) { sw= "N";} 
} 
if (sw=="S") {return true;} else {return false; } 
} 

function largofecha(fecha,campo)
{ 
    var long = fecha.length; 
    if (long<10) 
    {
     alert('El tamaño de la fecha de ' + campo + ' es de 10 caracteres');
     return -1;
    }
}

var primerslap=false; 
var segundoslap=false; 

function formateafecha(fecha) 
{
var long = fecha.length; 
var dia; 
var mes; 
var ano; 

if ((long>=2) && (primerslap==false)) { dia=fecha.substr(0,2); 
if ((IsNumeric(dia)==true) && (dia<=31) && (dia!="00")) { fecha=fecha.substr(0,2)+"/"+fecha.substr(3,7); primerslap=true; } 
else { fecha=""; primerslap=false;} 
} 
else 
{ dia=fecha.substr(0,1); 
if (IsNumeric(dia)==false) 
{fecha="";} 
if ((long<=2) && (primerslap=true)) {fecha=fecha.substr(0,1); primerslap=false; } 
} 
if ((long>=5) && (segundoslap==false)) 
{ mes=fecha.substr(3,2); 
if ((IsNumeric(mes)==true) &&(mes<=12) && (mes!="00")) { fecha=fecha.substr(0,5)+"/"+fecha.substr(6,4); segundoslap=true; } 
else { fecha=fecha.substr(0,3);; segundoslap=false;} 
} 
else { if ((long<=5) && (segundoslap=true)) { fecha=fecha.substr(0,4); segundoslap=false; } } 
if (long>=7) 
{ ano=fecha.substr(6,4); 
if (IsNumeric(ano)==false) { fecha=fecha.substr(0,6); } 
else { if (long==10){ if ((ano==0) || (ano<1900) || (ano>2100)) { fecha=fecha.substr(0,6); } } } 
} 

if (long>=10) 
{ 
fecha=fecha.substr(0,10); 
dia=fecha.substr(0,2); 
mes=fecha.substr(3,2); 
ano=fecha.substr(6,4); 
// Año no viciesto y es febrero y el dia es mayor a 28 
if ( (ano%4 != 0) && (mes ==02) && (dia > 28) ) { fecha=fecha.substr(0,2)+"/"; } 
if ( mes == 4 || mes == 6 || mes == 9 || mes == 11 ){ if (dia==31) fecha=fecha.substr(0,2)+"/"; }
} 
return (fecha); 
}   

/*-------------------------------*/


function esnulo(campo){
	return (campo == null||campo=="");
}

function esnulooguion(campo){
  return esnulo(campo) || ( trim( campo ) == "-" );
}

function esnumero(campo){
	return (!(isNaN( campo )));
}

function longitudcorrecta( campo, len ){
  if ( campo != null ){
    if ( campo.length == len ){
      return true;
    } else {
      return false;
    }
  } else {
    return false;
  } 
}

function mayuscula(campo){
  return campo.toUpperCase();
}
function minuscula(campo){
  return campo.toLowerCase();
}
function eslongdniok(dni){
  if ( dni.length == 8 ){
    return true;
  } else {
    return false;
  }
}

function eslongrucok(ruc){
  if ( ruc.length == 11 ){
    return true;
  } else {
    return false;
  }
}
function esLongContrasenhaOk(contrasenha){
  if ( contrasenha.length < longcontrasenhaok() ){
    return false;
  } else {
    return true;
  }
}
function longContrasenhaOk(){
  return 6;
}
function esNegativo(valor){
  if (valor < 0){
    return true;
  } else {
    return false;
  }
}

function esdniok(dni){
  return (!(esnulo(dni) || !esnumero(dni) || !eslongdniok(dni)));
}

function esrucok(ruc){
  return (!( esnulo(ruc) || !esnumero(ruc) || !eslongrucok(ruc) || !valruc(ruc) ));
}
function valruc(valor){
  valor = trim(valor);
  if ( esnumero( valor ) ) {
    if ( valor.length == 8 ){
      suma = 0;
      for (i=0; i<valor.length-1;i++){
        digito = valor.charAt(i) - '0';
        if ( i==0 ) suma += (digito*2);
        else suma += (digito*(valor.length-i));
      }
      resto = suma % 11;
      if ( resto == 1) resto = 11;
      if ( resto + ( valor.charAt( valor.length-1 ) - '0' ) == 11 ){
        return true;
      }
    } else if ( valor.length == 11 ){
      suma = 0;
      x = 6;
      for (i=0; i<valor.length-1;i++){
        if ( i == 4 ) x = 8;
        digito = valor.charAt(i) - '0';
        x--;
        if ( i==0 ) suma += (digito*x);
        else suma += (digito*x);
      }
      resto = suma % 11;
      resto = 11 - resto;
      
      if ( resto >= 10) resto = resto - 10;
      if ( resto == valor.charAt( valor.length-1 ) - '0' ){
        return true;
      }      
    }
  }
  return false;
}

function longitudMayor( campo, len ){
  if ( campo != null ){
    if ( campo.length > len ){
      return true;
    } else {
      return false;
    }
  } else {
    return false;
  } 
}

function estaEntre(campo, inicio, fin){
  if ( campo != null ){
    if ( campo.length >= inicio && campo.length <= fin ){
      return true;
    } else {
      return false;
    }
  } else {
    return false;
  }
}

function MO(e){
	if(!e)
	var e=window.event;
	var S=e.srcElement;
	while (S.tagName!="TD"){
		S=S.parentElement;
	}
	S.className="boxMenuOn";
}

function MU(e){
	if(!e)
	var e=window.event;
	var S=e.srcElement;
	while (S.tagName!="TD"){
		S=S.parentElement;
	}
	S.className="boxMenuOff";
}

function imagenBody()	{
	var capaFondo = document.getElementById("fondo").style;
	var ancho = document.body.clientWidth;
	var alto =  document.body.clientHeight;
	capaFondo.width = ancho;
	capaFondo.height = alto;
}

/*
var sorry="SUNAT - Derechos Reservados© 2001"
function click(e){
   if (document.all){
      if (event.button == 2){
         alert(sorry);
         return false;
      }
   }
   if (document.layers){
      if (e.which == 3){
         alert(sorry);
         return false;
      }
   }
}
if (document.layers){
   document.captureEvents(Event.MOUSEDOWN);
}
document.onmousedown=click;
function abreventana(i, j) {
  window.open(i, j, "toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=yes,resizable=yes,copyhistory=0,width=600,height=450")
}
/*
impresion 
*/
var da = (document.all) ? 1 : 0;
var pr = (window.print) ? 1 : 0;
var mac = (navigator.userAgent.indexOf("Mac") != -1); 


function printNoPrompt(objeto){
	if((navigator.appName == "Netscape")){
		objeto.print(); 
	} else {
		var WebBrowser = '<OBJECT ID="WebBrowser1" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></OBJECT>'; 
		document.body.insertAdjacentHTML('beforeEnd', WebBrowser); WebBrowser1.ExecWB(6, -1); WebBrowser1.outerHTML = "";
	}
}

function printPage(frame, arg) {
  if (frame == window) {
    printThis();
  } else {
    link = arg; // variable global 
    printFrame(frame);
  }
  return false;
}

function printThis() {
  if (pr) { // NS4, IE5
    window.print();
  } else if (da && !mac) { // IE4 (Windows)
    vbPrintPage();
  } else { // other browsers
    alert("Disculpe, su browser no soporta esta aplicacion.");
  }
}

function trim(cadena){
  cadena2 = "";
  len = cadena.length;
  for ( var i=0; i <= len ; i++ ){
  	if ( cadena.charAt(i) != " " ){
	  cadena2 = cadena2 + cadena.charAt(i);
	}
  }
  return cadena2;
}

function printFrame(frame) {
  if (pr && da) { // IE5
    frame.focus();
    window.print();
    link.focus();
  } else if (pr) { // NS4
    frame.print();
  } else if (da && !mac) { // IE4 (Windows)
    frame.focus();
    setTimeout("vbPrintPage(); link.focus();", 100);
  } else { // other browsers
    alert("Disculpe, su browser no soporta esta aplicaci&oacute;n.");
  }
}

if (da && !pr && !mac) with (document) {
  writeln('<OBJECT ID="WB" WIDTH="0" HEIGHT="0" CLASSID="clsid:8856F961-340A-11D0-A96B-00C04FD705A2"></OBJECT>');
  writeln('<' + 'SCRIPT LANGUAGE="VBScript">');
  writeln('Sub window_onunload');
  writeln('  On Error Resume Next');
  writeln('  Set WB = nothing');
  writeln('End Sub');
  writeln('Sub vbPrintPage');
  writeln('  OLECMDID_PRINT = 6');
  writeln('  OLECMDEXECOPT_DONTPROMPTUSER = 2');
  writeln('  OLECMDEXECOPT_PROMPTUSER = 1');
  writeln('  On Error Resume Next');
  writeln('  WB.ExecWB OLECMDID_PRINT, OLECMDEXECOPT_DONTPROMPTUSER');
  writeln('End Sub');
  writeln('<' + '/SCRIPT>');
}


/*
*************************************************************************************************************
*/

var wPopUp = null;

function posicionar_popup(ancho,alto,posicion,scrolls,redimensionable,statusbar){
	if(scrolls == null) scrolls = 'no';
	if(redimensionable == null) redimensionable = 'no';
	if(statusbar == null) statusbar = 'yes';
	
	if(posicion=='random'){
		LeftPosition=(screen.width)?Math.floor(Math.random()*(screen.width-ancho)):100;
		TopPosition=(screen.height)?Math.floor(Math.random()*((screen.height-alto)-75)):100;
	} else if(posicion=='maximize'){
		LeftPosition=0; 
		TopPosition=0;
	} else if(posicion=='modal'){
		LeftPosition=(screen.width)?(screen.width-ancho)/2:100; 
		TopPosition=(screen.height)?(screen.height-alto)/2:100;
		var configuracion = 'center=yes;dialogWidth='+ ancho + 'px;dialogHeight='+ alto + 'px;dialogTop=' + TopPosition + 'px;dialogLeft=' + LeftPosition + 'px;help=no;maximize=no;minimize=no';
		return configuracion;
	} else if(posicion=='center'){
		LeftPosition=(screen.width)?(screen.width-ancho)/2:100; 
		TopPosition=(screen.height)?(screen.height-alto)/2:100;
	} else if((posicion!='center' && posicion!='random') || posicion==null){
		LeftPosition=100;
		TopPosition=100;
	}
	statusbar = 'yes';
	//showModalDialog("",null,"dialogWidth:456px;dialogHeight:140px;resizable:yes;scroll:no;center:yes;resizeable:no;status:no;help:no");
	var configuracion = 'width='+ ancho + ',height='+ alto + ',top=' + TopPosition + ',left=' + LeftPosition + ',location=no,directories=no,menubar=no,toolbar=no,status=' + statusbar + ',scrollbars=' + scrolls + ',resizable=' + redimensionable; 
//	var configuracion = "dialogWidth:456px;dialogHeight:140px;resizable:yes;scroll:no;center:yes;resizeable:no;status:no;help:no"; 
	return configuracion;
}

function diferenciaDias(fini,ffin){
	var dias = 0;
	if(checkdate(fini) && checkdate(ffin)){
		var x = str2dt(fini);
		var y = str2dt(ffin);
		var mili = (y.getTime() - x.getTime());
		dias = parseInt(mili / (1000*60*60*24));
	}
	
	return dias;
}

function incrementafecha(fecha,dias){
	var nueva = "";
	if(!checkdate(fecha)){
		return nueva;
	}
	
	if(eval(dias) == 0){
		return nueva;
	} else {
		fecha = str2dt(fecha);
		var mili = fecha.getTime();
		dias = eval(dias * (1000*60*60*24));
		var nueva = new Date();
		nueva.setTime(mili + dias);
		nueva=dt2dtstr(nueva);
		return nueva;
	}
}

function fechaenrango(fecha,fechamin,fechamax){
	var rpta = false;
	if((typeof(fechamin) == "object") && (typeof(fechamax) == "object")){
		if((fecha >= fechamin) && (fecha <= fechamax)) {
			rpta = true;
		}
	}
	return rpta;
}

function radiochecked(radio){
	var rpta = "";
	if(typeof(radio) != "object"){
		return rpta;
	}
	if(typeof(radio.length) == "undefined"){
		if(radio.checked){
			rpta = radio.value;
		}
	} else {
		for (i = 0; i < radio.length;i++){ 
			if (radio[i].checked){
		       rpta = radio[i].value;
		       break; 
	       }
	    }
	}
    return rpta;
}

function checkchecked(check){
	var rpta = "";
	if(typeof(check) != "object"){
		return rpta;
	}
	
	if(typeof(check.length) == "undefined"){
		if(check.checked){
			rpta = check.value;
		}
	} else {
		for (i = 0; i < check.length;i++){ 
			if(check[i].checked){
		       rpta = check[i].value;
		       break; 
	       }
	    }
	}
    return rpta;
}

function checkAllChecks(check, estado){
	var contador = 0;

	if(typeof(check) != "object"){
		return cont;
	}
	if(typeof(check.length) == "undefined"){
		check.checked = estado;
		contador++;
	} else {
		for (i = 0; i < check.length;i++){ 
			check[i].checked = estado;
			contador++;
	    }
	}
	
	return contador;
}

function countChecks(check){
	var contador = 0;

	if(typeof(check) != "object"){
		return contador;
	}

	if(typeof(check.length) == "undefined"){
		return 1;
	} else {
		return check.length;
	}
	
	return contador;
}


function countSelChecks(check){
	var contador = 0;

	if(typeof(check) != "object"){
		return contador;
	}
	if(typeof(check.length) == "undefined"){
		if(check.checked == true) contador = 1;
	} else {
		for (i = 0; i < check.length;i++){ 
			if(check[i].checked == true) contador++;
	    }
	}
	
	return contador;
}

function seleccionCheck(check,form){
	var estado = check.checked;
	var elementos = form.length; 
	var contador = 0;
	for(i = 0; i < elementos; i++){
		var nombre = form.elements[i].name;
		if(nombre.substr(0,3) == "chk") {
			if(form.elements[i].disabled == false){
				form.elements[i].checked = estado;
				contador++;
			}
		}
	}
	return contador;
}

function validaRUC(objeto){
	var ruc = objeto.value;
	if(ruc.length != 8 && ruc.length != 11){
		alert("El documento debe ser de 8 u 11 dígitos");
		objeto.focus();
		return false;
	}

	if(ruc.length == 8){
		if(!esdniok(ruc)){
			alert("El DNI no es válido.");
			objeto.focus();
			return false;
		}
	}

	if(ruc.length == 11){
		if(!esrucok(ruc)){
			alert("El RUC no es válido.");
			objeto.focus();
			return false;
		}
	}

	return true;
}

function updateLocations(toolbar,menubar){
//parent['pnlHDocumento'].location.reload(); parent['pnlMDocumento'].location.reload(); maximizeParent();
	var objeto;
	objeto = eval("parent['" + toolbar + "']");
	reloadThis(objeto);

	objeto = eval("parent['" + menubar + "']");
	reloadThis(objeto);
}

function reloadThis(objeto){
	if(typeof(objeto) == "object"){
		objeto.location.reload();
	}
}

function jumpLink(targ,selObj,restore){
	eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
	if(restore) selObj.selectedIndex=0;
}

