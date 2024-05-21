package login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import user.Bank;
import user.DAO;
import user.User;

import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 DAO dao=new DAO();
     User user=new User();
     Bank b=new Bank();
      

     
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		
		if(dao.UserValid(name, pass)) {
			
			HttpSession hs = request.getSession(); 
			
			 user=dao.UserInfoByEmail(name);
			 b=dao.getbankdetailsbyemail(name);
			
			 
			String username=user.getLastname();
			String Accountnum=b.getAccountid();
			
			String IFC=b.getIFCCODE();
			String branch=b.getBranch();
			String balance=b.getBalance();
			String bankname=b.getBankname();

						
			 			hs.setAttribute("username", username);
						hs.setAttribute("Accountnum",Accountnum );
						hs.setAttribute("IFC", IFC);
						hs.setAttribute("branch", branch);
						hs.setAttribute("balance", balance);
						hs.setAttribute("bankname", bankname);
			
						 b=dao.get2ndbankdetailbyemil(name);
						 String acccountnum2=b.getAccountid();
						 String balance2=b.getBalance();
						 String ifc2=b.getIFCCODE();
						 String branch2=b.getBranch();
						 String bankname2=b.getBankname();
						 
						 hs.setAttribute("acccountnum2", acccountnum2);
						 hs.setAttribute("balance2", balance2);
						 hs.setAttribute("ifc2", ifc2);
						 hs.setAttribute("branch2", branch2);
						 hs.setAttribute("bankname2", bankname2);
						 
			RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
			rd.forward(request, response);
		}
		else 
		{
			PrintWriter out = response.getWriter(); 
			out.println("inavlid login details");
		}
		
	}

}
