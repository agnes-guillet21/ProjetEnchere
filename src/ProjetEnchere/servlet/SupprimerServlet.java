package ProjetEnchere.servlet;

import java.io.IOException;
import java.util.List;

import ProjetEnchere.bll.UtilisateurManager;
import ProjetEnchere.bo.Utilisateur;

@WebServlet("/SupprimerServlet")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  public SupprimerServlet() {
	        super();
	
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		   // initialisation erreur
		   
			List<Integer> listeCodesErreur = new ArrayList<>();

			//Récup utilisateur
			
			HttpSession session = request.getSession();
			Utilisateur currentUser = (Utilisateur) session.getAttribute("user");

			//Suppression utilisateur
			
			UtilisateurManager userManager = UtilisateurManager.getInstance();
			try {
				userManager.deleteUtilisateur(currentUser);
			} catch (  e) { // a renseigner !?
				listeCodesErreur.addAll( e.getListeCodesErreur());
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
				listeCodeSuccess.add(/*a renseigner*/.SUPPRESSION_REUSSIE);
				request.setAttribute("listeCodesSuccess",listeCodeSuccess);
				this.getServletContext().getRequestDispatcher("/ProjetEnchere").forward(request, response);
			
			}
	   }
			
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
	   
	   }
// test envoie git