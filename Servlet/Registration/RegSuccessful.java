package Registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class RegSuccessful
 */
public class RegSuccessful extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegSuccessful() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		Write SQL Connection here
		
		//		Write SQL Connection here
	String fn=request.getParameter("firstName");
	String ln=request.getParameter("lastName");
	String em=request.getParameter("email");
	String pn=request.getParameter("Phone Number");
	String pas=request.getParameter("Password");
	
	try 
	{
			// Load the JDBC driver
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      
	      	// Create a connection
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblogin.registration", "root", "Mohanlv8978@");
	      
	      
	      	// Create a prepared statement
	      PreparedStatement ps = con.prepareStatement("insert into registration values(?,?,?,?,?)"); 
	      
	      	//Assigning ??? to values
	      
	      ps.setString(1, fn);
	      ps.setString(2, ln);
	      ps.setString(3, em);
//	      ps.setInt(4, Integer.parseInt(pn));
	      ps.setString(4, pn);
	      ps.setString(5, pas);
	      
	      int i= ps.executeUpdate();
	      if(i>0) 
	      {
//	    	  response.sendRedirect("reglogin.html");
	    	  RequestDispatcher rd=request.getRequestDispatcher("reglogin.html");  
	  		rd.forward(request, response);
	      }
	      else 
	      {
	    	  System.out.println("try 'if else' is printed.");
	      }
	      
	}
	catch(Exception e) 
	{
		 System.out.println("catch is printed.");
	}	
	
	}

}
