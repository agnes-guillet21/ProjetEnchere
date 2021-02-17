package ProjetEnchere.bll;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
	 * if(ville.trim().equals(""){
	 * erreurs.put(BLLException.CHAMPSVIDE,BLLException.ERREUR_CHAMPSVIDE;
	System.out.println(erreurs);
	 * }
	 */
	public void validationFormulaire(String pseudo, String nom, String prenom,String email,String tel,String rue, String cp,String ville) throws Exception {
		BLLException e = new BLLException();//je creer une variable e d instance de bllexception
	
		Map<String, String> erreurs = new HashMap<String, String>();//decla hasmap 
		
		//reste  a faire le fait que se soit vide = null pr tous les champs

			if(pseudo.trim().equals("") &&!pseudo.matches("[A-Za-z0-9_]+")) {
		erreurs.put(BLLException.PSEUDO,BLLException.ERREUR_PSEUDO);
	System.out.println(erreurs);
		}
			
	if(nom == null && nom.trim().length()>30) {
		erreurs.put(BLLException.NOM,BLLException.ERREUR_NOM);
		System.out.println(erreurs);
	}	

		if(prenom == null && prenom.trim().length()>30){
			erreurs.put(BLLException.PRENOM,BLLException.ERREUR_PRENOM);
			System.out.println(erreurs);
		}
		if(email == null && email.trim().length()>100) {
			if(!email.matches("([^.@]+)(\\\\.[^.@]+)*@([^.@]+\\\\.)+([^.@]+)")) {
				erreurs.put(BLLException.EMAIL,BLLException.ERREUR_EMAIL);
				System.out.println(erreurs);
			}
		}else {
			erreurs.put(BLLException.EMAIL,BLLException.ERREUR_EMAIL1);
			System.out.println(erreurs);
		}
		if (tel == null && !tel.matches("\\+?[0-9][0-9][0-9]([0-9][0-9])+")){ // pas sur de ce regex
			erreurs.put(BLLException.TEL,BLLException.ERREUR_TEL);
			System.out.println(erreurs);
		}
		if(rue == null && rue.trim().length()>50) {
			erreurs.put(BLLException.RUE,BLLException.ERREUR_RUE);
			System.out.println(erreurs);
		}
		if(cp == null && rue.trim().length()>50) {
			erreurs.put(BLLException.CP,BLLException.ERREUR_CP);
			System.out.println(erreurs);
		}
		if(ville == null && ville.trim().length()>30) {
			erreurs.put(BLLException.VILLE,BLLException.ERREUR_VILLE);
			System.out.println(erreurs);
	}
	//initialisation du resultat global de la validation
		if(!erreurs.isEmpty()){
	  e.setErreurs(erreurs);//j' utilise le setter de la hasmap bll exception ( en passant para la hashmap) 
	  throw  e;//je lance un exception e de type BLLExc pr stopper l inscription 
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
			utilisateurDAO.insert(u1);
		} catch (DALException e) {
			e.printStackTrace();
		}		 
	 }
	
	/**
	 * Méthode permettant de récupérer un Utilisateur en fontion de son pseudo et de son mot de passe
	 * @param String login
	 * @param String pass
	 * @return Utilisateur user si login et mdp ok. 
	 * @return null si le mode passe ou le login ne sont pas bons
	 */
	public Utilisateur getUserByPseudoPassword(String login, String pass) {
		
		Utilisateur user = new Utilisateur();
		
		try {
			user = utilisateurDAO.getUserByPseudo(login);//Méthode présente dans la DAL			
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		if(user == null) {return null;}
		
		
		if (user.getPseudo().equals(login) && user.getMotDePasse().equals(pass)){
			return user;
		}else {
			return null;
			//TODO prepare message à envoyer en param à la jsp
		}
		
	}

	public Utilisateur verificationEmail(String email) {
		Utilisateur user = new Utilisateur();
		
		try {
			user = utilisateurDAO.getUserByEmail(email);
		} catch (DALException e) {
			e.printStackTrace();
		} 
			return user;	
		
	
	}

	public Utilisateur getUtilisateurById(int id) {
		return null;
	}
	
	/**
	 * Méthode permettant de "fermer" un utilisateur dans la BDD s'il n'a pas de vente en cours
	 * @param Utilisateur utilisateur
	 * @throws DALException
	 * @throws BLLException 
	 * @Override
	 */
	 public void fermer(Utilisateur utilisateur)throws BLLException, DALException {
		 if(utilisateurDAO.getUserByPseudo(utilisateur.getPseudo()) == null) {
			 throw new BLLException("Impossible de supprimer le compte. Aucun utilisateur avec le pseudo "+ utilisateur.getPseudo() + "n'existe dans la base de données.");
		 }
		try {
			this.utilisateurDAO.fermer(utilisateur);
		} catch (DALException e) {
			e.getMessage();
		} 
	 }
	 
	/**
	 * Méthode permettant de mettre à jour les informations d'un utilisateur dans la base de données 
	 * @param Utilisateur
	 * @return Utilisateur modifié
	 * @throws DALException
	 */
	public Utilisateur update(Utilisateur newUtilisateur,Utilisateur utilisateurSession) throws DALException{
		return this.utilisateurDAO.update(newUtilisateur,utilisateurSession);
	}
	
	public Utilisateur getUserByPseudo(String pseudo) throws DALException {
		return this.utilisateurDAO.getUserByPseudo(pseudo);
	}
}
