/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



import Entities.Fournisseur;

import Services.FournisseurService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author khaoula
 */
public class UPDATE_FRController implements Initializable {

    private ImageView img1;
    @FXML
    private Button img;
    @FXML
    private Button update;
    @FXML
    private TextField lastname;
    @FXML
    private TextField name;
    @FXML
    private TextField societe;
    @FXML
    private TextField secteur;
    @FXML
    private Label idE;
       File s;
   
    @FXML
    private Label wrong;
    @FXML
    private ImageView image;
    @FXML
    private DatePicker date;
    @FXML
    private TextField numsociete;
    public Label getIdE() {
        return idE;}
    /**
     * Initializes the controller class.
     */
  @Override
    public void initialize(URL url, ResourceBundle rb) {
         idE.setText(Integer.toString(idd));
    }
    public int idd= READ_FRController.i;

    @FXML
    private void upload(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        s = file;
        BufferedImage bufferedImage = ImageIO.read(file);
        Image image1;
        image1 = SwingFXUtils.toFXImage(bufferedImage, null);
        image.setImage(image1);
    }

    @FXML
    private void updateFR(ActionEvent event) throws SQLException, IOException {
        FournisseurService EMPS = new FournisseurService();
        Fournisseur EMP = EMPS.selectOne(idd);
        if (name.getText().trim().isEmpty()
                || lastname.getText().trim().isEmpty()
                || societe.getText().trim().isEmpty()
            
                || numsociete.getText().trim().isEmpty()
                || secteur.getText().trim().isEmpty()) {

            wrong.setVisible(true);
        } else {
           EMP.setId(idd);
            EMP.setName(name.getText());
            EMP.setLast_name(lastname.getText());
            EMP.setSecteur(secteur.getText());
            EMP.setEntreprise_Date(java.sql.Date.valueOf(date.getValue()));
             EMP.setImage((String)(s.getName()));
            EMP.setSociete(societe.getText());
            EMP.setNumsociete(Integer.parseInt(numsociete.getText()));
            EMPS.editUser(EMP);
        Parent home_page_parent =FXMLLoader.load(getClass().getResource("doneF.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                 
                    app_stage.setScene(home_page_scene);
                    app_stage.show();

        }
    }
    
}
