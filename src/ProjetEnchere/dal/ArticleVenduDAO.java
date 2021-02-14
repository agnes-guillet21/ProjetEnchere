package ProjetEnchere.dal;

import java.util.List;

import ProjetEnchere.bll.BLLException;
import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.dal.jdbc.DALException;

public interface ArticleVenduDAO {
	
	/**
	 * M�thode permettant d'afficher la liste de toutes les ventes
	 * @return une liste d'objet de types ArticleVendu
	 * @throws BLLException
	 */
	List<ArticleVendu> listerToutesLesVentes()throws DALException;
	
	
	List<ArticleVendu> listerVentesParCriteres()throws DALException;
	
	/**
	 * M�thode permettant d'ins�rer une nouvelle vente (objet de type ArticleVendu) dans la base de donn�e
	 * @param ArticleVendu a
	 */
	void insert(ArticleVendu a);
}
