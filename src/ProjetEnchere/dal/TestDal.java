package ProjetEnchere.dal;

import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.jdbc.DALException;

public class TestDal {

	public static void main(String[] args) {

		//Déclaration et instanciation de la DAO
				UtilisateurDAO utilisateurDAO =  DAOFactory.getUtilisateurDAO();

				Utilisateur u1 = new Utilisateur ("ag","guillet","agnes","agnes.guillet@hotmail.fr","0605040201","44800","Saint herblain","motdepasse",null, 0);
				//test methode insert
				System.out.println("Ajout d'un utilisateur... ");
				try {
					utilisateurDAO.insert(u1);
				} catch (DALException e) {
					
					e.printStackTrace();
				}
				System.out.println("Utilisateur ajoute  : " + u1.toString() );
	}

}
