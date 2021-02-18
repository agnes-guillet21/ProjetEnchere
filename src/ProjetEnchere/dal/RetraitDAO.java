package ProjetEnchere.dal;

import java.sql.SQLException;

import ProjetEnchere.bo.Retrait;
import ProjetEnchere.dal.jdbc.DALException;

public interface RetraitDAO {
	
	
	
void insertLieuRetrait(Retrait r) throws DALException, SQLException;

Retrait selectById(int noRetrait);


}