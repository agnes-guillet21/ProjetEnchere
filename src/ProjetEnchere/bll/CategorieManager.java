package ProjetEnchere.bll;

import java.util.ArrayList;
import java.util.List;
import ProjetEnchere.bo.Categorie;
import ProjetEnchere.dal.CategorieDAO;
import ProjetEnchere.dal.DAOFactory;
import ProjetEnchere.dal.jdbc.DALException;

/**
 * Classe gï¿½rant les objets de type Categorie en BLL
 * @author Team F
 *
 */
public class CategorieManager {
	
	private CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
	private static CategorieManager instance;
	

	/**
	 * Méthode permettant d'obtenir une instance de CategorieManager
	 * @return une instance de CategorieManager
	 */
	public static CategorieManager getInstance() {
		if(instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}

	public Categorie selectByName(String parameter) {
		// TODO Auto-generated method stub
		return null; 
		}
	

	/**
	* Méthode permettant d'afficher la liste des catégories
	* @return Une liste d'objets de type Categorie 
	*/
	public List<Categorie> selectAll() throws DALException{
		List<Categorie> listeCategories = new ArrayList<Categorie>();
		listeCategories = categorieDAO.selectAll();
		return listeCategories;	
	}

}
