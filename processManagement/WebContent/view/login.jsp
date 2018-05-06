<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/default.css" />
<link rel="stylesheet" href="css/formElements.css" />
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/default.js"></script>
<title>Login</title>
</head>

<body style="background-color:#025670;">
	<div class="login-form">
    <form action="test" method="post" onsubmit="return validate(this)">
    	<div class="login-form-header">User Login</div>
        <img class="login-form-img" src="img/u.png"/>
		<input type="text" name="username" class="form-input" style="background: url(img/user.png) no-repeat 10px 6px ;" placeholder="UserName"/>
		<div id="usernameVal" class="validator" style="margin-left:35px;"></div>
        <input type="password" name="password" class="form-input" style="background: url(img/password.png) no-repeat 10px 6px ;" placeholder="Password"/>
        <div id="passwordVal" class="validator" style="margin-left:35px;"></div>
        <input type="submit" class="form-button" value="Login"/>
    </form>
	</div>
</body>
</html>
