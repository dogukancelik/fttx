<%@ page import="Account.Menu" %>
<%Menu mn=new Menu(); %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ProcessManagement</title>
<base href="/processManagement/" >
<link rel="shortcut icon" href="img/processn.png">
<link rel="stylesheet" href="css/default.css">
<link rel="stylesheet" href="css/formElements.css">
<link rel="stylesheet" href="css/font-awesome.css">
<script type="text/javascript" src="js/default.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<body>
	<div class="head">
		<div class="logo">
			<i class="fa fa-navicon" onclick="leftMenu()"></i> 
			<a href="index">Process Management</a>
		</div>
		<div class="user" onclick="userMenu()">
			<img src="img/User-icon.png" align="left"/>
			<i class="fa fa-angle-down" style="font-size:22px;"></i>
		</div>
		<div class="name"><%=session.getAttribute("UserName") %></div>
	</div>
	<div class="sep"></div>
	<div class="leftMenu">
		<ul>
		<%
		String str=session.getAttribute("UserId").toString();
		for( String [] st:(mn.Menus(str)))  {
		%>
			<li><i class="fa fa-circle"></i> <%=st[1]%>
				<ul class="sub">
				<%
					for( String [] sts:(mn.subMenu(str,st[0].toString() )))  {
				%>
					<li> <i class="fa fa-circle-o"></i> <a href="<%=sts[1]%>/<%=sts[2]%>"><%=sts[2] %></a></li>
				<%}%>
				</ul>
			</li>
			<%} %>
		</ul>
	</div>
	<script>
		$( document ).ready(function() {
		    $(".leftMenu > ul:first-child > li").click(function(){
		    	if($(this).hasClass("active")){
		    		$(this).removeClass("active");
		    		$(this).children("ul").removeClass("active");
		    	}
		    	else{
		    		$(this).addClass("active");
		    		$(this).children("ul").addClass("active");
		    	}
		    	
		    });
		});
	</script>
	
	<div class="userMenu">
		<img src="img/arrowUp.png"/>
		<ul>
			<li><a href="myAccount"><i class="fa fa-user-circle"></i> My Account</a></li>
			<li><a href="signOut"><i class="fa fa-sign-out"></i> Sign Out</a></li>
		</ul>
	</div>
		