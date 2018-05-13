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
			$("#"+elm[i].name+"Val").html(elm[i].name+" Cannot Be Empty !");
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

function selectAdd(from, to){
	var from = $("select[name='"+from+"']");
	var to = $("select[name='"+to+"']");
	var i = to.children("option").length+1;
	
	if(from.val().length>0){
		from.children("option:selected").each(function(){
			if(!$(this).is("[hidden=hidden]")){
				$(this).attr("hidden", "hidden");
				var text = $(this).text();
				var val = $(this).val();
				to.append("<option value='"+val+"'>"+i+"-) "+text+"</option>");
				i++;
			}
		});
	}
}

function selectRemove(from, to){
	var from = $("select[name='"+from+"']");
	var to = $("select[name='"+to+"']");
	
	to.children("option:selected").each(function(){
		var f = $("option[value='"+$(this).val()+"']");
		from.find(f).removeAttr("hidden");
		$(this).remove();
	});
	
	selectRePresent(to);
}

function selectRePresent(to){
	var d = [];
	to.children("option").each(function(){
		var x = $(this).text().split("-) ");
		d.push([$(this).val(), x[1]]);
		$(this).remove();
	});
	
	for(var i=0;i<d.length;i++){
		to.append("<option value='"+d[i][0]+"'>"+(i+1)+"-) "+d[i][1]+"</option>");
	}
}

function selectOrder(o, to){
	var to = $("select[name='"+to+"']");
	var d = [];
	var s = to.children("option:selected").index();
	if(s!=-1){
		to.children("option").each(function(){
			var x = $(this).text().split("-) ");
			d.push([$(this).val(), x[1]]);
		});
		
		if(o == -1 && s>0){
			d00 = d[s-1][0];
			d01 = d[s-1][1];
			
			d10 = d[s][0];
			d11 = d[s][1];
			
			d[s-1][0] = d10;
			d[s-1][1] = d11;
			d[s][0] = d00;
			d[s][1] = d01;
			
			to.children("option").remove();
			for(var i=0;i<d.length;i++){
				to.append("<option value='"+d[i][0]+"'>"+(i+1)+"-) "+d[i][1]+"</option>");
			}
		}
		else if(o == +1 && s<d.length-1){
			d00 = d[s+1][0];
			d01 = d[s+1][1];
			
			d10 = d[s][0];
			d11 = d[s][1];
			
			d[s+1][0] = d10;
			d[s+1][1] = d11;
			d[s][0] = d00;
			d[s][1] = d01;
			
			to.children("option").remove();
			for(var i=0;i<d.length;i++){
				to.append("<option value='"+d[i][0]+"'>"+(i+1)+"-) "+d[i][1]+"</option>");
			}
		}
		
		
	}
}