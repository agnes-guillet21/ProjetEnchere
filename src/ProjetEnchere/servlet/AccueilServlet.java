package ProjetEnchere.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ProjetEnchere.bll.ArticleVenduManager;
import ProjetEnchere.bll.BLLException;
import ProjetEnchere.bll.CategorieManager;
import ProjetEnchere.bll.EnchereManager;
import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.bo.Categorie;
import ProjetEnchere.bo.Enchere;

/**
 * Servlet implementation class AccueilServlet
 */


public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String recherche = null;
	String categorie = "Toutes";
	String choix = "Tous";
	String filtreChoix = "EnCours";

//	EnchereManager enchereManager = EnchereManager.getEnchereManager();
//	CategorieManager categorieManager = CategorieManager.getCategorieManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ArticleVendu> listeEncheres = new ArrayList<>();
		ArticleVenduManager aVManager = ArticleVenduManager.getInstance();
		
		request.setCharacterEncoding("UTF-8");
		
//
////		List<Categorie> listCat = CategorieManager.getCategories();

			try {
				listeEncheres = aVManager.listerToutesLesVentes();
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

////		for (int i = 0; i < listEnchere.size(); i++) {
////			if (listEnchere.get(i).getArticleVendu().getDateDebutEncheres().before(Date.valueOf(LocalDate.now().plusDays(1))))
////			{
////				processEnchere.add(listEnchere.get(i));
////			}
////		}
		request.setAttribute("listeEncheres", listeEncheres);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
