package ProjetEnchere.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SeDeconnecterServlet")
public class SeDeconnecterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public SeDeconnecterServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	 }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 
	 // suppression session 
	 HttpSession session = request.getSession();
		session.removeAttribute("Utilisateur");
		session.invalidate();
		
		// retour acceuil
		this.getServletContext().getRequestDispatcher("/ProjetEnchere").forward(request, response); 
	 }


	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
	
	 }

}