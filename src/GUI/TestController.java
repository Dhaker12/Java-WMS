/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Categorie;
import Services.ServiceCategorie;
import Utils.SoundClick;
import com.jfoenix.controls.JFXTextField;
import java.awt.MenuItem;
import static java.awt.PageAttributes.MediaType.C5;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class TestController implements Initializable {

    @FXML
    private JFXTextField txt1;
    @FXML
    private JFXTextField txt2;
    @FXML
    private JFXTextField txt3;

    /**
     * Initializes the controller class.
     */
    ServiceCategorie srv = new ServiceCategorie();
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> c1;
    @FXML
    private TableColumn<?, ?> c2;
    @FXML
    private TableColumn<?, ?> c3;
    @FXML
    private TableColumn<?, ?> c4;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
        afficher();
    }    

    @FXML
    private void submit(ActionEvent event) {
         if ((txt1.getText().isEmpty())||(txt2.getText().isEmpty())||(txt3.getText().isEmpty())){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Champs vide");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez Remplir tous les champs !!! ");
        Optional<ButtonType> action = alert.showAndWait();
    }
         else {
             Categorie c=new Categorie(0,txt1.getText(), txt2.getText(),txt3.getText());
            srv.ajouterBS(c); 
            clear();
             
         }
        
        afficher();
        
    }
   
    public void afficher(){

        ObservableList obeListe = FXCollections.observableList(srv.displayAll());

        c1.setCellValueFactory(new PropertyValueFactory<>("nom_categorie"));
        c2.setCellValueFactory(new PropertyValueFactory<>("description_categorie"));
        c3.setCellValueFactory(new PropertyValueFactory<>("type_stockage"));
        c4.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
        

        table.setItems(obeListe);
        c4.setVisible(false);
        
    }

    @FXML
    private void go_table(MouseEvent event) {
        String nom=(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String desc=(c2.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String type=(c3.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        txt1.setText(nom);
        txt2.setText(desc);
        txt3.setText(type);
       
      
    }

    @FXML
    private void delete(ActionEvent event) {
        int k=Integer.valueOf(c4.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
            srv.supprimer(k);
            afficher();
            clear();
    }

    @FXML
    private void update(ActionEvent event) {
        int k=Integer.valueOf(c4.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        srv.modifierbs(k, txt1.getText(), txt2.getText(), txt3.getText());
        afficher();
        clear();
    }
    private void clear(){
        txt1.clear();
        txt2.clear();
        txt3.clear();
    }
}
