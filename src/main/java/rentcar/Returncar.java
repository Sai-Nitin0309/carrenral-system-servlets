package rentcar;
import java.io.IOException;

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

@WebServlet("/CompleteRideServlet")
public class Returncar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int bookid = Integer.parseInt(req.getParameter("bookId")); // Get book ID from request

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Nithin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
Booking booking=em.find(Booking.class,bookid);
       
Car car=em.find(Car.class, booking.getCarid());
car.setStatus("registered");
em.merge(car);
        // Step 3: Remove the booking
        em.remove(booking);
    et.commit();
    RequestDispatcher rd = req.getRequestDispatcher("reg.html");
        rd.forward(req, resp); // ✅ Forward after commit
        
    }
}