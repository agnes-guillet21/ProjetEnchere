package ProjetEnchere.dal;

import java.util.List;

import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.dal.jdbc.DALException;

public interface ArticleVenduDAO {

	List<ArticleVendu> listerToutesLesVentes()throws DALException;
	
	List<ArticleVendu> listerVentesParCriteres()throws DALException;
}
