package ProjetEnchere.bll;

/**
 * Classe gérant les messages d'erreurs survenant dans la couche BLL 
 * @author Team F
 *
 */
public class BLLException extends Exception {

	//Constructeurs
	public BLLException() {
		super();
	}
	
	public BLLException(String message) {
		super(message);
	}
	
	public BLLException(String message, Throwable exception) {
		super(message, exception);
	}

	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche BLL - ");
		sb.append(super.getMessage());
		
		return sb.toString() ;
	}
}

