<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/login.css">
<title>Login</title>
</head>
<body>
	<div class="wrapper">
		<div class="label-login">
			<p>LOGIN</p>
		</div>
		<p id="error">${loginFail}</p>
		<div class="div-login">
			<form action="<%=request.getContextPath()%>/login" method="post" name="frm-login" onsubmit = "return validateLogin()">
				<table id="tbl-login">
					
					<tr>
						<td>User Name <span>*</span></td>
						<td><input type="text" name="userName" id="userName"
							placeholder="Enter user name" value = "${userRegister.userName}"/></td>
					</tr>
					<tr>
						<td>Password <span>*</span></td>
						<td><input type="password" name="password" id="password"
							placeholder="Enter password" value = "${userRegister.password}"/></td>
					</tr>

					
					<tr>
						<td></td>
						<td>
							<button type="submit"
								name="login">Login</button>
							<a href = "<%=request.getContextPath()%>/register" id = "link-register">Click here to Register</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/js/login.js"></script>
</body>
</html>