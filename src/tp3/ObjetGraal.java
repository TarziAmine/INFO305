package tp3;

public abstract class ObjetGraal extends Objet {
	protected int poids;

	public ObjetGraal(String nom, int effetVie, int poids) {
		super(nom, effetVie);
		this.poids = poids;
	}

	public int getPoids() {
		return poids;
	}
}