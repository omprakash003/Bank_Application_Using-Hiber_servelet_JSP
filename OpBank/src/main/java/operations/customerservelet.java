package operations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Auth.customauth;
import Entities.customer;
import conn.Hibernatecustomer;

@WebServlet("/c1")
public class customerservelet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	String uid=req.getParameter("cid");
	String tid=req.getParameter("tid");
	customauth c1 = new customauth();
    SessionFactory ses = Hibernatecustomer.getsessionFactory();
    
    // Retrieve customer object
    customer customerData = c1.getCustomer(ses, uid);
    
    if (customerData != null) {
    	HttpSession session=req.getSession();
        out.println("Your Balance " + customerData.getBalance());
        session.setAttribute("name", customerData.getName());
        session.setAttribute("userid", customerData.getUserid());
        session.setAttribute("balance", customerData.getBalance());
        session.setAttribute("txid", customerData.getranxid());
        
        RequestDispatcher rd=req.getRequestDispatcher("operations.jsp");
        rd.forward(req, resp);
        
        
        
        
    } else {
        out.println("Userid and transaction id not found Not Found");
    }
	
}

}
