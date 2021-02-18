package ProjetEnchere.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ProjetEnchere.bll.ArticleVenduManager;
import ProjetEnchere.bll.EnchereManager;
import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.jdbc.DALException;
import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.bo.Enchere;

/**
 * Servlet implementation afficherVente
 */
@WebServlet("/vente.html")
public class AfficherVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherVenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =  request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		ArticleVenduManager aVenduMger = new ArticleVenduManager();		

		
		ArticleVendu nomArticle = null;
		
		int id = Integer.parseInt(request.getParameter("idArticle"));
		
		try {
			nomArticle = ArticleVenduManager.selectArticleById(id); //par numero et pas par id ^^
		} catch (DALException e) {
			
			e.printStackTrace();
		}
		if (nomArticle != null) {
			request.setAttribute("nomArticle", nomArticle);
			
			request.getRequestDispatcher("/WEB-INF/jsp/affichervente.jsp").forward(request, response);
		}
		
		//	R�cup�rer l'articleVendu pass� en param�tre de la requ�te http
		
		//  Pr�parer l'envoi de l'articleVendu r�cup�r� � la jsp affichervente.jsp
			
		request.setAttribute("titreDePage", "D�tail Vente");
		request.setAttribute("nomDePage", "DETAIL VENTE");
	
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}