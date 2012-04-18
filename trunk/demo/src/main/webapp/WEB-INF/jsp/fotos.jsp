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
	background-color: #444;
	padding: 10px;
	width: 520px;
}

#gallery ul {
	list-style: none;
}

#gallery ul li {
	display: inline;
}

#gallery ul img {
	border: 5px solid #3e3e3e;
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
</style>
</head>

<body>

	<h2 id="example">Galería Fotográfica</h2>
	<p>Click en la imagen para ver la foto completa</p>
	<div id="gallery">
		<ul>
			<li><a href="imgsgale/Campeonato_2011_001.jpg" title="texto 1">
					<img src="imgsgale/Campeonato_2011_001.jpg" width="72" height="72"
					alt="" />
			</a></li>
			<li><a href="imgsgale/Campeonato_2011_002.jpg" title="texto 1">
					<img src="imgsgale/Campeonato_2011_002.jpg" width="72" height="72"
					alt="" />
			</a></li>
			<li><a href="imgsgale/Campeonato_2011_003.jpg" title="texto 1">
					<img src="imgsgale/Campeonato_2011_003.jpg" width="72" height="72"
					alt="" />
			</a></li>
			<li><a href="imgsgale/Campeonato_2011_004.jpg" title="texto 1">
					<img src="imgsgale/Campeonato_2011_004.jpg" width="72" height="72"
					alt="" />
			</a></li>

			<li><a href="imgsgale/Campeonato_2011_005.jpg" title="texto 1">
					<img src="imgsgale/Campeonato_2011_005.jpg" width="72" height="72"
					alt="" />
			</a></li>

			<li><a href="imgsgale/Campeonato_2011_006.jpg" title="texto 2">
					<img src="imgsgale/Campeonato_2011_006.jpg" width="72" height="72"
					alt="" />
			</a></li>
			<li><a href="imgsgale/Campeonato_2011_007.jpg" title="texto 2"> <img
					src="imgsgale/Campeonato_2011_007.jpg" width="72" height="72" alt="" />
			</a></li>
			<li><a href="imgsgale/Campeonato_2011_008.jpg" title="texto 2"> <img
					src="imgsgale/Campeonato_2011_008.jpg" width="72" height="72" alt="" />
			</a></li>
			<li><a href="imgsgale/Campeonato_2011_009.jpg" title="texto 2"> <img
					src="imgsgale/Campeonato_2011_009.jpg" width="72" height="72" alt="" />
			</a></li>
			<li><a href="imgsgale/Campeonato_2011_010.jpg" title="texto 2"> <img
					src="imgsgale/Campeonato_2011_010.jpg" width="72" height="72" alt="" />
			</a></li>
			<li><a href="imgsgale/Campeonato_2011_011.jpg" title="texto 2"> <img
					src="imgsgale/Campeonato_2011_011.jpg" width="72" height="72" alt="" />
			</a></li>
			<li><a href="imgsgale/Campeonato_2011_012.jpg" title="texto 2"> <img
					src="imgsgale/Campeonato_2011_013.jpg" width="72" height="72" alt="" />
			</a></li>
			<li><a href="imgsgale/maura-rivera9.jpg" title="texto 2"> <img
					src="imgsgale/maura-rivera9.jpg" width="72" height="72" alt="" />
			</a></li>
			<li><a href="imgsgale/maura-rivera10.jpg" title="texto 2"> <img
					src="imgsgale/maura-rivera10.jpg" width="72" height="72" alt="" />
			</a></li>
			<li><a href="imgsgale/maura-rivera11.jpg" title="texto 2"> <img
					src="imgsgale/maura-rivera11.jpg" width="72" height="72" alt="" />
			</a></li>
		</ul>
	</div>

</body>
</html>