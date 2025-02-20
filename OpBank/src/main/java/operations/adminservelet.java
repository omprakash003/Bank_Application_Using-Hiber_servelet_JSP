package operations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.spi.RegisterableService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Auth.adminauth;
import Entities.admin;
import conn.Hibernateadmin;
@WebServlet("/s1")
public class adminservelet extends HttpServlet{
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
	    PrintWriter out = resp.getWriter();

	    String uname = req.getParameter("username");
	    int pass = 0; // Default value to avoid errors

	    try {
	    	pass = Integer.parseInt(req.getParameter("password").trim());
	    } catch (NumberFormatException e) {
	        out.println("Invalid password format!");
	        return;
	    }

	    adminauth a1 = new adminauth();
	    boolean isValid = a1.verify(Hibernateadmin.getsessionFactory(), uname, pass);

	    if (isValid) {
	        RequestDispatcher rd = req.getRequestDispatcher("Register.jsp");
	        rd.forward(req, resp);
	    } else {
	        out.println("Username and password do not match.");
	    }
		
	
	}
	
	
	

}
