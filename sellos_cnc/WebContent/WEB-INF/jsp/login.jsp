<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Login CNL</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    
	    body{
	    	background: url(http://mymaplist.com/img/parallax/back.png);
			background-color: #444;
		    background: url(http://mymaplist.com/img/parallax/pinlayer2.png),url(http://mymaplist.com/img/parallax/pinlayer1.png),url(http://mymaplist.com/img/parallax/back.png);    
		}
		
		.vertical-offset-100{
		    padding-top:100px;
		}

    </style>
    

	<script type="text/javascript">
	
	$(document).ready(function(){
		  $(document).mousemove(function(e){
		     TweenLite.to($('body'), 
		        .5, 
		        { css: 
		            {
		                'background-position':parseInt(event.pageX/8) + "px "+parseInt(event.pageY/12)+"px, "+parseInt(event.pageX/15)+"px "+parseInt(event.pageY/15)+"px, "+parseInt(event.pageX/30)+"px "+parseInt(event.pageY/30)+"px"
		            }
		        });
		  });
		});
	
	</script>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="../assets/ico/favicon.png">
    <script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>
  </head>

  <body>

   <div class="container">
    <div class="row vertical-offset-100">
    	<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-success">
    		
    		  
         <c:if test="${not empty msgError}"><div class="alert alert-danger"> <strong><c:out value="${msgError}"/></strong> </div></c:if>
		<c:if test="${not empty mensaje}"><div class="alert alert-success">  <strong><c:out value="${mensaje}"/></strong> </div></c:if>
		
		
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Iniciar Sesi&oacute;n</h3>
			 	</div>
			  	<div class="panel-body">
			    	<form accept-charset="UTF-8" role="form" action="ingresar.htm" method="post">
                    <fieldset>
                    
                    	 <div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<input type="text" class="form-control" name="username" placeholder="usuario">
						</div>
						
						 <div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<input type="password" class="form-control" name="password" placeholder="password">
						</div>
						  		
			    		<div class="checkbox">
			    	    	<label>
			    	    		<input name="remember" type="checkbox" value="Remember Me"> Recordarme
			    	    	</label>
			    	    </div>
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
			    	</fieldset>
			      	</form>
			    </div>
			</div>
		</div>
	</div>
</div>

  </body>
</html>
