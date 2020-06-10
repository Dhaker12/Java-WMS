/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author abdallah
 */
public class Facture {

     private int idFacture;
    private String type_product;
    private int quantite;
    private int prix;
 
    private int montant;
    private String Adresse;
    private Date Date;
    private int telephone;
    private int Fournisseur;
  // private String Produit_id ;
    private int Employee;

    public Facture(int idFacture, String type_product, int quantite, int prix, int montant, String Adresse, Date Date, int telephone, int Fournisseur, int Employee) {
        this.idFacture = idFacture;
        this.type_product = type_product;
        this.quantite = quantite;
        this.prix = prix;
        this.montant = montant;
        this.Adresse = Adresse;
        this.Date = Date;
        this.telephone = telephone;
        this.Fournisseur = Fournisseur;
        this.Employee = Employee;
    }

    public Facture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public String getType_product() {
        return type_product;
    }

    public void setType_product(String type_product) {
        this.type_product = type_product;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getFournisseur() {
        return Fournisseur;
    }

    public void setFournisseur(int Fournisseur) {
        this.Fournisseur = Fournisseur;
    }

    public int getEmployee() {
        return Employee;
    }

    public void setEmployee(int Employee) {
        this.Employee = Employee;
    }

    @Override
    public String toString() {
        return "Facture{" + "idFacture=" + idFacture + ", type_product=" + type_product + ", quantite=" + quantite + ", prix=" + prix + ", montant=" + montant + ", Adresse=" + Adresse + ", Date=" + Date + ", telephone=" + telephone + ", Fournisseur=" + Fournisseur + ", Employee=" + Employee + '}';
    }

    
    

   

    public void setReponse(String t0, String t1, String t2, String t3, String t4, String t5, String t6, String t7, String t8) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
