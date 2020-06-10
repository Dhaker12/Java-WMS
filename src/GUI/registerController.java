package GUI;
import Entities.FosUser;
import Services.FosUerService;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author khaoula
 */
public class registerController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField name;
    @FXML
    private TextField lastname;
    @FXML
    private Button submit;
    @FXML
    private TextField role;
   @FXML
    private Label wrong;
    @FXML
    private AnchorPane anchorPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wrong.setText("");
    }    

    @FXML
    private void Register(ActionEvent event) {
        
        FosUerService us = new FosUerService();
        FosUser user=new FosUser();
        if (username.getText().trim().isEmpty()
               
                || name.getText().trim().isEmpty()
                || lastname.getText().trim().isEmpty()
                || role.getText().trim().isEmpty()               
                || email.getText().trim().isEmpty()
                || password.getText().trim().isEmpty()
                ) {

            wrong.setVisible(true);

        }
          else {
        user.setUsername(username.getText());
        user.setFirstName(name.getText());
        user.setLastName(lastname.getText());
        user.setRoles(role.getText());
        user.setEmail(email.getText());
        user.setPassword(password.getText());
        
            us.ajouter(user);
 
        
    }
    
    }}