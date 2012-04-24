<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jQuery lightBox plugin</title>

<link rel="stylesheet" type="text/css"
	href="css/style-projects-jquery.css" />

<!-- Arquivos utilizados pelo jQuery lightBox plugin -->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.lightbox-0.5.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/jquery.lightbox-0.5.css" media="screen" />
<!-- / fim dos arquivos utilizados pelo jQuery lightBox plugin -->

<!-- Ativando o jQuery lightBox plugin -->
<script type="text/javascript">
	$(function() {
		$('#gallery a').lightBox();
	});
</script>
<style type="text/css">
/* jQuery lightBox plugin - Gallery style */
#gallery {
	background-color: #FFFFFF;
	padding: 10px;
	width: 700px;
}

#gallery ul {
	list-style: none;
}

#gallery ul li {
	display: inline;
}

#gallery ul img {
	border: 5px solid #FFFFFF;
	border-width: 5px 5px 20px;
}

#gallery ul a:hover img {
	border: 5px solid #fff;
	border-width: 5px 5px 20px;
	color: #fff;
}

#gallery ul a:hover {
	color: #fff;
}

.irgaleria {
	background-image: url("images/icon_galeria.jpg");
	height: 22px;
	display: block;
	width: 104px;
	margin-left: 480px;
	margin-top: 10px;
}
</style>
</head>

<body>
	<div>
		<a href="galeriaFotos.htm" class="irgaleria"></a>
	</div>


	<div id="gallery">
		<ul>
			<li><a href="images/digemin/DIGEMIN001.jpg" title="texto 1">
					<img src="images/digemin/DIGEMIN001.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN002.jpg" title="texto 1">
					<img src="images/digemin/DIGEMIN002.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN003.jpg" title="texto 1">
					<img src="images/digemin/DIGEMIN003.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN004.jpg" title="texto 1">
					<img src="images/digemin/DIGEMIN004.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN005.jpg" title="texto 1">
					<img src="images/digemin/DIGEMIN005.jpg" width="120" height="100"
					alt="" />
			</a></li>

			<li><a href="images/digemin/DIGEMIN006.jpg" title="texto 2">
					<img src="images/digemin/DIGEMIN006.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN007.jpg" title="texto 2">
					<img src="images/digemin/DIGEMIN007.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN008.jpg" title="texto 2">
					<img src="images/digemin/DIGEMIN008.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN009.jpg" title="texto 2">
					<img src="images/digemin/DIGEMIN009.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN010.jpg" title="texto 2">
					<img src="images/digemin/DIGEMIN010.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN011.jpg" title="texto 2">
					<img src="images/digemin/DIGEMIN011.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN012.jpg" title="texto 2">
					<img src="images/digemin/DIGEMIN012.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN013.jpg" title="texto 2">
					<img src="images/digemin/DIGEMIN013.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN014.jpg" title="texto 2">
					<img src="images/digemin/DIGEMIN014.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN015.jpg" title="texto 2">
					<img src="images/digemin/DIGEMIN015.jpg" width="120" height="100"
					alt="" />
			</a></li>
			<li><a href="images/digemin/DIGEMIN016.jpg" title="texto 2">
					<img src="images/digemin/DIGEMIN016.jpg" width="120" height="100"
					alt="" />
			</a></li>

		</ul>
	</div>

</body>
</html>