/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.DocumentException;
import Utils.ConnexionBD;
import Entities.Facture;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import Services.FactureService;
import Services.TrayIconDemo;
import com.gluonhq.impl.charm.a.b.b.n;
import static com.itextpdf.text.pdf.security.LtvTimestamp.timestamp;
import com.jfoenix.controls.JFXTimePicker;
import java.awt.AWTException;
import java.util.Calendar;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
//import service.PersonneService;



/**
 * FXML Controller class
 *
 * @author wiemhjiri
 */
public class AjoutFactureController implements Initializable {
    private Connection con;
        private Statement pst;
    @FXML
    private TextField txtPrenom;
    @FXML
    private Button btn_valider;
    private TextField txtfou;
    @FXML
    private TextField txtpx;
    @FXML
    private TextField txtqu;
    private TextField txtty;
    @FXML
    private TextField txtAd;
    @FXML
    private TextField txtte;
    private TextField txtEm;
    @FXML
     private TableView<Facture> tablereclamation1;
   
    @FXML
    private TableColumn<Facture, String> c1;
    @FXML
    private TableColumn<Facture, String> c2;
    @FXML
    private TableColumn<Facture, String> c3;
    @FXML
    private TableColumn<Facture, String> c4;
    @FXML
    private TableColumn<Facture, String> c5;
    @FXML
    private TableColumn<Facture, String> c6;
    @FXML
    private TableColumn<Facture, String> c7;
    @FXML
    private TableColumn<Facture, String> c8;
    @FXML
    private TableColumn<Facture, String> c9;

    public ObservableList<Facture> obb1 ;
    @FXML
    private Button idsup;
    @FXML
    private Button idrep;
    @FXML
    private Button idreturn;
    @FXML
    private TableColumn<?, ?> c10;
    @FXML
    private DatePicker date1;
    @FXML
    private ComboBox<?> combo;
     @FXML
    private ComboBox<?> combo1;
    @FXML
    private ComboBox<?> combo2;
    private TextField com;
    @FXML
    private TextField pro;
    @FXML
    private ComboBox<?> combo3;
    @FXML
    private TextField txt_search;
    
        String erreur;
    @FXML
    private ImageView prenomCheckMark;

   java.sql.Timestamp timestamp = null;
    @FXML
    private ImageView dateCheckMark;
    @FXML
    private ImageView ADCheckMark;
    @FXML
    private ImageView typeheckMark1;
    @FXML
    private ImageView quCheckMark3;
    @FXML
    private ImageView prixheckMark;
    @FXML
    private ImageView montantCheckMark1;
    


    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
         combo.setPromptText("Select fournisseur");
       ObservableList obList1 = FXCollections.observableList(sr.displayequipe());
         combo.getItems().clear();
         combo.setItems(obList1);
         
          combo1.setPromptText("Select employee");
         ObservableList obList = FXCollections.observableList(sr.displayequipe1());
         combo1.getItems().clear();
         combo1.setItems(obList);
        /* combo2.setPromptText("Select produit");
         ObservableList obList2 = FXCollections.observableList(sr.displayequipe2());
         combo2.getItems().clear();
         combo2.setItems(obList2);
         combo3.setPromptText("Select commande");
         ObservableList obList3 = FXCollections.observableList(sr.displayequipe3());
         combo3.getItems().clear();
         combo3.setItems(obList3);*/
          
          
         
          
         
afficher();        
    } 
  FactureService sr = new FactureService();

