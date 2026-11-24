package tp1;

public class TestDeux {
    public static void main(String[] args) {
        // --- Tests de base et Extension 1 ---
        Personne p1 = new Personne("Dupont", "Jean", 1969, Genre.HOMME);
        Personne p2 = new Personne("Martin", "Sylvie", 1968, Genre.FEMME);
        
        // Extension 1 : Ajout d'un compte
        p1.setCompte(new CompteEnBanque(123, 1000));

        System.out.println("--- Affichage de base ---");
        System.out.println(p1.toString());
        System.out.println(p2.toString());

        // Calcul de l'âge et comparaison
        System.out.println("\n--- Comparaison des âges ---");
        System.out.println("Âge de " + p1.getPrenom() + " : " + p1.age());
        
        // 1. En appelant directement age()
        if (p1.age() > p2.age()) {
            System.out.println(p1.getPrenom() + " est plus âgé que " + p2.getPrenom());
        } else {
            System.out.println(p2.getPrenom() + " est plus âgé que " + p1.getPrenom());
        }

        // 2. À travers la méthode estPlusAge()
        if (p1.estPlusAge(p2)) {
            System.out.println("Confirmation via méthode : " + p1.getPrenom() + " est plus âgé.");
        } else {
            System.out.println("Confirmation via méthode : " + p2.getPrenom() + " est plus âgé.");
        }

        // --- Extension 2 : Mariage et Séparation ---
        System.out.println("\n--- Extension 2 : Mariage ---");
        p1.marier(p2);
        System.out.println(p1.toString());
        System.out.println(p2.toString());

        System.out.println("\n--- Extension 2 : Séparation ---");
        p1.separer();
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        
     // --- Extension 3 : Arbre Généalogique ---
        System.out.println("\n--- Extension 3 : Arbre Généalogique ---");
        
        // Création de la famille demandée
        Personne jean = new Personne("Dupond", "Jean", 1940, Genre.HOMME);
        Personne emilie = new Personne("Durant", "Emilie", 1942, Genre.FEMME);
        jean.marier(emilie);

        Personne eric = new Personne("Dupond", "Eric", 1965, Genre.HOMME, jean, emilie);
        
        Personne jeanne = new Personne("Holly", "Jeanne", 1967, Genre.FEMME);
        eric.marier(jeanne);

        Personne sylvie = new Personne("France", "Sylvie", 1970, Genre.FEMME);

        Personne yannick = new Personne("Dupond", "Yannick", 1990, Genre.HOMME, eric, jeanne);

        Personne brigitte = new Personne("France", "Brigitte", 1992, Genre.FEMME, null, sylvie);

        Personne henri = new Personne("Dupond", "Henri", 2015, Genre.HOMME, yannick, brigitte);

        // Affichage de l'arbre
        System.out.println(henri.arbreGene());

        // --- Extension 4 : Test Ancêtre ---
        System.out.println("\n--- Extension 4 : Vérification d'ancêtre ---");
        System.out.println("Jean est-il ancêtre d'Henri ? " + jean.estAncetre(henri)); 
        System.out.println("Sylvie est-elle ancêtre d'Henri ? " + sylvie.estAncetre(henri)); 
        System.out.println("Eric est-il ancêtre de Jean ? " + eric.estAncetre(jean)); 

    }
}