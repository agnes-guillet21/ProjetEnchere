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
		if(message.equals("pseudo")) {
			sb.append("caractere incorrectes, merci de saisir un autre pseudo");
			return sb.toString() ;
		}
		return sb.toString() ;
		
		
	}

	
}

