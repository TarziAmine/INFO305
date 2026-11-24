package tp3;

import java.util.ArrayList;
import java.util.List;

public class TableRonde {
	private List<Chevalier> chevaliers;

	public TableRonde() {
		this.chevaliers = new ArrayList<>();
	}

	public void ajouter(Chevalier c) {
		chevaliers.add(c);
		System.out.println(c.getNom() + " rejoint la Table Ronde !");
	}

	// Mission 3 : Gestion des exceptions
	public void expulser(String nom) throws ChevalierIntrouvableException {
		for (int i = 0; i < chevaliers.size(); i++) {
			if (chevaliers.get(i).getNom().equalsIgnoreCase(nom)) {
				Chevalier c = chevaliers.remove(i);
				System.out.println(c.getNom() + " est expulsé et disparaît !");
				return;
			}
		}
		throw new ChevalierIntrouvableException("Aucun chevalier nommé '" + nom + "' à la Table Ronde.");
	}

	public void afficher() {
		System.out.println("\n--- Membres de la Table Ronde ---");
		if (chevaliers.isEmpty()) {
			System.out.println("La table est vide.");
		} else {
			for (Chevalier c : chevaliers) {
				System.out.println("- " + c.toString());
			}
		}
	}

	public Chevalier getChevalier(String nom) {
		for (Chevalier c : chevaliers) {
			if (c.getNom().equalsIgnoreCase(nom))
				return c;
		}
		return null;
	}
}