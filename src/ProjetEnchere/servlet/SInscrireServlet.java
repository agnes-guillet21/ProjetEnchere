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
		//  creation hasmap pr les erreurs
		Map<String, String> erreurs = new HashMap<String, String>();



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
				try {
					// besoin d une instance de mon utilisateur manager , dc vreation de variable 
					UtilisateurManager user = new UtilisateurManager();
					user.InsertUtilisateur(u1);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
		//VERIFACATION 
				
		try {
			validationMP(motDePasse, confirMP);
			validationFormulaire(pseudo, nom, prenom, email, tel, rue, cp, ville);
			UtilisateurManager utilisateur = UtilisateurManager.getInstance().verificationEmail(email);
		}catch (Exception e) {
			erreurs.put(PSEUDO, e.getMessage());
			erreurs.put(NOM, e.getMessage());
			erreurs.put(PRENOM, e.getMessage());
			erreurs.put(EMAIL, e.getMessage());
			erreurs.put(TEL, e.getMessage());
			erreurs.put(RUE, e.getMessage());
			erreurs.put(CP, e.getMessage());
			erreurs.put(VILLE, e.getMessage());
			//gerer les erreur de valaidation ici
		}

		
		//initialisation du resultat global de la validation
		if(erreurs.isEmpty()) {
			resultat= "Succes de l'inscription.";
		}else  {
			resultat = "Echec de l inscription";
		}

		//Stockage du resultat et des messages d'erreur dans l objet request
		request.setAttribute(ATT_ERREURS, erreurs);
		request.setAttribute(ATT_RESULTAT, resultat);

		//test methode insert
		System.out.println("Ajout d'un utilisateur... ");
		System.out.println("Utilisateur ajoute  : " + u1.toString() );
		
		
		//redirection  sur la page d acceuil en mode connecter.
		request.getRequestDispatcher("/ProjetEnchere").forward(request, response);
	}



	//METHODE VALIDATION FORMULAIRE a externaliser b

	private void validationMP(String motDePasse, String confirMP)throws Exception{
		if(motDePasse !=null && motDePasse.trim().length() !=0 && confirMP != null &&
				confirMP.trim().length()!=0) {
			if(!motDePasse.equals(confirMP)) {
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			}else if(motDePasse.trim().length()>30) {
				throw new Exception("le mot de passe ne doit pas depasser 30 caracteres");
			}
		}else {
			throw new Exception("Merci de saisir et de confirmer votre mot de passe");
		}
	}
	
	
	private void validationFormulaire(String pseudo, String nom, String prenom,String email,String tel,String rue, String cp,String ville) throws Exception {
		//creation variable bll exception
		//bll excpt je vais decla ma hashmap
		//il ne faut pas que je lance une exception  , je veux juste alimenter ma mah avc mon mess correspondant 
		if(pseudo != null && !pseudo.matches("[A-Za-z0-9_]+")){
			throw new Exception("caractere incorrectes, merci de saisir un autre pseudo");
		}
		if(nom != null && nom.trim().length()>30) {
			throw new Exception("le nom ne doit pas dépasser 30 caracteres, merci de saisir un autre nom");
		}
		if(prenom != null && prenom.trim().length()>30) {
			throw new Exception("le prénom ne doit pas dépasser 30 caracteres, merci de saisir un autre prenom");
		}
		if(email != null && email.trim().length()>100) {
			if(!email.matches("([^.@]+)(\\\\.[^.@]+)*@([^.@]+\\\\.)+([^.@]+)")) {
				throw new Exception(" Merci de saisir une adresse mail valide.");
			}
		}else {
			throw new Exception("l'email ne doit pas dépasser 20 caracteres");
		}
		if (tel != null && !tel.matches("\\+?[0-9][0-9][0-9]([0-9][0-9])+")){ // pas sur de ce regex
			throw new Exception("Merci de saisir un numéro de téléphone valide.");
		}
		if(rue != null && rue.trim().length()>50) {
			throw new Exception("Merci de saisir un nom de rue valide.");
		}
		if(cp != null && rue.trim().length()>50) {
			throw new Exception("Merci de saisir un code postal valide.");
		}
		if(ville != null && ville.trim().length()>30) {
			throw new Exception("Merci de saisir un nom de ville valide.");
		}

	}
}
