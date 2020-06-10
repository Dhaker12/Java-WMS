/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author user
 */
public class Documentation {
    

  
    int id_documentation,ide_admin; 
    String nom_documentation, contenu_documentation,NomAdmin; 
    String nom,spec;

    public Documentation(String nom, String spec) {
        this.nom = nom;
        this.spec = spec;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
    
    public Documentation() {
    }
    

    
    
    
    public int getIde_admin() {
        return ide_admin;
    }

    public void setIde_admin(int ide_admin) {
        this.ide_admin = ide_admin;
    }

    public int getId_documentation() {
        return id_documentation;
    }

    public void setId_documentation(int id_documentation) {
        this.id_documentation = id_documentation;
    }

    public String getNom_documentation() {
        return nom_documentation;
    }

    public void setNom_documentation(String nom_documentation) {
        this.nom_documentation = nom_documentation;
    }

    public String getContenu_documentation() {
        return contenu_documentation;
    }

    public void setContenu_documentation(String contenu_documentation) {
        this.contenu_documentation = contenu_documentation;
    }

    public Documentation(int ide_admin, String nom_documentation, String contenu_documentation) {
        this.ide_admin = ide_admin;
        this.nom_documentation = nom_documentation;
        this.contenu_documentation = contenu_documentation;
    }

    public Documentation(int id_documentation, int ide_admin, String nom_documentation, String contenu_documentation) {
        this.id_documentation = id_documentation;
        this.ide_admin = ide_admin;
        this.nom_documentation = nom_documentation;
        this.contenu_documentation = contenu_documentation;
    }

    public String getNomAdmin() {
        return NomAdmin;
    }

    public void setNomAdmin(String NomAdmin) {
        this.NomAdmin = NomAdmin;
    }

    public Documentation(int id_documentation, String nom_documentation, String contenu_documentation, String NomAdmin) {
        this.id_documentation = id_documentation;
        this.nom_documentation = nom_documentation;
        this.contenu_documentation = contenu_documentation;
        this.NomAdmin = NomAdmin;
    }

    
    @Override
    public String toString() {
        return "Documentation{" + "id_documentation=" + id_documentation + ", ide_admin=" + ide_admin + ", nom_documentation=" + nom_documentation + ", contenu_documentation=" + contenu_documentation + '}';
    }

    
    
    
    
    
}
