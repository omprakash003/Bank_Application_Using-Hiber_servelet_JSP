<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>

<title>customer Registration</title>
<style>
    body {
    background: linear-gradient(135deg, #667eea, #764ba2);
    color: white; /* Ensures text is readable */
}
    .content{
 
    padding: 40px;  /* Increased padding */
    border-radius: 10px;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
    justify-content: center;
    text-align: center;
    display: flex;
    flex-direction: column;
        font-size: 25px;
       
    }
    h1{
        text-align: center;
    }
    .content table{
        background-color: skyblue;
        height: 300px;
        border-collapse: collapse; /* Removes gaps between borders */
       table-layout: fixed;
        border-radius: 30px;
        color: black;
        
    }
    tr,td{
        padding: 12px;
       
    text-align: center; /* Centers text */
    }
    label {
    width: 150px; /* Fixed width for all labels */
    font-weight: bold;
}
    input{
    flex-grow: 1; /* Inputs take up remaining space */
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 5px;
}
    button{
        align-content: center;
        height: 35px;
        border-radius: 10px;
        font-size: 15px;
        font:bolder;
        color: green;
        border-color: darkgreen;
        
        
    }
</style>
</head>
<body>
<form action=registerservelet method=post>
<h1>Registration Page</h1>
<div class="content">

<table>
    
    
<tr>
<td>
<label>Customer Name</label>
<input type="text" name="cname" placeholder="Enter Customer name"><br><br>
    
<label>Customer Id</label>
<input type="number" name="cid" placeholder="Enter Customer ID"><br><br>
    
<label>Transaction Pin</label>
<input type="number" name="cpin" placeholder="Enter Transaction pin"><br><br>
    
<label>Phone Number</label>
<input type="text" name="phnumber" placeholder="Enter Phone Number"><br><br>

<label>D.O.B</label>
<input type="date" name="dob" placeholder="Enter DOB"><br><br>
    
<label>Intial amount</label>
<input type="number" name="balance" placeholder="Enter First Depsoit"><br><br>
    
<button type=Submit> Register Customer</button>

</td>
</tr>

</table>
</div>

</form>
</body>
</html>