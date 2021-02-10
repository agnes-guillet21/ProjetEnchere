package ProjetEnchere.bo;

/**
 * La classe Categorie est un attribut de la classe ArticleVendu
 * @author Team F
 *
 */
public class Categorie {

	private int noCategorie; //Num�ro g�n�r� par la BDD 
    private String libelle;

    /**
     * Constructeur sans param�tre
     */
    public Categorie() {
    }
    
    /**
     * Constructeur avec param�tre
     * @param noCategorie
     * @param libelle
     */
    public Categorie(int noCategorie, String libelle) {
        this.noCategorie = noCategorie;
        this.libelle = libelle;
    }
    
    /**
     * M�thode retournant le num�ro de la categorie
     * Ce num�ro est g�n�r� par la BDD lors de l'insertion en BDD
     * @return int noCategorie
     */
    public int getNoCategorie() {
        return noCategorie;
    }

    /**
     * Methode modifiant ou renseignant l'attribut noCategorie
     * Ce num�ro est � r�cup�r� dans la BDD car il est auto g�n�r� par elle
     * @param int noCategorie
     */
    public void setNoCategorie(int noCategorie) {
        this.noCategorie = noCategorie;
    }

    /**
     * Methode retournant le libell� de la Categorie
     * @return String libelle
     */
    public String getLibelle() {
        return libelle;
    }
    
    /**
     * Methode modifian ou renseignant l'attribut libell� 
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