public void setUpReclamation(){
            ArrayList<Facture> mahden = null ;
            mahden=(ArrayList<Facture>) sr.displayAll();
            obb1=FXCollections.observableArrayList(mahden);
        c1.setCellValueFactory(new PropertyValueFactory<>("idFacture"));
        c2.setCellValueFactory(new PropertyValueFactory<>("type_product"));
        c3.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        c4.setCellValueFactory(new PropertyValueFactory<>("prix"));
        c5.setCellValueFactory(new PropertyValueFactory<>("montant"));
        c6.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        c7.setCellValueFactory(new PropertyValueFactory<>("Date"));
        c8.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        c9.setCellValueFactory(new PropertyValueFactory<>("Fournisseur"));

        c10.setCellValueFactory(new PropertyValueFactory<>("Employee"));
            tablereclamation1.setItems(obb1);
    }

    @FXML
    private void valider(ActionEvent event) throws IOException, AWTException {
        FactureService ps=new FactureService();
  
//        int com1 = Integer.parseInt(com.getText());
        TrayIconDemo srvp=new TrayIconDemo();

       //  int id = Integer.parseInt(txtN.getText());
        int qu = Integer.parseInt(txtqu.getText());
        int pr = Integer.parseInt(txtpx.getText());
         int mo = Integer.parseInt(txtPrenom.getText());
                  int tel = Integer.parseInt(txtte.getText());
        ps.insert(new Facture(0,pro.getText(), qu ,pr,mo,txtAd.getText(),(java.sql.Date.valueOf(date1.getValue())),tel,sr.return_id_bs_sm(""+combo.getValue()),sr.return_id_bs_sm1(""+combo1.getValue())));
        JOptionPane.showMessageDialog(null, "Ajout effectué");
                srvp.pop1();

      /*  FXMLLoader fxml=new FXMLLoader(getClass().getResource("Recuperation.fxml"));
        
        Parent root=fxml.load();
        txtN.getScene().setRoot(root);
        RecuperationController rc=fxml.getController();
        
        rc.setLabelidFacture(txtN.getText());
        rc.setLabelmontant(txtPrenom.getText());
        rc.setLabelfournisseur(txtfou.getText());
        rc.setlabelprix(txtpx.getText());
        rc.setlabelquantite(txtqu.getText());
        rc.setlabeltype_product(txtty.getText());
        rc.setlabelAdresse(txtAd.getText());
        rc.setlabeltelephone(txtte.getText());
        rc.setlabelEmployee(txtEm.getText());*/
        
      
        
        
    }
    
     @FXML
    private void supprimer(ActionEvent event) {
    Facture i=tablereclamation1.getSelectionModel().getSelectedItem();
    sr.delete(i);
    setUpReclamation();
      JOptionPane.showMessageDialog(null, "personne supprimer..");
    
}
     public void afficher(){

        ObservableList obeListe = FXCollections.observableList(sr.displayAll());

        c1.setCellValueFactory(new PropertyValueFactory<>("idFacture"));
        c2.setCellValueFactory(new PropertyValueFactory<>("montant"));
        c3.setCellValueFactory(new PropertyValueFactory<>("fournisseur"));
        c4.setCellValueFactory(new PropertyValueFactory<>("prix"));
        c5.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        c6.setCellValueFactory(new PropertyValueFactory<>("type_product"));
        c7.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        c8.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        c9.setCellValueFactory(new PropertyValueFactory<>("Employee"));

        

        tablereclamation1.setItems(obeListe);
        // c4.setVisible(false);

        
    }



    @FXML
    private void update(ActionEvent event) {
    }

    @FXML
  //  private void pdf(ActionEvent event) {
private void pdf(ActionEvent event) throws FileNotFoundException, SQLException, DocumentException, AWTException {
     TrayIconDemo srvp=new TrayIconDemo();

         pdf Pdf=new pdf();
   Pdf.add("Facture.pdf");
                   srvp.pop2();

    } 
        
          
