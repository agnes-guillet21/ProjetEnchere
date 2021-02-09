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

import ProjetEnchere.bll.CategorieManager;
import ProjetEnchere.bll.EnchereManager;
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

	UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
	EnchereManager enchereManager = EnchereManager.getEnchereManager();
	CategorieManager categorieManager = CategorieManager.getCategorieManager();

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

		// Init. des messages
		List<Integer> listeCodeSuccess = new ArrayList<>();
		if (listeCodeSuccess.size() > 0) {
			request.setAttribute("listeCodesSuccess", listeCodeSuccess);
		}

		if (choix == null) {
			choix = "Tous";
		}

		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp");

		List<Categorie> listCat = CategorieManager.getCategories();
		List<Enchere> listEnchere = EnchereManager.getEncheres();

		List<Enchere> processEnchere = new ArrayList<>();

		HttpSession session = request.getSession();


		for (int i = 0; i < listEnchere.size(); i++) {
			if (listEnchere.get(i).getArticleVendu().getDateDebutEncheres().before(Date.valueOf(LocalDate.now().plusDays(1))))
			{
				processEnchere.add(listEnchere.get(i));
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
