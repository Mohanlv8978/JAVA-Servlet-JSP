<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<%HttpSession hs=request.getSession(); %>
	<div
		style="max-width: 800px; margin: auto; font-family: Arial, sans-serif;">
		<form action="Login.html" method="post">
			<div
				style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;">
				<h1 style="color: rgb(135, 203, 90);">Payments Web App</h1>
				<button
					style="background-color: red; color: rgb(255, 255, 255); border: 0; padding: 8px 16px; border-radius: 5px;">
					Logout</button>
			</div>
		</form>

		<div style="margin-bottom: 20px;">
			<h2>
				Welcome 
				<% 
				
				String a=(String)hs.getAttribute("kname");
				out.print(a);
				%>       
				<span style="font-weight: bold;"></span>
			</h2>
		</div>

		<div
			style="color: aliceblue; background-color: rgb(80, 81, 154); padding: 15px; border: 2px solid rgb(227, 9, 231); margin-bottom: 20px;">
			<p>
				Account Number:<span style="font-weight: bold;">
					<%
					String b = (String) hs.getAttribute("Account number");
					out.print(b);
					%>
				</span>
			</p>
			<p>
				Account Balance: <span style="font-weight: bold;">xxx </span>
			</p>
			<p>
				Wallet Balance: <span style="font-weight: bold;">xxx</span> <a
					href="#" style="color: rgb(255, 191, 0)">[ + Add To
					Wallet ] </a>
			</p>
			<button
				style="background-color: red; color: white; border: none; padding: 8px 16px; border-radius: 5px;">
				Send Money</button>
		</div>
	
		<div
			style="display: flex; justify-content: space-between; margin-bottom: 20px;">
			<div
				style="background-color: rgb(230, 138, 181); padding: 15px; border: 1px solid rgb(136, 13, 132); width: 30%;">
				<p
					style="background-color: rgb(23, 208, 32); color: white; border: none; padding: 8px 16px; border-radius: 5px;">
					STATE BANK OF INDIA</p>
				<p>
					Account Number:
					<%
				b = (String) hs.getAttribute("Account number");
				out.print(b);
				%>
				</p>

				<p>Balance:</p>

				<p>
					IFSC Code:
					<%
				String i = (String) hs.getAttribute("IFSC Code");
				out.print(i);
				%>
				</p>

				<p>
					Branch:
					<%
				String d = (String) hs.getAttribute("Branch");
				out.print(d);
				%>
				</p>

				<button
					style="background-color: rgb(255, 0, 0); color: white; border: none; padding: 8px 16px; border-radius: 5px;">
					Edit</button>
			</div>
			<div
				style="background-color: rgb(147, 203, 225); padding: 15px; border: 1px solid rgb(136, 13, 132); width: 30%;">
				  <p style="background-color: rgb(23, 208, 32); color: white; border: none; padding: 8px 16px; border-radius: 5px; text-align: center;">HDFC</p>
				<p> Account Number:</p>
				<p>Balance:</p>
				<p>IFSC Code:</p>
				<p>Branch:</p>
				<button
					style="background-color: rgb(255, 0, 0); color: white; border: none; padding: 8px 16px; border-radius: 5px;">
					Edit</button>
			</div>
			<div
				style="border: 1px dashed rgb(133, 13, 129); padding: 15px; width: 30%; display: flex; justify-content: center; align-items: center;">
				<span style="font-size: 24px; color: rgb(255, 0, 0);">[+]</span>
			</div>
		</div>

		<div style="margin-bottom: 20px;">
			<h3>Recent 5 transactions List</h3>
			<ul>
				<li>xxx</li>
				<li>xxx</li>
				<li>xxx</li>
				<li>xxx</li>
				<li>xxx</li>
			</ul>
			<button
				style="background-color: purple; color: white; border: none; padding: 8px 16px; border-radius: 5px;">
				Recent Statements</button>
		</div>
	</div>
</body>
</html>