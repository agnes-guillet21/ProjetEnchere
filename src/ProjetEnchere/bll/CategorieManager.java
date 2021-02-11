package ProjetEnchere.bll;

import java.util.List;
import ProjetEnchere.bo.Categorie;
import ProjetEnchere.dal.CategorieDAO;
import ProjetEnchere.dal.DAOFactory;

/**
 * Classe g�rant les objets de type Categorie en BLL
 * @author Team F
 *
 */
public class CategorieManager {
	
	private CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
	private static CategorieManager instance;
	
	
	/**
	 * M�thode permettant d'afficher la liste des cat�gories
	 * @return Une liste d'onjet de type Categorie
	 */
	public static List<Categorie> getCategories() {
		return null;
	}
	
	/**
	 * M�thode permettant d'obtenir une instance de CategorieManager
	 * @return une instance de CategorieManager
	 */
	public static CategorieManager getInstance() {
		if(instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}

}
