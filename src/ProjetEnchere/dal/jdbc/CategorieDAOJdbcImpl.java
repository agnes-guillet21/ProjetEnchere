package ProjetEnchere.dal.jdbc;

import java.util.List;

import ProjetEnchere.bo.Categorie;
import ProjetEnchere.dal.CategorieDAO;

public class CategorieDAOJdbcImpl implements CategorieDAO {

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
	public Void Insert() throws DALException {
		// TODO Auto-generated method stub
		return null;
		
		
		public CategorieDAOJdbcImpl() {
			super();
		
		
			@Override
			public Categorie selectById(int id) throws DALException {
				
				Categorie categorie = null;
				try (SeConnecter cnx = Utils.getConnection()) {
					PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
					pstmt.setInt(1, id);
					ResultSet rs = pstmt.executeQuery();
					
					if(rs.next())
					{
						categorie = categorieBuilder(rs);
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
					 DALException DALException = new DALException();
					 DALException.ajouterErreur(.SELECTION_CATEGORIE_ERREUR);		 
					 throw DALException;
				}

				return categorie;
	}

}
