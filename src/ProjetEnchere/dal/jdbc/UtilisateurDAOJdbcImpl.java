package ProjetEnchere.dal.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.DAOFactory;
import ProjetEnchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO{


//	public UtilisateurDAOJdbcImpl(String pseudo, String nom, String prenom, String email, String tel, String rue,
//			String cp, String ville, String motDePasse, String confirMP, int i) {
//		// TODO Auto-generated constructor stub
//	}

	public void insert ( Utilisateur u1) throws DALException, SQLException{
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

		try {
			System.out.println("La connexion est " + (cnx.isClosed()?"fermée":"ouverte") + ".");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		//test requete sql
		String sql ="INSERT INTO dbo.UTILISATEURS(pseudo,nom,prenom,email,telephone,"
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
			pstmt.close();
//			cnx.commit();

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

//				cnx.setAutoCommit(true);
				cnx.close();
			}catch (SQLException e) {
				throw new DALException(e.getLocalizedMessage());

//				if(pstmt!=null) {
//					pstmt.close();
//				}
//				if(cnx!=null) {
//					cnx.close();
//				}

			}
		}
	}



	@Override
	public Utilisateur getUserByPseudo(String pseudo) throws DALException {
		
		Utilisateur u = null;
		String sql = "SELECT no_utilisateur,pseudo, nom, prenom ,email ,telephone, rue, code_postal,ville ,mot_de_passe,credit ,administrateur FROM UTILISATEURS WHERE pseudo=";
		sql = sql + "'"+pseudo+"';";
		Statement stmt;
		
		try {
			Connection cnx = DALConnectionProvider.getConnection();
			
			stmt = cnx.createStatement();
						
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String telephone = rs.getString("telephone");
			String rue = rs.getString("rue");
			String codepostal = rs.getString("code_postal");
			String ville = rs.getString("ville");
			String motDePasse = rs.getString("mot_de_passe");
			int credit = rs.getInt("credit");
			
			u = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, motDePasse, credit);
			u.setNoUtilisateur(rs.getInt(1));
			
			cnx.close();

		} catch (SQLException e) {
				e.printStackTrace();
			}
		return u;
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
