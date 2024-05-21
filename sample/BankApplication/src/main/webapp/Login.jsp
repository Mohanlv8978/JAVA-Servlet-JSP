<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body style="background-color: #5b68bc;">
<%HttpSession hs=request.getSession(); %>
    <form action="LoginServlet" method="post">
		<div
			style="background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); height: 100vh; display: flex; justify-content: center; align-items: center;">
			  <h1 style="position: absolute; top: 20%; left: 28%; color: bisque">
				<% 
				String a=(String)hs.getAttribute("msg");
				out.print(a);
				%>  
				</h1>
			<div
				style="width: 300px; padding: 20px; background: rgba(255, 255, 255, 0.1); backdrop-filter: blur(10px); border-radius: 10px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);">
				
				<h2 style="color: white; text-align: center; margin-bottom: 20px;">Login</h2>
				<div style="margin-bottom: 10px;">
					<input type="text" name="uname" placeholder="Email" required
						style="width: 100%; padding: 10px; border: none; border-radius: 5px; box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.1);" />
				</div>
				<div style="margin-bottom: 20px;">
					<input type="password" name="upass" placeholder="Password" required
						style="width: 100%; padding: 10px; border: none; border-radius: 5px; box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.1);" />
				</div>
				<button
					style="width: 100%; padding: 10px; background: #4e9af1; color: white; border: none; border-radius: 5px; cursor: pointer; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);">
					Login </button>
					</div>
					</div>
	</form>
</body>
</html>