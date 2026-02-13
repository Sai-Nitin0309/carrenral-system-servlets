package rentcar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/carregister")
public class RegisterCar extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String carname=req.getParameter("carname");
		System.out.println(carname);
		int carid=Integer.parseInt(req.getParameter("carid"));
		System.out.println(carid);
	
		String carmodel=req.getParameter("carmodel");
		System.out.println(carmodel);
		String carowner=req.getParameter("carowner");
		System.out.println(carowner);
		
		int carnum=Integer.parseInt(req.getParameter("carnumber"));
		System.out.println(carnum);

		Car c =new Car(carid, carname, carmodel, carnum, carowner);
		System.out.println(c);
		
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("Nithin");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
		
		 PrintWriter pw=resp.getWriter();
		 pw.println("cra has been registered");
		
	}
	

}