package ProjetEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO{





	public void insert ( Utilisateur u1) throws DALException{
		Connection cnx=null;
		PreparedStatement stmt = null;

		//test requete sql
		String sql ="INSERT INTO dbo.UTILISATEURS(pseudo,nom,prenom,email,telephone,"
				+ "(code_postal,ville,mot_de_passe,credit,administrateur)"
				+ "VALUE (?,?,?,?,?,?,?,?,?,?,?,?,)";

		stmt=  cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, u1.getPseudo());
		stmt.setString(2, u1.getNom());
		stmt.setString(3, u1.getPrenom());
		stmt.setString(4, u1.getEmail());
		stmt.setString(5, u1.getTelephone());
		stmt.setString(6, u1.getCodepostal());
		stmt.setString(7, u1.getVille());
		stmt.setString(8, u1.getMotDePasse());
		stmt.setInt(9, u1.getCredit());
		if(u1 instanceof ) {
			stmt.setBoolean(10, u1.isAdministrateur()== true);
		}else {
			stmt.setBoolean(10, u1.isAdministrateur()==false);
		}


	}



	@Override
	public Utilisateur selectByPseudo(String pseudo) throws DALException {
		return null;
	}
}
