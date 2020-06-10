/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private VBox sidebar;
    @FXML
    private JFXButton homebtn;
    @FXML
    private Pane TopBar;
    @FXML
    private Pane MainPane;
    @FXML
    private JFXButton com;
    @FXML
    private JFXButton com1;
    @FXML
    private JFXButton com2;
    @FXML
    private JFXButton com3;
    @FXML
    private JFXButton com4;
    @FXML
    private JFXButton a;
    @FXML
    private JFXButton emp;
    @FXML
    private JFXButton fournisseur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
        try {
         //  TopBar.getChildren().clear();
            Parent parent = FXMLLoader.load(getClass().getResource("Topbar.fxml"));
            TopBar.getChildren().add(parent);
            TopBar.toFront();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }    

    @FXML
    private void homebtna(ActionEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("test.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void DailyMeeting(ActionEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("Produit_gui.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void Commandebtn(ActionEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("Commande_gui.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void Facturebtn(ActionEvent event) throws IOException {
           MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("AjoutFacture.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.getChildren().add(TopBar);
        MainPane.toFront();
    }

    @FXML
    private void reclamtionbtn(ActionEvent event) throws IOException {
               MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("Ajoutreclamation.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void Chartbtn(ActionEvent event) throws IOException {
               MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("chart.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }
    
    
      @FXML
    private void blogbtn(ActionEvent event) throws IOException {
               MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_starter.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void empbtn(ActionEvent event) throws IOException {
       
        MainPane.getChildren().clear();
       
        AnchorPane parent = FXMLLoader.load(getClass().getResource("READEMPLOYEE.fxml"));
        MainPane.getChildren().add(parent);
        
        MainPane.toFront();
    }

    @FXML
    private void Fournisseurbtn(ActionEvent event) throws IOException {
             MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("READFOURNISSEUR.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }


}
