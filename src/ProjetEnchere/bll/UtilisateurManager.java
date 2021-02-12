package ProjetEnchere.bll;

import java.sql.SQLException;

import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.DAOFactory;
import ProjetEnchere.dal.UtilisateurDAO;
import ProjetEnchere.dal.jdbc.DALException;


/**
 * Classe g�rant les objets Utilisateur en BLL
 * @author Team F
 *
 */
public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	//charger une instance de utilisateurdaojbc impl via lafactory

	

	// pr obtenir une instance de utilsateur dao 
	//qui est une instance  utilisateurdaojbc impl
	
	
	/**
	 * M�thode permettant d'obtenir une instance d'UtilisateurManager
	 * @return une instance d'ArticleVenduManager
	 */
//	public static UtilisateurManager getInstance() {
//		if(instance == null) {
//			instance = new UtilisateurManager();
//		}
//		return instance;
//	}

	/**
	 * M�thode insert une Instance d'Utilisateur dans la base de donn�es
	 * Utilis�e lors de la cr�ation d'un nouvel utilisateur
	 * Fait appel � la m�thode pr�sent dans la DAL
	 * Demande une instance d'Utilisateur en param�tre
	 * @param Utilisateur u1
	 * @throws SQLException 
	 */
	public void InsertUtilisateur(Utilisateur u1) throws SQLException {
		 try {
			utilisateurDAO.insert(u1);//M�thode pr�sente dans la DAL
		} catch (DALException e) {
			e.printStackTrace();
		}		 
	 }

public void deleteUser(Utilisateur user, String pseudo) throws SQLException {
	try {
		utilisateurDAO.deleteUser(user, pseudo);
	} catch (DALException e) {
		e.printStackTrace();
	}
}




	
	/**
	 * M�thode permettant de r�cup�rer un Utilisateur den fontion de son pseudo et de son mot de passe
	 * @param String login
	 * @param String pass
	 * @return Utilisateur user si login et mdp ok. 
	 * @return null si le mode passe ou le login ne sont pas bons
	 */

	public Utilisateur getUserByPseudoPassword(String login, String pass) {
		
		Utilisateur user = new Utilisateur();
		boolean ConnectionOK;
		
		try {
			user = utilisateurDAO.getUserByPseudo(login);//M�thode pr�sente dans la DAL
		} catch (DALException e) {
			//TODO PERSONNALISATION DE L'ERREUR
			e.printStackTrace();
		}
		
		if (user.getPseudo().equals(login) && user.getMotDePasse().equals(pass)){
			ConnectionOK = true;
			return user;
		}else {
			ConnectionOK = false;
			return null;
			//TODO prepare message � envoyer en param � la jsp
		}
		
	}
	
	public Utilisateur verificationEmail(String email) {
		Utilisateur user = new Utilisateur();
		boolean checkFormulaire;
		
		try {
			user = utilisateurDAO.getUserByEmail(email);
		} catch (DALException e) {
			e.printStackTrace();
		}
		if(user.getEmail().isEmpty()) {
			return user;	
		}else {
			checkFormulaire = false;
			return null;
		}	
	}

	public Utilisateur getUtilisateurById(int id) {
		return null;
	}
	

	
}
