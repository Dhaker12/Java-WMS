/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ChartController.numeroPDF;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author abdallah
 */
public class chartc {

    @FXML
    private HBox chartHBox;
    @FXML
    private AnchorPane chartNode;
        Document doc = new Document();


    @FXML
    private void lineChart(ActionEvent event) {
         double total = 0;
        DecimalFormat df2 = new DecimalFormat(".##");
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Nombre de reclamations par jour");
        stage.setWidth(600);
        stage.setHeight(600);


        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");
        //creating the chart
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
                
       lineChart.setTitle("Nombre de reclamations par jour");
        //defining a series
       XYChart.Series series = new XYChart.Series();
       series.setName("Nombre de reclamations par jour");
        //populating the series with data
     //  series.getData().add(new XYChart.Data("10", 23));
      // series.getData().add(new XYChart.Data("15", 14));
       series.getData().add(new XYChart.Data("3", 15));
       series.getData().add(new XYChart.Data("4", 24));
      series.getData().add(new XYChart.Data("5", 34));
    series.getData().add(new XYChart.Data("6", 36));
       series.getData().add(new XYChart.Data("7", 22));
        series.getData().add(new XYChart.Data("8", 45));
        series.getData().add(new XYChart.Data("9", 43));
       series.getData().add(new XYChart.Data("10", 17));
       series.getData().add(new XYChart.Data("11", 29));
//        series.getData().add(new XYChart.Data(12, 25));
        
       lineChart.getData().add(series);
       ((Group) scene.getRoot()).getChildren().add(lineChart);
        stage.setScene(scene);
        chartNode.getChildren().clear();
        chartNode.getChildren().setAll(lineChart);
    }

    @FXML
           private void convertirPDF(ActionEvent event) throws FileNotFoundException, DocumentException, BadElementException, IOException {
       numeroPDF = numeroPDF + 1;
        String nom = "Graph statistique " + numeroPDF + ".pdf";
        try {
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat Heure = new SimpleDateFormat("hh:mm:ss");
            //Font f = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);

            WritableImage wimg = chartNode.snapshot(new SnapshotParameters(), null);
            File file = new File("ChartSnapshot.png");
            ImageIO.write(SwingFXUtils.fromFXImage(wimg, null), "png", file);

            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(System.getProperty("user.home") + "\\Desktop\\" + nom));
            doc.open();
//            Image img = Image.getInstance("C:\\xampp\\htdocs\\TunisiaBonPlan2-Integration\\web\\uploads\\images\\Sanstitre.png");
            Image img = Image.getInstance("ChartSnapshot.png");
            doc.add(img);

//                doc.add(new Paragraph("                                                           "
//                        + "                                                                                           "
//                        + "    " + date.format(new java.util.Date()), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//                        taille12NORMALRed));
//
//                doc.add(new Paragraph("                                                           "
//                        + "                                                                                                 "
//                        + "  " + Heure.format(new java.util.Date()), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//                        taille12NORMALRed));
//                doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
//                doc.add(new Paragraph("                                    Bon de demande N°" + numeroCommande + " Ajouter un cadeaux dans le stock                                                         "));
//                doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
//                doc.add(new Paragraph("Bon Plan",taille12NORMA));
//                
//
//         
//         
//  /*********************************Tableaux**********************************************/
//              
//                PdfPTable table = new PdfPTable(2);
//                table.setWidthPercentage(60);
//                table.setSpacingBefore(11f);
//          
//                Font f = new Font(Font.FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);
//     
//                PdfPCell c1 = new PdfPCell(new Paragraph("Libelle", taille15B));
//                 c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//                  PdfPCell c2 = new PdfPCell(new Paragraph("Quantité", taille15B));
//                  c2.setHorizontalAlignment(Element.ALIGN_CENTER);
//                PdfPCell c3 = new PdfPCell(new Paragraph(boncadeaux.getCadeaux().getLibelle(), taille12NORMA));
//              c3.setHorizontalAlignment(Element.ALIGN_CENTER);
//                PdfPCell c4 = new PdfPCell(new Paragraph(TXQuantite.getText(), taille12NORMA));
//          c4.setHorizontalAlignment(Element.ALIGN_CENTER);
//    
//                table.addCell(c1);
//                table.addCell(c3);
//                table.addCell(c2);
//                table.addCell(c4);
// 
//  /*********************************Tableaux Admin**********************************************/
//     
//                 User loggedUser = pidev.bonplan.Controller.LoginController.getInstance().getLoggedUser();
//                 
//        
//  
// User UserConneter=myServices.chercherUtilisateurByid(loggedUser.getId());            
//  
//  
//                PdfPTable tableAdmin = new PdfPTable(2);
//                tableAdmin.setWidthPercentage(60);
//                tableAdmin.setSpacingBefore(11f);
//               
//        
// 
//                PdfPCell cAdmin1 = new PdfPCell(new Paragraph("Admin"));
//                 cAdmin1.setHorizontalAlignment(Element.ALIGN_CENTER);
//                  PdfPCell cAdmin2 = new PdfPCell(new Paragraph(UserConneter.getUsername()));
//                  cAdmin2.setHorizontalAlignment(Element.ALIGN_CENTER);
//           
//    
//                tableAdmin.addCell(cAdmin1);
//                tableAdmin.addCell(cAdmin2);
// 
//  
//   /*********************************Tableaux User**********************************************/
//                
//   
//   
//                          PdfPTable tableUser= new PdfPTable(2);
//                tableUser.setWidthPercentage(60);
//                tableUser.setSpacingBefore(11f);
//       
//               
// 
//                PdfPCell cUser1 = new PdfPCell(new Paragraph("Partenaire"));
//                 cUser1.setHorizontalAlignment(Element.ALIGN_CENTER);
//            
//                  PdfPCell cUser2 = new PdfPCell(new Paragraph(comboBoxSelectionnerPartenaire.getSelectionModel().getSelectedItem()));
//                  cUser2.setHorizontalAlignment(Element.ALIGN_CENTER);
//           
//    
//                tableUser.addCell(cUser1);
//                tableUser.addCell(cUser2);
//                
//                
//                  
//                doc.add(table);
//                doc.add(tableAdmin);
//              doc.add(tableUser);
            doc.close();
            Desktop.getDesktop().open(new File(System.getProperty("user.home") + "\\Desktop\\" + nom));
            writer.close();

        } catch (Exception e) {

            System.out.println("Error PDF");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());

        }

    }
    }
    

