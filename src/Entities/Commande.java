/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Dhake
 */
public class Commande {
    
    private int id_commande;
    private String nom_produit;
    private int quantite_commande;
    private int idcategorie;
    private String id_fournisseur;

    public Commande(int id_commande, String nom_produit, int quantite_commande, int idcategorie, String id_fournisseur) {
        this.id_commande = id_commande;
        this.nom_produit = nom_produit;
        this.quantite_commande = quantite_commande;
        this.idcategorie = idcategorie;
        this.id_fournisseur = id_fournisseur;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public int getQuantite_commande() {
        return quantite_commande;
    }

    public void setQuantite_commande(int quantite_commande) {
        this.quantite_commande = quantite_commande;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(String id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
    
    
    
}
