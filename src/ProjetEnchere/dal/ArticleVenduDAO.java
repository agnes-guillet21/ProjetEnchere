package ProjetEnchere.dal;

import java.util.List;

import ProjetEnchere.bll.BLLException;
import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.dal.jdbc.DALException;

public interface ArticleVenduDAO {
	
	/**
<<<<<<< HEAD
	 * M�thode permettant de lister toutes les ventes de l'application
	 * @return List<ArticleVendu> Une liste d'objets de type ArticleVendu
	 * @throws DALException
=======
	 * M�thode permettant d'afficher la liste de toutes les ventes
	 * @return une liste d'objet de types ArticleVendu
	 * @throws BLLException
>>>>>>> branch 'main' of https://github.com/agnes-guillet21/ProjetEnchere
	 */
	List<ArticleVendu> listerToutesLesVentes()throws DALException;
	
<<<<<<< HEAD
	/**
	 * M�thode permettant de lister les ventes en fonctions de crit�res donn�s par l'utilisateur
	 * @return List<ArticleVendu> Une liste d'objets de type ArticleVendu
	 * @throws DALException
	 */
=======
	
>>>>>>> branch 'main' of https://github.com/agnes-guillet21/ProjetEnchere
	List<ArticleVendu> listerVentesParCriteres()throws DALException;
	
	/**
<<<<<<< HEAD
	 * M�thode permettant d'ajouter une vente (un ArticleVendu) dans la base de donn�e
	 * @param Une instance d'ArticleVendu aV
	 * @throws DALException
	 */
	void ajouterVente(ArticleVendu aV) throws DALException;
=======
	 * M�thode permettant d'ins�rer une nouvelle vente (objet de type ArticleVendu) dans la base de donn�e
	 * @param ArticleVendu a
	 */
	void insert(ArticleVendu a);
>>>>>>> branch 'main' of https://github.com/agnes-guillet21/ProjetEnchere
}
