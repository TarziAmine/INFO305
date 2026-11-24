package tp3;

public class Main {

    public static void main(String[] args) {

        // Création des objets principaux
        TableRonde table = new TableRonde();
        QuatreCoinsDuMonde monde = new QuatreCoinsDuMonde();

        // ============================================
        // TEST 1 : Création de chevaliers
        // ============================================
        System.out.println("\n>>> TEST 1 : Création de chevaliers");
        System.out.println("----------------------------------------");
        
        Chevalier lancelot = new Chevalier("Lancelot", 100);
        Chevalier perceval = new Chevalier("Perceval", 50);
        Chevalier gauvain = new Chevalier("Gauvain", 80);
        Chevalier bohort = new Chevalier("Bohort", 30);
        
        table.ajouter(lancelot);
        table.ajouter(perceval);
        table.ajouter(gauvain);
        table.ajouter(bohort);
        
        // Test de validation : vie hors limites (doit être bornée entre 0 et 100)
        Chevalier testLimites = new Chevalier("TestLimites", 250);
        table.ajouter(testLimites);
        System.out.println("Note : TestLimites avait 250 PV, borné à 100");
        
        Chevalier testNegatif = new Chevalier("TestNegatif", -50);
        table.ajouter(testNegatif);
        System.out.println("Note : TestNegatif avait -50 PV, borné à 0");

        // ============================================
        // TEST 2 : Affichage de la Table Ronde
        // ============================================
        System.out.println("\n>>> TEST 2 : Affichage de la Table Ronde");
        System.out.println("----------------------------------------");
        table.afficher();

        // ============================================
        // TEST 3 : Expulsion d'un chevalier (succès)
        // ============================================
        System.out.println("\n>>> TEST 3 : Expulsion d'un chevalier existant (Bohort)");
        System.out.println("----------------------------------------");
        try {
            table.expulser("Bohort");
            System.out.println("✓ Expulsion réussie");
        } catch (ChevalierIntrouvableException e) {
            System.out.println("✗ Erreur inattendue : " + e.getMessage());
        }
        table.afficher();

        // ============================================
        // TEST 4 : Expulsion d'un chevalier inexistant (échec + exception)
        // ============================================
        System.out.println("\n>>> TEST 4 : Expulsion d'un chevalier INEXISTANT (Galahad)");
        System.out.println("----------------------------------------");
        try {
            table.expulser("Galahad");
            System.out.println("✗ L'exception aurait dû être levée !");
        } catch (ChevalierIntrouvableException e) {
            System.out.println("✓ Exception correctement levée : " + e.getMessage());
        }

        // ============================================
        // TEST 5 : Initialisation des Quatre Coins du Monde
        // ============================================
        System.out.println("\n>>> TEST 5 : Initialisation des Quatre Coins du Monde");
        System.out.println("----------------------------------------");
        monde.initialiser();
        System.out.println("✓ Monde initialisé avec 4 objets du Graal + 15 obstacles");
        
        // ============================================
        // TEST 6 : Affichage du monde (sans chevalier)
        // ============================================
        System.out.println("\n>>> TEST 6 : Affichage du monde (sans chevalier)");
        System.out.println("----------------------------------------");
        monde.afficher(false);

        // ============================================
        // TEST 7 : Quête avec Lancelot (100 PV - devrait réussir)
        // ============================================
        System.out.println("\n>>> TEST 7 : Quête de Lancelot (100 PV)");
        System.out.println("----------------------------------------");
        Chevalier lancelotQuete = new Chevalier("Lancelot", 100);
        Quete quete1 = new Quete(monde, lancelotQuete);
        quete1.lancer();

        // ============================================
        // TEST 8 : Quête avec Perceval (50 PV - risque d'échec)
        // ============================================
        System.out.println("\n>>> TEST 8 : Quête de Perceval (50 PV)");
        System.out.println("----------------------------------------");
        // On réinitialise le monde pour avoir une nouvelle configuration
        monde.initialiser();
        Chevalier percevalQuete = new Chevalier("Perceval", 50);
        Quete quete2 = new Quete(monde, percevalQuete);
        quete2.lancer();

        // ============================================
        // TEST 9 : Quête avec Gauvain (80 PV)
        // ============================================
        System.out.println("\n>>> TEST 9 : Quête de Gauvain (80 PV)");
        System.out.println("----------------------------------------");
        monde.initialiser();
        Chevalier gauvainQuete = new Chevalier("Gauvain", 80);
        Quete quete3 = new Quete(monde, gauvainQuete);
        quete3.lancer();

        // ============================================
        // TEST 10 : Affichage final de la Table Ronde
        // ============================================
        System.out.println("\n>>> TEST 10 : État final de la Table Ronde");
        System.out.println("----------------------------------------");
        table.afficher();

        // ============================================
        // TEST 11 : Test de la méthode instanceof (Mission 3)
        // ============================================
        System.out.println("\n>>> TEST 11 : Tests instanceof");
        System.out.println("----------------------------------------");
        Objet excalibur = new Excalibur();
        Objet roche = new Roche();
        
        System.out.println("Excalibur instanceof ObjetGraal : " + (excalibur instanceof ObjetGraal));
        System.out.println("Excalibur instanceof ObjetObstacle : " + (excalibur instanceof ObjetObstacle));
        System.out.println("Roche instanceof ObjetGraal : " + (roche instanceof ObjetGraal));
        System.out.println("Roche instanceof ObjetObstacle : " + (roche instanceof ObjetObstacle));

    }
}