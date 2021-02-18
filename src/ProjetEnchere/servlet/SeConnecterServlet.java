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
// pour git 
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
		HttpSession session = request.getSession();
		request.setAttribute("doGet", "ok");
		
		if(session.getAttribute("user")!=null) {
			request.getRequestDispatcher("/accueil").forward(request, response);
		}
		// info formulaire
		String login = request.getParameter("susername");
		String pass = request.getParameter("spassword");

		UtilisateurManager userManager = new UtilisateurManager();

		Utilisateur user = userManager.getUserByPseudoPassword(login, pass); // verif utilisateur
		
		if (user == null) {
			request.setAttribute("messageErreur", "Le compte n'existe pas");
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/seconnecter.jsp").forward(request, response);
		}else {
		// session utilis.
		//HttpSession session = request.getSession();// recu les sessions ds la variable sessaion
		session.setAttribute("user", user);// creer une session
		this.getServletContext().getRequestDispatcher("/accueil").forward(request, response);
		// retour accueil
		}
						
		}
	}

