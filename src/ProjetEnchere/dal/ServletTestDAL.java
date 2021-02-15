package ProjetEnchere.dal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.jdbc.DALConnectionProvider;
import ProjetEnchere.dal.jdbc.DALException;

/**
 * Servlet implementation class TestDAL
 */
@WebServlet("/TestDAL")
public class ServletTestDAL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//////////// TEST CONNEXION /////////////
		PrintWriter out = response.getWriter();
//		
//		try {
//			Connection cnx = DALConnectionProvider.getConnection();
//			out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte") + ".");
//			
//			cnx.close();
//			out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte") + ".");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		String pseudo = "Mamou";
		String nom = "Prevost";
		String prenom = "Amaury";
		String email = "amauryprevost@hotmail.fr";
		String telephone = "0631681002";
		String rue = "4 allée Richemont";
		String codepostal = "44000";
		String ville = "NANTES";
		String motDePasse = "mdp";
		int credit = 100;
//		
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, motDePasse, credit);
//		UtilisateurDAO uDAO = DAOFactory.getUtilisateurDAO();
//		try {
//
//			Connection cnx = DALConnectionProvider.getConnection();
//			out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte") + ".");
//			
//			String sql = "SELECT no_utilisateur,pseudo, nom, prenom ,email ,telephone, rue, code_postal,ville ,mot_de_passe,credit ,administrateur FROM UTILISATEURS WHERE pseudo='test';";
//			PreparedStatement pstmt;
//			pstmt = cnx.prepareStatement(sql);
//			
//			ResultSet rs = pstmt.executeQuery();
//			rs.next();
//			String pseudot = rs.getString("pseudo");
//			String nomt = rs.getString("nom");
//			String prenomt = rs.getString("prenom"); vv
//			String emailt = rs.getString("email");
//			String telephonet = rs.getString("telephone");
//			String ruet = rs.getString("rue");
//			String codepostalt = rs.getString("code_postal");
//			String villet = rs.getString("ville");
//			String motDePasset = rs.getString("mot_de_passe");
//			int creditt = rs.getInt("credit");
//			
//			Utilisateur u = new Utilisateur(pseudot, nomt, prenomt, emailt, telephonet, ruet, codepostalt, villet, motDePasset, creditt);
//			
//			System.out.println(u);
//			out.print(u);
//			
//			cnx.close();
//			out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte") + ".");
//
//		} catch (SQLException e) {
//
//			try {
//				uDAO.insert(u1);
//			} catch (DALException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//		String pseudo = "a";
//		Utilisateur u = new Utilisateur();
//		String sql = "SELECT no_utilisateur,pseudo, nom, prenom ,email ,telephone, rue, code_postal,ville ,mot_de_passe,credit ,administrateur FROM UTILISATEURS WHERE pseudo=";
//		sql = sql +"'" + pseudo + "';";
//		out.print(sql);
//		Statement stmt;
//		
//		try {
//			Connection cnx = DALConnectionProvider.getConnection();
//			
//			stmt = cnx.createStatement();
//						
//			ResultSet rs = stmt.executeQuery(sql);
//			rs.next();
//			String nom = rs.getString("nom");
//			String prenom = rs.getString("prenom");
//			String email = rs.getString("email");
//			String telephone = rs.getString("telephone");
//			String rue = rs.getString("rue");
//			String codepostal = rs.getString("code_postal");
//			String ville = rs.getString("ville");
//			String motDePasse = rs.getString("mot_de_passe");
//			int credit = rs.getInt("credit");
//			
//			u = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, motDePasse, credit);
//			u.setNoUtilisateur(rs.getInt(1));
//			
//			cnx.close();
//
//		} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		out.print(u);
//		
//		
		Connection cnx=null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String delete ="delete from UTILISATEURS WHERE pseudo=?;";
			try {
				cnx = DALConnectionProvider.getConnection();
				pstmt = cnx.prepareStatement(delete);
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
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
					e.printStackTrace();
				}
			}
			
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
