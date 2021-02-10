package ProjetEnchere.bll;

import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.ArticleVenduDAO;
import ProjetEnchere.dal.DAOFactory;
import ProjetEnchere.dal.UtilisateurDAO;
import ProjetEnchere.dal.jdbc.DALException;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	//charger une instance de utilisateurdaojbc impl via lafactory
	
	
	private static UtilisateurManager instance;
	//sert a pouvoir appeler des methodes  qui st des methodes ds la dal
	
	
	
	// pr obtenir une instance de utilsateur dao 
	//qui est une instance  utilisateurdaojbc impl
	
	
	
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}//creation nvl instance
		return instance;
	}

//methode qui va appeler l inster de ma dal
	 public void InsertUtilisateur(Utilisateur u1) {
		 //aappelle a ma methode  insert via ma daofactory
		 UtilisateurDAO  user = DAOFactory.getUtilisateurDAO();
		 //j ai creer mon instance d utilisateur dao , je peux directmt appeler ma methode insert
		 //mtnt il faut que j appeler a partir d user
		 
		 try {
			user.insert(u1);//methode que j ai creer en daojdbcimpl
		} catch (DALException e) {
			e.printStackTrace();//personnalisation de l erreur a faire
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
