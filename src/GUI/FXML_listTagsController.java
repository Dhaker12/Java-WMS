/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.ServiceTag;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author azizl
 */
public class FXML_listTagsController implements Initializable {
    @FXML
    private Pane MainPane;
  
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> c1;
    @FXML
    private TableColumn<?, ?> c2;
    @FXML
    private Button home;
    @FXML
    private TextField title;
    @FXML
    private Button update;
    @FXML
    private Button delete;

     ServiceTag srv = new ServiceTag ();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
    }    

 

    @FXML
    private void home(ActionEvent event) throws IOException {
           MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/GUI/FXML_starter.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }
        private void afficher() {
         ObservableList obeListe = FXCollections.observableList(srv.displayAll());

        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        c2.setCellValueFactory(new PropertyValueFactory<>("title"));
        
          table.setItems(obeListe);
    }

    @FXML
    private void update(ActionEvent event) {
        
        String ti= title.getText();
        String k=(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        int id=Integer.parseInt(k);
        srv.modifierbs(ti, id);
        afficher();
        
        
    }

    @FXML
    private void delete(ActionEvent event) {
                String k=(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
              int c=Integer.parseInt(k);
          
            srv.supprimer(c);
            afficher();
            title.clear();
        
    }
    
    @FXML
    private void go_tab(MouseEvent event) {
        
        
        String ti=(c2.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        title.setText(ti);
    }

 
 

  
    
}
