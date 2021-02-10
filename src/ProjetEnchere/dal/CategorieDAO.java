package ProjetEnchere.dal;

import java.util.List;

import ProjetEnchere.bo.Categorie;
import ProjetEnchere.dal.jdbc.DALException;


public interface CategorieDAO {

	List<Categorie> listerToutesLesCategories()throws DALException;
	
	Void Insert() throws DALException;
}
