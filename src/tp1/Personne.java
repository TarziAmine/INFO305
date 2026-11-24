package tp1;

import java.util.*;

public class Personne {
    private String nom;
    private String prenom;
    private int anneeNaissance;
    private Genre genre;
    private boolean estCelibataire;
    
    // Extension 1
    private CompteEnBanque compte; 
    
    // Extension 2
    private Personne conjoint; 
    
    // Extension 3
    private Personne pere; 
    private Personne mere; 

    // Constructeurs
    public Personne(String nom, String prenom, int anneeNaissance, Genre genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
        this.genre = genre;
        this.estCelibataire = true;
    }

    public Personne(String nom, String prenom, int anneeNaissance, Genre genre, Personne pere, Personne mere) {
        this(nom, prenom, anneeNaissance, genre);
        this.pere = pere;
        this.mere = mere;
    }

    // Getters et Setters
    public String getNom() { return this.nom; }
    public String getPrenom() { return this.prenom; }
    public void setCompte(CompteEnBanque compte) { this.compte = compte; }
    public CompteEnBanque getCompte() { return this.compte; }

    // Méthode age()
    public int age() {
        GregorianCalendar aujourDHui = new GregorianCalendar();
        int anneeCourante = aujourDHui.get(Calendar.YEAR);
        return anneeCourante - this.anneeNaissance;
    }

    // Méthode estPlusAge()
    public boolean estPlusAge(Personne autre) {
        return this.age() > autre.age();
    }

    // Extension 2 : Mariage et Séparation
    public void marier(Personne p) {
        this.conjoint = p;
        p.conjoint = this;
        this.estCelibataire = false;
        p.estCelibataire = false;
    }

    public void separer() {
        if (this.conjoint != null) {
            this.conjoint.conjoint = null;
            this.conjoint.estCelibataire = true;
        }
        this.conjoint = null;
        this.estCelibataire = true;
    }

    // Extension 4 : Ancêtre
    public boolean estAncetre(Personne p) {
        if (p == null) {
            return false;
        }
        if (p.pere == this || p.mere == this) {
            return true;
        }
        return this.estAncetre(p.pere) || this.estAncetre(p.mere); 
    }

    // Extension 4 : Arbre Généalogique
    public String arbreGene() {
        return this.prenom + " " + this.nom + ",\n" + construireArbre(1);
    }

    private String construireArbre(int profondeur) {
        String resultat = "";
        
        // Création de l'indentation avec une boucle for 
        String indent = "";
        for (int i = 0; i < profondeur * 10; i++) {
            indent = indent + " ";
        }
        
        if (this.pere != null) {
            resultat = resultat + indent + "de père " + this.pere.prenom + " " + this.pere.nom;
            if (this.pere.conjoint != null) {
                resultat = resultat + " époux de " + this.pere.conjoint.prenom + " " + this.pere.conjoint.nom;
            }
            resultat = resultat + "\n";
            resultat = resultat + this.pere.construireArbre(profondeur + 1);
        }
        if (this.mere != null) {
            resultat = resultat + indent + "de mère " + this.mere.prenom + " " + this.mere.nom;
            if (this.mere.conjoint != null) {
                resultat = resultat + " épouse de " + this.mere.conjoint.prenom + " " + this.mere.conjoint.nom;
            }
            resultat = resultat + "\n";
            resultat = resultat + this.mere.construireArbre(profondeur + 1);
        }
        return resultat;
    }

    // toString() avec conditions if/else
    public String toString() {
        String nee = "";
        String pronom = "";
        
        if (this.genre == Genre.HOMME) {
            nee = "né";
            pronom = "il";
        } else {
            nee = "née";
            pronom = "elle";
        }
        
        String statut = "";
        if (this.estCelibataire) {
            statut = "célibataire";
        } else {
            if (this.genre == Genre.HOMME) {
                statut = "marié à " + this.conjoint.prenom + " " + this.conjoint.nom;
            } else {
                statut = "mariée à " + this.conjoint.prenom + " " + this.conjoint.nom;
            }
        }
        
        return this.prenom + " " + this.nom + " " + nee + " en " + this.anneeNaissance + 
               ", " + pronom + " est " + statut + ".";
    }
}