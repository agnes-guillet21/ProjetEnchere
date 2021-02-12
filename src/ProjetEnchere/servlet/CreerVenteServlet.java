package ProjetEnchere.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ProjetEnchere.bll.CategorieManager;
import ProjetEnchere.bo.ArticleVendu;

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
		
		if (request.getAttribute("user") != null) {
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
		
		ArticleVendu a = new ArticleVendu();
		
		a.setNomArticle(request.getParameter("nomArticle"));
		a.setDescription(request.getParameter("description"));
		a.setCategorieArticle(cMger.selectByName(request.getParameter("categorie")));
		
		
		rd.forward(request, response);
	}

}
