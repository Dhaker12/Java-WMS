/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



import Entities.Fournisseur;




import Services.FournisseurService;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * FXML Controller class
 *
 * @author khaoula
 */
public class READ_FRController implements Initializable {

    public ObservableList<Fournisseur> obb;
    @FXML
    private TableColumn<Fournisseur, String> id;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField lastname;

    @FXML
    private TableView<Fournisseur> table;
    Parent root1;
    static int i;
    static int deleteid;
    static String emailadr;
    Writer writer;
    File filef;
    String text;
    @FXML
    private JFXTextField societe;
    @FXML
    private DatePicker Date;
    @FXML
    private Button upload;
    @FXML
    private Button submit;
    @FXML
    private JFXTextField numsociete;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> lastnom;
    @FXML
    private ImageView img;
    @FXML
    private JFXTextField secteur;
    File s;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUpFournisseur();

    }

    public void setUpFournisseur() {

// this gives the value in the selected cell:
        FournisseurService FS = new FournisseurService();
        ObservableList<Fournisseur> mahden = FXCollections.observableArrayList();
        mahden.addAll(FS.selectAll());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("Name"));
        lastnom.setCellValueFactory(new PropertyValueFactory<>("Last_name"));
        TableColumn<Fournisseur, Fournisseur> delete = new TableColumn<>("Delete");
        delete.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );
        delete.setCellFactory(param -> new TableCell<Fournisseur, Fournisseur>() {
            private final Button deleteButton = new Button("Delete");

            @Override
            protected void updateItem(Fournisseur person, boolean empty) {
                super.updateItem(person, empty);

                if (person == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(deleteButton);
                deleteButton.setOnAction(
                        (event) -> {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DELETE_FR.fxml"));

                            try {

                                Fournisseur selectedPerson = table.getSelectionModel().getSelectedItem();
                                deleteid = selectedPerson.getId();

                                root1 = (Parent) fxmlLoader.load();

                                DELETE_FRController sceneController = fxmlLoader.getController();

                            } catch (IOException ex) {
                                Logger.getLogger(DELETE_FRController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();

                        }
                );

            }
        });
        TableColumn<Fournisseur, Fournisseur> edit = new TableColumn<>("Edit");
        edit.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );
        edit.setCellFactory(param -> new TableCell<Fournisseur, Fournisseur>() {
            private final Button editButton = new Button("Edit");

            @Override
            protected void updateItem(Fournisseur person, boolean empty) {
                super.updateItem(person, empty);
                if (person == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(editButton);
                editButton.setOnAction(
                        (event) -> {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UPDATE_FR.fxml"));

                            try {

                                Fournisseur selectedPerson = table.getSelectionModel().getSelectedItem();
                                i = selectedPerson.getId();

                                root1 = (Parent) fxmlLoader.load();
                                System.out.println();
                                UPDATE_FRController scene2Controller = fxmlLoader.getController();

                                System.out.println(i);
                                //  Label l = l.setText(Integer.toString(i));

                            } catch (IOException ex) {
                                Logger.getLogger(READ_FRController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();

                        }
                );

            }
        });

        TableColumn<Fournisseur, Fournisseur> email = new TableColumn<>("Email");
        email.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );
        email.setCellFactory(param -> new TableCell<Fournisseur, Fournisseur>() {
            private final Button emailButton = new Button("Email");

            @Override
            protected void updateItem(Fournisseur person, boolean empty) {
                super.updateItem(person, empty);

                if (person == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(emailButton);
                emailButton.setOnAction(
                        (event) -> {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmailF.fxml"));

                            try {

                                Fournisseur selectedPerson = table.getSelectionModel().getSelectedItem();
                                // emailadr = selectedPerson.getEmail();

                                root1 = (Parent) fxmlLoader.load();

                                EmailFController sceneController3 = fxmlLoader.getController();

                            } catch (IOException ex) {
                                Logger.getLogger(EmailFController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();

                        }
                );

            }
        });

        TableColumn<Fournisseur, Fournisseur> export = new TableColumn<>("Export");
        export.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );
        export.setCellFactory(param -> new TableCell<Fournisseur, Fournisseur>() {
            private final Button exportButton = new Button("Export");

            @Override
            protected void updateItem(Fournisseur person, boolean empty) {
                super.updateItem(person, empty);

                if (person == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(exportButton);
                exportButton.setOnAction((ActionEvent e) -> {
                    Workbook workbook = new HSSFWorkbook();
                    Sheet spreadsheet = workbook.createSheet("sample");

                    Row row = spreadsheet.createRow(0);

                    for (int j = 0; j < 3; j++) {
                        row.createCell(j).setCellValue(table.getColumns().get(j).getText());
                    }

                    for (int i = 0; i < 3; i++) {
                        row = spreadsheet.createRow(i + 1);
                        for (int j = 0; j < 3; j++) {
                            if (table.getColumns().get(j).getCellData(i) != null) {
                                row.createCell(j).setCellValue(table.getColumns().get(j).getCellData(i).toString());
                            } else {
                                row.createCell(j).setCellValue("");
                            }
                        }
                    }

                    FileOutputStream fileOut = null;
                    try {
                        fileOut = new FileOutputStream("/home/khaoula/Desktop/test.xls");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(READ_FRController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        workbook.write(fileOut);
                    } catch (IOException ex) {
                        Logger.getLogger(READ_FRController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        fileOut.close();
                    } catch (IOException ex) {
                        Logger.getLogger(READ_FRController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                );
            }

        });

        table.setItems(mahden);
        table.getColumns().addAll(delete, edit, email, export);

    }

    @FXML
    private void upload(ActionEvent event)  throws IOException {
         FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        s = file;
        BufferedImage bufferedImage = ImageIO.read(file);
        Image image;
        image = SwingFXUtils.toFXImage(bufferedImage, null);
        img.setImage(image);
    }    

    @FXML
    private void ADDEMP(ActionEvent event) {
         FournisseurService FS= new  FournisseurService();
        Fournisseur F= new Fournisseur();

        F.setName(name.getText());
        F.setLast_name(lastname.getText());
        F.setSociete(societe.getText());
        F.setNumsociete(Integer.parseInt(numsociete.getText()));
        F.setSecteur(secteur.getText());

        F.setEntreprise_Date(java.sql.Date.valueOf(Date.getValue()));
        F.setImage((String)(s.getName()));
        
            FS.ajouter(F);

   Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText(null);
alert.setContentText("Fournisseur Added!");

alert.showAndWait();
clear();
 setUpFournisseur();
    
    }
 private void clear(){
        name.clear();
        lastname.clear();
        societe.clear();
        secteur.clear();
        numsociete.clear();
        Date.setValue(null);
        img.setImage(null);
    }}

