package ProjetEnchere.dal.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import ProjetEnchere.bo.EtatVente;
import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.DAOFactory;
import ProjetEnchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO{


	/**
	 * Méthode permettant d'insérer un utilisateur dans la BDD
	 * @param Utilisateur u1
	 */
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
		String sql = "SELECT no_utilisateur,pseudo, nom, prenom ,email ,telephone, rue, code_postal,ville ,mot_de_passe,credit ,administrateur,utilisateur_ferme_le FROM UTILISATEURS WHERE pseudo=";
		sql = sql + "'"+pseudo+"';";
		Statement stmt;

		try {
			Connection cnx = DALConnectionProvider.getConnection();

			stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
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
				u.setFerme_le(null);
				if (rs.getDate("utilisateur_ferme_le")!=null) {
					u.setFerme_le(rs.getDate("utilisateur_ferme_le").toLocalDate());
			}
			}

			stmt.close();
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}


	public Utilisateur getUserByEmail(String email) throws DALException{

		Utilisateur user=null;
		Statement stmt=null;
		Connection cnx=null;
		ResultSet rs=null;
		try {
			cnx = DALConnectionProvider.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt = cnx.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//requete sql
		String sql = "SELECT no_utilisateur,pseudo, nom, prenom ,email ,telephone, rue, code_postal,ville ,mot_de_passe,credit ,administrateur FROM UTILISATEURS WHERE email=";
		sql = sql + "'"+email+"';";

		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.next();
			String pseudo = rs.getString("pseudo");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String mail = rs.getString("email");
			String telephone = rs.getString("telephone");
			String rue = rs.getString("rue");
			String codepostal = rs.getString("code_postal");
			String ville = rs.getString("ville");
			String motDePasse = rs.getString("mot_de_passe");
			int credit = rs.getInt("credit");

			user = new Utilisateur(pseudo, nom, prenom, mail, telephone, rue, codepostal, ville, motDePasse, credit);
			user.setNoUtilisateur(rs.getInt(1));

			stmt.close();
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * Méthode permettant de récupérer un utilisateur de la BDD grace à son numéro utilisateur
	 * @param noUtilisateur id
	 * @return Utilisateur
	 * @throws DALException
	 */
	public Utilisateur getUserById(int id)  throws DALException{

		Utilisateur u = null;
		String sql = "SELECT no_utilisateur,pseudo, nom, prenom ,email ,telephone, rue, code_postal,ville ,mot_de_passe,credit ,administrateur FROM UTILISATEURS WHERE no_utilisateur=";
		sql = sql +id+";";
		Statement stmt;

		try {
			Connection cnx = DALConnectionProvider.getConnection();

			stmt = cnx.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			String pseudo = rs.getString("pseudo");
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
			u.setNoUtilisateur(id);

			stmt.close();
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}


	/**
	 * Méthode permettant de "fermer" un utilisateur dans la BDD s'il n'a pas de ven,tes en cours
	 * @param Utilisateur utilisateur
	 * @throws DALException
	 * @Override
	 */
	public void fermer(Utilisateur utilisateur) throws DALException {

		Connection cnx=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			verificationVentesEnCours(utilisateur);
		} catch (DALException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		String fermer ="UPDATE UTILISATEURS SET utilisateur_ferme_le = ? WHERE pseudo=?;";
		try {
			cnx = DALConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(fermer);
			pstmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
			pstmt.setString(2, utilisateur.getPseudo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("erreur lors de la suppression de l'utilisateur :",e);
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(cnx !=null) {
					cnx.close();
				}
			}catch (SQLException e) {
				throw new DALException("erreur de la  suppression  de l'utilisateur:", e);
			}

		}

	}
	
	
	/**
	 * Méthode permettant de mettre à jour les informations d'un utilisateur dans la base de données 
	 * @param Utilisateur
	 * @return Utilisateur modifié
	 * @throws DALException
	 * @Override
	 */
//	public Utilisateur update(Utilisateur utilisateur, Utilisateur utilisateurSession) throws DALException {
//		Connection cnx=null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		
//		try {
//			cnx = DALConnectionProvider.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		if(utilisateur == null) {
//			throw new DALException("Pas d'utilisateur passé en paramêtre de la méthode update");
//		}
//	
//		String update ="UPDATE UTILISATEURS SET pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?, mot_de_passe=? WHERE pseudo=?;";
//					
//		try {
//			pstmt = cnx.prepareStatement(update);
//			pstmt.setString(1, utilisateur.getPseudo());
//			pstmt.setString(2, utilisateur.getNom());
//			pstmt.setString(3, utilisateur.getPrenom());
//			pstmt.setString(4, utilisateur.getEmail());
//			pstmt.setString(5, utilisateur.getTelephone());
//			pstmt.setString(6, utilisateur.getRue());
//			pstmt.setString(7, utilisateur.getCodepostal());
//			pstmt.setString(8, utilisateur.getVille());
//			pstmt.setString(9, utilisateur.getMotDePasse());
//			pstmt.setString(10, utilisateurSession.getPseudo());
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	
//		try {
//			pstmt.close();
//			cnx.close();
//		} catch (SQLException e) {
//			throw new DALException("Impossible de fermer la connexion avec la base de données");
//		}
//		
//		return getUserByPseudo(utilisateur.getPseudo());
//	}
/*
	* Méthode permettant de vérifier si un utilisateur a des ventes en cours
    * @param Utilisateur u
    * @throws DALException
    * @throws SQLException
    */
   private void verificationVentesEnCours(Utilisateur u) throws DALException, SQLException {
      
       final String sql = "SELECT UTILISATEURS.no_utilisateur, pseudo, nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur,utilisateur_ferme_le, etat_vente " +
               "FROM UTILISATEURS INNER JOIN ARTICLES_VENDUS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur WHERE ARTICLES_VENDUS.etat_vente='"+ EtatVente.EN_COURS + "' AND pseudo =? ;";
       ResultSet rs = null;
       PreparedStatement pstmt = null;
       Connection cnx = null;
      
       try {
           cnx = DALConnectionProvider.getConnection();
       } catch (SQLException e) {
           throw new DALException("Problème de connexion à la base de données");
       }
      
       try {
           pstmt = cnx.prepareStatement(sql);
           pstmt.setString(1, u.getPseudo());
           rs = pstmt.executeQuery();
       } catch (SQLException e) {
           throw new DALException("Requête SQL Impossible");
       }
       if(rs.next()) {
           throw new DALException("Le compte ne peut pas être fermé car il y a des ventes en cours");
       }
      
   }
   
   /* Méthode permettant de mettre à jour les informations d'un utilisateur dans la base de données
   * @param Utilisateur
   * @return Utilisateur modifié
   * @throws DALException
   * @Override
   */
  public Utilisateur update(Utilisateur utilisateur, Utilisateur utilisateurSession) throws DALException {
      Connection cnx=null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
     
     
      try {
          cnx = DALConnectionProvider.getConnection();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      if(utilisateur == null) {
          throw new DALException("Pas d'utilisateur passé en paramêtre de la méthode update");
      }
 
      String update ="UPDATE UTILISATEURS SET pseudo='?',nom='?',prenom='?',email='?',telephone='?',rue='?',code_postal='?',ville='?', mot_de_passe='?' WHERE pseudo='?';";
                 
      try {
          pstmt = cnx.prepareStatement(update);
          pstmt.setString(1, utilisateur.getPseudo());
          pstmt.setString(2, utilisateur.getNom());
          pstmt.setString(3, utilisateur.getPrenom());
          pstmt.setString(4, utilisateur.getEmail());
          pstmt.setString(5, utilisateur.getTelephone());
          pstmt.setString(6, utilisateur.getRue());
          pstmt.setString(7, utilisateur.getCodepostal());
          pstmt.setString(8, utilisateur.getVille());
          pstmt.setString(9, utilisateur.getMotDePasse());
          pstmt.setString(10, utilisateurSession.getPseudo());
          pstmt.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      }
 
      try {
          pstmt.close();
          cnx.close();
      } catch (SQLException e) {
          throw new DALException("Impossible de fermer la connexion avec la base de données");
      }
     
      return getUserByPseudo(utilisateur.getPseudo());
  }
    /**
     * Méthode permettant de "fermer" un utilisateur dans la BDD s'il n'a pas de ven,tes en cours
     * @param Utilisateur utilisateur
     * @throws DALException
     * @Override
     */
//    public void fermer(Utilisateur utilisateur) throws DALException {
//
// 
//
//        Connection cnx=null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
// 
//
//        try {
//            verificationVentesEnCours(utilisateur);
//        } catch (DALException e) {
//            e.getMessage();
//        } catch (SQLException e) {
//            e.getMessage();
//        }
//        
//        String fermer ="UPDATE UTILISATEURS SET utilisateur_ferme_le = ? WHERE pseudo=?;";
//        try {
//            cnx = DALConnectionProvider.getConnection();
//            pstmt = cnx.prepareStatement(fermer);
//            pstmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
//            pstmt.setString(2, utilisateur.getPseudo());
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            throw new DALException("erreur lors de la suppression de l'utilisateur :",e);
//        }finally {
//            try {
//                if(pstmt!=null) {
//                    pstmt.close();
//                }
//                if(cnx !=null) {
//                    cnx.close();
//                }
//            }catch (SQLException e) {
//                throw new DALException("erreur de la  suppression  de l'utilisateur:", e);
//            }
//
// 
//
//        }
//
//
//    }

	@Override
	public List<Utilisateur> select() throws DALException {

		return null;
	}



	@Override
	public Utilisateur selectConnexion(String identifiant, String password) throws DALException {
		return null;
	}



	@Override
	public Utilisateur selectPseudo(String pseudo) throws DALException {
		return null;
	}






}



