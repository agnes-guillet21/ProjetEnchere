package ProjetEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.bo.Categorie;
import ProjetEnchere.bo.Retrait;
import ProjetEnchere.dal.RetraitDAO;

public class RetraitDAOJdbcImpl implements RetraitDAO {
	
	
	
	public void insertLieuRetrait(Retrait r) throws DALException, SQLException{
	Connection cnx=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	if(r == null) {
		throw new DALException("Pas d'utilisateur creer en parametre de ma methode inserer");
	}
	
	try {
		cnx = DALConnectionProvider.getConnection();
	} catch (SQLException e2) {
		e2.printStackTrace();
	}

	try {
		System.out.println("La connexion est " + (cnx.isClosed()?"ferm�e":"ouverte") + ".");
	} catch (SQLException e2) {
		e2.printStackTrace();
	}
		String insert ="insert into RETRAITS(rue,code_postal,ville) VALUES (?,?,?);";
	
		try {
			pstmt = cnx.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, r.getRue());
			pstmt.setString(2, r.getCodePostal());
			pstmt.setString(3, r.getVille());
			pstmt.executeUpdate();
			//recuperer l  identity ay travers du resultset 

						rs = pstmt.getGeneratedKeys();
						if(rs.next()) {
							r.setNo_retrait(rs.getInt(1));
						}
	} catch (SQLException e) {
		throw new DALException("erreur lors de la suppression de l'utilisateur :",e);
	}finally {
		try {
			//lib des ressources on ferme le stmt et la connexio
			if(pstmt!=null) {
				pstmt.close();
			}
			if(cnx !=null) {
				cnx.close();
			}
		}catch (SQLException e) {
			throw new DALException("erreur de la  suppression  de l'article:", e);}
		}
	}

	
	
		public ArticleVendu select(int noArticle) throws DALException, SQLException {
			DALException be = new DALException();
			try (Connection cnx = DALConnectionProvider.getConnection();
					PreparedStatement psmt = cnx.prepareStatement(SELECT);) { // a voir pour le select
				psmt.setInt(1, noArticle);
				ResultSet rs = psmt.executeQuery();
				ArticleVendu article = new ArticleVendu();
				Retrait retrait = new Retrait();
				

				if (rs.next()) {
					
					retrait.setRue(rs.getString("rue"));
					retrait.setVille(rs.getString("ville"));
					retrait.setCodePostal(rs.getString("codePostal"));


									}
				rs.close();
				psmt.close();
				return article;
			} catch (SQLException e) {
				e.printStackTrace();
	}
	}
}
