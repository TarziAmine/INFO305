package tp3;

import java.util.ArrayList;
import java.util.List;

public class Chevalier {
 private String nom;
 private int niveauVie;
 private List<ObjetGraal> sac;

 public Chevalier(String nom, int niveauVie) {
     this.nom = nom;
     this.niveauVie = Math.max(0, Math.min(100, niveauVie)); // Entre 0 et 100
     this.sac = new ArrayList<>();
 }

 public void modifierVie(int variation) {
     this.niveauVie += variation;
 }

 public void ajouterAuSac(ObjetGraal obj) {
     sac.add(obj);
 }

 public int getPoidsSac() {
     int poids = 0;
     for (ObjetGraal obj : sac) {
         poids += obj.getPoids();
     }
     return poids;
 }

 public boolean estEnVie() { return niveauVie > 0; }
 public boolean aGagne() { return sac.size() == 4; }
 
 public String getNom() { return nom; }
 public int getNiveauVie() { return niveauVie; }
 public List<ObjetGraal> getSac() { return sac; }


 public String toString() {
     return String.format("%s (Vie: %d, Poids: %dkg, Sac: %d/4)", 
             nom, niveauVie, getPoidsSac(), sac.size());
 }
}



