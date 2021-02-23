package ProjetEnchere.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ProjetEnchere.bll.UtilisateurManager; // rajout import 
import ProjetEnchere.bo.Utilisateur;
 
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
		HttpSession session = request.getSession();
		RequestDispatcher rd;
	
		if(session.getAttribute("user")!=null) {
			rd = request.getRequestDispatcher("/accueil");
		}else{ rd = request.getRequestDispatcher("/WEB-INF/jsp/seconnecter.jsp");}
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		
		if(session.getAttribute("user")!=null) {
			request.getRequestDispatcher("/accueil");
		}

		String login = request.getParameter("susername");
		String pass = request.getParameter("spassword");

		UtilisateurManager userManager = new UtilisateurManager();

		Utilisateur user = userManager.getUserByPseudoPassword(login, pass);
		
		if (user == null) {
			request.setAttribute("messageErreur", "Le compte n'existe pas ou le mot de passe est incorrect");
			rd = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/seconnecter.jsp");
		} else {
		if (user.getFerme_le() != null) {
			request.setAttribute("messageErreur", "Le compte a été supprimé");
			rd = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/seconnecter.jsp");
		}else {

		session.setAttribute("user", user);
		rd = this.getServletContext().getRequestDispatcher("/accueil");
		}
						
		}
		rd.forward(request, response);
	}

}
