function userMenu(){
	var display = $(".userMenu").css("display");
	if(display == "none"){
		$(".userMenu").css("display", "block");
	}
	else{
		$(".userMenu").css("display", "none");
	}
}

function leftMenu(){
	var c = getCookie("leftMenu");
	if(c == 0){
		setCookie("leftMenu", 1, 365*24*60*60);
		$(".leftMenu").addClass("wide");
		$(".content").addClass("wide");
	}
	else{
		setCookie("leftMenu", 0, 365*24*60*60);
		$(".leftMenu").removeClass("wide");
		$(".content").removeClass("wide");
	}
}

function getCookie(name){
	var cookieString = document.cookie;
	var allCookie = cookieString.split(";");
	
	for(var i=0; i<allCookie.length; i++){
		var str = allCookie[i].split("=");
		if(str[0] == name){
			return str[1];
			break;
		}
	}
}

function setCookie(name, value, exp) {
    var d = new Date();
    d.setTime(d.getTime() + (exp*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = name + "=" + value + ";" + exp + ";path=/";
}

function validate(elm){
	var x=0;
	for(var i=0;i<elm.length-1;i++){
		if(elm[i].value==""){
			$("#"+elm[i].name+"Val").html(elm[i].name+" Connot Be Empty !");
			x++;
		}
		else{
			$("#"+elm[i].name+"Val").html("");
		}
	}
	
	if(x>0){
		return false;
	}
}