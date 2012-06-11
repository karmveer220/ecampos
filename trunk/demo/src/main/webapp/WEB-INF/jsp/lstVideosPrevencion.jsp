<script type="text/javascript" src="js/jquery-1.7.2.min.js" ></script>
<script type='text/javascript' src='js/jwplayer.js'></script>

<body>
	<div id="container">Loading the player...</div>
	<script type="text/javascript">
		jwplayer("container").setup({
			flashplayer: "swf/player.swf",
			playlist: [
			{ duration: 76, file: "swf/Postura_Correcta2.flv", image: "images/video2.jpg", title: "Postura Correcta 1" },
			{ duration: 140, file: "swf/Postura_Correcta1.flv", image: "images/video1.jpg", title: "Postura Correcta 2" },
			],
			"playlist.position": "right",
			"playlist.size": 360,
			height: 270,
			width: 695,
			skin: 'skin/bekle.zip',
			controlbar: 'over',
		});
	</script>
</body>
</html>

