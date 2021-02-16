package ProjetEnchere.bll;

import java.util.HashMap;
import java.util.Map;

import ProjetEnchere.servlet.SInscrireServlet;

/**
 * Classe gérant les messages d'erreurs survenant dans la couche BLL 
 * @author Team F
 *
 */
public class BLLException extends Exception {
	
	public static final String ERREUR_PSEUDO ="caractere incorrectes, merci de saisir un autre pseudo";
	public static final String PSEUDO ="userpseudo";
	public static final String ERREUR_NOM ="Nom incorrecte, merci de saisir un autre nom";
	public static final String NOM ="username";
	public static final String ERREUR_PRENOM ="Prenom incorrecte, merci de saisir un autre prenom";
	public static final String PRENOM="userfirstname";
	public static final String ERREUR_EMAIL ="Adresse mail incorrecte, merci de saisir une autre adresse mail";
	public static final String ERREUR_EMAIL1 ="Taille de l'adresse mail incorrecte, merci de saisir une autre adresse mail";
	public static final String EMAIL = "usermail";
	public static final String ERREUR_TEL ="Numero de tel incorrecte, merci de saisir un autre numero telephone";
	public static final String TEL="userphone";
	public static final String ERREUR_RUE="Nom de rue incorrecte, merci de saisir un autre nom de rue";
	public static final String RUE="user_street";
	public static final String ERREUR_CP="Code postal incorrecte, merci de saisir un autre code postal";
	public static final String CP="usercp";
	public static final String ERREUR_VILLE="Ville incorrecte, merci de saisir un autre code postal";
	public static final String VILLE="city";
	
	//public static final String ATT_ERREURS="erreurs";
	//public static final String ATT_RESULTAT= "resultat";

	//  creation hasmap pr les erreurs
	private	Map<String, String> erreurs ;
//rajouter un setter 
	

	//Constructeurs
	public BLLException() {
		super();
	}

	
	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
		
	}

	public BLLException(String message) {
		super(message);
	}

	public BLLException(String message, Throwable exception) {
		super(message, exception);
		//modification
	}

	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche BLL - ");
		sb.append(super.getMessage());
		return sb.toString() ;
	}
	



}

