package ProjetEnchere.bll;

import java.sql.SQLException;

import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.DAOFactory;
import ProjetEnchere.dal.UtilisateurDAO;
import ProjetEnchere.dal.jdbc.DALException;


/**
 * Classe gérant les objets Utilisateur en BLL
 * @author Team F
 *
 */
public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	//charger une instance de utilisateurdaojbc impl via lafactory

	

	// pr obtenir une instance de utilsateur dao 
	//qui est une instance  utilisateurdaojbc impl
	
	
	/**
	 * Méthode permettant d'obtenir une instance d'UtilisateurManager
	 * @return une instance d'ArticleVenduManager
	 */
//	public static UtilisateurManager getInstance() {
//		if(instance == null) {
//			instance = new UtilisateurManager();
//		}
//		return instance;
//	}

	/**
	 * Méthode insert une Instance d'Utilisateur dans la base de données
	 * Utilisée lors de la création d'un nouvel utilisateur
	 * Fait appel à la méthode présent dans la DAL
	 * Demande une instance d'Utilisateur en paramètre
	 * @param Utilisateur u1
	 * @throws SQLException 
	 */
	public void InsertUtilisateur(Utilisateur u1) throws SQLException {
		 try {
			utilisateurDAO.insert(u1);//Méthode présente dans la DAL
		} catch (DALException e) {
			//TODO PERSONNALISATION DE L'ERREUR
			e.printStackTrace();
		}		 
	 }
	
	/**
	 * Méthode permettant de récupérer un Utilisateur den fontion de son pseudo et de son mot de passe
	 * @param String login
	 * @param String pass
	 * @return Utilisateur user si login et mdp ok. 
	 * @return null si le mode passe ou le login ne sont pas bons
	 */
	public Utilisateur getUserByPseudoPassword(String login, String pass) {
		
		Utilisateur user = new Utilisateur();
		boolean ConnectionOK;
		
		try {
			user = utilisateurDAO.getUserByPseudo(login);//Méthode présente dans la DAL
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
			//TODO prepare message à envoyer en param à la jsp
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
	

	/*pseudo caractere alphanumerique:
	 * for ( email : i
	 * 
	 * 
	 *  pseudo et email doivent etre unique 
	 *  
	 *  dc si present ds laBDD => pas bon  
	 *  select , email from Utilisateurs where email = email;
	 *  si request.getParameter("userpseudo")== select pseudo , email from Utilisateurs where pseudo = pseudo,
	 */
	
}
