/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author azizl
 */

import Entities.post;
import Utils.DataSource;
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

public class ServicePost {
    
    Connection c=DataSource.getInstance().getCnx();
    public void ajouterPost(post t)
    {
        
        try {
            PreparedStatement pt= c.prepareStatement(" insert into post (section_id,tag_id,title,description,photo,postdate)values (?,?,?,?,?,?)");
            
           
             pt.setInt(1,t.getSection_id());
             pt.setInt(2,t.getTag_id());
             
            pt.setString(3,t.getTitle());
            pt.setString(4,t.getDescription());
            pt.setString(5,t.getPhoto());
            pt.setDate(6,t.getPostdate());
         
            pt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicePost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public List<post> displayAll() {

        ArrayList <post> tab = new ArrayList ();
     try {
             PreparedStatement pt =c.prepareStatement("SELECT * from post");
               ResultSet res= pt.executeQuery();
             while(res.next())

             {
                 post o = new post(res.getInt("id"),res.getInt("section_id"),res.getInt("tag_id"),res.getString("title"),res.getString("description"),res.getString("photo"),res.getDate("postdate"));     
                 tab.add(o);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ServicePost.class.getName()).log(Level.SEVERE, null, ex);
         }
         
              return tab;
      }
    
      
        public void supprimer(int id)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from post where id=?" );
            pt.setInt(1,id);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
           public void modifierbs ( int id,int idSection, int idTag ,String title, String description, String photo,Date postdate  )
    {
        try {
            PreparedStatement pt= c.prepareStatement("update post set  section_id=?,tag_id=?,title=?,photo=?,description=?,postdate=? where id=?");
            pt.setInt(1,idSection);
            pt.setInt(2,idTag);
            pt.setString(3,title);
            pt.setString(4,photo);
            pt.setString(5,description);
            pt.setDate(6,postdate);
            pt.setInt(7,id);
          
            
            

            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePost.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
           
           public List<String> displaytag()
       {
             List<String> list = new ArrayList<String>();

        ObservableList obList = FXCollections.observableList(list);

        Connection c=DataSource.getInstance().getCnx();
         try {
            PreparedStatement pt =c.prepareStatement("select * from tag");
            ResultSet rs= pt.executeQuery();

            while(rs.next())
            {
               list.add(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePost.class.getName()).log(Level.SEVERE, null, ex);
        }
         return list;
       }
           
      
        public List<String> displaysection()
       {
             List<String> list = new ArrayList<String>();

        ObservableList obList = FXCollections.observableList(list);

        Connection c=DataSource.getInstance().getCnx();
         try {
            PreparedStatement pt =c.prepareStatement("select * from section");
            ResultSet rs= pt.executeQuery();

            while(rs.next())
            {
               list.add(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePost.class.getName()).log(Level.SEVERE, null, ex);
        }
         return list;
       }
      
      public int returnIdTag (String title) 
             {
                
    int k=0;

        try {
            PreparedStatement pt =c.prepareStatement("select id from tag where title=?");
            pt.setString(1, title);
            ResultSet rs= pt.executeQuery();

            while(rs.next())
            {
               k = rs.getInt(1);
            }
              } catch (SQLException ex) {
            Logger.getLogger(ServicePost.class.getName()).log(Level.SEVERE, null, ex);
        }
             return k;
             }
      
      
      
        public int returnIdSection (String title) 
             {
                
    int k=0;

        try {
            PreparedStatement pt =c.prepareStatement("select id from section where title=?");
            pt.setString(1, title);
            
            ResultSet rs= pt.executeQuery();

            while(rs.next())
            {
               k = rs.getInt(1);
            }
              } catch (SQLException ex) {
            Logger.getLogger(ServicePost.class.getName()).log(Level.SEVERE, null, ex);
        }
             return k;
             }
      
    
       
      public List<post> displayPost(int id) {

        ArrayList <post> tab = new ArrayList ();
     try {
                   PreparedStatement pt =c.prepareStatement("SELECT * from post where tag_id=? ");
                   pt.setInt(1, id);
               ResultSet res= pt.executeQuery();
             while(res.next())

             {
                 post o = new post(res.getInt("id"),res.getInt("section_id"),res.getInt("tag_id"),res.getString("title"),res.getString("description"),res.getString("photo"),res.getDate("postdate"));     
                 tab.add(o);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ServicePost.class.getName()).log(Level.SEVERE, null, ex);
         }
         
              return tab;
      }
      
      
      
            public List<post> displayPostSection(int id) {

        ArrayList <post> tab = new ArrayList ();
     try {
                   PreparedStatement pt =c.prepareStatement("SELECT * from post where section_id=? ");
                   pt.setInt(1, id);
               ResultSet res= pt.executeQuery();
             while(res.next())

             {
                 post o = new post(res.getInt("id"),res.getInt("section_id"),res.getInt("tag_id"),res.getString("title"),res.getString("description"),res.getString("photo"),res.getDate("postdate"));     
                 tab.add(o);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ServicePost.class.getName()).log(Level.SEVERE, null, ex);
         }
         
              return tab;
      }
      
      
      
      
      
}
