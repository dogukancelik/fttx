function userMenu(){
	var display = $(".userMenu").css("display");
	if(display == "none"){
		$(".userMenu").css("display", "block");
	}
	else{
		$(".userMenu").css("display", "none");
	}
}