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
	public static final String PSEUDO ="userpseudo";
	public static final String NOM ="username";
	public static final String PRENOM="userfirstname";
	public static final String EMAIL = "usermail";
	public static final String TEL="userphone";
	public static final String RUE="user_street";
	public static final String CP="usercp";
	public static final String VILLE="city";
	public static final String ATT_ERREURS="erreurs";
	public static final String ATT_RESULTAT= "resultat";

	//  creation hasmap pr les erreurs
	public	Map<String, String> erreurs = new HashMap<String, String>();



	//Constructeurs
	public BLLException() {
		super();
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
	// la je creer une methode pr personnalisation
	public String getMessageErreur(String message) {
		StringBuffer sb = new StringBuffer("Couche BLL - ");
		if(message.equals(PSEUDO)) {
			sb.append("caractere incorrectes, merci de saisir un autre pseudo");
			return sb.toString() ;
		}
		if(message.equals(NOM)) {
			sb.append("Nom incorrecte, merci de saisir un autre nom");
			return sb.toString() ;
		}
		if(message.equals(PRENOM)) {
			sb.append("Prénom incorrecte, merci de saisir un autre nom");
			return sb.toString() ;
		}
		if(message.equals(EMAIL)) {
			sb.append("Email incorrecte, merci de saisir une autre mail");
			return sb.toString() ;
		}
		if(message.equals(TEL)) {
			sb.append("Numéro de télephone incorrecte, merci de saisir un autre numéro");
			return sb.toString() ;
		}
		if(message.equals(RUE)) {
			sb.append("Numéro de rue incorrecte, merci de saisir un autre numéro");
			return sb.toString() ;
		}
		if(message.equals(CP)) {
			sb.append("Code Postal incorrecte, merci de saisir un autre Code postal");
			return sb.toString() ;
		}
		if(message.equals(CP)) {
			sb.append("Code Postal incorrecte, merci de saisir un autre Code postal");
			return sb.toString() ;
		}
		if(message.equals(VILLE)) {
			sb.append("Nom de ville incorrecte, merci de saisir un autre nom de ville");
			return sb.toString() ;
		}
		return message;

	}



}

