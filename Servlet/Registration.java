package Registration;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		PrintWriter out = response.getWriter();
//				out.println("hi");
		
		RequestDispatcher rd=request.getRequestDispatcher("Login.html");  
		rd.forward(request, response);
	}

}
