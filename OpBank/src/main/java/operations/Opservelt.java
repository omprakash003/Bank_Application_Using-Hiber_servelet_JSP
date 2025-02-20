package operations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Auth.customauth;
import conn.Hibernatecustomer;


@WebServlet("/op")
public class Opservelt extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession();
		
		Long balance=(Long)session.getAttribute("balance");
		String amount=req.getParameter("amt");
		Long amt=Long.parseLong(amount.trim());
		String name=(String)session.getAttribute("name");
		
		int sid=(Integer)session.getAttribute("userid");
		String ridd=req.getParameter("rid");
		int rid=Integer.parseInt(ridd.trim());
		if(amt>balance) {
			out.print("Insufficient balance");
		}
		else {
			customauth c1=new customauth();
		if(	c1.updatetransaction(Hibernatecustomer.getsessionFactory(),sid, rid, amt, balance)) {
			out.print("Money Debited");
		}
			
		}
	}

}
