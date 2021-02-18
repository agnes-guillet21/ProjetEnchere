package ProjetEnchere.dal;

import java.util.List;

import ProjetEnchere.bll.BLLException;
import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.bo.Enchere;
import ProjetEnchere.dal.jdbc.DALException;

public interface ArticleVenduDAO {
	
	/**
	 * M�thode permettant de lister toutes les ventes de l'application
	 * @return List<ArticleVendu> Une liste d'objets de type ArticleVendu
	 * @throws DALException
	 */
	List<ArticleVendu> listerToutesLesVentes()throws DALException;
	

	/**
	 * M�thode permettant de lister les ventes en fonctions de crit�res donn�s par l'utilisateur
	 * @return List<ArticleVendu> Une liste d'objets de type ArticleVendu
	 * @throws DALException
	 */
	List<ArticleVendu> listerVentesParCriteres(String nom)throws DALException;
	
	/**
	 * M�thode permettant d'ajouter une vente (un ArticleVendu) dans la base de donn�e
	 * @param Une instance d'ArticleVendu aV
	 * @throws DALException
	 */
	void ajouterVente(ArticleVendu aV) throws DALException;

	/**
	 * M�thode permettant d'ins�rer une nouvelle vente (objet de type ArticleVendu) dans la base de donn�e
	 * @param ArticleVendu a
	 */
	void insert(ArticleVendu a);
	
	/**
	 * Méthode permmetant de récupérer les encheres en cours pour l'afficher sur la page acceuil 
	 * @return Liste Enchere
	 * @throws DALException
	 */
	List<ArticleVendu> select(String categorie, String recherche) throws DALException;
		
}
