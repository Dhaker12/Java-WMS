/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.*;
import Entities.Employee;
import Services.EmployeeService;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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
public class READ_EMPController implements Initializable {
    public ObservableList<Employee> obb;
    @FXML
    private TableColumn<Employee, String> id;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField lastname;

    @FXML
    private TableView<Employee> table;
    Parent root1;
    static int i;
    static int deleteid;
    static String emailadr;
    Writer writer;
    File filef;
String text;
    @FXML
    private JFXTextField fonction;
    @FXML
    private DatePicker birthdate;
    @FXML
    private Button upload;
    @FXML
    private Button submit;
    @FXML
    private JFXTextField email;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> lastnom;
     @FXML
    private ImageView img;
     File s;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
        setUpEmployee();

    }

    public void setUpEmployee() {

// this gives the value in the selected cell:
        EmployeeService EMPS = new EmployeeService();
        ObservableList<Employee> mahden = FXCollections.observableArrayList();
        mahden.addAll(EMPS.selectAll());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("Name"));
        lastnom.setCellValueFactory(new PropertyValueFactory<>("Last_name"));
        TableColumn<Employee, Employee> delete = new TableColumn<>("Delete");
        delete.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );
        delete.setCellFactory(param -> new TableCell<Employee, Employee>() {
            private final Button deleteButton = new Button("Delete");

            @Override
            protected void updateItem(Employee person, boolean empty) {
                super.updateItem(person, empty);

                if (person == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(deleteButton);
                deleteButton.setOnAction(
                        (event) -> {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DELETE_EMP.fxml"));

                            try {

                                Employee selectedPerson = table.getSelectionModel().getSelectedItem();
                                deleteid = selectedPerson.getId();

                                root1 = (Parent) fxmlLoader.load();

                                DELETE_EMPController sceneController = fxmlLoader.getController();

                            } catch (IOException ex) {
                                Logger.getLogger(DELETE_EMPController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();

                        }
                );

            }
        });
        TableColumn<Employee, Employee> edit = new TableColumn<>("Edit");
        edit.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );
        edit.setCellFactory(param -> new TableCell<Employee, Employee>() {
            private final Button editButton = new Button("Edit");

            @Override
            protected void updateItem(Employee person, boolean empty) {
                super.updateItem(person, empty);
                if (person == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(editButton);
                editButton.setOnAction(
                        (event) -> {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UPDATE_EMP.fxml"));

                            try {

                                Employee selectedPerson = table.getSelectionModel().getSelectedItem();
                                i = selectedPerson.getId();

                                root1 = (Parent) fxmlLoader.load();
                                System.out.println();
                                UPDATE_EMPController scene2Controller = fxmlLoader.getController();

                                System.out.println(i);
                                //  Label l = l.setText(Integer.toString(i));

                            } catch (IOException ex) {
                                Logger.getLogger(READ_EMPController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();

                        }
                );

            }
        });

        TableColumn<Employee, Employee> email = new TableColumn<>("Email");
        email.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );
        email.setCellFactory(param -> new TableCell<Employee, Employee>() {
            private final Button emailButton = new Button("Email");

            @Override
            protected void updateItem(Employee person, boolean empty) {
                super.updateItem(person, empty);

                if (person == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(emailButton);
                emailButton.setOnAction(
                        (event) -> {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EMAIL.fxml"));

                            try {

                                Employee selectedPerson = table.getSelectionModel().getSelectedItem();
                                // emailadr = selectedPerson.getEmail();

                                root1 = (Parent) fxmlLoader.load();

                                EMAILController sceneController3 = fxmlLoader.getController();

                            } catch (IOException ex) {
                                Logger.getLogger(EMAILController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();

                        }
                );

            }
        });

        TableColumn<Employee, Employee> export = new TableColumn<>("Export");
        export.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );
        export.setCellFactory(param -> new TableCell<Employee, Employee>() {
            private final Button exportButton = new Button("Export");

            @Override
            protected void updateItem(Employee person, boolean empty) {
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
                if(table.getColumns().get(j).getCellData(i) != null) { 
                    row.createCell(j).setCellValue(table.getColumns().get(j).getCellData(i).toString()); 
                }
                else {
                    row.createCell(j).setCellValue("");
                }   
            }
        }

        FileOutputStream fileOut = null;
                    try {
                        fileOut = new FileOutputStream("/home/khaoula/Desktop/workbook.xls");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(READ_EMPController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        workbook.write(fileOut);
                    } catch (IOException ex) {
                        Logger.getLogger(READ_EMPController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        fileOut.close();
                    } catch (IOException ex) {
                        Logger.getLogger(READ_EMPController.class.getName()).log(Level.SEVERE, null, ex);
                    }



                 }
                ); 
            }

        });

        table.setItems(mahden);
        table.getColumns().addAll(delete, edit, email, export);

    }
  

       @FXML
    private void ADDEMP(ActionEvent event) throws FileNotFoundException, IOException {
        EmployeeService EMPS= new  EmployeeService();
        Employee EMP= new Employee();

        EMP.setName(name.getText());
        EMP.setLast_name(lastname.getText());
        EMP.setFonction(fonction.getText());
        EMP.setBirth_Date(java.sql.Date.valueOf(birthdate.getValue()));
        EMP.setImage((String)(s.getName()));
        EMP.setEmail(email.getText());
        EMPS.ajouter(EMP);
        Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText(null);
alert.setContentText("Employee Added!");

alert.showAndWait();
clear();
 setUpEmployee();
    
    }
 private void clear(){
        name.clear();
        lastname.clear();
        fonction.clear();
        email.clear();
        birthdate.setValue(null);
        img.setImage(null);
    }
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
        Image image;
        image = SwingFXUtils.toFXImage(bufferedImage, null);
        img.setImage(image);
    }    

}
        

