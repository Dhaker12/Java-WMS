/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Employee;
import Entities.Fournisseur;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khaoula
 */
public class FournisseurService {
      private Connection connection = ConnexionBD.getinstance().getcnx();
    private static Statement ste=null;
    
    public  FournisseurService() {
     try {
            System.out.println("DataSource.getInstance().getCon()" + ConnexionBD.getinstance().getcnx() == null);
            
            ste=ConnexionBD.getinstance().getcnx().createStatement();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
         public void supprimer(int id) {
        String SQL = "DELETE FROM fournisseur WHERE id = ?";
        PreparedStatement pre = null;
        try {
            // get a connection and then in your try catch for executing your delete...
            pre = connection.prepareStatement(SQL);
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
         public void ajouter(Fournisseur user) {
        String req = "INSERT INTO fournisseur (societe, numsociete, secteur, Name ,Last_name ,EntrepriseDate, image) VALUES (?, ?, ?, ?, ?, ?, ? )" ;
        PreparedStatement pre;
        
        try {
            pre = connection.prepareStatement(req);
            pre.setString(1, user.getSociete());
            pre.setInt(2, user.getNumsociete());
            pre.setString(3, user.getSecteur());
            pre.setString(4, user.getName());
            pre.setString(5, user.getLast_name());
            pre.setDate(6, user.getEntreprise_Date());
            pre.setString(7, user.getImage());
            pre.executeUpdate();
            System.out.println("fournisseur ajouter avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public ArrayList<Fournisseur> selectAll() {
        ArrayList<Fournisseur> users = new ArrayList<>();
        ResultSet rs;
        try {
            rs = ste.executeQuery("SELECT id, societe, numsociete, secteur, Name, Last_name, EntrepriseDate, image FROM fournisseur");
        //  rs = ste.executeQuery("SELECT id, Name FROM fournisseur");

         users = new ArrayList<>();
            while (rs.next()){
            users.add(new Fournisseur(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getDate(7), rs.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  users;
    }
                
        public Fournisseur selectOne(int id) {
        Statement ste=null;
        Fournisseur user= new Fournisseur();
        ResultSet rs=null;
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery("SELECT * from fournisseur where id="+id);
             while (rs.next()) {
            System.out.println("Name : "
            + rs.getString("Name")
            + ", societe : "
            + rs.getString("societe"));          
            }
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }  
        
        
        
         public void editUser(Fournisseur u) throws SQLException {
              try{
            String query = "update `fournisseur` set societe =?, secteur =?, Name = ?, Last_name =?, EntrepriseDate =?, image =?, numsociete=?  where id =?  ;";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, u.getSociete());
            st.setString(2, u.getSecteur());
            st.setString(3, u.getName());
            st.setString(4, u.getLast_name());
            st.setDate(5, u.getEntreprise_Date());
            st.setString(6, u.getImage());
            st.setInt(7, u.getNumsociete());
           
            st.setString(8,String.valueOf(u.getId()));

            st.execute();
            System.out.println("Changes saved successfully !");

        }
    catch (SQLException ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 
        
        
        
        
}
