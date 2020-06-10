
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
import Services.SendMailNews;
import Entities.mailNews;
import javafx.scene.layout.AnchorPane;
import Entities.post;
import Entities.tag;
import Services.ServiceMailNews;
import Services.ServicePost;
import Services.ServiceSection;
import Services.ServiceTag;
import Utils.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale; 
import javax.speech.Central; 
import javax.speech.synthesis.Synthesizer; 
import javax.speech.synthesis.SynthesizerModeDesc; 
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.shape.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author azizl
 */
public class FXML_frontOfficeController implements Initializable {

    @FXML
    private AnchorPane main;
   
    TextToSpeech tts = new TextToSpeech();
       ServiceTag sr=new ServiceTag();
       ServicePost srv=new ServicePost();
       ServiceSection ss=new ServiceSection();
      
       int y=0;
       
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
        // TODO
    }    

        
        void afficher()
        {
             TabPane tabPane = new TabPane();
                 main.getChildren().add(tabPane);
            Scene scene = new Scene(new Group());
            scene.getStylesheets().add("test.css");
              
             ServicePost srv = new ServicePost();
                DataSource.getInstance(); 
            ArrayList <post> tab = new ArrayList ();
            tab =(ArrayList<post>) srv.displayAll();
         //System.out.println(Arrays.toString(tab.toArray()));
         
         Tab sections = new Tab();
         sections.setText("Sections");
         Pane listsection=new Pane();
         
         
         ArrayList <String> itms = new ArrayList ();
         itms=ss.sectionlist();
        
            for(int i =0; i<itms.size(); i++){
                
             Button btn = new Button();
             btn.setLayoutX(258);
             btn.setLayoutY(40+y);
             btn.setText(itms.get(i));
            String s=itms.get(i);
             listsection.getChildren().add(btn);
             
             y+=40;
             
       
            
             sections.setContent(listsection);
             
            
         
             
          btn.setOnAction(new EventHandler<ActionEvent>() {
             
            @Override
            public void handle(ActionEvent event) {
                
                     int x=srv.returnIdSection(s);
             System.out.println(x+"!!!!!!!!!!!!!!!!!");
    
                 ArrayList <post> tab = new ArrayList ();
            tab =(ArrayList<post>) srv.displayPostSection(x);
            post(tab);
            }
          });
                
         }
            tabPane.getTabs().add(sections);
         
         
         
         
         
         
         Tab tags = new Tab();
         tags.setText("Tags");
         Pane list =new Pane();
          
         
        
         ArrayList <String> items = new ArrayList ();
         items=sr.taglist();
        
            for(int i =0; i<items.size(); i++){
                
             Button btn = new Button();
             btn.setLayoutX(258);
             btn.setLayoutY(40+y);
             btn.setText(items.get(i));
            String s=items.get(i);
             list.getChildren().add(btn);
             
             y+=40;
             
       
            
             tags.setContent(list);
             
            
         
             
          btn.setOnAction(new EventHandler<ActionEvent>() {
             
            @Override
            public void handle(ActionEvent event) {
                
               
             int x=srv.returnIdTag(s);
             System.out.println(x+"!!!!!!!!!!!!!!!!!");
    
                 ArrayList <post> tab = new ArrayList ();
            tab =(ArrayList<post>) srv.displayPost(x);
            postlist(tab);
            
            }
          });
                
         }
            tabPane.getTabs().add(tags);
         
         
         
    for(int i = 0; i < tab.size(); i++) {
        
       
        
       //speak();
       int z=i+1;
        
        Tab a = new Tab();
        a.setText("Post "+z);
        Pane post =new Pane();
     
        
         ImageView imageView = new ImageView();
    

           Rectangle r = new Rectangle();
           r.setWidth(78);
           r.setHeight(68);
           r.setLayoutX(99);
           r.setLayoutY(217);
           r.setFill(Color.rgb(78, 205, 196));
           r.setArcHeight(10);
           r.setArcWidth(10);
           
         Text day = new Text();
         Text month = new Text();
         Text title = new Text();
         Text desc = new Text();
         
         
    
           
         
         title.setText(tab.get(i).getTitle());
         title.setLayoutX(77);
         title.setLayoutY(311);
         title.setFill(Color.BLACK);
          title.setFont(Font.font ("System", 24));
          title.setWrappingWidth(480);
          
          
              desc.setText(tab.get(i).getDescription());
         desc.setLayoutX(87);
         desc.setLayoutY(title.getLayoutY()+60);
         desc.setFill(Color.BLACK);
           desc.setFont(Font.font ("System", 12));
           desc.setWrappingWidth(470);
         
         //take image from DB
        Image image = new Image("file:C:\\Users\\azizl\\OneDrive\\Pictures\\"+tab.get(i).getPhoto());
        imageView.setImage(image);
       
        
        
        Date dat;
        dat=tab.get(i).getPostdate();
        
        
        LocalDate ld = dat.toLocalDate();
            int d=ld.getDayOfMonth();
           int m=ld.getMonthValue();
            
       
        String d2=String.valueOf(d);
        
        day.setText(d2);
        month.setText(getMonthForInt(m));
        
        month.setLayoutX(120);
        month.setLayoutY(273);

      
        
        day.setLayoutX(125);
        
        day.setLayoutY(246);
        
    
        day.setFont(Font.font ("System", 24));
        day.setFill(Color.WHITE);
        r.toBack();
        day.toFront();
        
        month.setFont(Font.font ("System", 24));
        month.setFill(Color.WHITE);
        r.toBack();
        month.toFront();
        
        
        imageView.setX(62);
        imageView.setY(73);
        imageView.setFitWidth(503);
        imageView.setFitHeight(193);
        System.out.println(tab.get(i).getId()); 
        
        
             Button btn = new Button();
             btn.setText("Speak");
             btn.setLayoutX(88);
             btn.setLayoutY(35);
             btn.setOnAction(new EventHandler<ActionEvent>() {
             
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    tts.speak(desc.getText(), 1.0f, false, false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXML_frontOfficeController.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
             });
        
        
         post.getChildren().add(imageView);
      post.getChildren().add(r);
      post.getChildren().add(day);
      post.getChildren().add(month);
      post.getChildren().add(title);
      post.getChildren().add(desc);
      post.getChildren().add(btn);
  
       a.setContent(post);
      
  
              
      tabPane.getTabs().add(a);
      
        main.getChildren().add(post);
  
        
      
    
    
    }
    
    Tab mail=new Tab();
    mail.setText("Newsletter");
    Pane mailInput = new Pane();
    
    Text msg= new Text();
    TextField input= new TextField();
    Button sumbit=new Button();
    
    
    msg.setText("Newsletter");
    msg.setFont(Font.font ("System", 44));
    msg.setLayoutX(201);
    msg.setLayoutY(98);
    
    input.setPrefWidth(170);
    input.setLayoutX(127);
    input.setLayoutY(224);
    
    sumbit.setText("Submit");
    sumbit.setLayoutX(395);
    sumbit.setLayoutY(224);
    
    
    
          sumbit.setOnAction(new EventHandler<ActionEvent>() {
             
            @Override
            public void handle(ActionEvent event) {
                
               if (isValid(input.getText()))
               {
                 ServiceMailNews srv = new ServiceMailNews();
                    mailNews t = new mailNews(input.getText());
                    srv.ajouterMail(t);
                    input.clear();
               }
               else
               { 
                   System.out.println("wrong mail");
               }
                
                    
             
             }
             });
    
    
    
    
    
    
    
    mailInput.getChildren().add(msg);
     mailInput.getChildren().add(input);
      mailInput.getChildren().add(sumbit);
      
      mail.setContent(mailInput);
      
      tabPane.getTabs().add(mail);
    
}
        
        
        
        
        
      String getMonthForInt(int num) {
            String month = "wrong";
            DateFormatSymbols dfs = new DateFormatSymbols();
            String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
        }
      
      void speak (String text)
      {
          try { 
            // Set property as Kevin Dictionary 
            System.setProperty( 
                "freetts.voices", 
                "com.sun.speech.freetts.en.us"
                    + ".cmu_us_kal.KevinVoiceDirectory"); 
  
            // Register Engine 
            Central.registerEngineCentral( 
                "com.sun.speech.freetts"
                + ".jsapi.FreeTTSEngineCentral"); 
  
            // Create a Synthesizer 
            Synthesizer synthesizer 
                = Central.createSynthesizer( 
                    new SynthesizerModeDesc(Locale.US)); 
  
            // Allocate synthesizer 
            synthesizer.allocate(); 
  
            // Resume Synthesizer 
            synthesizer.resume(); 
  
            // Speaks the given text 
            // until the queue is empty. 
            synthesizer.speakPlainText( 
                text, null); 
            synthesizer.waitEngineState( 
                Synthesizer.QUEUE_EMPTY); 
  
            // Deallocate the Synthesizer. 
            synthesizer.deallocate(); 
            
           
        } 
  
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
      }
      
      public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
      
      
      void post(ArrayList<post> tab)
      {
          
          

         for(int i = 0; i < tab.size(); i++) {
        
       
        
       //speak();
      
        
      
      
        Pane post =new Pane();
     
        
         ImageView imageView = new ImageView();
    

           Rectangle r = new Rectangle();
           r.setWidth(78);
           r.setHeight(68);
           r.setLayoutX(99);
           r.setLayoutY(217);
           r.setFill(Color.rgb(78, 205, 196));
           r.setArcHeight(10);
           r.setArcWidth(10);
           
         Text day = new Text();
         Text month = new Text();
         Text title = new Text();
         Text desc = new Text();
         
         
    
           
         
         title.setText(tab.get(i).getTitle());
         title.setLayoutX(77);
         title.setLayoutY(311);
         title.setFill(Color.BLACK);
          title.setFont(Font.font ("System", 24));
          title.setWrappingWidth(480);
          
          
              desc.setText(tab.get(i).getDescription());
         desc.setLayoutX(87);
         desc.setLayoutY(title.getLayoutY()+60);
         desc.setFill(Color.BLACK);
           desc.setFont(Font.font ("System", 12));
           desc.setWrappingWidth(470);
         
         //take image from DB
        Image image = new Image("file:C:\\Users\\azizl\\OneDrive\\Pictures\\"+tab.get(i).getPhoto());
        imageView.setImage(image);
       
        
        
        Date dat;
        dat=tab.get(i).getPostdate();
        
        LocalDate localDate = dat.toLocalDate();
            int d=localDate.getDayOfMonth();
            int m=localDate.getMonthValue();
            
       
        String d2=String.valueOf(d);
        
        day.setText(d2);
        month.setText(getMonthForInt(m));
        
        month.setLayoutX(120);
        month.setLayoutY(273);

      
        
        day.setLayoutX(125);
        
        day.setLayoutY(246);
        
    
        day.setFont(Font.font ("System", 24));
        day.setFill(Color.WHITE);
        r.toBack();
        day.toFront();
        
        month.setFont(Font.font ("System", 24));
        month.setFill(Color.WHITE);
        r.toBack();
        month.toFront();
        
        
        imageView.setX(62);
        imageView.setY(73);
        imageView.setFitWidth(503);
        imageView.setFitHeight(193);
        System.out.println(tab.get(i).getId()); 
        
        
             Button btn = new Button();
             btn.setText("Speak");
             btn.setLayoutX(88);
             btn.setLayoutY(35);
             btn.setOnAction(new EventHandler<ActionEvent>() {
             
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    tts.speak(desc.getText(), 1.0f, false, false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXML_frontOfficeController.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
             });
        
        
         post.getChildren().add(imageView);
      post.getChildren().add(r);
      post.getChildren().add(day);
      post.getChildren().add(month);
      post.getChildren().add(title);
      post.getChildren().add(desc);
      post.getChildren().add(btn);
  
       
      
  
              
   
      
        main.getChildren().add(post);
  
        
      
    
    
    }
          Button back = new Button();
             back.setText("back");
             back.setLayoutX(88+90);
             back.setLayoutY(35);
             main.getChildren().add(back);
             back.setOnAction(new EventHandler<ActionEvent>() {
             
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sprint2_aziz/FXML_frontOffice.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                 
                   
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(FXML_frontOfficeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             });
      }
         
    public void back(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/sprint2_aziz/FXML_frontOffice.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    
     void postlist(ArrayList<post> tab)
      {
          
           ScrollPane pst=new ScrollPane();

         for(int i = 0; i < tab.size(); i++) {
        
       
        
       //speak();
      
        
      
      
            
             Pane post=new Pane();
     
        
         ImageView imageView = new ImageView();
    

           Rectangle r = new Rectangle();
           r.setWidth(78);
           r.setHeight(68);
           r.setLayoutX(99);
           r.setLayoutY(217);
           r.setFill(Color.rgb(78, 205, 196));
           r.setArcHeight(10);
           r.setArcWidth(10);
           
         Text day = new Text();
         Text month = new Text();
         Text title = new Text();
         Text desc = new Text();
         
         
    
           
         
         title.setText(tab.get(i).getTitle());
         title.setLayoutX(77);
         title.setLayoutY(311);
         title.setFill(Color.BLACK);
          title.setFont(Font.font ("System", 24));
          title.setWrappingWidth(480);
          
          
              desc.setText(tab.get(i).getDescription());
         desc.setLayoutX(87);
         desc.setLayoutY(title.getLayoutY()+60);
         desc.setFill(Color.BLACK);
           desc.setFont(Font.font ("System", 12));
           desc.setWrappingWidth(470);
         
         //take image from DB
        Image image = new Image("file:C:\\Users\\azizl\\OneDrive\\Pictures\\"+tab.get(i).getPhoto());
        imageView.setImage(image);
       
        
        
        Date dat;
        dat=tab.get(i).getPostdate();
        
        LocalDate localDate = dat.toLocalDate();
            int d=localDate.getDayOfMonth();
            int m=localDate.getMonthValue();
            
       
        String d2=String.valueOf(d);
        
        day.setText(d2);
        month.setText(getMonthForInt(m));
        
        month.setLayoutX(120);
        month.setLayoutY(273);

      
        
        day.setLayoutX(125);
        
        day.setLayoutY(246);
        
    
        day.setFont(Font.font ("System", 24));
        day.setFill(Color.WHITE);
        r.toBack();
        day.toFront();
        
        month.setFont(Font.font ("System", 24));
        month.setFill(Color.WHITE);
        r.toBack();
        month.toFront();
        
        
        imageView.setX(62);
        imageView.setY(73);
        imageView.setFitWidth(503);
        imageView.setFitHeight(193);
        System.out.println(tab.get(i).getId()); 
        
        
             Button btn = new Button();
             btn.setText("Speak");
             btn.setLayoutX(88);
             btn.setLayoutY(35);
             btn.setOnAction(new EventHandler<ActionEvent>() {
             
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    tts.speak(desc.getText(), 1.0f, false, false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXML_frontOfficeController.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
             });
        
        
         post.getChildren().add(imageView);
      post.getChildren().add(r);
      post.getChildren().add(day);
      post.getChildren().add(month);
      post.getChildren().add(title);
      post.getChildren().add(desc);
      post.getChildren().add(btn);
  
       
      
  
              
   
      
        pst.getChildrenUnmodifiable().add(post);
  
        
      
    
    
    }
          Button back = new Button();
             back.setText("back");
             back.setLayoutX(88+90);
             back.setLayoutY(35);
             main.getChildren().add(back);
             back.setOnAction(new EventHandler<ActionEvent>() {
             
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sprint2_aziz/FXML_frontOffice.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                 
                   
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(FXML_frontOfficeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             });
               main.getChildren().add(pst);
      }
   
     

      
      
    
}
