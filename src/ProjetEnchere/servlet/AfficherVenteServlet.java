package ProjetEnchere.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ProjetEnchere.bll.EnchereManager;
import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.jdbc.DALException;
import ProjetEnchere.bo.Enchere;


public class AfficherVenteServlet {

	@WebServlet("/afficherVenteServlet")
	public class AfficherDetailEnchere extends HttpServlet {
		private static final long serialVersionUID = 1L;
	   
}
	
	
	@Override
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config); }
//		
//	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session =  request.getSession();
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
			
			
			
			int noArticle = 0;

			
			if (request.getParameter("noArticle")!=null) {
				noArticle = Integer.parseInt(request.getParameter("noArticle"));
			} else { 
				noArticle = (int) request.getAttribute("noArticle");
			}
			
			Enchere enchere = null;
			System.out.println("numero article :" + noArticle);
			try {			
				enchere = EnchereManager.select(noArticle);
			} catch (DALException e) {
				e.printStackTrace();
			}
			request.setAttribute("enchere",enchere);}
		
		
			/**
			 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
			 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}