package ProjetEnchere.bll;

import java.util.List;

import ProjetEnchere.bo.Enchere;
import ProjetEnchere.dal.ArticleVenduDAO;
import ProjetEnchere.dal.DAOFactory;
import ProjetEnchere.dal.jdbc.DALException;



/**
 * Classe g�rant les objets de type Enchere en BLL
 * @author Team F
 *
 */
public class EnchereManager {
	ArticleVenduManager aVenduMger =new ArticleVenduManager();
	/**
	* Constructeur par d�faut
	*/
	public EnchereManager() {
	super();
	}
	// public select(int noArticle) throws DALException {
	// return aVenduMger.select(noArticle);
	//
	// }
	/**
	* M�thode permettant de r�cup�rer une liste d'objets Enchere
	* @return Une liste d'onjet de type Enchere
	*/
	public static List<Enchere> getEncheres() {
	return null;
	}

	}
