package ProjetEnchere.bll;

import java.util.List;

import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.dal.ArticleVenduDAO;
import ProjetEnchere.dal.DAOFactory;
import ProjetEnchere.dal.jdbc.DALException;

/**
 * Classe g�rant les objets ArticleVendu en BLL
 * @author Team F
 *
 */
public class ArticleVenduManager {

	private ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();
	private static ArticleVenduManager instance;
	
	
	
	/**
	 * M�thode permettant d'obtenir une instance d'ArticleVenduManager
	 * @return une instance d'ArticleVenduManager
	 */
	public static ArticleVenduManager getInstance(){
		if(instance == null) {
			instance = new ArticleVenduManager();
		}
		return instance;
	}

	
	/**
	 * M�thode permettant d'afficher la liste des ventes
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

	/**
	 * M�thode permettant d'ins�rer une nouvelle vente (objet de type ArticleVendu) dans la base de donn�e
	 * @param ArticleVendu a
	 */
	public void insert(ArticleVendu a) {

		
		articleVenduDAO.insert(a); }
	
	
//	public static ArticleVendu selectArticleById(int id)throws DALException{
//		return articleVenduDAO.getById(id); }	
//
//		articleVenduDAO.insert(a); 	
	

public List<ArticleVendu> listerVentesParCriteres(String nom){
	try {
		return this.articleVenduDAO.listerVentesParCriteres(nom);
	} catch (DALException e) {
		e.printStackTrace();
	}return null;
}

}

