package ProjetEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ProjetEnchere.bll.BLLException;
import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.dal.ArticleVenduDAO;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO{

	private static final String SELECT_ALL="SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie,no_retrait FROM ARTICLES_VENDUS;";
	private static UtilisateurDAOJdbcImpl utilisateur = new UtilisateurDAOJdbcImpl();
	
	
	/**
	 * Méthode permettant d'afficher la liste de toutes les ventes
	 * @return une liste d'objet de types ArticleVendu
	 * @throws BLLException
	 * @Override
	 */
	public List<ArticleVendu> listerToutesLesVentes() throws DALException {
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
//				articleVendu.setCategorieArticle(CategorieDAOJdbcImpl.SelectById(rs.getInt("no_categorie"));
//				articleVendu.setLieuRetrait(RetraitDAOJdbcImpl.SelectById(rs.getInt("no_retrait"));
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

	@Override
	public List<ArticleVendu> listerVentesParCriteres() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Méthode permettant d'insérer une nouvelle vente (objet de type ArticleVendu) dans la base de données
	 * @param ArticleVendu a
	 * @Override
	 */
	public void insert(ArticleVendu a) {
		//TODO Méthode à implémenter
		
	}

}
