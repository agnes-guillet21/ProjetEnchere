package ProjetEnchere.dal;

import ProjetEnchere.dal.jdbc.UtilisateurDAOJdbcImpl;

public abstract class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		//creer une instance de stagiaire dao imp et la stocker ds stagiaire dao
		
		UtilisateurDAO utilisateurDAO= new UtilisateurDAOJdbcImpl();
		return utilisateurDAO;
}

//	protected  UtilisateurDAO insert() {
//		UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
//		return utilisateurDAO;
//	};
}
