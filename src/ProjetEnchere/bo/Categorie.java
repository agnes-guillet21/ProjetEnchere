package ProjetEnchere.bo;

/**
 * La classe Categorie est un attribut de la classe ArticleVendu
 * @author Team F
 *
 */
public class Categorie {

	private int noCategorie; //Numéro généré par la BDD 
    private String libelle;

    /**
     * Constructeur sans paramètre
     */
    public Categorie() {
    }
    
    /**
     * Constructeur avec paramètre
     * @param noCategorie
     * @param libelle
     */
    public Categorie(int noCategorie, String libelle) {
        this.noCategorie = noCategorie;
        this.libelle = libelle;
    }
    
    /**
     * Méthode retournant le numéro de la categorie
     * Ce numéro est généré par la BDD lors de l'insertion en BDD
     * @return int noCategorie
     */
    public int getNoCategorie() {
        return noCategorie;
    }

    /**
     * Methode modifiant ou renseignant l'attribut noCategorie
     * Ce numéro est à récupéré dans la BDD car il est auto généré par elle
     * @param int noCategorie
     */
    public void setNoCategorie(int noCategorie) {
        this.noCategorie = noCategorie;
    }

    /**
     * Methode retournant le libellé de la Categorie
     * @return String libelle
     */
    public String getLibelle() {
        return libelle;
    }
    
    /**
     * Methode modifian ou renseignant l'attribut libellé 
     * @param String libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "noCategorie=" + noCategorie +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}