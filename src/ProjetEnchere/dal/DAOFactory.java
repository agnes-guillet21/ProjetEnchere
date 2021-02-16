package ProjetEnchere.dal;

import ProjetEnchere.dal.jdbc.ArticleVenduDAOJdbcImpl;
import ProjetEnchere.dal.jdbc.CategorieDAOJdbcImpl;
import ProjetEnchere.dal.jdbc.RetraitDAOJdbcImpl;
import ProjetEnchere.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * Classe g�rant le contact avec la couche DAL
 * @author Team F
 *
 */
public abstract class DAOFactory {

	
	/**
	 * M�thode permettant d'instancier un objet UtilisateurDAO avec une instance UtilisateurDAOJdbcImpl 
	 * @return une instance d'UtilisateurDAO
	 */
	public static UtilisateurDAO getUtilisateurDAO() {
		UtilisateurDAO utilisateurDAO= new UtilisateurDAOJdbcImpl();
		return utilisateurDAO;
	}
	
	/**
	 * M�thode permettant d'instancier un objet ArticleVenduDAO avec une instance ArticleVenduDAOJdbcImpl 
	 * @return une instance d'ArticleVenduDAO
	 */
	public static ArticleVenduDAO getArticleVenduDAO() {
		ArticleVenduDAO articleVenduDAO= new ArticleVenduDAOJdbcImpl();
		return articleVenduDAO;
	}
	
	/**
	 * M�thode permettant d'instancier un objet CategorieDAO avec une instance CategorieDAOJdbcImpl 
	 * @return une instance d'CategorieDAO
	 */
	public static CategorieDAO getCategorieDAO() {
		CategorieDAO categorieDAO= new CategorieDAOJdbcImpl();
		return categorieDAO;
	}
	public static RetraitDAO getRetraitDAO(){
		RetraitDAO retraitDAO = new RetraitDAOJdbcImpl();
		return retraitDAO;
	}
}
