package ProjetEnchere.dal.jdbc; // modif pour pouvoir l'envoyer

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class DALConnectionProvider {
	
	private static DataSource dataSource;
	
	static
	{
		Context context;
		try {
			context = new InitialContext();
			DALConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'acc�der � la base de donn�es");
		}
	}
	
	public static Connection getConnection() throws SQLException
	{
		return DALConnectionProvider.dataSource.getConnection();
	}
}
