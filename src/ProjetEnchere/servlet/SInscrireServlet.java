package ProjetEnchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.DAOFactory;
import ProjetEnchere.dal.UtilisateurDAO;
import ProjetEnchere.dal.jdbc.DALException;
import ProjetEnchere.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class SInscrireServlet
 */
@WebServlet("/inscription.html")
public class SInscrireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SInscrireServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/creercompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperer ts les infos ds les champs du formulaire
		String pseudo=request.getParameter("userpseudo");
		String nom=request.getParameter("username");
		String prenom=request.getParameter("userfirstname");
		String email=request.getParameter("usermail");
		String tel=request.getParameter("userphone");
		String rue=request.getParameter("user_street");
		String cp=request.getParameter("usercp");
		String ville=request.getParameter("city");
		String motDePasse=request.getParameter("spassword");
		String confirMP=request.getParameter("spassword2");
		
		request.setCharacterEncoding("UTF-8");
		
	//faire appelle a mon truc qui permet d enregistrer en base
		UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
		
		// on utilise tt par l utilisateurDAOJdbcimpl
		Utilisateur u1 = new Utilisateur(pseudo,nom,prenom,email,tel,rue,cp,ville,motDePasse,confirMP,0);
		
		
		//conditions pr valider le formulaire mot de passe soit identique.
		if(motDePasse == confirMP) {
			request.getParameter("spassword");
		}else {
			System.out.println("les deux mots de passes ne sont pas identiques");
		}
		
		 
		/*
		 *  pseudo et email doivent etre unique 
		 *  
		 *  dc si present ds laBDD => pas bon  
		 *  select , email from Utilisateurs where email = email;
		 *  si request.getParameter("userpseudo")== select pseudo , email from Utilisateurs where pseudo = pseudo,
		 */
		
	
		//test methode insert
		System.out.println("Ajout d'un utilisateur... ");
		try {
			utilisateurDAO.insert(u1);// ca c est mon insertion en base!
		} catch (DALException e) {
		request.setAttribute("erreur",e);
		}
		// faire une jsp erreur ds un folder erreur
		//request.getRequestDispatcher("/WEB-INF/erreur/erreur.jsp").forward(request, response);
		System.out.println("Utilisateur ajoute  : " + u1.toString() );
		
		
	}

}
