package rentcar;



import java.io.IOException;

import java.util.List;



import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;

import javax.persistence.EntityTransaction;

import javax.persistence.Persistence;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@WebServlet("/carbooked")

public class CarBooked extends HttpServlet {

	

	

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

	

	EntityManagerFactory emf =Persistence.createEntityManagerFactory("Nithin");

	EntityManager em=emf.createEntityManager();

	EntityTransaction et=em.getTransaction();

	et.begin();

	String query="select b from Booking b";

	 List<Booking> booklist=em.createQuery(query).getResultList();

//	List<Booking> booklist= new Bookcar().getAllBookings(); 

	  req.setAttribute("booklist", booklist);

	    

	    RequestDispatcher rd= req.getRequestDispatcher("bookedcars.jsp");

	    rd.forward(req, resp);

	

	   et.commit();

	   

	   

	  

	

	  

	}

}