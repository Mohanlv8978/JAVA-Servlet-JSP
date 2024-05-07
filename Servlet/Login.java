package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		try { 
			
			
			
		    // Load the JDBC driver
		    Class.forName("com.mysql.cj.jdbc.Driver");

		    // Create a connection
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblogin", "root", "Mohanlv8978@");
		    
		    
		    String name=request.getParameter("uname");
		    String pass=request.getParameter("upass");
		 
	
		        // Create a prepared statement
		        PreparedStatement ps = con.prepareStatement("SELECT * FROM registration WHERE email =? AND password =?");
		        
		            // Set the parameters
		            ps.setString(1, name);
		            ps.setString(2, pass);
		            
		            
		            
		            // Execute the query
		            ResultSet rs = ps.executeQuery();
		            
		            HttpSession hs= request.getSession();
		    		hs.setAttribute(name, name);
		
		 if(rs.next())
			{
			 //		if(name.equals("Mohan")&& pass.equals("Mohanlv8978")) 
			RequestDispatcher rd=request.getRequestDispatcher("Dashboard.jsp");  
			rd.forward(request, response);
		}
		else 
		{
			PrintWriter out = response.getWriter(); 
			out.println("inavlid login details");
		}
		}
		catch(Exception e) {
			 System.out.println(" login servlet Something went wrong.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
