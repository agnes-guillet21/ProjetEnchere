package ProjetEnchere.dal.jdbc;

import java.sql.Connection;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ProjetEnchere.bll.BLLException;
import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.dal.ArticleVenduDAO;
import ProjetEnchere.dal.CategorieDAO;
import ProjetEnchere.dal.DAOFactory;
import ProjetEnchere.dal.RetraitDAO;


public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO{

	private static final String SELECT_ALL="SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie,no_retrait FROM ARTICLES_VENDUS;";
	private static final String INSERT_VENTE="INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, "
			+ "prix_initial, prix_vente, no_utilisateur, no_categorie, no_retrait) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static UtilisateurDAOJdbcImpl utilisateur = new UtilisateurDAOJdbcImpl();


	/**
	 * Mï¿½thode permettant de lister toutes les ventes de l'application
	 * @return List<ArticleVendu> Une liste d'objets de type ArticleVendu
	 * @throws DALException
	 * @Override
	 */
	public List<ArticleVendu> listerToutesLesVentes() throws DALException {
		CategorieDAO categorieDAO= DAOFactory.getCategorieDAO();
		RetraitDAO retraitDAO= DAOFactory.getRetraitDAO();
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ArticleVendu> listeVentes = new ArrayList<ArticleVendu>();

		try {
			cnx = DALConnectionProvider.getConnection();
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);

			while (rs.next()) {
				ArticleVendu articleVendu = new ArticleVendu();
				articleVendu.setNoArticle(rs.getInt("no_article"));
				articleVendu.setNomArticle(rs.getString("nom_article"));
				articleVendu.setDescription(rs.getString("description"));
				articleVendu.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				articleVendu.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				articleVendu.setMiseAPrix(rs.getInt("prix_initial"));
				articleVendu.setPrixVente(rs.getInt("prix_vente"));
				//TODO Revoir la récupération des Objets liés à ArticleVendu
				articleVendu.setUtilisateurVendeur(utilisateur.getUserById(rs.getInt("no_utilisateur")));
				articleVendu.setCategorieArticle(categorieDAO.selectById(rs.getInt("no_categorie")));
							//	articleVendu.setLieuRetrait(retraitDAO.selectById(rs.getInt("no_retrait")));
				listeVentes.add(articleVendu);

			}
		} catch (SQLException e) {
			throw new DALException("listerToutesLesVentes() Echec");
		}finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeVentes;
	}

	/**
	 * Méthode permettant de lister les ventes en fonctions de critï¿½res donnï¿½s par l'utilisateur
	 * @return List<ArticleVendu> Une liste d'objets de type ArticleVendu
	 * @throws DALException
	 * @Override
	 */
	public List<ArticleVendu> listerVentesParCriteres(String nom) throws DALException {
		CategorieDAO categorieDAO= DAOFactory.getCategorieDAO();
		RetraitDAO retraitDAO= DAOFactory.getRetraitDAO();
		List<ArticleVendu> listeEncheres = new ArrayList<ArticleVendu>();
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try {
			cnx = DALConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
			try {
				
		
				String selectByCritere= "SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,"
						+ "no_utilisateur,no_categorie,no_retrait from ARTICLES_VENDUS WHERE nom_article like '%"+nom+"%';";
							//	+ " and no_categorie=?";
						//pstmt.setString(1,no_categorie )
						//changer le para de la methode pr ajouter une catego
					System.out.println(selectByCritere);
				pstmt = cnx.prepareStatement(selectByCritere);
				
				//pstmt.setString(1, nom);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						ArticleVendu articleVendu = new ArticleVendu();
						articleVendu.setNoArticle(rs.getInt("no_article"));
						articleVendu.setNomArticle(rs.getString("nom_article"));	
						articleVendu.setDescription(rs.getString("description"));
						articleVendu.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
						articleVendu.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
						articleVendu.setMiseAPrix(rs.getInt("prix_initial"));
						articleVendu.setPrixVente(rs.getInt("prix_vente"));
						
						articleVendu.setUtilisateurVendeur(utilisateur.getUserById(rs.getInt("no_utilisateur")));	
						articleVendu.setCategorieArticle(categorieDAO.selectById(rs.getInt("no_categorie")));
						//articleVendu.setLieuRetrait(retraitDAO.selectById(rs.getInt("no_retrait")));
						listeEncheres.add(articleVendu);
					}
			} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
					if(pstmt !=null) {
						pstmt.close();
					}
					if(cnx !=null) {
						cnx.close();
					}
					
				}catch (SQLException e) {
					throw new DALException ("getByCritere echec");
				}
				}
				
		return listeEncheres ;
	}


	/**
	 * Méthode permettant d'ajouter une vente (un ArticleVendu) dans la base de donnï¿½e
	 * @param Une instance d'ArticleVendu aV
	 * @throws DALException
	 * @Override
	 */
	public void ajouterVente(ArticleVendu articleVendu) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			cnx = DALConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(INSERT_VENTE, Statement.RETURN_GENERATED_KEYS);
			//(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, no_retrait)
			pstmt.setString(1, articleVendu.getNomArticle());
			pstmt.setString(2,articleVendu.getDescription());
			pstmt.setDate(3, Date.valueOf(articleVendu.getDateDebutEncheres()));
			pstmt.setDate(4, Date.valueOf(articleVendu.getDateFinEncheres()));
			pstmt.setInt(5,articleVendu.getMiseAPrix());
			pstmt.setInt(6,articleVendu.getPrixVente());
			pstmt.setInt(7,articleVendu.getUtilisateurVendeur().getNoUtilisateur());
			//TODO Revoir la récupération des Objets liés à ArticleVendu
			//pstmt.setInt(8,articleVendu.getCategorieArticle().getNoCategorie());
			pstmt.setInt(8,1);
			//pstmt.setInt(9,articleVendu.getLieuRetrait().getNoRetrait());
			pstmt.setInt(9, 1);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Mï¿½thode permettant d'insï¿½rer une nouvelle vente (objet de type ArticleVendu) dans la base de donnï¿½es
	 * @param ArticleVendu a
	 * @Override
	 */
	public void insert(ArticleVendu a) {	
	}

	@Override
	public List<ArticleVendu> select(String categorie, String recherche) throws DALException {


		return null;
	}

	//@Override
	//public ArticleVendu getById(int id) throws DALException {

	//	private static final String GET_BY_ID =  // a terminer
	//	ArticleVendu articleVendu = null;

	//	try (Connection cnx = DALConnectionProvider.getConnection()) {
	//		PreparedStatement pstmt = cnx.prepareStatement(GET_BY_ID);
	//		pstmt.setInt(1, id);

	//		ResultSet rs = pstmt.executeQuery();

	//		if (rs.next()) {
	//			articleVendu = !!! ; // a terminer !

	//		}

	//	} catch (Exception e) {
	//		e.printStackTrace();
	//		DALException businessException = new DALException();
	//		throw businessException;

	//	}
	//	return articleVendu;
	//}

}
