/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.ConnexionBD;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import Utils.ConnexionBD;
import Entities.Facture;

//import gui.pdf;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

public class FactureService {
     private int idFacture;

    private Connection cnx;
    private Statement st1;
    private PreparedStatement pst;
    private ResultSet rs;

    public FactureService() {
    cnx=ConnexionBD.getinstance().getcnx();
    }
    
    public void insert(Facture p){
        String req="insert into facture (type_product,quantite,Prix,montant,Adresse,Date,Telephone,Fournisseur,Employee) values ('"+p.getType_product()+"','"+p.getQuantite()+"','"+p.getPrix()+"','"+p.getMontant()+"','"+p.getAdresse()+"','"+p.getDate()+"','"+p.getTelephone()+"','"+p.getFournisseur()+"','"+p.getEmployee()+"')";
        
        try {
            st1=cnx.createStatement();
           st1.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertPST(Facture f){
        String req="insert into facture (type_product,quantite,Prix,montant,Adresse,Date,Telephone,Fournisseur,Employee) values (?,?,?,?,?,?,?,?,?)";
        
        try {
            pst=cnx.prepareStatement(req);
         

           // pst.setInt(1, f.getIdFacture());
                        
           pst.setString(2, f.getType_product());
            pst.setInt(3, f.getQuantite());

            pst.setInt(4, f.getPrix());
            pst.setInt(5, f.getMontant());
            pst.setString(6, f.getAdresse());
            pst.setDate(7, (Date) f.getDate());
            pst.setInt(8, f.getTelephone());

            pst.setInt(9, f.getFournisseur());

            pst.setInt(10, f.getEmployee());

        

            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public boolean update(Facture t) {

   String req="update facture set idFacture=? WHERE idFacture=?;";
           
    try {   pst=cnx.prepareStatement(req);
          
            pst.setInt(1, t.getIdFacture());
                        
           // pst.setString(2, t.getType_product());
            //pst.setInt(3, t.getPrix());
            // pst.setInt(4, t.getQuantite());
           //pst.setString(6, t.getAdresse());
            ////pst.setString(8, t.getTelephone());

           // pst.setInt(9, t.getFournisseur());
            
            //pst.setInt(10, t.getEmployee());
 
         pst.executeUpdate();
            System.out.println("table modifier");
            return true; }
            catch (SQLException ex) {
               Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);

                    

          
            return false;
   }
   
    
    }

    
    public boolean delete(Facture t) {
   //String req="DELETE FROM reclamation wehre (id_reclamation='"+t.getId_reclamation()+"')  ";
   String req="DELETE FROM Facture where idFacture=?;";
    try {
            pst=cnx.prepareStatement(req);
            pst.setInt(1,t.getIdFacture());
            pst.executeUpdate();
            System.out.println("table effacer");
            return true;
    }
            catch (SQLException ex) {
                 Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Facture> displayAll() {
    
        String req="Select * from Facture";
       List<Facture> list=new ArrayList<>();
        try {
            st1=cnx.createStatement();
            rs=st1.executeQuery(req);
            while (rs.next()){
            list.add(new Facture(
                 //  rs.getInt(1),

                    rs.getInt(1),
                    rs.getString(2),

                    rs.getInt(3),
                   rs.getInt(4),

                    rs.getInt(5),
                    rs.getString(6),
                    rs.getDate(7),
                    rs.getInt(8),
                    rs.getInt(9), 

                    rs.getInt(10) )); 

           
            
           
                                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    
    }
    
    public List<String> displayequipe()
       {
             List<String> list = new ArrayList<String>();

        ObservableList obList = FXCollections.observableList(list);

                cnx=ConnexionBD.getinstance().getcnx();

         try {
            PreparedStatement pt =cnx.prepareStatement("select * from fournisseur");
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
            PreparedStatement pt =cnx.prepareStatement("select id from fournisseur where Name=?");
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
    
    public int return_id_bs_sm1 (String sm) 
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
    
     public List<String> displayequipe2()
       {
             List<String> list = new ArrayList<String>();

        ObservableList obList = FXCollections.observableList(list);

                cnx=ConnexionBD.getinstance().getcnx();

         try {
            PreparedStatement pt =cnx.prepareStatement("select * from produit");
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
    public int return_id_bs_sm2 (String sm) 
             {
                cnx=ConnexionBD.getinstance().getcnx();
    int k=0;

        try {
            PreparedStatement pt =cnx.prepareStatement("select reference from produit where nom_produit=?");
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
     public List<String> displayequipe3()
       {
             List<String> list = new ArrayList<String>();

        ObservableList obList = FXCollections.observableList(list);

                cnx=ConnexionBD.getinstance().getcnx();

         try {
            PreparedStatement pt =cnx.prepareStatement("select * from commande");
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
    public int return_id_bs_sm3 (String sm) 
             {
                cnx=ConnexionBD.getinstance().getcnx();
    int k=0;

        try {
            PreparedStatement pt =cnx.prepareStatement("select id_commande from commande where id_commande=?");
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

    public FactureService(int idFacture) {
        this.idFacture = idFacture;
    }
    
 public int getIdFacture() {
        return idFacture;
    }
 
     
   /* public List<Facture> displayAl2() throws DocumentException {
      String file_name="C:\\Users\\abdallah\\Documents\\NetBeansProjects\\ConnexionDB3A14_20\\1.pdf";
   // public void GeneratePdf(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
    Document document=new  Document();
         try {
             PdfWriter.getInstance(document, new FileOutputStream(file_name));
         } catch (FileNotFoundException ex) {
             Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
         }
        document.open();
        String req="Select * from Facture";
       List<Facture> list=new ArrayList<>();
        try {
            st1=cnx.createStatement();
            rs=st1.executeQuery(req);
            while (rs.next()){
            list.add(new Facture(
                 //  rs.getInt(1),
                        //document.add(new Paragraph("Username :"+rs.));

            document.add((",kk,"+rs.getInt(1))),  
            document.add((",kk,"+rs.getString(2))),  
            document.add((",kk,"+rs.getInt(3))),  
            document.add((",kk,"+rs.getInt(4))),  
            document.add((",kk,"+rs.getInt(5))),  
            document.add((",kk,"+rs.getString(6))),  
            document.add((",kk,"+rs.getDate(7))),  
            document.add((",kk,"+rs.getString(8))),  
            document.add((",kk,"+rs.getInt(9))),  
            document.add((",kk,"+rs.getInt(10)))));

                

                  

                    

                  //  rs.getInt(10) )); 

           
            
           
                                    
            }
                    document.close();

        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;  
    } 
  public static Observablelist<facture> searchEmployee(String empId) throws ClassNotFoundException,SQLException{
        
    }
            = "select * from employee where id = "+empId;
String sql
try{
DBUtil.dbExecute(sql);
}catch(SQLException e){
D 231 System.out.println("Error ocured while searchuing the recored"+e);
e.printStackTrace();
    

    }*/
 
    
} 