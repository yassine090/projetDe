/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacepackage;

import Myconnection.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import projetpidev.Questions;
import projetpidev.formulaire;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class SupprimerFormulaireController implements Initializable {

    @FXML
    private Label ttid;
    @FXML
    private TextField tID;
    @FXML
    private Button ok;
    @FXML
    private Button retour3;
    @FXML
    private TextField tNom;
    @FXML
    private TextField tPrenom;
    @FXML
    private TextField tAdresse;
    @FXML
    private TextField tDate;
    @FXML
    private TextField tSex;
    @FXML
    private TextField tDesc;
    @FXML
    private TextField thh;
    @FXML
    private Button suivant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public Connection cnx;
        private PreparedStatement ste;

    private void SuppFormulaire(ActionEvent event) {
        int Id=Integer.parseInt(ttid.getText()) ;
        try{
String req = "DELETE FROM formulaire WHERE Id= '"+Id+"'";
        ste=cnx.prepareStatement(req);
ste.setInt(1,Id);
ste.executeUpdate();

}catch(SQLException ex){
    System.out.println(ex.getMessage());
    }
}

    @FXML
    private void SearchOk(ActionEvent event) {
           
                 int Id=Integer.parseInt(tID.getText()) ;
                 
                 
                 
                 
                 cnx = MyConnection.getInstance().getConnection();
                 try {
                     ste = cnx.prepareStatement("select * from questions where Id='"+Id+"'");
                 } catch (SQLException ex) {
                     Logger.getLogger(SupprimerFormulaireController.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 Questions f =new Questions();
                 ResultSet rs = null;
                 try {
                     rs = ste.executeQuery();
                 } catch (SQLException ex) {
                     Logger.getLogger(SupprimerFormulaireController.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 try {
                     if (rs.next()){
                         f.setId(Id);
                         f.setQuestion1(rs.getString("Question1"));             

                         f.setQuestion2(rs.getString("Question2"));
                         f.setQuestion3(rs.getString("Question3"));
                         f.setQuestion4(rs.getString("Question4"));
                         f.setQuestion5(rs.getString("Question5"));
                         f.setQuestion6(rs.getString("Question6"));
                         f.setQuestion7(rs.getString("Question6"));
                     }
                     tNom.setText(f.getQuestion1());
                 tPrenom.setText(f.getQuestion2());
                 tAdresse.setText(f.getQuestion3());
                 tDate.setText(f.getQuestion4());
                 tDesc.setText(f.getQuestion5());
                 tSex.setText(f.getQuestion6());
                 thh.setText(f.getQuestion7());
                
                 
                 } catch (SQLException ex) {
                     Logger.getLogger(SupprimerFormulaireController.class.getName()).log(Level.SEVERE, null, ex);
                 }
         
             }


    @FXML
    private void retourpage3(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modification.fxml"));
            Parent root = loader.load();
            ModificationController mc =loader.getController();
            ok.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
System.out.println(ex.getMessage());        }
    }

    @FXML
    private void nextt(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Email.fxml"));
            Parent root = loader.load();
            EmailController ec =loader.getController();
            ok.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
System.out.println(ex.getMessage());        }
    }
    }
    
        
        
    
    
    
    

