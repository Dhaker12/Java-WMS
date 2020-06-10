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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khaoula
 */
public class DoneController implements Initializable {

    @FXML
    private Button EXIT;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void EXIT(ActionEvent event) {
        // get a handle to the stage
    Stage stage = (Stage) EXIT.getScene().getWindow();
    // do what you have to do
    stage.close();
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
 
    Parent home_page_parent =FXMLLoader.load(getClass().getResource("READ_EMP.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.close(); //optional
                    app_stage.setScene(home_page_scene);
                    app_stage.show();
        
    }
    
}
