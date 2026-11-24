package tp2;

public class Livre {
	private String auteur;
	private String titre;
	private double prix;
	private int nbPages;

	public Livre(String auteur, String titre, double prix, int nbPages) {
		this.auteur = auteur;
		this.titre = titre;
		this.prix = prix;
		this.nbPages = nbPages;
	}

	public Livre(String auteur, String titre, double prix) {
		this.auteur = auteur;
		this.titre = titre;
		this.prix = prix;
		this.nbPages = 0;
	}

	public String getAuteur() {
		return auteur;
	}

	public String getTitre() {
		return titre;
	}

	public double getPrix() {
		return prix;
	}

	public int getNbPages() {
		return nbPages;
	}

	public boolean estPlusCher(Livre autre) {
		return this.prix > autre.prix;
	}

	public String toString() {
		if (nbPages == 0) {
			return "Auteur : " + auteur + ", Titre : " + titre + ", prix : " + prix;
		} else {
			return "Auteur : " + auteur + ", Titre : " + titre + ", prix : " + prix + ", nombre pages : " + nbPages;
		}
	}

}
