var calendar = function(obj){
	
	/*###############################################################*/
	/*################   KULLANICIDAN ALINAN VERİLER   ##############*/
	/*###############################################################*/
	var selector = $("#" + obj["id"]); 
	var startDate = obj["startDate"];
	var droppable = obj["droppable"];
	var data = obj["data"] === undefined ? [] : obj["data"];
	
	
	/*###############################################################*/
	/*###################   PROGRAM DEĞİŞKENLERİ   ##################*/
	/*###############################################################*/
	var date = new Date();
	var toDay = ("0" + date.getDate()).slice(-2);
	var toMonth = ("0" + (date.getMonth() + 1)).slice(-2);
	var toYear = date.getFullYear();
	
	var selectedDay;
	var selectedMonth;
	var selectedYear;
	
	var days=[
		"Monday", 
		"Tuesday", 
		"Wednesday", 
		"Thursday", 
		"Friday", 
		"Saturday", 
		"Sunday"
	];
	var months=[
		["January", 31],
		["February", 28],
		["March", 31],
		["April", 30],
		["May", 31],
		["June", 30],
		["July", 31],
		["August", 31],
		["September", 30],
		["October", 31],
		["November", 30],
		["December", 31]
	];
	
	/*###############################################################*/
	/*###################   PROGRAM KARAR YAPISI   ##################*/
	/*###############################################################*/
	if(startDate=="Today"){
		selectedDay = toDay;
		selectedMonth = toMonth;
	 	selectedYear = toYear;
	}
	else{
		var a = startDate.split(".");
		selectedDay = a[0];
		selectedMonth = a[1];
	 	selectedYear = a[2];
	}
	
	
	
	/*###############################################################*/
	/*###################   PROGRAM FONKSİYONLARI   #################*/
	/*###############################################################*/
	function fillTable(day, month, year){
		/* 
			## 01.01.1900 pazartesi takvimin başlangıç günü
			
			## 1 yıl 365 gün olduğundan her yıl başlangıç günü bir sonraki güne denk gelir. 
				Şubatın 29 çektiği yıldan sonraki yılın başlangıç günü +2 dir.
				Bu nedenle geçerli yıldan başlangıç yılı çıkarılır ve üzerine + %25 eklenir.
				Sonra haftada 7 gün olduğundan mod 7 alınır ve yılın başlangıç günü hesaplanır.
				
			##  Geçerli yılda şubat 29 çekiyor ise geçerli yıl henüz geçmemiş olduğundan,
				hesaplamaya katılmaması için -1 eklenmelidir.
		*/
		var firstDayOfYear = year - 1900;
		firstDayOfYear += Math.floor(firstDayOfYear/4);
		firstDayOfYear %= 7;
		if(year%4==0){
			firstDayOfYear--;
		}
		
		/*
			## Geçerli aydan önceki ayların gün sayısı toplanır ve mod 7 alınır. Eğer şubat ayı
			   29 çekiyor ise hesaplamaya katılması için +1 eklenmelidir
		*/
		var firstDayOfMonth = 0;
		for(var i=0;i<month-1;i++){
			firstDayOfMonth += months[i][1];	
		}
		
		if(month>2 && year%4==0){
			firstDayOfMonth++;
		}
		else if(month==2 && year%4==0){
			months[1][1] = 29;
		}
		
		firstDayOfMonth %= 7;
		
		/*
			## Yıllardan ve aylardan artan artık günler ayrı ayrı hesaplandı. Şimdi bu ikisi
			   toplanarak tekrar mod 7 alınır ve geçerli ayın takvimde başlangıç günü hesaplanır.
		*/
		var startDay = (firstDayOfYear + firstDayOfMonth) % 7;
		
		/*
			## Takvim 42 hücreden oluştuğundan artık günlerden dolayı önceki ayın günleri ve
			   sonraki ayın günleri olmalıdır. Hücreler 1 den 42 ye numaralıdır.
			
			 ## Önceki ve sonraki aylar takvimde passive klası ile pasif haldedir.
			 
			 ## Önceki ayın günleri mevcut hücrenin numarasından başlangıç günü çıkarılıp önceki
			 	ayın toplam gün sayısı eklenerek hesaplanır.
				
			 ## Mevcut ayın günleri hücre numarasından başlangıç günü çıkarılarak hesaplanır.
			 	Mevcut ayın günleri 1 ile ayın toplam sayısı arasındadır.
				
			 ## Sonraki ayın günleri hücre numarasından başlangıç günü ve mevcut ayın toplam 
			 	günü çıkarılarak hesaplanır
		*/
		var lastMonth = (month == 1) ? 12 : month -1;
		lastMonth = months[lastMonth-1][1];
		thisMonth = months[month-1][1];
		var cell=1;
		selector.children("table").children("tbody").children("tr").each(function(){
			$(this).children("td").each(function(){
				if(cell - startDay<1){ /* Geçen ay günleri */
					$(this).html(cell - startDay + lastMonth);
					$(this).addClass("passive");
					$(this).attr("day",-1);
				}
				else if(cell - startDay>=1 && cell-startDay<=thisMonth){ /* Mevcut ay günleri */
					$(this).html(cell - startDay);
					$(this).attr("day",cell - startDay);
					(cell - startDay == day) ?  $(this).addClass("selectedDay") :"";
					
					if(droppable==true){
						$( this ).droppable({
						  	drop: function( event, ui ) {
								$(this).css("background-color","#ffffff");
								
								var c = ui.draggable.css("background-color");
								var co = ui.draggable.text();
								var a = ui.draggable.attr("id");
								$(this).append("<p class='dropped' style='background-color:"+c+"' alt="+a+">"+co+"</p>");
								
								ui.draggable.css("top", "0px");
								ui.draggable.css("left", "0px");
								ui.draggable.css("display", "none");
								
								var d = $(this).attr("day") + "." + selectedMonth + "." + selectedYear;
								data.push([a, d, c, co]);
								
								$(this).children("p:last-child").dblclick(function(){
									var i=$(this).attr("alt");
									$("#" + i).css("display", "block");
									$(this).remove();
									
									var ind = data[0].indexOf(i);
									data.splice(ind, 1);
								});
								
						    },
						  	over: function( event, ui ) {
								$(this).css("background-color","#eaf8fa");
							},
							
						    out: function( event, ui ) {
								$(this).css("background-color","#ffffff");  
							}
						});
					}
				}
				else{ /* Sonraki ay günleri */
					$(this).html(cell - startDay - thisMonth);
					$(this).addClass("passive");
					$(this).attr("day",-1);
				}
				cell++;
            });
		});
		
	}
	
	function createTable(){
		/*
			## Tablonun oluşturulması işlemidir
			
			## Tablo haftanın 7 günü için 7 stun ve 6 satırdır toplam 42 hücreden oluşur. 
			   31 çeken aylardan dolayı 5 satır gerekiyor ve artık günlerden dolayıda 1 satıra
			   daha ihtiyaç duyuluyor
		*/
		selector.append("<div class='JcalendarHead' align='center'><span>"+months[selectedMonth-1][0] + " " + selectedYear+"</span></div>");
		selector.children(".JcalendarHead").append("<button class='prev'>&#9668;</button><button class='next'>&#9658;</button><button class='btn'> Today </button>");
		selector.append("<table class='Jcalendar' cellpadding='0' cellspacing='1'><thead></thead><tbody></tbody></table>");
		
		/*
			## Tablonun başlık kısmı
		*/
		for(var i=0;i<days.length;i++){
			selector.children("table").children("thead").append("<th>"+days[i]+"</th>")
		}
		
		/*
			## Ayın günleri
		*/
		for(var i=0;i<6;i++){
			selector.children("table").children("tbody").append("<tr align='right' valign='top'></tr>");
			for(var j=0; j<7; j++){
				selector.children("table").children("tbody").children("tr:last-child").append("<td></td>");
			}
			
		}	
	}
	
	function clearTable(){
		selector.children("table").children("tbody").children("tr").each(function(){
			$(this).children("td").each(function(){
				$(this).html("");
				$(this).removeClass("selectedDay");
				$(this).removeClass("passive");
			});
		});
	}
	
	function fillDraggableData(){
		for(var i=0;i<data.length;i++){
			var d = data[i][1].split(".");
			
			if(d[2]==selectedYear && d[1]==selectedMonth){
				selector.children("table").children("tbody").children("tr").each(function(){
					$(this).children("td").each(function(){
						if($(this).attr("day")==d[0]){
							$(this).append("<p class='dropped' style='background-color:"+data[i][2]+"' alt='"+data[i][0]+"'>"+data[i][3]+"</p>");	
						}
					});
				});
			}
		}
	}
	
	this.out = function(){
		var str="";
		for(var i=0;i<data.length;i++){
			str+= data[i][0] + "=>" + data[i][1] + ";";
		}
		str = str.substring(0,str.length-1);
		return str;	
	}
	
	
	/*###############################################################*/
	/*#################   FONKSİYONLARIN ÇAĞIRILMASI   ##############*/
	/*###############################################################*/
	createTable();
	fillTable(selectedDay, selectedMonth, selectedYear);
	fillDraggableData();
	
	
	/*###############################################################*/
	/*#################   BUTONLARA FONKSİYON ATAMASI   #############*/
	/*###############################################################*/
	selector.children(".JcalendarHead").children(".next").click(function(){
		selectedDay = 01;
		selectedMonth++;
		if(selectedMonth > 12){
			selectedMonth = 01;
			selectedYear++;
		}
		
		clearTable();
		fillTable(selectedDay, selectedMonth, selectedYear);
		fillDraggableData();
		selector.children(".JcalendarHead").children("span").html(months[selectedMonth-1][0] + " " + selectedYear);	
	});
	
	selector.children(".JcalendarHead").children(".prev").click(function(){
		selectedDay = 01;
		selectedMonth--;
		if(selectedMonth < 01){
			selectedMonth = 12;
			selectedYear--;
		}
		
		clearTable();
		fillTable(selectedDay, selectedMonth, selectedYear);
		fillDraggableData();
		selector.children(".JcalendarHead").children("span").html(months[selectedMonth-1][0] + " " + selectedYear);	
	});
	
	selector.children(".JcalendarHead").children(".btn").click(function(){
		selectedDay = toDay;
		selectedMonth = toMonth;
		selectedYear = toYear;
		
		clearTable();
		fillTable(selectedDay, selectedMonth, selectedYear);
		fillDraggableData();
		selector.children(".JcalendarHead").children("span").html(months[selectedMonth-1][0] + " " + selectedYear);	
	});
	
}
// JavaScript Document