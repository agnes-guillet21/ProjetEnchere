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
	
//	public static UtilisateurManager getInstance() { patter singleton 
//		if(instance == null) {
//			instance = new UtilisateurManager();
//		}
//		return instance;
//	}


	
	/*	 Methode : validation formulaire, validationMP verificationEmail
	 * utilisee pr valider l inscription
	 * 
	 * 
	 */
	public void validationFormulaire(String pseudo, String nom, String prenom,String email,String tel,String rue, String cp,String ville) throws Exception {
		//creation variable bll exception
		//bll excpt je vais decla ma hashmap
		//il ne faut pas que je lance une exception  , je veux juste alimenter ma mah avc mon mess correspondant 
		if(pseudo != null && !pseudo.matches("[A-Za-z0-9_]+")){
			throw new Exception("caractere incorrectes, merci de saisir un autre pseudo");
		}
		if(nom != null && nom.trim().length()>30) {
			throw new Exception("le nom ne doit pas dépasser 30 caracteres, merci de saisir un autre nom");
		}
		if(prenom != null && prenom.trim().length()>30) {
			throw new Exception("le prénom ne doit pas dépasser 30 caracteres, merci de saisir un autre prenom");
		}
		if(email != null && email.trim().length()>100) {
			if(!email.matches("([^.@]+)(\\\\.[^.@]+)*@([^.@]+\\\\.)+([^.@]+)")) {
				throw new Exception(" Merci de saisir une adresse mail valide.");
			}
		}else {
			throw new Exception("l'email ne doit pas dépasser 20 caracteres");
		}
		if (tel != null && !tel.matches("\\+?[0-9][0-9][0-9]([0-9][0-9])+")){ // pas sur de ce regex
			throw new Exception("Merci de saisir un numéro de téléphone valide.");
		}
		if(rue != null && rue.trim().length()>50) {
			throw new Exception("Merci de saisir un nom de rue valide.");
		}
		if(cp != null && rue.trim().length()>50) {
			throw new Exception("Merci de saisir un code postal valide.");
		}
		if(ville != null && ville.trim().length()>30) {
			throw new Exception("Merci de saisir un nom de ville valide.");
		}

	}
	public void validationMP(String motDePasse, String confirMP)throws Exception{
		if(motDePasse !=null && motDePasse.trim().length() !=0 && confirMP != null &&
				confirMP.trim().length()!=0) {
			if(!motDePasse.equals(confirMP)) {
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			}else if(motDePasse.trim().length()>30) {
				throw new Exception("le mot de passe ne doit pas depasser 30 caracteres");
			}
		}else {
			throw new Exception("Merci de saisir et de confirmer votre mot de passe");
		}
	}
	
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
		return null;
			
		}	
	}

	public Utilisateur getUtilisateurById(int id) {
		return null;
	}
	

	 public void delete(Utilisateur utilisateur)throws DALException {
		this.utilisateurDAO.delete(utilisateur);//appelle a ma methode ds utilisateur dao 
	 }
	 
	 
	 
	public  void update(Utilisateur utilisateur) throws DALException{
		this.utilisateurDAO.update(utilisateur);
	}

}
