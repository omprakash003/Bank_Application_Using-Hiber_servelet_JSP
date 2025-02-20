<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
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
<form action="c1" method="post">
<div class="form">
<table>
<tr>
<td>
<h2>Enter Your Credentials</h2><br>
<label>Customer id</label>
<input type="text" name="cid" placeholder="Enter your customer id"><br><br>
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