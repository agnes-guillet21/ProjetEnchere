package ProjetEnchere.servlet;

import java.io.IOException;
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
		//recuperer ts les infos ds les champs du formulaire
		String pseudo=request.getParameter("userpseudo");
		//		boolean valid = (pseudo!=null)&& pseudo.matches("[a-zA-Z0-9]+");//alphanumeric
		//		if("pseudo".equals("pseudo from Utilisateurs where pseudo = pseudo")){
		//			System.out.println("un compte avec cet email existe deja");
		//		}else{
		//			request.getParameter("pseudo");
		//			}
		//		
		String nom=request.getParameter("username");
		String prenom=request.getParameter("userfirstname");
		String email=request.getParameter("usermail");
		//		if("email".equals("email from Utilisateurs where email = email")){
		//			System.out.println("un compte avec cet email existe deja");
		//		}else{
		//			request.getParameter("usermail");
		//			}
		String tel=request.getParameter("userphone");
		String rue=request.getParameter("user_street");
		String cp=request.getParameter("usercp");
		String ville=request.getParameter("city");
		String motDePasse=request.getParameter("spassword");
		String confirMP=request.getParameter("spassword2");
		//		if(motDePasse.equals(confirMP) {
		//			request.getParameter("spassword");
		//		}else {
		//			System.out.println("les deux mots de passes ne sont pas identiques");
		//		}
		request.setCharacterEncoding("UTF-8");

		/*
		 * if("email".equals(email from Utilisateurs where email = email){
		 * System.out.println("un compte avec cet email existe deja");
		 * }else{
		 * request.getParameter("usermail");
		 * }
		 * 
		 *  pseudo et email doivent etre unique 
		 *  
		 *  dc si present ds laBDD => pas bon  
		 *  select , email from Utilisateurs where email = email;
		 *  si request.getParameter("userpseudo")== select pseudo , email from Utilisateurs where pseudo = pseudo,
		 */
		//pseudo caractere alphanumerique:
		//			if(request.getParameter("userpseudo"){
		//				request.getParameter("userpseudo");
		//		}else {
		//			System.out.println("Caractères non autorisés pour le pseudo");
		//		}
		//	






		//faire appelle a mon truc qui permet d enregistrer en base
		//	methode insert exist ds ma dal  masi on ne veut pas l appeler directmt
		// utiliser l utilisateurmanager

		// on utilise tt par l utilisateurDAOJdbcimpl
		Utilisateur u1 = new Utilisateur(pseudo,nom,prenom,email,tel,rue,cp,ville,motDePasse,0);
		UtilisateurManager.getInstance().InsertUtilisateur(u1);

		//test methode insert
		System.out.println("Ajout d'un utilisateur... ");
		// ca c est mon insertion en base!
		System.out.println("Utilisateur ajoute  : " + u1.toString() );


		request.getRequestDispatcher("/ProjetEnchere").forward(request, response);







	}

}
