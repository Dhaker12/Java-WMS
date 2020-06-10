/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Commande;
import Utils.ConnexionBD;
import java.sql.Connection;
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
public class ServiceCommande {
       Connection c=ConnexionBD.getinstance().getcnx();
       public void ajouterBS(Commande t)
    {
        try 
        {
      PreparedStatement pt= c.prepareStatement(" insert into commande (nom_produit,quantite_cammande,idcategorie,id_fournisseur) values ( ?, ?, ?, ?)");
           
            //pt.setInt(1,t.getId_commande());
            pt.setString(1,t.getNom_produit());
            pt.setInt(2,t.getQuantite_commande());
            pt.setInt(3,t.getIdcategorie());
            pt.setString(4,t.getId_fournisseur());
            
            pt.execute();


        } catch (SQLException ex)
        {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       public List<Commande> displayAll() {
      // L'id du freelancer dans la requette est statique il faut le changer (session) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ArrayList <Commande> tab = new ArrayList ();


         try {
             PreparedStatement pt =c.prepareStatement("SELECT * from Commande");
               ResultSet res= pt.executeQuery();
             while(res.next())

             {
                 Commande o = new Commande(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4), res.getString(5));

                 tab.add(o);

             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
         }

       return tab;
     // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
       public void supprimer(int id_commande)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from commande where id_commande=?" );
            pt.setInt(1,id_commande);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void modifierbs (int id_commande,String nom_produit, int quantite_commande,String id_fournisseur)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update commande set nom_produit= ?,quantite_cammande= ?,id_fournisseur= ? where id_commande=?");
            pt.setString(1,nom_produit);
            pt.setInt(2,quantite_commande);
            pt.setString(3,id_fournisseur);
            pt.setInt(4,id_commande);
            

            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
             return k;
             }

    
}
