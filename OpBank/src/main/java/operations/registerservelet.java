package operations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.customer;
import conn.Hibernatecustomer;
import doa.customerdoa;


@WebServlet("/registerservelet")
public class registerservelet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String cid=req.getParameter("cid");
		String name=req.getParameter("cname");
		String phnumber=req.getParameter("phnumber");
		String intamt=req.getParameter("balance");
		String cpin=req.getParameter("cpin");
		String dob=req.getParameter("dob");
		int userid=Integer.parseInt(cid.trim());
		Long balance=Long.parseLong(intamt.trim());
		int tid=Integer.parseInt(cpin.trim());
		customer c1=new customer(userid,name,phnumber,balance,tid,dob);
		customerdoa doa=new customerdoa(Hibernatecustomer.getsessionFactory());
		if(doa.savecustomer(c1)) {
			out.println("<h4>customer with Name "+ name +" is successfully registerd<h4><br>");
			out.println("<a href=register.jsp>Register another</a>");
		}
		else {
			out.print("Registration unsuccesfull try again...");
		}
		
	}

}
