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
		
		
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		
		try { 
			
			// Load the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create a connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblogin", "root","Mohanlv8978@");

			// Create a prepared statement
			PreparedStatement ps = con.prepareStatement("SELECT * FROM registration WHERE email =? AND password =?");

			// Set the parameters
			ps.setString(1, name);
			ps.setString(2, pass);

			// Execute the query
			ResultSet rs = ps.executeQuery();
		            
		 if(rs.next())
			{
				String email = name;
				PreparedStatement ps1 = con.prepareStatement("SELECT last_name FROM registration WHERE email = ?");
								  ps1 = con.prepareStatement("SELECT Account_Number FROM registration WHERE email = ?");
								  ps1 = con.prepareStatement("SELECT IFSC_Code FROM registration WHERE email = ?");
								  ps1 = con.prepareStatement("SELECT Branch FROM registration WHERE email = ?");
								  
				ps1.setString(1, email);
				
				String UserName = rs.getString("last_name");
				String AC = rs.getString("Account_Number");
				String Ifc = rs.getString("IFSC_Code");
				String Br = rs.getString("Branch");
				
							rs = ps.executeQuery();
				
				HttpSession hs = request.getSession();
							hs.setAttribute("kname", UserName);
							hs.setAttribute("Account number", AC);
							hs.setAttribute("IFSC Code", Ifc);
							hs.setAttribute("Branch", Br);
	

				// if(name.equals("Mohan")&& pass.equals("Mohanlv8978"))
				RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
				rd.forward(request, response);
		}
		else 
		{
			PrintWriter out = response.getWriter(); 
			out.println("inavlid login details");
		}
		}
		catch(Exception e) {
			PrintWriter out = response.getWriter();
			out.println(" login servlet Something went wrong.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
