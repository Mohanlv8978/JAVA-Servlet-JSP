package registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import user.DAO;
import user.User;

import java.io.IOException;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       DAO dao=new DAO();
       User user=new User();
    
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		String fn=request.getParameter("firstName");
		String ln=request.getParameter("lastName");
		String em=request.getParameter("email");
		String pn=request.getParameter("Phone Number");
		String pas=request.getParameter("Password");
		
		
		String UserAlreadyExitMessage ="User Account Already Exists "+em+".Please Login";
		String RegistrationSuccessfull="Registration successfull";
		
			
			if(dao.UserExistWithEmail(em)) {
				
				response.setContentType("text/html");  
				
			    HttpSession hs = request.getSession();
			    hs.setAttribute("msg", UserAlreadyExitMessage);
			    
				RequestDispatcher rd =  request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
				}
			
			else {
				
				user.setFirstname(fn);
				user.setLastname(ln);
				user.setEmail(em);
				user.setPassword(pas);
				user.setPhone(pn);
				
				dao.insertuser(user);
				
				response.setContentType("text/html");  
				
				HttpSession hs = request.getSession();
				hs.setAttribute("msg",RegistrationSuccessfull );
				
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
				
			}
			
	}
}
