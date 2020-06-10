/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Entities.post;
import Services.SendMailNews;
import Services.ServiceMailNews;
import Services.ServicePost;
import Utils.DataSource;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author azizl
 */
public class FXML_addBlogController implements Initializable {
    ServicePost srv = new ServicePost();
    FileChooser fc = new FileChooser();
    @FXML
    private Pane MainPane;

    @FXML
    private Button home;
    @FXML
    private TextField title;
    @FXML
    private TextArea desc;
    @FXML
    private Button browse;
    @FXML
    private Label img;
    @FXML
    private ComboBox<?> tag;
    @FXML
    private ComboBox<?> section;
     @FXML
     private Button add;
     private String imgname;

    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList obList1 = FXCollections.observableList(srv.displaytag());
         ObservableList obList2 = FXCollections.observableList(srv.displaysection());
         tag.getItems().clear();
         section.getItems().clear();
         
         tag.setItems(obList1);
         section.setItems(obList2);
         
         
         
         
    }    



    @FXML
    private void home(ActionEvent event) throws IOException {
           MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/GUI/FXML_starter.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }
    
    @FXML
     private void browse(ActionEvent event) throws IOException {
        
        
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
    private void add(ActionEvent event) {
       
        
        ServicePost srv=new ServicePost();
      post p= new post(
                srv.returnIdSection(""+section.getValue()),
                srv.returnIdTag(""+tag.getValue()),
                title.getText(),
                desc.getText(),
                imgname,
                new Date(System.currentTimeMillis()));
      
        srv.ajouterPost(p);
        
         
         
        clear();
        
            Connection c=DataSource.getInstance().getCnx();
        ServiceMailNews sr=new ServiceMailNews();
        
         ArrayList <String> items = new ArrayList ();
         items=sr.mailList();
        
           for (String item:items)
           {
                 SendMailNews s = new SendMailNews();
                    s.send(item);
           }
        
        
        
        
        
    }
    
      private void clear(){
      title.clear();
      desc.clear();
      
    }
    
}
