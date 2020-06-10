/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entities.Produit;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Dhake
 */
public class ServiceProduit {
    Connection c=ConnexionBD.getinstance().getcnx();
    public void ajouterBS(Produit t)
    {
        try 
        {
      PreparedStatement pt= c.prepareStatement(" insert into produit (reference,categorie,nom_produit,description_produit,quantite,prix_unitaire,prix_vente,date_fabrication,date_expiration,photoProduit) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            //pt.setInt(1,t.getId_Tache());
            pt.setString(1,t.getReference());
            pt.setInt(2,t.getCategorie());
            pt.setString(3,t.getNom_produit());
            pt.setString(4,t.getDescription_produit());
            pt.setInt(5,t.getQuantite());
            pt.setInt(6,t.getPrix_unitaire());
            pt.setInt(7,t.getPrix_vente());
            pt.setDate(8,t.getDate_fabrication());
            pt.setDate(9,t.getDate_expiration());
            pt.setString(10,t.getPhotoProduit());
            

            pt.execute();


        } catch (SQLException ex)
        {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public List<Produit> displayAll() {
      // L'id du freelancer dans la requette est statique il faut le changer (session) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ArrayList <Produit> tab = new ArrayList ();


         try {
             PreparedStatement pt =c.prepareStatement("SELECT * from Produit");
               ResultSet res= pt.executeQuery();
             while(res.next())

             {
                 Produit o = new Produit(res.getInt(5), res.getInt(6),res.getInt(7), res.getInt(2), res.getString(3), res.getString(1), res.getString(4), res.getString(10), res.getDate(8), res.getDate(9));
                        

                 tab.add(o);

             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
         }

       return tab;
    }
     public void supprimer(String reference)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from produit where reference=?" );
            pt.setString(1,reference);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void modifierbs (String nom_produit, String description_produit,String reference, int prix_unitaire,int prix_vente,Date date_fabrication,Date date_expiration)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update produit set nom_produit= ?,description_produit= ?,prix_unitaire= ?,prix_vente= ?,date_fabrication= ?,date_expiration= ? where reference=?");
            pt.setString(1,nom_produit);
            pt.setString(2,description_produit);
            pt.setInt(3,prix_unitaire);
            pt.setInt(4,prix_vente);
            pt.setDate(5,date_fabrication);
            pt.setDate(6,date_expiration);
            pt.setString(7,reference);
            
            

            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public List<String> displayequipe()
       {
             List<String> list = new ArrayList<String>();

        ObservableList obList = FXCollections.observableList(list);

        Connection c=ConnexionBD.getinstance().getcnx();
         try {
            PreparedStatement pt =c.prepareStatement("select * from categorie");
            ResultSet rs= pt.executeQuery();

            while(rs.next())
            {
               list.add(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
         return list;
       }
    public int return_id_bs_sm (String sm) 
             {
                Connection c=ConnexionBD.getinstance().getcnx();
    int k=0;

        try {
            PreparedStatement pt =c.prepareStatement("select id_categorie from categorie where nom_categorie=?");
            pt.setString(1, sm);
            ResultSet rs= pt.executeQuery();

            while(rs.next())
            {
               k = rs.getInt(1);
            }
              } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
             return k;
             }
}
