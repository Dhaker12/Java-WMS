/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author user
 */
public class Formation {
  
    int id_formation;
             String id_formateur,id_liste;
    String nom_formation,sujet_formation,time_debut,time_fin,date_debut,NomFormateur,listeP;

    public Formation(String id_formateur, String id_liste, String nom_formation, String sujet_formation, String time_debut, String time_fin, String date_debut) {
        this.id_formateur = id_formateur;
        this.id_liste = id_liste;
        this.nom_formation = nom_formation;
        this.sujet_formation = sujet_formation;
        this.time_debut = time_debut;
        this.time_fin = time_fin;
        this.date_debut = date_debut;
    }

    public Formation(int id_formation, String id_formateur, String id_liste, String nom_formation, String sujet_formation, String time_debut, String time_fin, String date_debut, String NomFormateur, String listeP) {
        this.id_formation = id_formation;
        this.id_formateur = id_formateur;
        this.id_liste = id_liste;
        this.nom_formation = nom_formation;
        this.sujet_formation = sujet_formation;
        this.time_debut = time_debut;
        this.time_fin = time_fin;
        this.date_debut = date_debut;
        this.NomFormateur = NomFormateur;
        this.listeP = listeP;
    }
    
     public Formation(int id_formation, String id_formateur, String id_liste, String nom_formation, String sujet_formation, String time_debut, String time_fin, String date_debut) {
        this.id_formation = id_formation;
        this.id_formateur = id_formateur;
        this.id_liste = id_liste;
        this.nom_formation = nom_formation;
        this.sujet_formation = sujet_formation;
        this.time_debut = time_debut;
        this.time_fin = time_fin;
        this.date_debut = date_debut;
    }

    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public String getId_formateur() {
        return id_formateur;
    }

    public void setId_formateur(String id_formateur) {
        this.id_formateur = id_formateur;
    }

    public String getId_liste() {
        return id_liste;
    }

    public void setId_liste(String id_liste) {
        this.id_liste = id_liste;
    }

    public String getNom_formation() {
        return nom_formation;
    }

    public void setNom_formation(String nom_formation) {
        this.nom_formation = nom_formation;
    }

    public String getSujet_formation() {
        return sujet_formation;
    }

    public void setSujet_formation(String sujet_formation) {
        this.sujet_formation = sujet_formation;
    }

    public String getTime_debut() {
        return time_debut;
    }

    public void setTime_debut(String time_debut) {
        this.time_debut = time_debut;
    }

    public String getTime_fin() {
        return time_fin;
    }

    public void setTime_fin(String time_fin) {
        this.time_fin = time_fin;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getNomFormateur() {
        return NomFormateur;
    }

    public void setNomFormateur(String NomFormateur) {
        this.NomFormateur = NomFormateur;
    }

    public String getListeP() {
        return listeP;
    }

    public void setListeP(String listeP) {
        this.listeP = listeP;
    }
    
    }

   

    
    
    
    
    

