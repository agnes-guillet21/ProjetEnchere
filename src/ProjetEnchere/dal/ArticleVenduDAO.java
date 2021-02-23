package ProjetEnchere.dal;

import java.util.List;

import ProjetEnchere.bll.BLLException;
import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.bo.Enchere;
import ProjetEnchere.dal.jdbc.DALException;

public interface ArticleVenduDAO {
	
	/**
	 * Mï¿½thode permettant de lister toutes les ventes de l'application
	 * @return List<ArticleVendu> Une liste d'objets de type ArticleVendu
	 * @throws DALException
	 */
	List<ArticleVendu> listerToutesLesVentes()throws DALException;
	

	/**
	 * Mï¿½thode permettant de lister les ventes en fonctions de critï¿½res donnï¿½s par l'utilisateur
	 * @return List<ArticleVendu> Une liste d'objets de type ArticleVendu
	 * @throws DALException
	 */
	List<ArticleVendu> listerVentesParCriteres(String nom)throws DALException;
	
	/**
	 * Méthode permettant d'ajouter une vente (un ArticleVendu) dans la base de donnée
	 * @param Une instance d'ArticleVendu aV
	 * @throws DALException
	 */
	void ajouterVente(ArticleVendu aV) throws DALException;

	
	/**
	 * MÃ©thode permmetant de rÃ©cupÃ©rer les encheres en cours pour l'afficher sur la page acceuil 
	 * @return Liste Enchere
	 * @throws DALException
	 */
	List<ArticleVendu> select(String categorie, String recherche) throws DALException;
		
	//public ArticleVendu getById(int id) throws DALException;

}
