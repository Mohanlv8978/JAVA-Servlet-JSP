<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="user.Bank" %>
    <%@page import="user.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<%HttpSession hs=request.getSession(); %>
<%Bank b=new Bank();
User user=new User();
%>
	<div
		style="max-width: 800px; margin: auto; font-family: Arial, sans-serif;">
		<form action="Login.jsp" method="post">
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
				 String welcome = (String)hs.getAttribute("username");
				out.print(welcome); 
				%>       
				<span style="font-weight: bold;"></span>
			</h2>
		</div>

		<div
			style="color: aliceblue; background-color: rgb(80, 81, 154); padding: 15px; border: 2px solid rgb(227, 9, 231); margin-bottom: 20px;">
			<p>
				Account Number:<span style="font-weight: bold;">
					<%
					String accountnum=(String) hs.getAttribute("Accountnum"); 
					out.print(accountnum);
					
					%>
				</span>
			</p>
			<p>
				Account Balance: <span style="font-weight: bold;"></span>
				<%
				 String Ba=(String)hs.getAttribute("balance");
				out.print(Ba);
				
				%> 	
			</p>
			<p>
    		Wallet Balance: <span style="font-weight: bold;"></span>
    		<button style="background-color: rgb(255, 225, 0);"> + Add To Wallet </button>
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
					<%
				String bankname=(String) hs.getAttribute("bankname");
					out.print(bankname); 
					%>
					
					</p>
				<p>
					Account Number:
					<%
				 out.print(accountnum); 
				%>
				</p>

				<p>Balance:
				<%
				 out.print(Ba); 
				%>
				
				</p>

				<p>
					IFSC Code:
					<%
				String ifc=(String) hs.getAttribute("IFC");
				out.print(ifc);
				%>
				</p>

				<p>
					Branch:
					<%
				 String branch=(String)hs.getAttribute("branch");
					out.print(branch);
				
				%>
				</p>

				<button
					style="background-color: rgb(255, 0, 0); color: white; border: none; padding: 8px 16px; border-radius: 5px;">
					Edit</button>
			</div>
			<div
				style="background-color: rgb(147, 203, 225); padding: 15px; border: 1px solid rgb(136, 13, 132); width: 30%;">
				  <p style="background-color: rgb(23, 208, 32); color: white; border: none; padding: 8px 16px; border-radius: 5px; text-align: center;">
				  <%bankname=(String) hs.getAttribute("bankname2");
					out.print(bankname); %>
					</p>
				<p> Account Number: 
				<%
				 String ac =(String)hs.getAttribute("acccountnum2");
				out.print(ac);
				
				%> </p>
				
				<p>Balance:
				<%
				String balance2=(String)hs.getAttribute("balance2");
				out.print(balance2);
				%> </p>
				
				<p>IFSC Code:
				<%
			 String ifc2=(String)hs.getAttribute("ifc2");
				out.print(ifc2); 
				%>
				</p>
				
				<p>Branch:
				<%
				
				String d = (String) hs.getAttribute("branch2");
				out.print(d);   
				%>
				</p>
				
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