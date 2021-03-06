package ProjetEnchere.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
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
		RequestDispatcher rd = null;
		
		request.setCharacterEncoding("UTF-8");
	
		Utilisateur u1 = new Utilisateur(pseudo,nom,prenom,email,tel,rue,cp,ville,motDePasse,0);
		UtilisateurManager user = new UtilisateurManager(); 	
					
		try {
			
			user.validationFormulaire(pseudo, nom, prenom, email, tel, rue, cp, ville);
			user.validationMP(motDePasse, confirMP);
			
			if(user.verificationEmail(email)!= null) {
				System.out.println("le mail est deja existant");
			}
			user.InsertUtilisateur(u1);
			HttpSession session = request.getSession();// on creer une session au moment de l inscription 
			//on va lui passer l utilisateur en attribut
			Utilisateur user1 = user.getUserByPseudoPassword(u1.getPseudo(), u1.getMotDePasse());
			session.setAttribute("user", user1);
			rd = request.getRequestDispatcher("/accueil");
		} catch (BLLException e2) {
			request.setAttribute("erreurs",e2.getErreurs());//passage de la hashmap en attribut
			//response.getWriter().print("erreurs");
			rd = request.getRequestDispatcher("/WEB-INF/jsp/creercompte.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			rd.forward(request, response);
		}
	
	}
}
