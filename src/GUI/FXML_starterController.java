/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author azizl
 */
public class FXML_starterController implements Initializable {

    @FXML
    private Pane MainPane;
    @FXML
    private Button logout;
    @FXML
    private Button addB;
    @FXML
    private Button listS;
    @FXML
    private Button addS;
    @FXML
    private Button listT;
    @FXML
    private Button addT;
    @FXML
    private Button listB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void addB(ActionEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_addBlog.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void ListS(ActionEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_listSections.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void addS(ActionEvent event) throws IOException {
        
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_addSection.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }
    

    @FXML
    private void ListT(ActionEvent event) throws IOException {
                   MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/GUI/FXML_listTags.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void addT(ActionEvent event) throws IOException {
           MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_addTag.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void listB(ActionEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/GUI/FXML_listBlogs.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
        
    }
    
}
