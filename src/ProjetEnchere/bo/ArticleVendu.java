package ProjetEnchere.bo;

import java.time.LocalDate;

/**
 * Objet en vente sur l'application
 * @author Team F
 *
 */
public class ArticleVendu {

///////////////// ATTRIBUTS //////////////////////////////
	private int noArticle; //Num�ro automatiquement incr�ment� par la BDD
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
	 * Constructeur par d�faut sans param�tre
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
	 * M�thode r�cup�rant le num�ro Article (le num�ro a pr�alablement �t� g�n�r� par la BDD et r�cup�r� dans la BDD)
	 * @return int noArticle
	 */
	public int getNoArticle() {
		return noArticle;
	}
	
	/**
	 * Attention le num�ro doit �tre r�cup�r� dans la BDD
	 * @param int noArticle
	 */
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	
	/**
	 * M�thode r�cup�rant le nom de l'Article
	 * @return String nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}
	
	/**
	 * M�thode modifiant ou renseignant l'attribut nom dans l'instance Article
	 * @return String nomArticle
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	
	/**
	 * M�thode r�cup�rant la d�scription de l'Article
	 * @return String Description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * M�thode modifiant ou renseignant l'attribut description dans l'instance Article
	 * @return String description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * M�thode r�cup�rant la cat�gorie de l'Article
	 * La categorie est un Objet de type Categorie
	 * @return Categorie categorieArticle
	 */
	public Categorie getCategorieArticle() {
		return categorieArticle;
	}
	
	/**
	 * M�thode modifiant ou renseignant l'attribut categorieArticle dans l'instance Article
	 * L'attribut est un objet de type Categorie
	 * @return Categorie categorieArticle
	 */
	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}
	
	/**
	 * M�thode r�cup�rant la date de d�but d'Encheres
	 * @return LocalDate dateDebutEncheres
	 */
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	
	/**
	 * M�thode modifiant ou renseignant l'attribut dateDebutEncheres
	 * @param LocalDate dateDebutEncheres
	 */
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	
	/**
	 * M�thode r�cup�rant la date de fin d'Encheres
	 * @return LocalDate dateFinEncheres
	 */
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	
	/**
	 * M�thode modifiant ou renseignant l'attribut dateFinEncheres
	 * @param LocalDate dateFinEncheres
	 */
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	
	/**
	 * M�thode r�cup�rant la Mise � prix
	 * @return int miseAPrix
	 */
	public int getMiseAPrix() {
		return miseAPrix;
	}
	
	/**
	 * Methode modifiant ou renseignant l'attribut miseAPrix
	 * @param int miseAPrix
	 */
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	
	/**
	 * M�thode r�cup�rant le prix de Vente d'un objet
	 * @return int prixVente
	 */
	public int getPrixVente() {
		return prixVente;
	}
	
	/**
	 * Methode modifiant ou renseignant l'attribut prixDeVente 
	 * @param int prixVente
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	
	/**
	 * Methode retournant l'�tat d'une vente
	 * @return String etatVente
	 */
	public String getEtatVente() {
		return etatVente;
	}
	
	/**
	 * Methode modifiant ou renseignant l'attribut etatVente
	 * @param String etatVente
	 */
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	
	/**
	 * Methode retournant l'utilisateur mettant en vent l'objet
	 * L'utilisateur est une instance de type Utilisateur
	 * @return Utilisateur utilisateurVendeur
	 */
	public Utilisateur getUtilisateurVendeur() {
		return utilisateurVendeur;
	}
	
	/**
	 * Methode modifiant ou renseignant l'attribut utilisateurVendeur
	 * @param Utilisateur utilisateurVendeur
	 */
	public void setUtilisateurVendeur(Utilisateur utilisateurVendeur) {
		this.utilisateurVendeur = utilisateurVendeur;
	}
	
	/**
	 * Methode retournant le lieu de retrait de la vente
	 * Le lieu est une instance de type Retrait
	 * @return Retrait lieuRetrait
	 */
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}
	
	/**
	 * Methode modifiant ou renseignant l'attribut lieuRetrait
	 * @param Retrait lieuRetrait
	 */
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
