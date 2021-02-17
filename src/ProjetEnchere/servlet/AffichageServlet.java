package ProjetEnchere.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.mbeans.UserMBean;

import ProjetEnchere.bll.UtilisateurManager; // import à completer
import ProjetEnchere.bo.Utilisateur;
import ProjetEnchere.dal.jdbc.DALException;

@WebServlet("/profil.html")
public class AffichageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AffichageServlet() {
        super();
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Utilisateur uVendeur = (Utilisateur) request.getSession().getAttribute("user");
    	boolean sameUser = true;
    	
    	request.setAttribute("sameUser", sameUser);
    	request.setAttribute("titreDePage", "Profil");
    	request.setAttribute("userAffiche", uVendeur);
    	request.setAttribute("nomDePage", "PROFIL");
    	this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/profil.jsp").forward(request, response);
    }
    		
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	UtilisateurManager uMger = new UtilisateurManager();
    	Utilisateur uVendeur = null;
    	 
    	try {
			uVendeur = (Utilisateur) uMger.getUserByPseudo(request.getParameter("utilisateurVendeur"));
		} catch (DALException e) {
			e.printStackTrace();
		}
       	
   
    	request.setAttribute("titreDePage", "Profil");
    	request.setAttribute("userAffiche", uVendeur);
    	request.setAttribute("nomDePage", "PROFIL");
    	this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/profil.jsp").forward(request, response);
	}

}