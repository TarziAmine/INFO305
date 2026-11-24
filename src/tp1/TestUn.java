package tp1;

public class TestUn {
    public static void main(String[] args) {
		System.out.println("Salut tous !!");
		
		
        System.out.println("\n--- Tests avec des constantes ---");
        // Étape 2 : Création avec constantes
        final int NUM1 = 1;
        final int SOLDE1 = 500;
        final int NUM2 = 102;

        CompteEnBanque c1 = new CompteEnBanque(NUM1, SOLDE1);
        CompteEnBanque c2 = new CompteEnBanque(NUM2);

        System.out.println(c1.toString());
        System.out.println(c2.toString());

        c1.retirer(100);
        c2.deposer(200);

        System.out.println("Après opérations :");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        
    }
}