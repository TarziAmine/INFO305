package tp1;

public class CompteEnBanque {
    // Attributs 
    private int numero;
    private int solde;

    // Constructeurs 
    public CompteEnBanque(int numero) {
        this.numero = numero;
        this.solde = 0;
    }

    public CompteEnBanque(int numero, int solde) {
        this.numero = numero;
        this.solde = solde;
    }

    // Méthodes
    public void deposer(int montant) {
        if (montant > 0) {
            this.solde = this.solde + montant;
        }
    }

    public void retirer(int montant) {
        if (montant > 0 && this.solde >= montant) {
            this.solde = this.solde - montant;
        } else {
            System.out.println("Retrait impossible : fonds insuffisants.");
        }
    }

    public int getSolde() {
        return this.solde;
    }

    public int getNumero() {
        return this.numero;
    }

    public String toString() {
        return "Compte n°" + this.numero + " | Solde: " + this.solde;
    }
}