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

import ProjetEnchere.bll.UtilisateurManager; // rajout import 
import ProjetEnchere.bo.Utilisateur;
// pour git !
/**
 * Servlet implementation class SeConnecterServlet
 */
@WebServlet("/connexion.html")
public class SeConnecterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeConnecterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/seconnecter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		// info formulaire
		String login = request.getParameter("Identifiant");
		String pass = request.getParameter("MotDePasse"));

		UtilisateurManager userManager = UtilisateurManager.getInstance();

		try {
			Utilisateur user = userManager.getUtilisateurByPseudoPassword(login, pass); // verif utilisateur
			
			// session utilis.
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
		} catch (Exception e) { // a créer pour gerer les erreurs !?
			errors = true;
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}
		
		// si erreur retour vers formulaire login
		if(errors) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/seconnecter.jsp").forward(request, response);
	}
		// retour acceuil
		}else{
				this.getServletContext().getRequestDispatcher("/ProjetEnchere").forward(request, response);
				
		}
}