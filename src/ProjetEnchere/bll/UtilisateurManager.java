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

	private static UtilisateurManager instance;
	//sert a pouvoir appeler des methodes  qui st des methodes ds la dal
	
	// pr obtenir une instance de utilsateur dao 
	//qui est une instance  utilisateurdaojbc impl
	
	/**
	 * M�thode permettant d'obtenir une instance d'UtilisateurManager
	 * @return une instance d'ArticleVenduManager
	 */
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

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
			//TODO PERSONNALISATION DE L'ERREUR
			e.printStackTrace();
		}		 
	 }

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
