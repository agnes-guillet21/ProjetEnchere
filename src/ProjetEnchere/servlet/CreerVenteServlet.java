package ProjetEnchere.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ProjetEnchere.bll.ArticleVenduManager;
import ProjetEnchere.bll.CategorieManager;
import ProjetEnchere.bll.RetraitManager;
import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.bo.Categorie;
import ProjetEnchere.bo.EtatVente;
import ProjetEnchere.bo.Retrait;
import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.jdbc.DALException;

/**
 * Servlet implementation class CreerVenteServlet
 */
@WebServlet("/vendre.html")
public class CreerVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerVenteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession session = request.getSession();

		CategorieManager cMger = new CategorieManager();
		List<Categorie> listeCategories = new ArrayList<Categorie>();
		
		try {
			listeCategories = cMger.selectAll();
			request.setAttribute("listeCategories", listeCategories);
		} catch (DALException ex) {
			ex.printStackTrace();
		}
		
		if (session.getAttribute("user") != null) {
			rd = request.getRequestDispatcher("/WEB-INF/jsp/vendrearticle.jsp");
		}else {
			rd = request.getRequestDispatcher("connexion.html");
		}
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		CategorieManager cMger = new CategorieManager();
		RetraitManager rMger = new RetraitManager();
		ArticleVenduManager aMger = new ArticleVenduManager();
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("user");
		ArticleVendu a = new ArticleVendu();
		Retrait r = new Retrait(request.getParameter("rue"), request.getParameter("codePostal"), request.getParameter("ville"));
		
		a.setNomArticle(request.getParameter("nomArticle"));
		a.setDescription(request.getParameter("description"));
		a.setCategorieArticle(cMger.selectByName(request.getParameter("categorie")));
		a.setDateDebutEncheres(LocalDate.parse(request.getParameter("dateDebutEnchere")));
		a.setDateFinEncheres(LocalDate.parse(request.getParameter("dateFinEnchere")));
		a.setMiseAPrix(Integer.parseInt(request.getParameter("miseAPrix")));
		a.setEtatVente(EtatVente.EN_COURS);
		a.setUtilisateurVendeur(u);
		//TODO Test sur le lieu de retrait
//		if(rMger.selectByCriteres(r)==null) {
//			rMger.insert(r);
//		}
		// la je fais appel select des critere
		//si elle est vide je peux faire l insertion 
		//sinon je leve une exception qui me dira lieu de retrait deja existant ds la bdd
		
		
		//lieu de retrait  on l insere lors de la creation de la vente
		// si lieu de retrait est deja existant ca ne doit pas bloquer la creation 
		a.setLieuRetrait(rMger.selectByCriteres(r));
		aMger.insert(a);
		
		request.setAttribute("doGet", "ok");
		rd = request.getRequestDispatcher("/accueil");
		rd.forward(request, response);

	}

}
