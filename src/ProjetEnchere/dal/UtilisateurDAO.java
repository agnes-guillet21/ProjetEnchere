package ProjetEnchere.dal;




import java.sql.SQLException;
import java.util.List;
import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.jdbc.DALException;

public interface UtilisateurDAO {

	/**
	 * Méthode permettant d'ajouter un Utilisateur en base de Données
	 * @param Utilisateur utilisateur
	 * @throws DALException
	 * @throws SQLException
	 */
	void insert(Utilisateur utilisateur)throws DALException, SQLException;

	/**
	 * Méthode permettant de "fermer" un utilisateur dans la BDD s'il n'a pas de ven,tes en cours
	 * @param Utilisateur utilisateur
	 * @throws DALException
	 * @Override
	 */
	void fermer(Utilisateur utilisateur) throws DALException;
	
	void update(Utilisateur utilisateur) throws DALException;

	List<Utilisateur> select() throws DALException;
	
	Utilisateur selectConnexion(String identifiant, String password) throws DALException;
	
	Utilisateur selectPseudo(String pseudo) throws DALException;	

	Utilisateur getUserByEmail(String email) throws DALException;
		
	Utilisateur getUserByPseudo(String pseudo) throws DALException;

}
