package tp3;

public class Quete {
	private QuatreCoinsDuMonde monde;
	private Chevalier chevalier;

	public Quete(QuatreCoinsDuMonde monde, Chevalier chevalier) {
		this.monde = monde;
		this.chevalier = chevalier;
	}

	public void lancer() {
		monde.placerChevalierAleatoire();
		System.out.println("\n=== DÉBUT DE LA QUÊTE DE " + chevalier.getNom().toUpperCase() + " ===");
		monde.afficher(true);

		int tour = 0;
		while (chevalier.estEnVie() && !chevalier.aGagne()) {
			tour++;
			// 1. Déplacement
			monde.deplacerChevalier();

			// 2. Pénalité de poids
			int poids = chevalier.getPoidsSac();
			if (poids > 0) {
				chevalier.modifierVie(-poids);
			}

			// 3. Vérification mort
			if (!chevalier.estEnVie()) {
				System.out.println("\n!!! " + chevalier.getNom() + " est épuisé et disparaît au tour " + tour + " !!!");
				// Les objets du sac sont replacés
				for (ObjetGraal obj : chevalier.getSac()) {
					monde.placerAleatoire(obj);
				}
				chevalier.getSac().clear();
				monde.afficher(true);
				return; // Échec
			}

			// 4. Interaction avec l'objet
			Objet obj = monde.getObjetSurCase();
			if (obj != null) {
				chevalier.modifierVie(obj.getEffetVie());
				System.out.printf("[Tour %d] %s trouve %s en (%d,%d). Vie: %d\n", tour, chevalier.getNom(),
						obj.getNom(), monde.getPosX(), monde.getPosY(), chevalier.getNiveauVie());

				if (obj instanceof ObjetGraal) {
					chevalier.ajouterAuSac((ObjetGraal) obj);
					System.out.println(" -> Mis dans le sac !");
				}
				monde.retirerObjet(); // L'objet est ramassé ou consumé
			}

		}

		if (chevalier.aGagne()) {
			System.out.println(
					"\n*** VICTOIRE ! " + chevalier.getNom() + " a trouvé le Graal en " + tour + " tours ! ***");
		}
		monde.afficher(true);
	}
}
