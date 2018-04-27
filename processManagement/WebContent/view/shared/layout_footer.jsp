<script>
	var c = getCookie("leftMenu");
	if(c == undefined){
		c = 0;
		setCookie("leftMenu", 0, 365*24*60*60);
	}
		
	if(c == 1){
		$(".leftMenu").addClass("wide");
		$(".content").addClass("wide");
	}
</script>
</body>
</html>