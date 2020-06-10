/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Commande;
import Services.SMS;
import Services.ServiceCommande;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dhake
 */
public class Commande_guiController implements Initializable {
    ServiceCommande srv = new ServiceCommande();


    @FXML
    private JFXComboBox<?> combo;
    @FXML
    private JFXTextField txt1;
    @FXML
    private JFXTextField txt2;
    @FXML
    private JFXTextField txt3;
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
    @FXML
    private TableColumn<?, ?> c5;

    /**
     * Initializes the controller class.
     */
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
    private void go_table(MouseEvent event) {
        String nom=(c2.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String qte=(c3.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String forn=(c5.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        txt1.setText(nom);
        txt2.setText(""+qte);
        txt3.setText(forn);
        combo.setDisable(true); 
    }

    @FXML
    private void submit(ActionEvent event) {
        
        ServiceCommande srv = new ServiceCommande();
        int qte = Integer.parseInt(txt2.getText());
        if ((txt1.getText().isEmpty())||(txt2.getText().isEmpty())||(txt3.getText().isEmpty())){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Champs vide");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez Remplir tous les champs !!! ");
        Optional<ButtonType> action = alert.showAndWait();
    }
        else{
             Commande C= new Commande(0, txt1.getText(), qte, srv.return_id_bs_sm(""+combo.getValue()), txt3.getText());
        srv.ajouterBS(C);
        SMS srvss=new SMS();
        //srvss.SendSMS("WMS", "Commande Passé avec succes", "21625064521");
        clear();
            
        }
       
        afficher();
        
    }
    public void afficher(){

        ObservableList obeListe = FXCollections.observableList(srv.displayAll());

        c1.setCellValueFactory(new PropertyValueFactory<>("id_commande"));
        c2.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
        c3.setCellValueFactory(new PropertyValueFactory<>("quantite_commande"));
        c4.setCellValueFactory(new PropertyValueFactory<>("idcategorie"));
        c5.setCellValueFactory(new PropertyValueFactory<>("id_fournisseur"));
        
        table.setItems(obeListe);
        //c1.setVisible(false);
        
    }

    @FXML
    private void delete(ActionEvent event) {
        int k=Integer.valueOf(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
            srv.supprimer(k);
            afficher();
            clear();
    }

    @FXML
    private void update(ActionEvent event) {
        int qte = Integer.parseInt(txt2.getText());
        int k=Integer.valueOf(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        srv.modifierbs(k, txt1.getText(), qte, txt3.getText());
        afficher();
        clear();
    }
    private void clear(){
        txt1.clear();
        txt2.clear();
        txt3.clear();
    }
    
}
