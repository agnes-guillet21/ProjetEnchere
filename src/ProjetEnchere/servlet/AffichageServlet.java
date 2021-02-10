package ProjetEnchere.servlets;

import java.io.IOException;


import ProjetEnchere.bll.UtilisateurManager; // import à completer
import ProjetEnchere.bo.Utilisateur;

@WebServlet("/AffichageServlet")
public class AffichageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AffichageServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    			// Initialisation erreurs
    		List<Integer> listeCodesErreur=new ArrayList<>();

    		UtilisateurManager userManager = UtilisateurManager.getInstance(); 

    		boolean isCurrentUser = true; // pour afficher le bouton modif ou pas
    		
    		
    		if(request.getParameter("profil") != null) {
    			
    			int id = Integer.parseInt((request.getParameter("profil")));  // recup id utilisateur
    			isCurrentUser = false;

    			try {	
    				Utilisateur user =  userManager.getUtilisateurById(id); // recup infos utilisateur
    				request.setAttribute("otherUser", user);
    			} catch (Exception e) { // créer exeption !?
    				request.setAttribute(" ",e.get /**liste...*/ ()); // a renseigner
    				e.printStackTrace();
    			}
    			
    		}
    		
    		request.setAttribute("isCurrentUser",isCurrentUser);
    		request.setAttribute("displayNav", false);
    		
    		// retour page profil
    		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/.jsp").forward(request, response); // a renseigner
    	
    		
    		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    			//TODO Auto-generated method stub
    			doGet(request, response);
	}

}