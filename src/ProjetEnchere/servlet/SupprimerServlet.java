package ProjetEnchere.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ProjetEnchere.bll.BLLException;
import ProjetEnchere.bll.UtilisateurManager;
import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.jdbc.DALException;

@WebServlet("/SupprimerCompte.html")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  public SupprimerServlet() {
	        super();
	  }

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session = (HttpSession) request.getSession();
			Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
			UtilisateurManager userManager = new UtilisateurManager();
			
			try {
				userManager.fermer(currentUser);
			} catch (DALException e1) {
				e1.printStackTrace();
			} catch (BLLException e) {
				e.printStackTrace();
			}
			
			session.removeAttribute("user");
			request.setAttribute("suppressionOK", "Votre compte a bien été supprimé");
			request.getRequestDispatcher("/deconnexion.html").forward(request, response);
			session.invalidate();
			
	   }
			
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
	   
	   }

}