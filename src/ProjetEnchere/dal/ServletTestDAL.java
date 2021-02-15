package ProjetEnchere.dal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import ProjetEnchere.bll.UtilisateurManager;
import ProjetEnchere.bo.ArticleVendu;
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

			UtilisateurManager uMger = new UtilisateurManager();			
			Utilisateur utilisateur = new Utilisateur("test", "nomtest", "prenomtest", "test@test.test", null, "1 rue test", "00000", "Test", "mdptest", 500);
			
			try {
				uMger.delete(utilisateur);
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
