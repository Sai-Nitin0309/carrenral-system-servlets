<%@page import="rentcar.Car"%>
<%@page import="rentcar.Booking"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Booking</title>
<style>
    body {
        font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(120deg, #dfe9f3, #ffffff);
        margin: 0;
        padding: 30px;
    }

    h2 {
        text-align: center;
        margin-bottom: 30px;
        color: #222;
        font-size: 28px;
        letter-spacing: 1px;
    }

    /* Car Card */
    .car-container {
        margin: 20px auto;
        padding: 25px;
        max-width: 650px;
        background: linear-gradient(135deg, #ffffff, #f7f9fc);
        border-radius: 14px;
        box-shadow: 0 6px 16px rgba(0, 0, 0, 0.1);
        transition: all 0.3s ease;
    }

    .car-container:hover {
        transform: translateY(-5px);
        box-shadow: 0 10px 22px rgba(0, 0, 0, 0.15);
    }

    .car-details {
        margin-bottom: 18px;
        padding-bottom: 12px;
        border-bottom: 1px solid #e0e0e0;
    }

    .car-details div {
        margin: 6px 0;
        font-size: 16px;
        color: #444;
    }

    .car-details strong {
        color: #111;
    }

    /* Form layout */
    form {
        display: flex;
        flex-wrap: wrap;
        gap: 12px;
        margin-top: 10px;
    }

    input[type="text"], input[type="date"] {
        flex: 1 1 calc(50% - 12px);
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 8px;
        font-size: 14px;
        background: #fafafa;
        transition: border 0.3s ease, box-shadow 0.3s ease;
    }

    input[type="text"]:focus, input[type="date"]:focus {
        border-color: #007bff;
        box-shadow: 0 0 6px rgba(0, 123, 255, 0.3);
        outline: none;
        background: #fff;
    }

    /* Full width input for username */
    input[name="username"] {
        flex: 1 1 100%;
    }

    /* Submit Button */
    button {
        flex: 1 1 100%;
        padding: 14px;
        background: linear-gradient(90deg, #007bff, #00c6ff);
        color: white;
        font-size: 15px;
        font-weight: bold;
        border: none;
        border-radius: 10px;
        cursor: pointer;
        transition: all 0.3s ease;
    }

    button:hover {
        background: linear-gradient(90deg, #0056b3, #0096c7);
        transform: translateY(-2px);
        box-shadow: 0 6px 16px rgba(0, 150, 255, 0.4);
    }

    button:active {
        transform: scale(0.97);
    }

    /* Responsive Design */
    @media (max-width: 600px) {
        form {
            flex-direction: column;
        }
        input[type="text"], input[type="date"], button {
            flex: 1 1 100%;
        }
    }
</style>
</head>
<body>

<h2>🚘 Available Cars for Booking</h2>

<%
    List<Car> carlist = (List<Car>) request.getAttribute("carlist");
    if (carlist != null && !carlist.isEmpty()) {
        for (Car c : carlist) {
%>
    <div class="car-container">
        <div class="car-details">
            <div><strong>Car ID:</strong> <%= c.getCarId() %></div>
            <div><strong>Car Name:</strong> <%= c.getCarName() %></div>
            <div><strong>Car Model:</strong> <%= c.getCarModel() %></div>
        </div>

        <form action="bookcar" method="POST">
            <input type="hidden" name="carid" value="<%= c.getCarId() %>">

            <input type="text" name="username" placeholder="Enter username" required>
            <input type="date" name="sdate" required>
            <input type="date" name="edate" required>

            <button type="submit">Book This Car</button>
        </form>
    </div>
<%
        }
    } else {
%>
    <p style="text-align:center; color:red;">No cars available for booking at the moment.</p>
<%
    }
%>

</body>
</html>
