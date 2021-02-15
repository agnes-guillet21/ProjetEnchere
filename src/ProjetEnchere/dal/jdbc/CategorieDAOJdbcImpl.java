package ProjetEnchere.dal.jdbc;

import java.util.List;

import ProjetEnchere.bo.Categorie;
import ProjetEnchere.dal.CategorieDAO;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	
	public CategorieDAOJdbcImpl() {
		super();
	}
	
	/**
	 * M�thode permettant d'afficher la liste des cat�gories
	 * @return Une liste d'objets de type Categorie
	 * @Override
	 */
	public List<Categorie> listerToutesLesCategories() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

		
	@Override
	public Categorie selectById(int id) throws DALException {
		
//		Categorie categorie = null;
//		try (SeConnecter cnx = Utils.getConnection()) {
//			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
//			pstmt.setInt(1, id);
//			ResultSet rs = pstmt.executeQuery();
//			
//			if(rs.next())
//			{
//				categorie = categorieBuilder(rs);
//			}
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			 DALException DALException = new DALException();
//			 DALException.ajouterErreur(.SELECTION_CATEGORIE_ERREUR);		 
//			 throw DALException;
//		}
//
		return null;
	}

			@Override
			public Categorie insert(Categorie categorie) throws DALException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean update(Categorie categorie) throws DALException {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean delete(Categorie categorie) throws DALException {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<Categorie> selectAll() throws DALException {
				// TODO Auto-generated method stub
				return null;
			}

}
