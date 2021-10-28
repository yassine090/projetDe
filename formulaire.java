/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpidev;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author LENOVO
 */
public class formulaire {
    private static final AtomicInteger count = new AtomicInteger(0); 
    public int Id;
    public String Nom;
    public String Prenom;
    public String Adresse;
    public String DateNaissance;
    public String Sexe;
    public String descriptionSymptomes;
    
    
    
    public formulaire(){

}
public formulaire(int Id , String Nom, String Prenom , String Adresse,String DateNaissance,String Sexe, String descriptionSymptomes){
this.Id =Id;
this.Nom=Nom;
this.Prenom=Prenom;
this.DateNaissance= DateNaissance;
this.Adresse=Adresse;
this.Sexe =Sexe;
this.descriptionSymptomes =descriptionSymptomes;


}
public formulaire( String Nom, String Prenom , String Adresse,String DateNaissance,String Sexe, String descriptionSymptomes){

 this.Nom=Nom;
this.Prenom=Prenom;
this.DateNaissance= DateNaissance;
this.Adresse=Adresse;
this.Sexe =Sexe;
this.descriptionSymptomes = descriptionSymptomes;
this.Id = count.incrementAndGet(); 

}
public int getId() {
        return Id;
    }

    public String getNom() {
        return Nom;
    }

    

    public String getPrenom() {
        return Prenom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getDateNaissance() {
        return DateNaissance;
    }

    public String getSexe() {
        return Sexe;
    }

    public String getDescriptionSymptomes() {
        return descriptionSymptomes;
    }
   

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setDateNaissance(String DateNaissance) {
        this.DateNaissance = DateNaissance;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public void setDescriptionSymptomes(String descriptionSymptomes) {
        this.descriptionSymptomes = descriptionSymptomes;
    }
    @Override
    public String toString() {
        return "formulaire{" + "Id=" + Id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Adresse=" + Adresse + ", DateNaissance=" + DateNaissance + ", Sexe=" + Sexe + ", descriptionSymptomes=" + descriptionSymptomes + '}';
    }
}

   