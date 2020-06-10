/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Produit;
import Services.Create_QR;
import Services.SendMailBySite;
import Services.ServiceProduit;
import Services.TrayIconDemo;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.awt.AWTException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
import static java.util.Locale.filter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import static jdk.nashorn.internal.objects.NativeArray.filter;
import static jdk.nashorn.internal.objects.NativeString.search;
import static sun.awt.image.ImagingLib.filter;
import static sun.reflect.annotation.TypeAnnotation.filter;
import static sun.util.locale.LocaleMatcher.filter;

/**
 * FXML Controller class
 *
 * @author Dhake
 */
public class Produit_guiController implements Initializable {

    @FXML
    private JFXTextField txt1;
    @FXML
    private JFXTextField txt6;
    @FXML
    private JFXTextField txt3;
    @FXML
    private JFXTextField txt4;
    @FXML
    private JFXTextField txt5;
    @FXML
    private JFXTextField txt7;
    private JFXTextField txt10;
    @FXML
    private TableColumn<?, ?> c1;
    @FXML
    private TableColumn<?, ?> c2;
    @FXML
    private TableColumn<?, ?> c3;
    @FXML
    private TableColumn<?, ?> c4;
    @FXML
    private TableColumn<?, ?> c5;
    @FXML
    private TableColumn<?, ?> c6;
    @FXML
    private TableColumn<?, ?> c7;
    @FXML
    private TableColumn<?, ?> c8;
    @FXML
    private TableColumn<?, ?> c9;
    @FXML
    private TableColumn<?, ?> c10;

    /**
     * Initializes the controller class.
     */
    ServiceProduit srv = new ServiceProduit();
    String path=null;
   
   

    @FXML
    private JFXDatePicker date1;
    @FXML
    private JFXDatePicker date2;
    @FXML
    private JFXComboBox<?> combo;
    @FXML
    private TableView<?> table;
    @FXML
    private JFXTextField search;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         combo.setPromptText("Select categorie");
         ObservableList obList1 = FXCollections.observableList(srv.displayequipe());
         combo.getItems().clear();
         combo.setItems(obList1);
         afficher();

         
    }    
   

    @FXML
    private void submit(ActionEvent event) throws AWTException, ParseException {
        ServiceProduit srv =new ServiceProduit();
        SendMailBySite srvn= new SendMailBySite();
        TrayIconDemo srvp=new TrayIconDemo();
        Create_QR srvc= new Create_QR();
        int qte = Integer.parseInt(txt5.getText());
        int pu = Integer.parseInt(txt7.getText());
        int pv = Integer.parseInt(txt6.getText());
        
       
        
     if (date1.getValue().isAfter(date2.getValue())){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Date Incorecte");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez vérifier que tous les champs sont REMPLIS !!!  ");
        Optional<ButtonType> action = alert.showAndWait();
    }
     else if ((txt1.getText().isEmpty())||(txt4.getText().isEmpty())||(txt3.getText().isEmpty())){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Champs vide");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez Remplir tous les champs !!! ");
        Optional<ButtonType> action = alert.showAndWait();
    }
     else{
   
        Produit P= new Produit(qte, pu, pv, srv.return_id_bs_sm(""+combo.getValue()),txt3.getText(), txt1.getText() , txt4.getText(), path, (java.sql.Date.valueOf(date1.getValue().toString())),(java.sql.Date.valueOf(date2.getValue().toString())));
        srv.ajouterBS(P);
        srvc.Create("nom= "+txt3.getText()+" ref= "+txt1.getText(), txt3.getText());
        srvn.send(txt3.getText());
        //srvc.Create("test2", "test2");
        
        //srvn.send("test2");
        srvp.pop();
        clear();
        }
        

       // System.out.println((java.sql.Date.valueOf(date1.getValue().toString())));
       
        afficher();
        
    }
     private void clear(){
        txt1.clear();
        txt3.clear();
        txt4.clear();
        txt5.clear();
        txt6.clear();
        txt7.clear();
        txt10.clear();
        combo.getItems().clear();
        
             
        
        
    }
     
         

      public void afficher(){

      ObservableList obeListe = FXCollections.observableList(srv.displayAll());

        c5.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        c7.setCellValueFactory(new PropertyValueFactory<>("prix_unitaire"));
        c6.setCellValueFactory(new PropertyValueFactory<>("prix_vente"));
        c2.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        c3.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
        c1.setCellValueFactory(new PropertyValueFactory<>("reference"));
        c4.setCellValueFactory(new PropertyValueFactory<>("description_produit"));
        c10.setCellValueFactory(new PropertyValueFactory<>("photoProduit"));
        c8.setCellValueFactory(new PropertyValueFactory<>("date_fabrication"));
        c9.setCellValueFactory(new PropertyValueFactory<>("date_expiration"));
        

        table.setItems(obeListe);
        c6.setVisible(true);
       
        // FilteredList filter=new FilteredList(obeListe,e->true);
    }

    @FXML
    private void delete(ActionEvent event) {
         String k=(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
           srv.supprimer(k);
          //System.out.println (k);
            afficher();
            clear();
    }

    @FXML
    private void update(ActionEvent event) {
       
        
        int pu = Integer.parseInt(txt7.getText());
        int pv = Integer.parseInt(txt6.getText());
        String k=(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        srv.modifierbs(txt3.getText(), txt4.getText(),k, pu, pv, (java.sql.Date.valueOf(date1.getValue().toString())),(java.sql.Date.valueOf(date1.getValue().toString())));
        afficher();
        clear();
        
    }

    @FXML
    private void go_tab(MouseEvent event) {
        
        String nom=(c3.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String desc=(c4.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String pu=(c6.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String pv=(c7.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        
        
        
       // txt1.setEditable(false); 
        txt1.setDisable(true); 
        combo.setDisable(true); 
        txt5.setDisable(true); 
        txt10.setDisable(true); 
  
        txt3.setText(nom);
        txt4.setText(desc);
        txt6.setText(""+pu);
        txt7.setText(""+pv);
        
    }


    @FXML
    
    private void upload(MouseEvent event) throws MalformedURLException {
        FileChooser fc = new FileChooser();
       // fc.setInitialDirectory(new File(System.getProperty("user.home") + "\Desktop"));//importation de l'image ou
        fc.setTitle("Veuillez choisir l'image"); //titre de la
      
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
         path = selectedFile.toURI().toURL().toExternalForm();
            
         // Image image = new Image(selectedFile.toURI().toString()) {};
        // Image image = new Image(selectedFile.toURI().toString()) {};
         //  img.setImage("") ;
            //labelImage.setText("Cliquez sur le button pour la changer!");

    }
    }

    @FXML
    private void up(ActionEvent event) {
    }

    @FXML
    private void yhez(ActionEvent event) {
        
    }

    @FXML
    private void search(KeyEvent event) {
    
    }
    
  
    
   
    
}
