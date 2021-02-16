package ProjetEnchere.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ProjetEnchere.bll.BLLException;
import ProjetEnchere.bll.UtilisateurManager;
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
	public static final String PSEUDO ="userpseudo";
	public static final String NOM ="username";
	public static final String PRENOM="userfirstname";
	public static final String EMAIL = "usermail";
	public static final String TEL="userphone";
	public static final String RUE="user_street";
	public static final String CP="usercp";
	public static final String VILLE="city";
	public static final String ATT_ERREURS="erreurs";
	public static final String ATT_RESULTAT= "resultat";

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
		String resultat;
	 
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
				//	methode insert exist ds ma dal  mais on ne veut pas l appeler directmt
				// utiliser l utilisateurmanager
				// on utilise tt par l utilisateurDAOJdbcimpl
		
				Utilisateur u1 = new Utilisateur(pseudo,nom,prenom,email,tel,rue,cp,ville,motDePasse,0);
				// besoin d une instance de mon utilisateur manager , dc creation de variable 
				UtilisateurManager user = new UtilisateurManager();
				
					
					try {
						user.validationFormulaire(pseudo, nom, prenom, email, tel, rue, cp, ville);
						user.validationMP(motDePasse, confirMP);
						if(user.verificationEmail(email)!= null) 
						System.out.println("le mail est deja existant");
						user.InsertUtilisateur(u1);
						
					} catch (Exception e2) {
						e2.printStackTrace();
						//gerer la direction 
						//renvoyer sur la page inscription
						// garder les champs et plus message d erreur  => jsp avc EL
						//pr avoir les messages d erreurs  il faudra passer la hasmap en attribut 
				
					}
						

			
					HttpSession session = request.getSession();// on creer une session au moment de l inscription 
					//on va lui passer l utilisateur en attribut
					Utilisateur user1 = user.getUserByPseudoPassword(u1.getPseudo(), u1.getMotDePasse());
					session.setAttribute("user", user1);
					request.getRequestDispatcher("connexion.html").forward(request, response);
	}
	
}
					
		


//		//Stockage du resultat et des messages d'erreur dans l objet request
//		request.setAttribute(ATT_ERREURS, erreurs);
//		request.setAttribute(ATT_RESULTAT, resultat);

		//test methode insert
//		System.out.println("Ajout d'un utilisateur... ");
//		System.out.println("Utilisateur ajoute  : " + u1.toString() );
//		
//		
//		//redirection  sur la page d acceuil en mode connecter.
//		request.getRequestDispatcher("/ProjetEnchere").forward(request, response);
//	}
//	}
//	
//
//	

