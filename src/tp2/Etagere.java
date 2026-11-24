package tp2;


public class Etagere {
	private Livre[] livres;
	private int capacite;
	private int nbLivres;

	public Etagere(int capacite) {
		this.capacite = capacite;
		this.livres = new Livre[capacite];
		this.nbLivres = 0;
	}

	public void ajouter(Livre unLivre) {
		if (unLivre != null && nbLivres < capacite) {
			livres[nbLivres] = unLivre;
			nbLivres++;
		}
	}

	public int getNbLivres() {
		return nbLivres;
	}

	public Livre chercher(String auteur, String titre) {
		for (int i = 0; i < nbLivres; i++) {
			if (livres[i] != null && livres[i].getAuteur().equals(auteur) && livres[i].getTitre().equals(titre)) {
				return livres[i];
			}
		}
		return null;
	}

	public String toString() {
		String res = "il y a " + nbLivres + " livres. Contenu étagère : \n";
		for (int i = 0; i < nbLivres; i++) {
			if (livres[i] != null) {
				res += "\t" + livres[i].toString() + "\n";
			}
		}
		return res;
	}
}