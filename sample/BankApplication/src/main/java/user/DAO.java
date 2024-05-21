package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	
	public boolean insertuser(User user) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		      
	      	// Create a connection
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblogin", "root", "Mohanlv8978@");
	      
	      
	      	// Create a prepared statement
	      String insertQuery = "INSERT INTO registration (first_Name, last_Name, email, phone_Number, password) VALUES ('" + user.getFirstname() + "','" + user.getLastname() + "','" + user.getEmail() + "','" + user.getPhone() + "','" + user.getPassword() + "')";
	      PreparedStatement ps = con.prepareStatement (insertQuery); 
	      ps.executeUpdate();
	      con.close();
			
		}
		catch(Exception e) 
		{
			System.out.println("Error: " + e.getMessage());
			
		}
		return false;
			
	}

		public boolean UserExistWithEmail(String em) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		      
	      	// Create a connection
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblogin", "root", "Mohanlv8978@");
	      
	      
	      	// Create a prepared statement
	      String insertQuery = "SELECT * FROM registration  where email='"+em+"'";
	      PreparedStatement ps = con.prepareStatement (insertQuery);
	      ResultSet rs = ps.executeQuery();
	      
	      
	      if(rs.next())
	      {
	    	  return true;
	      }
	      con.close();			
		}
		catch(Exception e) 
		{
			System.out.println("Error: " + e.getMessage());
			
		}
		return false;
	}
	
		public boolean UserValid(String uname, String upass) {
			
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create a connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblogin", "root","Mohanlv8978@");

			// Create a prepared statement
			PreparedStatement ps = con.prepareStatement
			                                           ("SELECT * FROM registration WHERE email ='"+uname+"' AND password ='"+upass+"'");
			

			ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
				 return true;
			 }
			 con.close();
			
		}
		catch(Exception e) {
			
			System.out.println("Error: " + e.getMessage());
			
		}
		
		return false;
		
	}
		
		public User UserInfoByEmail(String uname) {
			User user=new User();
//			Bank b=new Bank(); 		
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");

				// Create a connection
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblogin", "root","Mohanlv8978@");

				// Create a prepared statement
				PreparedStatement ps = con.prepareStatement("SELECT *FROM Registration INNER JOIN Bank_Accounts ON Registration.id = Bank_Accounts.id WHERE Registration.email = '"+uname+"'");
				                                           

				ResultSet rs = ps.executeQuery();
				
				 if(rs.next()) {
					 
					
					  					String username = rs.getString("last_name");
										user.setLastname(username);
				 }
				 con.close();
				
			}
				
			
			catch(Exception e) {
				
				
				System.out.println("Error: " + e.getMessage());
				
			}
			return user;
			
			
		}

		public Bank getbankdetailsbyemail(String uname) {
			
//		User user=new User();
			Bank b=new Bank();
			 		
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");

				// Create a connection
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblogin", "root","Mohanlv8978@");

				// Create a prepared statement
				PreparedStatement ps = con.prepareStatement("SELECT *FROM Registration INNER JOIN Bank_Accounts ON Registration.id = Bank_Accounts.id WHERE Registration.email = '"+uname+"'");
				
				ResultSet rs = ps.executeQuery();
				
				if ( rs.next()) {
					 
//					 PreparedStatement 	ps1 = con.prepareStatement("SELECT last_name FROM registration WHERE email = '"+uname+"'");
//					  					ps1 = con.prepareStatement("SELECT Account_Number FROM registration WHERE email = '"+uname+"'");
//					  					ps1 = con.prepareStatement("SELECT IFSC_Code FROM registration WHERE email = '"+uname+"'");
//					  					ps1 = con.prepareStatement("SELECT Branch FROM registration WHERE email = '"+uname+"'");
					 
												
					
										
										
					  					String Account = rs.getString("Account_id");
										String Ifc = rs.getString("IFSC_CODE");
										String Branch = rs.getString("Branch");
										String balance=rs.getString("Balance");
										String bankname=rs.getString("Bank_Name");
										  
										
										b.setAccountid(Account);
										b.setBalance(balance);
										b.setIFCCODE(Ifc);
										b.setBranch(Branch);
										b.setBankname(bankname);
										
				 }
				
				con.close();
			}
				
			
			catch(Exception e) {
				
				System.out.println("Error: " + e.getMessage());
			}
			
			return b;
		}

		public Bank get2ndbankdetailbyemil(String uname) {
			
			Bank b=new Bank();
			
			try {
			
				Class.forName("com.mysql.cj.jdbc.Driver");

				// Create a connection
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblogin", "root","Mohanlv8978@");
				
				PreparedStatement ps=con.prepareStatement("SELECT MAX(Bank_Accounts.Account_id)  AS Account_id FROM Registration INNER JOIN Bank_Accounts ON Registration.id = Bank_Accounts.id WHERE Registration.email = '"+uname+"'");
				
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) 
				{
					String account2=rs.getString("Account_id");
					b.setAccountid(account2);
					
				
				PreparedStatement ps1=con.prepareStatement("SELECT Balance  FROM registration INNER JOIN bank_accounts ON registration.id=bank_accounts.id WHERE bank_accounts.Account_id='"+account2+"'");
				PreparedStatement ps2=con.prepareStatement("SELECT  IFSC_CODE FROM registration INNER JOIN bank_accounts ON registration.id=bank_accounts.id WHERE bank_accounts.Account_id='"+account2+"'");
				PreparedStatement ps3=con.prepareStatement("SELECT  Branch FROM registration INNER JOIN bank_accounts ON registration.id=bank_accounts.id WHERE bank_accounts.Account_id='"+account2+"'");
				PreparedStatement ps4=con.prepareStatement("SELECT  Bank_Name FROM registration INNER JOIN bank_accounts ON registration.id=bank_accounts.id WHERE bank_accounts.Account_id='"+account2+"'");
				
				
				
				ResultSet 	rs1 = ps1.executeQuery();
				ResultSet  	rs2=  ps2.executeQuery();
				ResultSet  	rs3=  ps3.executeQuery();
				ResultSet  	rs4=  ps4.executeQuery();
				
					if(rs1.next()&&rs2.next()&&rs3.next()&&rs4.next())
					{
						
						
						String balance2=rs1.getString("Balance");
						String IFC2=rs2.getString("IFSC_CODE");
						String branch2=rs3.getString("Branch");
						String bankname2=rs4.getString("Bank_Name");
						
						
						b.setBalance(balance2);
						b.setIFCCODE(IFC2);
						b.setBranch(branch2);
						b.setBankname(bankname2);
					}
				}
				
			}
			catch(Exception e) {
				
				System.out.println("Error: " + e.getMessage());
			}
			
			return b;
			
			
		}
		
		
		
		
}
