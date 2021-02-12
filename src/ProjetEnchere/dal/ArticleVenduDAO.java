package ProjetEnchere.dal;

import java.util.List;

import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.dal.jdbc.DALException;

public interface ArticleVenduDAO {
	
	/**
	 * Méthode permettant de lister toutes les ventes de l'application
	 * @return List<ArticleVendu> Une liste d'objets de type ArticleVendu
	 * @throws DALException
	 */
	List<ArticleVendu> listerToutesLesVentes()throws DALException;
	
	/**
	 * Méthode permettant de lister les ventes en fonctions de critères donnés par l'utilisateur
	 * @return List<ArticleVendu> Une liste d'objets de type ArticleVendu
	 * @throws DALException
	 */
	List<ArticleVendu> listerVentesParCriteres()throws DALException;
	
	/**
	 * Méthode permettant d'ajouter une vente (un ArticleVendu) dans la base de donnée
	 * @param Une instance d'ArticleVendu aV
	 * @throws DALException
	 */
	void ajouterVente(ArticleVendu aV) throws DALException;
}
