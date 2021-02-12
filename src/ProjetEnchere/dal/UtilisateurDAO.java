package ProjetEnchere.dal;




import java.sql.SQLException;

import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.jdbc.DALException;

public interface UtilisateurDAO {



	void insert ( Utilisateur utilisateur)throws DALException, SQLException;

	void delete(Utilisateur utilisateur) throws DALException;
	
	void update(Utilisateur utilisateur) throws DALException;

<<<<<<< HEAD
	List<Utilisateur> select() throws DALException;
	
	Utilisateur selectConnexion(String identifiant, String password) throws DALException;
	
	Utilisateur selectPseudo(String pseudo) throws DALException;
	
=======
	Utilisateur getUserByEmail(String email) throws DALException;
	
	void deleteUser(Utilisateur user, String pseudo)throws DALException, SQLException;
>>>>>>> branch 'main' of https://github.com/agnes-guillet21/ProjetEnchere
}
