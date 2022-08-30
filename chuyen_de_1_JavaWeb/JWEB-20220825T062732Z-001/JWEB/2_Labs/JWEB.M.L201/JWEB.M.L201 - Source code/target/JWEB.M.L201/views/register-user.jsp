<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/register-user.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Register User</title>
</head>
<body>
	<div class="wrapper">
		<div class="label-register">
			<p>USER DETAIL</p>
		</div>
		
		<% String message = (String) request.getAttribute("message");%>
		<% if (message == null) {
			message = "";
		}%>
		<p id="error"><%= message %></p>
		
		<div class="div-register">

			<form action="<%=request.getContextPath()%>/register" method="post"
				onsubmit="return validateRegister()" name="frm-register">
				
				<table id="tbl-register">
					<tr>
						<td>First Name <span>*</span></td>
						<td><input type="text" name="firstName" id="firstName"
							placeholder="Enter first name"/></td>
					</tr>
					<tr>
						<td>Last Name <span>*</span></td>
						<td><input type="text" name="lastName" class="lastName"
							id="lastName" placeholder="Enter last name" /></td>
					</tr>
					<tr>
						<td>Email <span>*</span></td>
						<td><input type="email" name="email" id="email"
							placeholder="Enter email"/></td>
					</tr>
					<tr>
						<td>User Name <span>*</span></td>
						<td><input type="text" name="userName" id="userName"
							placeholder="Enter user name"/></td>
					</tr>
					<tr>
						<td>Password <span>*</span></td>
						<td><input type="password" name="password" id="password"
							placeholder="Enter password" /></td>
					</tr>

					<tr>
						<td>Confirm Password <span>*</span></td>
						<td><input type="password" name="confirmPassword"
							id="confirmPassword" placeholder="Enter password again" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<button type="submit" name="register">Register</button> 
							<a href="<%=request.getContextPath()%>/login" id="link-login">Click
								here to Login</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<hr />
		<p class="label-result">User List</p>
		<div class="div-result">
			<table class="tbl-result" id="tbl-result" border="1">
				<thead>
				</thead>

				<tbody>
				</tbody>
			</table>
		</div>
		
	</div>
	<script
		src="<%=request.getContextPath()%>/resources/js/register-user.js"></script>
</body>
</html>