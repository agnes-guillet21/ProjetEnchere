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
	
	/**
	 * Méthode permettant de valider les champs du formulaire d'inscription
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param tel
	 * @param rue
	 * @param cp
	 * @param ville
	 * @throws Exception
	 */
	public void validationFormulaire(String pseudo, String nom, String prenom,String email,String tel,String rue, String cp,String ville) throws Exception {
		BLLException e = new BLLException();

		Map<String, String> erreurs = new HashMap<String, String>();

		
		if(pseudo.isEmpty()) {
			erreurs.put(BLLException.CHAMPSVIDE,BLLException.ERREUR_CHAMPSVIDE);
		}
		if(!pseudo.matches("[A-Za-z0-9_]+")) {
			erreurs.put(BLLException.PSEUDO,BLLException.ERREUR_PSEUDO);
		}

		if(nom.trim().length()>30) {
			erreurs.put(BLLException.NOM,BLLException.ERREUR_NOM);
		}
		
//		if(nom.isBlank()) {
//			erreurs.put(BLLException.NOM,BLLException.ERREUR_NOM);
//		}
//		
//		for (int i = 0; i < nom.length(); i++) {
//			if (nom.charAt(i) == ' ') { 
//				erreurs.put(BLLException.CHAMPSVIDE,BLLException.ERREUR_CHAMPSVIDE);
//			}
//		}
//		nom=removeSpace(nom);
//		if(nom.isEmpty()) {
//			erreurs.put(BLLException.CHAMPSVIDE,BLLException.ERREUR_CHAMPSVIDE);
//		}
		
		if(prenom.isEmpty()){
			erreurs.put(BLLException.CHAMPSVIDE,BLLException.ERREUR_CHAMPSVIDE);
		}
		
		if (prenom.trim().length()>30) {
			erreurs.put(BLLException.PRENOM,BLLException.ERREUR_PRENOM);
		}
		
		if(email.isEmpty() || email.trim().length() == 0 ) {
			erreurs.put(BLLException.CHAMPSVIDE,BLLException.ERREUR_CHAMPSVIDE);
		}
		
		if(!email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
			erreurs.put(BLLException.EMAIL,BLLException.ERREUR_EMAIL);
		}
		if (email.trim().length()>100){
			erreurs.put(BLLException.EMAIL,BLLException.ERREUR_EMAIL1);
		}
		
		if (tel.isEmpty()){ 
			erreurs.put(BLLException.CHAMPSVIDE,BLLException.ERREUR_CHAMPSVIDE);
		}
		if (!tel.matches("([0-9][0-9])+")) {
			erreurs.put(BLLException.TEL,BLLException.ERREUR_TEL);
		}
		
		if(rue.isEmpty()) {
			erreurs.put(BLLException.CHAMPSVIDE,BLLException.ERREUR_CHAMPSVIDE);
		}
		if (rue.trim().length()>50) {
			erreurs.put(BLLException.RUE,BLLException.ERREUR_RUE);			
		}
		
		if(cp.isEmpty()) {
			erreurs.put(BLLException.CHAMPSVIDE,BLLException.ERREUR_CHAMPSVIDE);
		}
		if (cp.trim().length()>50) {
			erreurs.put(BLLException.CP,BLLException.ERREUR_CP);	
		}
		
		if(ville.isEmpty()) {
			erreurs.put(BLLException.CHAMPSVIDE,BLLException.ERREUR_CHAMPSVIDE);
		}
		if (ville.trim().length()>30) {
			erreurs.put(BLLException.VILLE,BLLException.ERREUR_VILLE);
		}
		
		if(!erreurs.isEmpty()){
			e.setErreurs(erreurs); 
			throw  e;
		}	
	}
	
	/**
	 * Méthode vérifiant que le mot de passe et la confirmation du mot de passe sont identiques
	 * @param motDePasse
	 * @param confirMP
	 * @throws Exception
	 */
	public void validationMP(String motDePasse, String confirMP)throws Exception{
		Map<String, String> erreurs = new HashMap<String, String>();
		BLLException e = new BLLException();
		if(motDePasse !=null && motDePasse.trim().length() !=0 && confirMP != null &&
				confirMP.trim().length()!=0) {
			if(!motDePasse.equals(confirMP)) {
				erreurs.put(BLLException.MP,BLLException.ERREUR_MP);
			}else if(motDePasse.trim().length()>30) {
				erreurs.put(BLLException.TAILLE_MP,BLLException.ERREUR_TMP);
			}
		}else if(motDePasse == null || motDePasse.trim().length() == 0){
			erreurs.put(BLLException.CHAMPSVIDE,BLLException.ERREUR_CHAMPSVIDE);
		}else if(confirMP == null || confirMP.trim().length() == 0){
			erreurs.put(BLLException.CHAMPSVIDE,BLLException.ERREUR_CHAMPSVIDE);
		}
		if(!erreurs.isEmpty()){
			e.setErreurs(erreurs);
			throw  e;
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
	
	public static String removeSpace(String s) { 
		String withoutspaces = ""; 
		for (int i = 0; i < s.length(); i++) { 
			if (s.charAt(i) != ' ') withoutspaces += s.charAt(i); 
			} return withoutspaces; 
	}

	
}