private void searchProduct () {
    
}
private Boolean testSaisie() {
        erreur = "";
        
        if (!testTel()) {
            erreur = erreur + ("Telephone doit avoir 8 chiffres et ne doit pas contenir des caracteres \n");
        }
        if (!testDate()) {
            erreur = erreur + ("Veuillez verifier que vous avez choisi une date superieur a la date courante \n");
        }
       
       

        if (  !testTel() || !testDate()  ) {
            Notifications n = Notifications.create()
                    .title("Erreur de format")
                    .text(erreur)
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(6));
            n.showInformation();
        }

        return   testTel() && testDate()  ;
    }

    @FXML
    private boolean testTel(){
        if (txtte.getText().trim().length() == 8) {
            int nbChar = 0;
            for (int i = 1; i < txtte.getText().trim().length(); i++) {
                char ch = txtte.getText().charAt(i);
                if (Character.isLetter(ch)) {
                    nbChar++;
                }
            }

            if (nbChar == 0) {
                prenomCheckMark.setImage(new Image("Images/checkMark.png"));
                return true;
            } else {
                prenomCheckMark.setImage(new Image("Images/erreurcheckMark.png"));
//                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
                return false;

            }
        } else if (txtte.getText().trim().length() != 8) {
//            erreur = erreur + ("Il faut saisir 8 chiffres dans le numéro de telephone\n");
            prenomCheckMark.setImage(new Image("Images/erreurcheckMark.png"));
            return false;
        }

        return true;
        
        
      
    }

    
    
    @FXML
    private boolean testDate() {
         java.sql.Timestamp today_date = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        if (date1.getValue() != null && date1.getValue() != null) {
           // timestamp = java.sql.Timestamp.valueOf(date1.getValue() + " " + date1.getValue() + ":00");
            if (date1.equals(today_date) ) {
                dateCheckMark.setImage(new Image("Images/erreurcheckMark.png"));
                return true;
            } else {
                dateCheckMark.setImage(new Image("Images/checkMark.png"));
            }
            return false;
        } else if (date1.getValue() == null && date1.getValue() == null) {
            return true;
        } else if (date1.getValue() != null && date1.getValue() == null) {
            dateCheckMark.setImage(new Image("Images/erreurcheckMark.png"));
        } else if (date1.getValue() == null && date1.getValue() != null) {
            dateCheckMark.setImage(new Image("Images/erreurcheckMark.png"));
        }
        return false;
    }


   
    @FXML
 private Boolean testAdresse() {
        int nbNonChar = 0;
        for (int i = 1; i < txtAd.getText().trim().length(); i++) {
            char ch = txtAd.getText().charAt(i);
            if (!Character.isLetter(ch)) {
                nbNonChar++;
            }
        }

        if (nbNonChar == 0 && txtAd.getText().trim().length() >= 0) {
            ADCheckMark.setImage(new Image("Images/checkMark.png"));
            return true;
        } else {
            ADCheckMark.setImage(new Image("Images/erreurcheckMark.png"));
//                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
            return false;

        }

    }

    @FXML
    private boolean testProduit(KeyEvent event) {
        
        int nbNonChar = 0;
        for (int i = 1; i < pro.getText().trim().length(); i++) {
            char ch = pro.getText().charAt(i);
            if (!Character.isLetter(ch)) {
                nbNonChar++;
            }
        }

        if (nbNonChar == 0 && pro.getText().trim().length() >= 0) {
            typeheckMark1.setImage(new Image("Images/checkMark.png"));
            return true;
        } else {
            typeheckMark1.setImage(new Image("Images/erreurcheckMark.png"));
//                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
            return false;

        }

    }

    @FXML
    private boolean testquan(KeyEvent event) {
           if (txtqu.getText().trim().length()>0 ) {
            int nbChar = 0;
            for (int i = 1; i < txtqu.getText().trim().length(); i++) {
                char ch = txtqu.getText().charAt(i);
                if (Character.isLetter(ch)) {
                    nbChar++;
                }
            }

            if (nbChar == 0) {
                quCheckMark3.setImage(new Image("Images/checkMark.png"));
                return true;
            } else {
                quCheckMark3.setImage(new Image("Images/erreurcheckMark.png"));
//                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
               
            }} else if (txtqu.getText().trim().length() != 8) {
//            erreur = erreur + ("Il faut saisir 8 chiffres dans le numéro de telephone\n");
            quCheckMark3.setImage(new Image("Images/erreurcheckMark.png"));
            return false;
        }

            return false;

            }

    @FXML
    private boolean testprix(KeyEvent event) {
        
        if (txtpx.getText().trim().length()>0 ) {
            int nbChar = 0;
            for (int i = 1; i < txtpx.getText().trim().length(); i++) {
                char ch = txtpx.getText().charAt(i);
                if (Character.isLetter(ch)) {
                    nbChar++;
                }
            }

            if (nbChar == 0) {
                prixheckMark.setImage(new Image("Images/checkMark.png"));
                return true;
            } else {
                prixheckMark.setImage(new Image("Images/erreurcheckMark.png"));
//                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
               
            }} else if (txtpx.getText().trim().length() != 8) {
//            erreur = erreur + ("Il faut saisir 8 chiffres dans le numéro de telephone\n");
            prixheckMark.setImage(new Image("Images/erreurcheckMark.png"));
            return false;
        }

            return false;

        
    }
        
        
    
    

   
    

}
    

