package ProjetEnchere.dal;




import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.jdbc.DALException;

public interface UtilisateurDAO {


	//besoin d un select d un utilisateur par son pseudo 

	void insert ( Utilisateur u1)throws DALException;

	Utilisateur selectByPseudo(String pseudo)throws DALException;

}
