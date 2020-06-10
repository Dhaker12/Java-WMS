/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.reclamation;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import Services.SendMail1;
import Services.reclamtionService1;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author 
 */
public class AjoutreclamationController implements Initializable {
    @FXML
    private TextField txtPrenom;
    @FXML
    private Button btn_valider;
    
    @FXML
        private TableView<reclamation> tablereclamation2;
        reclamtionService1 srv = new reclamtionService1();
         @FXML
    private TableColumn<reclamation, String> c1;
    @FXML
    private TableColumn<reclamation, String> c2;
    @FXML
    private TableColumn<reclamation, String> c3;

                public ObservableList<reclamation> obb ;
    @FXML
    private Button idsup;
    @FXML
    private DatePicker date1;

    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
     afficher();
    }    
    public void setUpReclamation(){
            ArrayList<reclamation> mahden = null ;
            mahden=(ArrayList<reclamation>) srv.displayAll();
            obb=FXCollections.observableArrayList(mahden);
             c1.setCellValueFactory(new PropertyValueFactory<>("idFacture"));
        c2.setCellValueFactory(new PropertyValueFactory<>("montant"));
        c3.setCellValueFactory(new PropertyValueFactory<>("fournisseur"));
        
            tablereclamation2.setItems(obb);
    }
    public void afficher(){

        ObservableList obeListe = FXCollections.observableList(srv.displayAll());

        c1.setCellValueFactory(new PropertyValueFactory<>("Id_reclamation"));
        c2.setCellValueFactory(new PropertyValueFactory<>("Description"));
      //  c3.setCellValueFactory(new PropertyValueFactory<>("Employee"));
        
        

        tablereclamation2.setItems(obeListe);
        // c4.setVisible(false);

        
    }
    

    @FXML
    private void valider(ActionEvent event) throws IOException {
        reclamtionService1 ps=new reclamtionService1();
                SendMail1 srvn= new SendMail1();

//                int id = Integer.parseInt(txtN.getText());
                
                

        ps.insert(new reclamation(0,txtPrenom.getText(),(java.sql.Date.valueOf(date1.getValue()))));
                srvn.send(txtPrenom.getText());

                JOptionPane.showMessageDialog(null, "Ajout effectué");
        

       // FXMLLoader fxml=new FXMLLoader(getClass().getResource("Recuperation_1_1.fxml"));
        
       // Parent root=fxml.load();
        //txtN.getScene().setRoot(root);
       // RecuperationController_11 rc=fxml.getController();
        
       // rc.setLabelId_reclamation(txtN.getText());
       // rc.setlabelDescription(txtPrenom.getText());
       
        //rc.setlabelEmployee(txtEm.getText());
        
      
        
        
    }
    private void supprimer(ActionEvent event) {
       reclamation i = tablereclamation2.getSelectionModel().getSelectedItem();
    srv.delete(i);
    setUpReclamation();
      JOptionPane.showMessageDialog(null, "Reclamation supprimer..");
    }

    @FXML
    private void go_table11(MouseEvent event) {
         
       // String id_reclamation=(c1.getCellData(tablereclamation2.getSelectionModel().getSelectedIndex()).toString());
        String desc=(c2.getCellData(tablereclamation2.getSelectionModel().getSelectedIndex()).toString());
        //String type=(c3.getCellData(tablereclamation2.getSelectionModel().getSelectedIndex()).toString());
        

        

        //txtN.setText(id_reclamation);
        txtPrenom.setText(desc);
       
      //  txtEm.setText(type);

    
    }
     @FXML
    private void update(ActionEvent event) {
        //nt k=Integer.valueOf(c1.getCellData(tablereclamation2.getSelectionModel().getSelectedIndex()).toString());
                reclamation i = tablereclamation2.getSelectionModel().getSelectedItem();

        srv.update(i);
            setUpReclamation();

        afficher();
       // clear();
    }

    @FXML
    private void supprimer1(ActionEvent event) {
        reclamation i = tablereclamation2.getSelectionModel().getSelectedItem();
    srv.delete(i);
    setUpReclamation();
      JOptionPane.showMessageDialog(null, "Reclamation supprimer..");
    }

    @FXML
    private void testDate(ActionEvent event) {
    }

    
}
