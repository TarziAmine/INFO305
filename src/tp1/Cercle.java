package tp1;

public class Cercle {
	public static void main(String[] args) {
		Point p = new Point(3.0, 0.0);
		Point q = new Point(6.0, 0.0);

		Cercle c1 = new Cercle(p, 5.0);
		Cercle c2 = new Cercle(q, 1.0);

		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);

		boolean resultat = c1.contient(q);
		System.out.println(c1 + " contient le point " + q + "est : " + resultat);
		
		boolean resultat2 = c1.contient(c2);
		System.out.println(c1 + " contient le cercle c2 est : " + resultat2);
	}

	// attributs
	private Point centre;
	private double rayon;

	public Cercle(Point centre, double rayon) {
		this.centre = centre;
		this.rayon = rayon;
	}

	public boolean contient(Point p) {
		double d = this.centre.distance(p);
		return d <= this.rayon;
	}

	public boolean contient(Cercle autre) {

		double d = this.centre.distance(autre.centre);
		return d + autre.rayon <= this.rayon;
	}

	// méthodes
	public double circonference() {
		return Math.PI * rayon * 2;
	}

	public double surface() {
		return Math.PI * rayon * rayon;
	}

	public void affiche() {
		System.out.println("Le cercle a pour centre :" + centre + " et rayon : " + rayon);
	}

	public String toString() {
		return "Le cercle a pour centre :" + centre + " et rayon : " + rayon;
	}

}
