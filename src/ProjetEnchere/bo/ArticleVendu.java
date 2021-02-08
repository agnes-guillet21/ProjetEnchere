package ProjetEnchere.bo;

import java.time.LocalDate;

public class ArticleVendu {

	
///////////////// ATTRIBUTS //////////////////////////////
	private int noArticle; //Numéro automatiquement incrémenté par la BDD
	private String nomArticle;
	private String description;
	private Categorie categorieArticle;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private String etatVente;
	private Utilisateur utilisateurVendeur;
	private Retrait lieuRetrait;


///////////////// CONSTRUCTEURS //////////////////////////////
	
	/**
	 * Constructeur par défaut
	 */
	public ArticleVendu() {
		super();
	}
	
	/**
	 * Constructeur avec parametres
	 * @param nomArticle
	 * @param description
	 * @param categorieArticle
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @param utilisateurVendeur
	 * @param lieuRetrait
	 */
	public ArticleVendu(String nomArticle, String description, Categorie categorieArticle, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, String etatVente, Utilisateur utilisateurVendeur,
			Retrait lieuRetrait) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.categorieArticle = categorieArticle;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.utilisateurVendeur = utilisateurVendeur;
		this.lieuRetrait = lieuRetrait;
	}
	
///////////////// GETTERS SETTERS //////////////////////////////	
	
	/**
	 * Méthode récupérant le numéro Article généré par la BDD
	 * @return 
	 */
	public int getNoArticle() {
		return noArticle;
	}
	
	/**
	 * Attention le numéro doit être récupéré dans la BDD
	 * @param noArticle
	 */
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	
	public String getNomArticle() {
		return nomArticle;
	}
	
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getCategorieArticle() {
		return categorieArticle;
	}
	
	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}
	
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	
	public int getMiseAPrix() {
		return miseAPrix;
	}
	
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	
	public int getPrixVente() {
		return prixVente;
	}
	
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	
	public String getEtatVente() {
		return etatVente;
	}
	
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	
	public Utilisateur getUtilisateurVendeur() {
		return utilisateurVendeur;
	}
	
	public void setUtilisateurVendeur(Utilisateur utilisateurVendeur) {
		this.utilisateurVendeur = utilisateurVendeur;
	}
	
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}
	
	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}
	
	
///////////////// METHODES //////////////////////////////
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", categorieArticle=" + categorieArticle + ", dateDebutEncheres=" + dateDebutEncheres
				+ ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix=" + miseAPrix + ", prixVente=" + prixVente
				+ ", etatVente=" + etatVente + "]";
	}
	
}
