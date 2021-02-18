package ProjetEnchere.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterConfig;
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
import ProjetEnchere.bll.UtilisateurManager;
import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.bo.Categorie;
import ProjetEnchere.bo.Enchere;


/**
 * Servlet implementation class AccueilServlet
 */
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		EnchereManager enchereManager = new EnchereManager();
		//CategorieManager categorieManager = CategorieManager.getCategorieManager();
		List<ArticleVendu> listeEncheres = new ArrayList<>();
		ArticleVenduManager aVManager = ArticleVenduManager.getInstance();
		//List<Categorie> listCat = CategorieManager.getCategories();
		String recherche = null;
		String categorie = "Toutes";
		String choix = "Tous";
		String filtreChoix = "EnCours";


		
		request.setCharacterEncoding("UTF-8"); // ???
		
		//mise en place d un filter
	
		// récup de la catégorie et de rechercher
		if(request.getParameter("categorie")!=null) {
			categorie = request.getParameter("categorie");
		}
		

		if(request.getParameter("ArticleVendu")!=null) { 			// La nomination n est probablement pas la bonne pour"articlevendu"
			recherche = request.getParameter("ArticleVendu");
		}
		
		System.out.println(categorie);
		System.out.println(recherche);
		
		try {
				
		// Recup liste categories pour select html
		listeEncheres = aVManager.listerToutesLesVentes();
		request.setAttribute("listeEncheres", listeEncheres);

		} catch (BLLException e) {
		e.printStackTrace();
		}

		
		
		

			
			
////		for (int i = 0; i < listEnchere.size(); i++) {
////			if (listEnchere.get(i).getArticleVendu().getDateDebutEncheres().before(Date.valueOf(LocalDate.now().plusDays(1))))
////			{
////				processEnchere.add(listEnchere.get(i));
////			}
////		}
			
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getAttribute("doGet").equals("ok")) {
			doGet(request, response);
		}
		
		String nomProduitRecherche= request.getParameter("srecherche");
		//instancie categorie manager 
		 Categorie c1 = new Categorie();
		 CategorieManager c = new CategorieManager();
		 ArticleVenduManager aVManager =  new ArticleVenduManager();
		 List<ArticleVendu> listeEncheres = new ArrayList<>();
		 
		 String categorie = request.getParameter("scategorie");
		 
		 if((nomProduitRecherche.isEmpty()|| nomProduitRecherche==null) && (categorie.isEmpty() || categorie==null)) {
			 try {
				listeEncheres= aVManager.listerToutesLesVentes();
				request.setAttribute("listeEncheres", listeEncheres);// renvoyer des infos faut les monter en attibuts
				request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);//je les envoie
			} catch (BLLException e) {
				e.printStackTrace();
			}
			 if(!nomProduitRecherche.isEmpty()|| nomProduitRecherche != null) {
				 // methode ds la dal select by critere ( ya 2 criteres le nom et la categorie)
				 
			 }
			  
		 }
		 //je veux modifier la liste des ventes en fction des filtres => categorie choisie
		 //transmettre le getparameter  a ma dal 
		 //ma dal ma m envoyer une liste des ventes en fction des para
		// lister par criteres presente ds ma dal
			//listeEncheres = aVManager.listerToutesLesVentes();
			//request.setAttribute("listeEncheres", listeEncheres);
		 
		 
		 request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);;
	}

}
