<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="rentcar.Booking"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Details</title>
    <style>
        .booking-card {
            max-width: 400px;
            margin: 30px auto;
            padding: 20px;
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            font-family: Arial, sans-serif;
        }

        .booking-card div {
            margin-bottom: 12px;
            font-size: 16px;
        }

        .booking-card strong {
            color: #333;
            display: inline-block;
            width: 120px;
        }

        .booking-card button {
            padding: 10px 20px;
            background-color: #28a745;
            border: none;
            color: white;
            font-weight: bold;
            cursor: pointer;
            border-radius: 5px;
        }

        .booking-card button:hover {
            background-color: #218838;
        }
    </style>
</head>


<body>




<%List<Booking> booklist=(List<Booking>) request.getAttribute("booklist"); %>



<%for(Booking b:booklist){%>
	
	
	




	
	   <div class="booking-card">
	   
	    
	<div><strong>BOOK Id </strong>  <%=b.getBookId() %></div>
      <div> <strong> Car ID </strong>  <%=b.getCarid() %> </div> 
		<div><strong> Car Username </strong>  <%=b.getUsername() %></div>
		<div><strong> Car sdate </strong>  <%=b.getSdate() %> </div>
		<div><strong> Car Endate </strong>  <%=b.getEdate() %></div>
		
		 <form action="CompleteRideServlet"> 
		 <input type="hidden" name="bookId" value="<%=b.getBookId() %>">
		
		  <button type="submit">Ride Completed</button>
        </form>
         </div>
	
<%}%>


	







 
</body>
</html>

    