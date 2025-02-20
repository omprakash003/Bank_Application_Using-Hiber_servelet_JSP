%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %>
<%
    HttpSession session2 = request.getSession();
    String name = (String) session2.getAttribute("name");
    Long balance=(Long) session2.getAttribute("balance");
    int tid=(Integer) session2.getAttribute("txid");
    
    
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Transfer</title>
<style>
.form{
display:flex;
justify-content:center;
padding:100px;
font-size:25px;
}
button{
align-content: center;
        height: 35px;
        border-radius: 10px;
        font-size: 15px;
        
        
}
</style>
</head>
<body>
<form action="op" method="post">
<div class="form">
<table>
<tr>
<td>
<h2>Hello  <%=name%>  Enter  Receiver details</h2><br>
<h3>Balance amount: <%=balance %></h3>
<label>Customer id</label>
<input type="text" name="rid" placeholder="Enter your Receiver id"><br><br>
<label>Enter amount </label>
<label>Rs.</label>
<input type="text" name="amt" placeholder="Enter valid amount "><br><br>
<label>Transaction id</label>
<input type="text" name="tid" placeholder="Enter your customer id"><br><br>
<button type="submit">Submit</button>
</td>
</tr>
</table>
</div>
</form>


</body>
</html>