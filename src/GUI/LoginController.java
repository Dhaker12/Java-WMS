package GUI;

import Security.FOSJCrypt;
import Utils.ConnexionBD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author khaoula
 */
public class LoginController implements Initializable {

  
   private Connection connection = ConnexionBD.getinstance().getcnx();
    private static Statement ste=null;
    @FXML
    private TextField username;
    @FXML
    private TextField pass;
    

   @FXML
    private Label errorMessage;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXButton login;
    @FXML
    private JFXButton register;
 
    /**
     * Initializes the controller class.
     */
     /* public void setApp(Main application){
        this.main = application;
   }
*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorMessage.setText("");
        username.setPromptText("login");
        pass.setPromptText("password");
    }    

    @FXML
    private void Login(ActionEvent event) throws UnsupportedEncodingException, NoSuchAlgorithmException, SQLException, IOException {
   Boolean u = false;
        int i=0;
            try {

            String query = "select password, roles from fos_user where  (username = ? );";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, username.getText());
            ResultSet rest = stm.executeQuery();
            String pas= pass.getText();
            while (rest.next()) {
                i++;
               String DBpassword = rest.getString("password");
               boolean test =FOSJCrypt.checkPassword(pas,DBpassword);
               System.out.println(test);
                if (test) {
                    u = true;
                     errorMessage.setText("Logged in with success  "+u);
                     String role=rest.getString("roles");
                     /* if(role.equals("a:1:{i:0;s:11:\"ROLE_CLIENT\";}"))
                      {
                      System.out.println("client");
                      }
                
                      else 
                      { if((role.equals("a:1:{i:0;s:5:\"ADMIN\";}"))||role.equals("a:1:{i:0;s:10:\"ROLE_ADMIN\";}"));
                      System.out.println("admin");
                      
                      if(role.equals("a:1:{i:0;s:13:\"ROLE_EMPLOYEE\";}"));
                      System.out.println("Employee");
                      }  
                     */ 
                      Parent home_page_parent =FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                        Scene home_page_scene = new Scene(home_page_parent);
                        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                 
                    app_stage.setScene(home_page_scene);
                    app_stage.show();
                      }
                else {
                    u = false;
                     errorMessage.setText("Wrong credentials  "+ u);

                 } }
       if(i==0){System.out.println("Could not find user ");}
        } catch (SQLException ex) {

    System.out.println("not good at all ");
        }
            }

    @FXML
    private void register(ActionEvent event) throws IOException {
        Parent home_page_parent =FXMLLoader.load(getClass().getResource("register.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                 
                    app_stage.setScene(home_page_scene);
                    app_stage.show();
    }
}


