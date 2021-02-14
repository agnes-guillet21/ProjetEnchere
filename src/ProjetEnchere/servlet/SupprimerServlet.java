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

import ProjetEnchere.bll.UtilisateurManager;
import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.jdbc.DALException;

@WebServlet("/SupprimerServlet")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  public SupprimerServlet() {
	        super();
	  }
	
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		   // initialisation erreur
		   
			List<Integer> listeCodesErreur = new ArrayList<>();

			//Récup utilisateur
			
			HttpSession session = (HttpSession) request.getSession().getAttribute("user");
			Utilisateur currentUser = (Utilisateur) session.getAttribute("user");

			//Suppression utilisateur
			UtilisateurManager userManager = new UtilisateurManager();
			try {
				userManager.delete(currentUser);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			//Déco utilisateur
			session.removeAttribute("user");
			session.invalidate();
			
			//Redirection profil
			
			if(listeCodesErreur.size() > 0) {
				request.setAttribute(" ", listeCodesErreur); // a renseigner
				request.setAttribute("user", currentUser);
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/modifierprofil.jsp").forward(request, response);
				
			//Redirection acceuil
			
			}else {
				List<Integer> listeCodeSuccess = new ArrayList<>();
				//listeCodeSuccess.add(/*a renseigner*/.SUPPRESSION_REUSSIE);
				request.setAttribute("listeCodesSuccess",listeCodeSuccess);
				this.getServletContext().getRequestDispatcher("/ProjetEnchere").forward(request, response);
			
			}
	   }
			
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
	   
	   }
}
// test envoie git