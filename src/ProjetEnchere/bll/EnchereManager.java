package ProjetEnchere.bll;

import java.util.List;

import ProjetEnchere.bo.Enchere;

/**
 * Classe gérant les objets de type Enchere en BLL
 * @author Team F
 *
 */
public class EnchereManager {
	private static EnchereManager instance;
	
	/**
	 * Méthode permettant de récupérer une liste d'objets Enchere
	 * @return Une liste d'onjet de type Enchere
	 */
	public static List<Enchere> getEncheres() {
		return null;
	}

	/**
	 * Méthode permettant d'obtenir une instance d'EnchereManager
	 * @return une instance d'EnchereManager
	 */
	public static EnchereManager getEnchereManager() {
		if(instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}

}
