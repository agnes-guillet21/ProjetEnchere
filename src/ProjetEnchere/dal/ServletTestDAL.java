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

import ProjetEnchere.dal.jdbc.DALConnectionProvider;

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
			
			cnx.close();
			out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte") + ".");

		} catch (SQLException e) {
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
