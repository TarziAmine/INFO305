package tp3;

public class QuatreCoinsDuMonde {
	public static final int TAILLE = 10;
	private Objet[][] grille;
	private int posX, posY; // Position du chevalier en quête

	public QuatreCoinsDuMonde() {
		grille = new Objet[TAILLE][TAILLE];
	}

	public void initialiser() {
		// Vider la grille
		for (int i = 0; i < TAILLE; i++)
			for (int j = 0; j < TAILLE; j++)
				grille[i][j] = null;

		// Créer et placer les objets du Graal
		placerAleatoire(new Excalibur());
		placerAleatoire(new PierreFalLial());
		placerAleatoire(new LanceLug());
		placerAleatoire(new Chaudron());

		// Créer et placer des obstacles (ex: 15 obstacles)
		for (int i = 0; i < 5; i++)
			placerAleatoire(new Roche());
		for (int i = 0; i < 5; i++)
			placerAleatoire(new Puits());
		for (int i = 0; i < 5; i++)
			placerAleatoire(new Ronces());
	}

	public void placerAleatoire(Objet obj) {
		boolean place = false;
		while (!place) {
			int x = (int) (Math.random() * TAILLE);
			int y = (int) (Math.random() * TAILLE);
			if (grille[x][y] == null) {
				grille[x][y] = obj;
				place = true;
			}
		}
	}

	public void placerChevalierAleatoire() {
		posX = (int) (Math.random() * TAILLE);
		posY = (int) (Math.random() * TAILLE);
		// On s'assure qu'il ne tombe pas directement sur un objet au départ
		if (grille[posX][posY] != null) {
			placerChevalierAleatoire();
		}
	}

	public void deplacerChevalier() {
		// 8 directions possibles
		int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
		int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int dir = (int) (Math.random() * 8);

	
		posX = (posX + dx[dir] + TAILLE) % TAILLE;
		posY = (posY + dy[dir] + TAILLE) % TAILLE;
	}

	public Objet getObjetSurCase() {
		return grille[posX][posY];
	}

	public void retirerObjet() {
		grille[posX][posY] = null;
	}

	public void afficher(boolean afficherChevalier) {
		System.out.print("\n     ");
		for (int i = 0; i < TAILLE; i++)
			System.out.printf("%-3d", i);
		System.out.println();

		for (int i = 0; i < TAILLE; i++) {
			System.out.printf("%-4d", i);
			for (int j = 0; j < TAILLE; j++) {
				if (afficherChevalier && i == posX && j == posY) {
					System.out.print("C  "); // C pour Chevalier
				} else if (grille[i][j] != null) {
					System.out.print(grille[i][j].getSymbole() + "  ");
				} else {
					System.out.print(".  ");
				}
			}
			System.out.println();
		}
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
