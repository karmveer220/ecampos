<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>SELLOS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

 
 
    <!-- Le styles -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/jquery-ui-1.10.4.custom.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/displaytag.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <style type="text/css">
   
      /*para el menu con navegacion del admin*/
      .label,.glyphicon { margin-right:5px; }
      
      /*para grids */
      	.trash { color:rgb(209, 91, 71); }
		.flag { color:rgb(248, 148, 6); }
		.panel-body { padding:0px; }
		.panel-footer .pagination { margin: 0; }
		.panel .glyphicon,.list-group-item .glyphicon { margin-right:5px; }
		.panel-body .radio, .checkbox { display:inline-block;margin:0px; }
		.panel-body input[type=checkbox]:checked + label { text-decoration: line-through;color: rgb(128, 144, 160); }
		.list-group-item:hover, a.list-group-item:focus {text-decoration: none;background-color: rgb(245, 245, 245);}
		.list-group { margin-bottom:0px; }
		
		/*footer*/
		#enlaces_footer li{
			float:left;
			margin-right:20px;
			margin-left:15px;
			height:80px;
			text-align:center;
		}
		
		#footer{
			background:url(img/back_menu.jpg);	
			padding:30px 10px;
			overflow:hidden;
			margin-top:15px;
		}
		
		#footer .page{
			width:950px;
			margin:0 auto;	
			overflow:hidden;	
		}
		
		#footer .fleft{
			background:url(img/logonotarios.png) center left no-repeat;	
			color:#FFF;
			padding-left:90px;
		}
		
		#footer .fright{
			text-align:right;	
		}
		#footer .fright a{
			color:#FFF;	
		}

		.fleft{
			float:left;	
		}
		
		.fright{
			float:right;	
		}

    </style>
   

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="${pageContext.request.contextPath}/js/html5shiv.js"></script>
    <![endif]-->
   
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/ico/favicon.png">
    
    
    
   <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>  
  	<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.gvChart-1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.displaytag-ajax-1.2.js"></script> 
    <script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
     <script src="${pageContext.request.contextPath}/js/reportes_std.js"></script>
    
  </head>

  <body>


    <div class="container">
      <nav class="navbar navbar-default" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span><span
                    class="icon-bar"></span><span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.htm">COLEGIO DE NOTARIOS DEL CALLAO</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
            
                <li class="active"><a href="${pageContext.request.contextPath}/index.htm"><span class="glyphicon glyphicon-home"></span>Inicio</a></li>
                
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                    class="glyphicon glyphicon-list-alt"></span>NOTARIOS <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/lnotarios.htm">Lista de Notarios</a></li>
                     </ul>
                </li>
              
                
            </ul>
            <ul class="nav navbar-nav navbar-right">
                 
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                    class="glyphicon glyphicon-user"></span>ecampos <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}"><span class="glyphicon glyphicon-off"></span>Salir</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>
    
    </div>
    
    <div class="container">