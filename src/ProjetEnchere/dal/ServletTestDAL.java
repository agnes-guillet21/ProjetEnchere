package ProjetEnchere.dal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		try {
			Connection cnx = DALConnectionProvider.getConnection();
			out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte") + ".");
			
			String sql = "SELECT no_utilisateur,pseudo, nom, prenom ,email ,telephone, rue, code_postal,ville ,mot_de_passe,credit ,administrateur FROM UTILISATEURS WHERE pseudo='test';";
			PreparedStatement pstmt;
			pstmt = cnx.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String pseudot = rs.getString("pseudo");
			String nomt = rs.getString("nom");
			String prenomt = rs.getString("prenom");
			String emailt = rs.getString("email");
			String telephonet = rs.getString("telephone");
			String ruet = rs.getString("rue");
			String codepostalt = rs.getString("code_postal");
			String villet = rs.getString("ville");
			String motDePasset = rs.getString("mot_de_passe");
			int creditt = rs.getInt("credit");
			
			Utilisateur u = new Utilisateur(pseudot, nomt, prenomt, emailt, telephonet, ruet, codepostalt, villet, motDePasset, creditt);
			
			System.out.println(u);
			out.print(u);
			
			cnx.close();
			out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte") + ".");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		String pseudo = "Mamou1";
		String nom = "Prevost";
		String prenom = "Amaury";
		String email = "amauryprevost1@hotmail.fr";
		String telephone = "0631681002";
		String rue = "4 allée Richemont";
		String codepostal = "44000";
		String ville = "NANTES";
		String motDePasse = "mdp";
		int credit = 100;
		
		Utilisateur u1 = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, motDePasse, credit);
		
		UtilisateurDAO uDAO = DAOFactory.getUtilisateurDAO();
		try {
			uDAO.insert(u1);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u1 + " a bien été ajuouté");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
