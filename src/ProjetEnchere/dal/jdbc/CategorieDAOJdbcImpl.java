package ProjetEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ProjetEnchere.bo.Categorie;
import ProjetEnchere.dal.CategorieDAO;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	private final static String SELECT_ALL = "SELECT no_categorie, libelle FROM CATEGORIES;";
	
	public CategorieDAOJdbcImpl() {
		super();
	}
		
	@Override
	public Categorie selectById(int id) throws DALException {
		
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

				
//	public CategorieDAOJdbcImpl(CateorieDAO) {
//						//	
//		private static final String INSERT = "INSERT INTO CATEGORIE(libelle) VALUES (?);";
//						
//	@Override
//	public void insert(Categorie categorie) throws DALException {
//		Connection cnx = null;
//		DALException be = new DALException();
//		try {
//			cnx = DALConnectionProvider.getConnection();
//			PreparedStatement psmt = cnx.prepareStatement(INSERT);
//			psmt.setString(1, categorie.getLibelle());
//			psmt.close();
//		} catch (Exception e) 
//		} finally {
//		try {
//			cnx.close();
//		} catch (SQLException e) {
//		e.printStackTrace();
//	}
		
		/**
		* Méthode permettant d'afficher la liste des catégories
		* @return Une liste d'objets de type Categorie List<Categorie>
		* @Override
		*/
		public List<Categorie> selectAll() throws DALException {
			Connection cnx = null;
			DALException be = new DALException();
			List<Categorie> listeCategories = new ArrayList<Categorie>();
		
			try {
				cnx = DALConnectionProvider.getConnection();
				Statement smt = cnx.createStatement();
				ResultSet rs = smt.executeQuery(SELECT_ALL);
				
				while (rs.next()) {
					
					int noCategorie = rs.getInt("no_categorie");
					String libelle = rs.getString("libelle");
					Categorie categorie = new Categorie(noCategorie, libelle);
						
// ===>>>		Categorie categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
					listeCategories.add(categorie);
				}
				smt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return listeCategories;
		}
				
}
				