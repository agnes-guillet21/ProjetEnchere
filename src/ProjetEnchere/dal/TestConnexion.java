package ProjetEnchere.dal;

import java.sql.Connection;
import java.sql.SQLException;

import ProjetEnchere.dal.jdbc.DALConnectionProvider;
import ProjetEnchere.dal.jdbc.DALException;

public class TestConnexion {
	
    public static void main(String[] args) throws SQLException, DALException {
        Connection cnx = null;
		cnx = DALConnectionProvider.getConnection();
        
        System.out.println(cnx.toString());
    }

 

}

