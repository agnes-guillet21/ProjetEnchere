package ProjetEnchere.bll;

import java.sql.SQLException;

import ProjetEnchere.bo.Retrait;
import ProjetEnchere.dal.DAOFactory;
import ProjetEnchere.dal.RetraitDAO;
import ProjetEnchere.dal.jdbc.DALException;

public class RetraitManager {
	private RetraitDAO retraitDAO = DAOFactory.getRetraitDAO();

	public RetraitManager() {
		// TODO Auto-generated constructor stub
	}

	public Retrait selectByCriteres(Retrait r) {
		
		return null;
	}

	public void insert(Retrait r) throws SQLException {
		try {
			retraitDAO.insertLieuRetrait(r);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Méthode permettant de sélectionner et récupérer un lieu de Retrait à partir de la rue, du code postal et de la ville dans la base de données
	 * @param Retrait r
	 * @return Retrait r ou null si le lieu n'existe pas en base de données
*/


}