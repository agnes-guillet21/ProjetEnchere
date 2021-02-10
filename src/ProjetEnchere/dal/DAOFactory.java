package ProjetEnchere.dal;

import ProjetEnchere.dal.jdbc.ArticleVenduDAOJdbcImpl;
import ProjetEnchere.dal.jdbc.UtilisateurDAOJdbcImpl;

public abstract class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		//creer une instance de stagiaire dao imp et la stocker ds stagiaire dao
		
		UtilisateurDAO utilisateurDAO= new UtilisateurDAOJdbcImpl();
		return utilisateurDAO;
}
	
	public static ArticleVenduDAO getArticleVenduDAO() {
		//creer une instance de stagiaire dao imp et la stocker ds stagiaire dao
		
		ArticleVenduDAO articleVenduDAO= new ArticleVenduDAOJdbcImpl();
		return articleVenduDAO;
}
	
}
