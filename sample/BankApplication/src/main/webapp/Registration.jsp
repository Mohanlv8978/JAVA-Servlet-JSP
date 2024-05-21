<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

<div
		style="max-width: 400px; margin: auto; padding: 20px; border: 1px solid #060606; border-radius: 8px;">
		<h2 style="text-align: center; color: #333;">New User
			Registration</h2>
		<form action="RegistrationServlet" method="post">
			<div style="margin-bottom: 20px;">
				<label for="firstName" style="display: block; margin-bottom: 5px;">First
					Name:</label> <input type="text" name="firstName"
					style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;" />
			</div>
			<div style="margin-bottom: 20px;">
				<label for="lastName" style="display: block; margin-bottom: 5px;">Last
					Name:</label> <input type="text" name="lastName"
					style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;" />
			</div>
			<div style="margin-bottom: 20px;">
				<label for="email" style="display: block; margin-bottom: 5px;">Email:*</label>
				<input type="email" name="email" required
					style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;" />
			</div>
			<div style="margin-bottom: 20px;">
				<label for="username" style="display: block; margin-bottom: 5px;">Phone
					Number:</label> <input type="text" name="Phone Number"
					style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;" />
			</div>
			<div style="margin-bottom: 20px;">
				<label for="username" style="display: block; margin-bottom: 5px;">Password:*</label>
				<input type="password" name="Password" required
					style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;" />
			</div>
			<div style="margin-bottom: 20px;">
				<fieldset>
					<legend>Gender</legend>
					<label> <input type="radio" name="gender" value="Male" />
						Male
					</label> <label style="margin-left: 20px;"> <input type="radio"
						name="gender" value="Female" /> Female
					</label>
				</fieldset>
			</div>
			<button type="submit"
				style="width: 100%; padding: 10px; background-color: #007BFF; color: white; border: none; border-radius: 4px; cursor: pointer;">
				Register</button>
		</form>
	</div>
	<div style="text-align: center; margin-top: 20px;">
		<form action="Login.jsp" method="post">
		
		<%  String welcomeb="welcome back"; 
			HttpSession hs = request.getSession();
	    	hs.setAttribute("msg", welcomeb);
			 %>
			 
			<button onclick=""
				style="padding: 10px; background-color: #28a745; color: white; border: none; border-radius: 4px;">
				Login</button>
		</form>
	</div>
</body>
</html>