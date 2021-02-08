package ProjetEnchere.bo;

import java.time.LocalDate;

public class Enchere {

///////////////// ATTRIBUTS //////////////////////////////
	private int noEnchere;//Auto g�n�r�e par la BDD
	private LocalDate dateEnchere;
	private int montantEnchere;
	private ArticleVendu articleVendu;
	private Utilisateur utilisateur;
	

///////////////// CONSTRUCTEURS //////////////////////////////
	/**
	 * Constructeur sans param�tre
	 */
	public Enchere() {
		super();
	}

	/**
	 * Constructeur avec param�tre
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param articleVendu
	 * @param utilisateur
	 */
	public Enchere(LocalDate dateEnchere, int montantEnchere, ArticleVendu articleVendu,
			Utilisateur utilisateur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.articleVendu = articleVendu;
		this.utilisateur = utilisateur;
	}

	
///////////////// GETTERS SETTERS //////////////////////////////		
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * 
	 * @return Le No de l'ench�re qui a �t� g�n�r�e lors de l'insertion en BDD
	 */
	public int getNoEnchere() {
		return noEnchere;
	}

	/**
	 *  Attention le num�ro doit �tre r�cup�r� dans la BDD
	 * @return 
	 */
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	
///////////////// METHODES //////////////////////////////	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [noEnchere=");
		builder.append(noEnchere);
		builder.append(", dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", montantEnchere=");
		builder.append(montantEnchere);
		builder.append(", articleVendu=");
		builder.append(articleVendu);
		builder.append(", utilisateur=");
		builder.append(utilisateur);
		builder.append("]");
		return builder.toString();
	}

	
}
