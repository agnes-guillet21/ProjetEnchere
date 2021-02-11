package ProjetEnchere.dal;




import java.sql.SQLException;

import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.jdbc.DALException;

public interface UtilisateurDAO {


	//besoin d un select d un utilisateur par son pseudo 

	void insert ( Utilisateur u1)throws DALException, SQLException;

	Utilisateur getUserByPseudo(String pseudo)throws DALException;

	Utilisateur getUserByEmail(String email) throws DALException;
	
	void deleteUser(Utilisateur user, String pseudo)throws DALException, SQLException;
}
