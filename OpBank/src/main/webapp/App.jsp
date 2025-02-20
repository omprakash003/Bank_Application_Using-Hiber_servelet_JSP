<%@ page import="java.util.*" %>
<%@page session="true" %>
<html lang="en">
<head>
    <title>OP Banks Money is Everything</title>
    <style>
        /* Red Top Border with Moving Text */
        .top-border {
            width: 100%;
            height: 100px; /* Increased height as per your requirement */
            background-color: skyblue;
            position: fixed; /* Always stays at the top */
            top: 0;
            left: 0;
            z-index: 10; /* Ensures it's above everything */
            overflow: hidden; /* Prevents text from overflowing */
            display: flex;
            align-items: center; /* Vertically centers the text */
        }

        /* Moving Text */
        .moving-text {
            width: 100%;
            color: white;
            font-size: 50px; /* Adjusted for better visibility */
            font-weight: bold;
            white-space:pre-wrap;/* Prevents text from wrapping */
            overflow: hidden;
        }

        /* Scrolling Text Animation */
        .moving-text span {
            display: inline-block;
            animation: marquee 10s linear infinite; /* Slower animation for smooth scrolling */
        }

        /* Keyframes for scrolling text */
        @keyframes marquee {
            0% { transform: translateX(100%); }
           
            100% { transform: translateX(-100%); }
        }

        /* Background Image (Scrollable) */
        body {
            margin: 0; /* Remove default margin */
            padding-top: 110px; /* Push content below the large border */
            background-image: url('image/Bank.jpg'); /* Replace with your image */
            background-size: cover; /* Cover the entire screen */
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: scroll; /* Allows the background to scroll */
        }

        /* Content */
        .content {
            text-align: center;
            color: white;
            font-size: 24px;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.6); /* Semi-transparent background */
            margin: 20px auto;
            width: 80%;
            border-radius: 10px;
        }
         table {
            width: 100%; /* Full width */
            border-collapse: collapse;
             border-spacing: 10px;
        }
        th, td {
            
            padding: 10px;
            text-align: center;
            width: 33.33%;
            color:white;
           
        }

        /* Extra content to force scrolling */
        .extra-content {
            height: 200vh; /* Increase this value to make page longer */
        }
        a{
        color:red;
        }
    </style>
</head>
<body>
<%
String username=(String)session.getAttribute("username");
if(username==null){
	username="Guest";
}
%>

   
    <div class="top-border">
        <div class="moving-text">
            <span><%=username %> Welcome to OP Bank</span>
        </div>
    </div>

    
    <div class="content">
        <table>
            <tr>
                <td>
                    <h3>Services</h3><br>
                    <a href="user.jsp" class="button-link">Money Transfer</a><br><br>
                    <a href="Operations.jsp">Check Balance</a>
                </td>
                
                 <td>
                 <h3>Admin</h3><br>
                 <a href=Admin.jsp>Admin_Login</a>
                 </td>
                 
                 <td>
                    <h3>About Us</h3><br>
                    <a href="https://en.wikipedia.org/wiki/State_Bank_of_India">
               Click to Know More</a>
                </td>
                 
            </tr>
       
           

       
        </table>
    </div>

    <!-- Extra Content to Enable Scrolling -->
    <div class="extra-content"></div>

</body>
</html>

