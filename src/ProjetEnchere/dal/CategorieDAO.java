package ProjetEnchere.dal;

import java.util.List;

import ProjetEnchere.bo.Categorie;
import ProjetEnchere.dal.jdbc.DALException;

public interface CategorieDAO {

	Categorie insert(Categorie categorie) throws DALException;
	
	boolean update(Categorie categorie) throws DALException;
	
	boolean delete(Categorie categorie) throws DALException;

	List<Categorie> selectAll() throws DALException;

	Categorie selectById(int id) throws DALException;


}
