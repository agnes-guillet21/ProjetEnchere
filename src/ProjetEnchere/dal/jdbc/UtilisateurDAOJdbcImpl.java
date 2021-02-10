package ProjetEnchere.dal.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO{


	//	public UtilisateurDAOJdbcImpl(String pseudo, String nom, String prenom, String email, String tel, String rue,
	//			String cp, String ville, String motDePasse, String confirMP, int i) {
	//		// TODO Auto-generated constructor stub
	//	}

	public void insert ( Utilisateur u1) throws DALException{
		Connection cnx=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// c est un tableau , c est ma vue de ma requete sql

		if(u1 == null) {
			throw new DALException("Pas d'utilisateur creer en parametre de ma methode inserer");
		}

		try {
			cnx = DALConnectionProvider.getConnection();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		//test requete sql
		String sql ="INSERT INTO UTILISATEURS(pseudo,nom,prenom,email,telephone,"
				+ "code_postal,ville,mot_de_passe,credit,administrateur)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?);";

		// desactivation de l autocommit (mode transactionnel)
		try {
			//cnx.setAutoCommit(false);
			pstmt = cnx.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, u1.getPseudo());
			pstmt.setString(2, u1.getNom());
			pstmt.setString(3, u1.getPrenom());
			pstmt.setString(4, u1.getEmail());
			pstmt.setString(5, u1.getTelephone());
			pstmt.setString(6, u1.getCodepostal());
			pstmt.setString(7, u1.getVille());
			pstmt.setString(8, u1.getMotDePasse());
			pstmt.setInt(9, u1.getCredit());
			pstmt.setInt(10, 0);

			//execution de la requete
			pstmt.executeUpdate();
			//recuperer l  identity ay travers du resultset 
			//			rs = pstmt.getGeneratedKeys();
			//			if(rs.next()) {
			//				u1.setNoUtilisateur(rs.getInt(1));
			//			}
			//pstmt.close();
			//cnx.commit();
			// a voir faire un appel de methode se deco
			// 

		}catch(SQLException e) {
			throw new DALException("erreur de lors de l'insertion d'un nouvel utilisateur" + u1, e);
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(cnx!=null) {
					cnx.close();
				}

			}catch(SQLException e) {
				throw new DALException("erreur de lors de l'insertion d'un nouvel utilisateur" + u1);
			}
		}
	}



	@Override
	public Utilisateur selectByPseudo(String pseudo) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}


	public Utilisateur selectByEmail(String email) throws DALException{
		Utilisateur user;
		Connection cnx=null;
		Statement stmt = null;
		ResultSet rs = null;

		if(user == null) {
			throw new DALException("Pas d'utilisateur creer en parametre de ma methode selectByEmail");
		}
		//connection
		try {
			cnx = DALConnectionProvider.getConnection();
		} catch (SQLException e2) {	
			e2.printStackTrace();
		}
		//requete sql

		String sql="select email from UTILISATEURS where email=?;";
		try {
			stmt = cnx.prepareStatement(sql);
			stmt.setString(1,user.getEmail());
			rs = stmt.executeQuery(sql);
			if(rs.getString("email")!=null) {
				
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return user;

	}




	//			
	//			try {
	//				cnx.rollback();
	//			}catch (SQLException e1) {
	//				throw new DALException(e1.getMessage());
	//			}
	//		}finally {
	//			try {
	//				cnx.setAutoCommit(true);
	//				cnx.close();
	//			}catch (SQLException e) {
	//				throw new DALException(e.getLocalizedMessage());
	//			}
	//		}
	//	}	
	//methode select all





}
