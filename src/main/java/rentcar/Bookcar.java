package rentcar;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/bookcar")
public class Bookcar extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int carid=Integer.parseInt(req.getParameter("carid"));
	String username=req.getParameter("username");
	String startdate=req.getParameter("sdate");
	String enddate=req.getParameter("edate");
	
	Booking b=new Booking(carid,username,startdate,enddate);
	

	EntityManagerFactory emf =Persistence.createEntityManagerFactory("Nithin");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	et.begin();
	em.persist(b);
	
	Car carupdatestatus=em.find(Car.class, carid);
	carupdatestatus.setStatus("booked");
	em.merge(carupdatestatus);
	et.commit();
	resp.getWriter().print("car booked suceessfully");	
	resp.getWriter().print(carid+" "+carupdatestatus.getCarName());

}


}