package tp2;

public class EtagereDeux {
	private java.util.ArrayList<Livre> livres;

	public EtagereDeux() {
		this.livres = new java.util.ArrayList<>();
	}

	public void ajouter(Livre unLivre) {
		livres.add(unLivre);
	}

	public int getNbLivres() {
		return livres.size();
	}

	public Livre chercher(String auteur, String titre) {
		for (Livre l : livres) {
			if (l.getAuteur().equals(auteur) && l.getTitre().equals(titre)) {
				return l;
			}
		}
		return null;
	}

	public String toString() {
		String res = "il y a " + livres.size() + " livres. Contenu étagère : \n";
		for (Livre l : livres) {
			res += "\t" + l.toString() + "\n";
		}
		return res;
	}
}