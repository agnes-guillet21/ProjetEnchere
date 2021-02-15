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
		
		
	//	public CategorieDAOJdbcImpl() {
	//		super();
	//	
	//		private static final String INSERT = "INSERT INTO CATEGORIE(libelle) VALUES (?);";
	//		private static final String SELECT_ALL = "SELECT no_categorie, libelle FROM CATEGORIES;";
//			
//			@Override
//			public void insert(Categorie categorie) throws DALException {
//				Connection cnx = null;
//				DALException be = new DALException();
//				try {
				//					cnx = ConnectionProvider.getConnection();
//				PreparedStatement psmt = cnx.prepareStatement(INSERT);
//				psmt.setString(1, categorie.getLibelle());
//					psmt.close();
//				} catch (Exception e) 
//			} finally {
//				try {
//					cnx.close();
//				} catch (SQLException e) {
				//					e.printStackTrace();
//		}
//				List<Categorie> selectAll() throws DALException {
//					Connection cnx = null;
//					DALException be = new DALException();
//					List<Categorie> listeCategorie = new ArrayList<Categorie>();
//						try {
//							cnx = ConnectionProvider.getConnection();
//							Statement smt = cnx.createStatement();
//							ResultSet rs = smt.executeQuery(SELECT_ALL);
//							while (rs.next()) {
//							Categorie categorie = Mapping.mappingCategorie(rs);
//							listeCategorie.add(categorie);
//						}
//					smt.close();
//						}
//						
//						}
//				}
			//					return listeCategorie;
//				}
		//			}
				

		
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
