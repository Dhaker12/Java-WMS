/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.section;

import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azizl
 */
public class ServiceSection {
      Connection c=DataSource.getInstance().getCnx();
    public void ajouterSection(section t)
    {
        
        try {
            PreparedStatement pt= c.prepareStatement(" insert into section (title) values (?)");
            
         
            pt.setString(1,t.getTitle());
      
            
            pt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceSection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
         public ArrayList<section> displayAll() {
      // L'id du freelancer dans la requette est statique il faut le changer (session) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ArrayList <section> tab = new ArrayList ();


     try {
             PreparedStatement pt =c.prepareStatement("SELECT * from section");
               ResultSet res= pt.executeQuery();
             while(res.next())

             {
                 section o = new section(res.getInt(1),res.getString(2) );
                        

                 tab.add(o);

             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceSection.class.getName()).log(Level.SEVERE, null, ex);
         }
              return tab;
      }
         
            public void supprimer(int id)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from section where id=?" );
            pt.setInt(1,id);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceSection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
           public void modifierbs (String title ,int id)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update section set title=? where id=?");
            pt.setString(1,title);
            pt.setInt(2,id);
          
            

            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceSection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
           
           
                           public ArrayList<String> sectionlist()
      {
           ArrayList <String> tab = new ArrayList ();
          try {
             PreparedStatement pt =c.prepareStatement("SELECT * from section");
               ResultSet res= pt.executeQuery();
               while(res.next())

             {
                 String s=res.getString(2);
                 tab.add(s);
             }
            } catch (SQLException ex) {
             Logger.getLogger(ServiceSection.class.getName()).log(Level.SEVERE, null, ex);
         }
              return tab;
          
      }
    
    
}
