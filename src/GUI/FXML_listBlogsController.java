/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.post;
import Services.ServicePost;
import java.io.File;
import java.io.IOException;


import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;


import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author azizl
 */
public class FXML_listBlogsController implements Initializable {

    ServicePost srv =new ServicePost();
       FileChooser fc = new FileChooser();
    
    @FXML
    private Pane MainPane;

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
    @FXML
    private TableColumn<?, ?> c6;
    @FXML
    private TableColumn<?, ?> c7;
    @FXML
    private Button home;
    @FXML
    private ComboBox<?> section;
    @FXML
    private ComboBox<?> tag;
    @FXML
    private TextField title;
    @FXML
    private TextArea desc;
    @FXML
    private Button browse;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    private String imgname;

    /**
     * Initializes the controller class.
     */
  @Override
    public void initialize(URL url, ResourceBundle rb) {
                 ObservableList obList1 = FXCollections.observableList(srv.displaytag());
         ObservableList obList2 = FXCollections.observableList(srv.displaysection());
         tag.getItems().clear();
         section.getItems().clear();
         
         tag.setItems(obList1);
         section.setItems(obList2);
           afficher();
                  
     
        // TODO
    }    

 

    @FXML
    private void home(ActionEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/GUI/FXML_starter.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }
     public void afficher(){
          ObservableList obeListe = FXCollections.observableList(srv.displayAll());

        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        c2.setCellValueFactory(new PropertyValueFactory<>("section_id"));
        c3.setCellValueFactory(new PropertyValueFactory<>("tag_id"));
        c4.setCellValueFactory(new PropertyValueFactory<>("title"));
        c5.setCellValueFactory(new PropertyValueFactory<>("description"));
        c6.setCellValueFactory(new PropertyValueFactory<>("photo"));
        c7.setCellValueFactory(new PropertyValueFactory<>("postdate"));
        
        
        table.setItems(obeListe);
     }
    @FXML
    private void browse(ActionEvent event) {
          fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("images files","*.png","*.jpg","*.jpeg"));
        File img = fc.showOpenDialog(null);
        imgname=img.getName();
        
        if(img !=null)
        {
            System.err.println(img.getName());
        }
        
    }

    @FXML
    private void update(ActionEvent event) {
        int sec =srv.returnIdSection(""+section.getValue());
        int tagg = srv.returnIdTag(""+tag.getValue());
        String k=(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        int id=Integer.parseInt(k);
        String ti= title.getText();
        String dess=desc.getText();
        
        srv.modifierbs(id, sec, tagg, ti, dess, imgname, new Date(System.currentTimeMillis()));
         
                   afficher();
                   title.clear();
                   desc.clear();
        
    }

    
    @FXML
    private void delete(ActionEvent event) {
            String k=(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
              int c=Integer.parseInt(k);
          
          srv.supprimer(c);
            afficher();
            title.clear();
            desc.clear();
           
    }
    
    
    
        @FXML
    private void go_tab(MouseEvent event) {
        
        String section=(c2.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String ta=(c3.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String ti=(c4.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String description=(c5.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String photo=(c6.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
    
        
            System.out.println(section);
            System.out.println(ta);
            System.out.println(description);
            System.out.println(photo);
        
       // txt1.setEditable(false); 
     
  
        title.setText(ti);
        desc.setText(description);
        
    }
}
