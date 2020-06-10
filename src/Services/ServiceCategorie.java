/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Categorie;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dhake
 */
public class ServiceCategorie {
    Connection c=ConnexionBD.getinstance().getcnx();
    public void ajouterBS(Categorie t)
    {
        try 
        {
      PreparedStatement pt= c.prepareStatement(" insert into categorie (nom_categorie,description_categorie,type_stockage) values (?, ?, ?)");
            //pt.setInt(1,t.getId_Tache());
            pt.setString(1,t.getNom_categorie());
            pt.setString(2,t.getDescription_categorie());
            pt.setString(3,t.getType_stockage());

            pt.execute();


        } catch (SQLException ex)
        {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void supprimer(int id_categorie)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from categorie where id_categorie=?" );
            pt.setInt(1,id_categorie);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Categorie> displayAll() {
      // L'id du freelancer dans la requette est statique il faut le changer (session) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ArrayList <Categorie> tab = new ArrayList ();


         try {
             PreparedStatement pt =c.prepareStatement("SELECT * from Categorie");
               ResultSet res= pt.executeQuery();
             while(res.next())

             {
                 Categorie o = new Categorie(res.getInt(1), res.getString(2), res.getString(3),res.getString(4));

                 tab.add(o);

             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
         }

       return tab;
     // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void modifierbs (int id_categorie,String nom_categorie, String description_categorie,String type_stockage)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update categorie set nom_categorie= ?,description_categorie= ?,type_stockage= ? where id_categorie=?");
            pt.setString(1,nom_categorie);
            pt.setString(2,description_categorie);
            pt.setString(3,type_stockage);
            pt.setInt(4,id_categorie);
            

            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
