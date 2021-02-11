package ProjetEnchere.bll;

import java.util.List;

import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.dal.ArticleVenduDAO;
import ProjetEnchere.dal.DAOFactory;
import ProjetEnchere.dal.jdbc.DALException;

/**
 * Classe gérant les objets ArticleVendu en BLL
 * @author Team F
 *
 */
public class ArticleVenduManager {

	private ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();
	private static ArticleVenduManager instance;
	
	/**
	 * Méthode permettant d'obtenir une instance d'ArticleVenduManager
	 * @return une instance d'ArticleVenduManager
	 */
	public static ArticleVenduManager getInstance(){
		if(instance == null) {
			instance = new ArticleVenduManager();
		}
		return instance;
	}

	/**
	 * Méthode permettant d'afficher la liste des ventes
	 * @return une liste d'objet de types ArticleVendu
	 * @throws BLLException
	 */
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