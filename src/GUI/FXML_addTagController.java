/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.section;
import Entities.tag;
import Services.ServiceSection;
import Services.ServiceTag;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author azizl
 */
public class FXML_addTagController implements Initializable {

    @FXML
    private Pane MainPane;

    @FXML
    private Button home;
    @FXML
    private Label img;
    @FXML
    private Button add;
    @FXML
    private TextField title;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

 

    @FXML
    private void home(ActionEvent event) throws IOException {
              MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/GUI/FXML_starter.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void add(ActionEvent event) {
              ServiceTag srv=new ServiceTag();
        tag t= new tag( title.getText() );
        
        srv.ajoutertag(t);
        clear();
    }
      private void clear(){
      title.clear();
     
      
    }
    
}
