package tp2;

public class Principale {

//	private static java.util.Scanner scanner = new java.util.Scanner(System.in);

	/*
	 * private static String lireLigne() { return scanner.nextLine(); }
	 */
	public static void main(String[] args) {

		// PARTIE 1 : Tests de la classe Livre
		Livre v1 = new Livre("Hugo", "Les misérables", 20.5);
		Livre v2 = new Livre("Hergé", "Tintin au Tibet", 8.0, 52);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v1 + " est plus cher que " + v2 + " est : " + v1.estPlusCher(v2));
		System.out.println("-------------------------------------------------");

		// PARTIE 2 : Tests de la classe Etagere
		Etagere et = new Etagere(10);
		et.ajouter(v1);
		et.ajouter(v2);
		System.out.println(et.toString());

		Livre v3 = et.chercher("Hergé", "Tarzan");
		if (v3 == null)
			System.out.println("Le livre n'est pas dans l'étagère");
		else
			System.out.println("L'étagère contient le livre : " + v3);
		System.out.println("-------------------------------------------------");

		// PARTIE 3 : Tests de la classe EtagereDeux
		EtagereDeux et2 = new EtagereDeux();
		et2.ajouter(v1);
		et2.ajouter(v2);
		System.out.println(et2.toString());

		Livre v4 = et2.chercher("Hergé", "Tarzan");
		if (v4 == null)
			System.out.println("Le livre n'est pas dans l'étagère");
		else
			System.out.println("L'étagère contient le livre : " + v4);
		System.out.println("-------------------------------------------------");

		/*
		 * // PARTIE 4 : Nouveau main (Saisie clavier) Etagere etSaisie = new
		 * Etagere(100);
		 * 
		 * System.out.print("Définir un livre ('o'/'n') ? "); String reponse =
		 * lireLigne();
		 * 
		 * while (reponse.equals("o")) { System.out.print("Auteur ? "); String auteur =
		 * lireLigne();
		 * 
		 * System.out.print("Titre ? "); String titre = lireLigne();
		 * 
		 * System.out.print("Prix : "); String prixStr = lireLigne(); double prix =
		 * Double.parseDouble(prixStr);
		 * 
		 * System.out.print("Nombre de pages ? "); String pagesStr = lireLigne(); int
		 * pages = Integer.parseInt(pagesStr);
		 * 
		 * Livre nouveauLivre; if (pages == 0) { nouveauLivre = new Livre(auteur, titre,
		 * prix); } else { nouveauLivre = new Livre(auteur, titre, prix, pages); }
		 * 
		 * etSaisie.ajouter(nouveauLivre);
		 * 
		 * System.out.print("Définir un livre ('o'/'n') ? "); reponse = lireLigne(); }
		 * 
		 * System.out.println(etSaisie.toString());
		 */
	}
}