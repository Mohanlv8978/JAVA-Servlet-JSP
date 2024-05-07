<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
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
				Welcome <span style="font-weight: bold;"></span>
			</h2>
		</div>

		<div
			style="color: aliceblue; background-color: rgb(80, 81, 154); padding: 15px; border: 2px solid rgb(227, 9, 231); margin-bottom: 20px;">
			<p>
				Account Number:<span style="font-weight: bold;">8899535788</span>
			</p>
			<p>
				Account Balance: <span style="font-weight: bold;">1650.0</span>
			</p>
			<p>
				Wallet Balance: <span style="font-weight: bold;">50.00</span> <a
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
				style="background-color: rgb(147, 203, 225); padding: 15px; border: 1px solid rgb(136, 13, 132); width: 30%;">
				<p>STATE BANK OF INDIA</p>
				<p>Bank Acct No:8899535788</p>
				<p>Balance:1650.0</p>
				<p>IFSC Code:1002</p>
				<p>Branch:Gajuwaka</p>
				<button
					style="background-color: rgb(255, 0, 0); color: white; border: none; padding: 8px 16px; border-radius: 5px;">
					Edit</button>
			</div>
			<div
				style="background-color: rgb(147, 203, 225); padding: 15px; border: 1px solid rgb(136, 13, 132); width: 30%;">
				<p>BANK NAME</p>
				<p>Bank Acct No: 1234</p>
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
				<li>1000 Sent to Sirisha</li>
				<li>2500 Received from Daddy</li>
				<li>150 Received from Momy</li>
				<li>2000</li>
				<li>xxxx</li>
			</ul>
			<button
				style="background-color: purple; color: white; border: none; padding: 8px 16px; border-radius: 5px;">
				Recent Statements</button>
		</div>
	</div>
</body>
</html>