package ProjetEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ProjetEnchere.bo.ArticleVendu;
import ProjetEnchere.bo.Retrait;
import ProjetEnchere.bo.Utilisateur;
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
			throw new DALException("erreur de la  suppression  de l'article:", e);
		}

	
	}
	}

	@Override
	public Retrait selectById(int id) throws DALException{
		Connection cnx= null;
		Statement stmt=null; 
		Retrait retrait= null;
		
		
		String sql = "SELECT no_retrait, rue,code_postal,ville FROM RETRAITS WHERE no_retrait=";
		sql = sql +id+";";
		

		try {
			cnx = DALConnectionProvider.getConnection();
			stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			retrait = new Retrait();
			rs.next();
			retrait.setNo_retrait(rs.getInt("no_retrait"));
			retrait.setRue(rs.getString("rue"));
			retrait.setCodePostal(rs.getString("code_postal"));
			retrait.setVille(rs.getString("ville"));
			


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
		return retrait;
		
	}
}
