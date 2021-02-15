package ProjetEnchere.dal;




import java.sql.SQLException;
import java.util.List;
import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.jdbc.DALException;

public interface UtilisateurDAO {


	void insert ( Utilisateur utilisateur)throws DALException, SQLException;

	void delete(Utilisateur utilisateur) throws DALException;
	
	void update(Utilisateur utilisateur) throws DALException;


	List<Utilisateur> select() throws DALException;
	
	Utilisateur selectConnexion(String identifiant, String password) throws DALException;
	
	Utilisateur selectPseudo(String pseudo) throws DALException;
	

	Utilisateur getUserByEmail(String email) throws DALException;
	
	
	Utilisateur getUserByPseudo(String pseudo) throws DALException;

}
