/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author Dhake
 */
public class Produit {
    
    private int quantite,prix_unitaire,prix_vente,categorie;
    private String reference,nom_produit,description_produit,photoProduit;
    private Date date_fabrication,date_expiration;

    public Produit(int quantite, int prix_unitaire, int prix_vente, int categorie,String nom_produit, String reference, String description_produit, String photoProduit, Date date_fabrication, Date date_expiration) {
        this.quantite = quantite;
        this.nom_produit = nom_produit;
        this.prix_unitaire = prix_unitaire;
        this.prix_vente = prix_vente;
        this.categorie = categorie;
        this.reference = reference;
        this.description_produit = description_produit;
        this.photoProduit = photoProduit;
        this.date_fabrication = date_fabrication;
        this.date_expiration = date_expiration;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(int prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public int getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(int prix_vente) {
        this.prix_vente = prix_vente;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getDescription_produit() {
        return description_produit;
    }

    public void setDescription_produit(String description_produit) {
        this.description_produit = description_produit;
    }

    public String getPhotoProduit() {
        return photoProduit;
    }

    public void setPhotoProduit(String photoProduit) {
        this.photoProduit = photoProduit;
    }

    public Date getDate_fabrication() {
        return date_fabrication;
    }

    public void setDate_fabrication(Date date_fabrication) {
        this.date_fabrication = date_fabrication;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }
    
    
    
}
