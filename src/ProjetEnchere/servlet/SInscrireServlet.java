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
		//  creation hasmap pr les erreurs
		//Map<String, String> erreurs = new HashMap<String, String>();
		
		
		//appel a mes methode de validation de formulaire
//		validationMP(motDePasse, confirMP );
//		validationFormulaire();
//		verificationEmail();
		
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
			UtilisateurManager.getInstance().InsertUtilisateur(u1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//test methode insert
		System.out.println("Ajout d'un utilisateur... ");
		// ca c est mon insertion en base!
		System.out.println("Utilisateur ajoute  : " + u1.toString() );

		request.getRequestDispatcher("/ProjetEnchere").forward(request, response);
	}



	//methodes validation MP et formulaire

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
	private void validationFormulaire(String pseudo, String nom, String prenom,String email,String tel,String rue, String cp,String ville ) throws Exception {
		if(pseudo != null && !pseudo.matches("[A-Za-z0-9_]+")){
			throw new Exception("caractere incorrectes, merci de saisir un autre pseudo");
		}
//		if(nom != null && nom.trim().length()>30) {
//			throw new Exception("le nom ne doit pas dépasser 30 caracteres, merci de saisir un autre nom");
//		}
//		if(prenom != null && prenom.trim().length()>30) {
//			throw new Exception("le prénom ne doit pas dépasser 30 caracteres, merci de saisir un autre prenom");
//		}
//		if(email != null && email.trim().length()>100) {
//			if(!email.matches("([^.@]+)(\\\\.[^.@]+)*@([^.@]+\\\\.)+([^.@]+)")) {
//				throw new Exception(" Merci de saisir une adresse mail valide.");
//			}
//		}else {
//			throw new Exception("l'email ne doit pas dépasser 20 caracteres");
//		}
//		if (tel != null && !tel.matches("\\+?[0-9][0-9][0-9]([0-9][0-9])+")){ // pas sur de ce regex
//			throw new Exception("Merci de saisir un numéro de téléphone valide.");
//		}
//		if(rue != null && rue.trim().length()>50) {
//			throw new Exception("Merci de saisir un nom de rue valide.");
//		}
//		if(cp != null && rue.trim().length()>50) {
//			throw new Exception("Merci de saisir un code postal valide.");
//		}
//		if(ville != null && ville.trim().length()>30) {
//			throw new Exception("Merci de saisir un nom de ville valide.");
//		}

	}
}
