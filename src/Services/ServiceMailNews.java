/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.mailNews;
import Entities.tag;
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
public class ServiceMailNews {
    
       Connection c=DataSource.getInstance().getCnx();
    public void ajouterMail(mailNews m)
    {
        
        try {
            PreparedStatement pt= c.prepareStatement(" insert into mailnews (mail) values (?)");
    
            pt.setString(1,m.getMail());
      
            
            pt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMailNews.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
      public ArrayList<mailNews> displayAll() {
    
        ArrayList <mailNews> tab = new ArrayList ();


     try {
             PreparedStatement pt =c.prepareStatement("SELECT * from mailnews");
               ResultSet res= pt.executeQuery();
             while(res.next())

             {
                 mailNews o = new mailNews(res.getInt(1),res.getString(2) );
                        

                 tab.add(o);

             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceMailNews.class.getName()).log(Level.SEVERE, null, ex);
         }
              return tab;
      }
      
      
      public ArrayList<String> mailList()
      {
           ArrayList <String> tab = new ArrayList ();
          try {
             PreparedStatement pt =c.prepareStatement("SELECT * from mailnews");
               ResultSet res= pt.executeQuery();
               while(res.next())

             {
                 String s=res.getString(2);
                 tab.add(s);
             }
            } catch (SQLException ex) {
             Logger.getLogger(ServiceMailNews.class.getName()).log(Level.SEVERE, null, ex);
         }
              return tab;
          
      }
    
}
