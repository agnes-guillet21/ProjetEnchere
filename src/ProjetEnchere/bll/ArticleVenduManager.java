package ProjetEnchere.bll;

import java.util.List;

import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.dal.ArticleVenduDAO;
import ProjetEnchere.dal.DAOFactory;
import ProjetEnchere.dal.jdbc.DALException;


public class ArticleVenduManager {

	private ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();
	private static ArticleVenduManager instance;
	
	public static ArticleVenduManager getInstance(){
		if(instance == null) {
			instance = new ArticleVenduManager();
		}
		return instance;
	}

	public List<ArticleVendu> listerToutesLesVentes() throws BLLException {
		List<ArticleVendu> catalogue = null;

			try {
				catalogue = this.articleVenduDAO.listerToutesLesVentes();
				return catalogue;
			} catch (DALException e) {
				throw new BLLException("Echec listerToutesLesVentes()", e);
			}
		
	}
}