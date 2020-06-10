/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

//import connexiondb3a14_20.DataSource;
import Entities.reclamation;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class reclamtionService1 {
    private Connection cnx;
    private Statement st2;
    private PreparedStatement pst;
    private ResultSet rs;

    public reclamtionService1() {
    cnx=ConnexionBD.getinstance().getcnx();
    }
    
    public void insert(reclamation p){
        String req="insert into reclamation (Description,Date) values ('"+p.getDescription()+"','"+p.getDate()+"')";
        
        try {
            st2=cnx.createStatement();
            st2.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(reclamtionService1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertPST(reclamation f){
        String req="insert into reclamation (Description,Date) values (?,?)";
        
        try {
            pst=cnx.prepareStatement(req);
           // pst.setInt(1, f.getId_reclamation());
            pst.setString(2, f.getDescription());
            pst.setDate(3, (Date) f.getDate());

         //   pst.setInt(3, f.getEmployee());
           

                                   

            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(reclamtionService1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public boolean update(reclamation t) {
       String req="update set description WHERE Id_reclamation=?";
    try {
            pst=cnx.prepareStatement(req);
              pst.setString(2,t.getDescription());

            //pst.setInt(1 ,t.getId_reclamation());
            pst.executeUpdate();
            System.out.println("table mo");
            return true;
    }
            catch (SQLException ex) {
                 Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
   

    public boolean delete(reclamation t) {
          String req="DELETE FROM reclamation where Id_reclamation=?;";
    try {
            pst=cnx.prepareStatement(req);
            pst.setInt(1 ,t.getId_reclamation());
            pst.executeUpdate();
            System.out.println("table effacer");
            return true;
    }
            catch (SQLException ex) {
                 Logger.getLogger(reclamtionService1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    }

    public List<reclamation> displayAll() {
    
        String req="Select * from reclamation";
       List<reclamation> list=new ArrayList<>();
        try {
            st2=cnx.createStatement();
            rs=st2.executeQuery(req);
            while (rs.next()){
            list.add(new reclamation(
                    rs.getInt(1),
                    rs.getString(2),
                     rs.getDate(3)


                  //  rs.getInt(3)
                   ));
                                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(reclamtionService1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    
    }
    
    
   public void modifierbs (String Id_reclamation, String Description,String Employee)
    {
        try {
            PreparedStatement pt= cnx.prepareStatement("update reclamation set description= ? where id_reclamation=?");
           // pt.setString(1,Id_reclamation);
            pt.setString(2,Description);
            //pt.setString(3,Employee);
            

            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(reclamtionService1.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 
    public List<String> displayequipe1()
       {
             List<String> list = new ArrayList<String>();

        ObservableList obList = FXCollections.observableList(list);

    cnx=ConnexionBD.getinstance().getcnx();

         try {
            PreparedStatement pt =cnx.prepareStatement("select * from employee");
            ResultSet rs= pt.executeQuery();

            while(rs.next())
            {
               list.add(rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
        }
         return list;
         
       }
    public int return_id_bs_sm (String sm) 
             {
    cnx=ConnexionBD.getinstance().getcnx();
    int k=0;

        try {
            PreparedStatement pt =cnx.prepareStatement("select id from employee where Name=?");
            pt.setString(1, sm);
            ResultSet rs= pt.executeQuery();

            while(rs.next())
            {
               k = rs.getInt(1);
            }
              } catch (SQLException ex) {
            Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
        }
             return k;
             }
    
    
    
    
    
}
