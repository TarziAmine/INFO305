package tp3;

public abstract class Objet {
	protected String nom;
	protected int effetVie;

	public Objet(String nom, int effetVie) {
		this.nom = nom;
		this.effetVie = effetVie;
	}

	public abstract String getSymbole();

	public int getEffetVie() {
		return effetVie;
	}

	public String getNom() {
		return nom;
	}
}