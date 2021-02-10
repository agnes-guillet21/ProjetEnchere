package ProjetEnchere.dal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
//		PrintWriter out = response.getWriter();
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
		
		Utilisateur u1 = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, motDePasse, credit);
		UtilisateurDAO uDAO = DAOFactory.getUtilisateurDAO();
		try {
			uDAO.insert(u1);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
