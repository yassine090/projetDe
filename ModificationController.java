/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacepackage;

import Myconnection.MyConnection;
import formulaireServices.formulaireServices;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static jdk.nashorn.internal.runtime.Debug.id;
import projetpidev.formulaire;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ModificationController implements Initializable {

    @FXML
    private TextField tID;
    @FXML
    private TextField tNom;
    @FXML
    private TextField tPrenom;
    @FXML
    private TextField tAdresse;
    @FXML
    private TextField tDate;
    
    @FXML
    private TextField tDesc;
    @FXML
    private Button btnOk;
    private Button btnMOD;
    @FXML
    private Button btnRetour1;
    @FXML
    private TextField tSexe;
    @FXML
    private Button suiv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public Connection cnx;
        private PreparedStatement ste;

    @FXML
    private void ChercherId(ActionEvent event) {
                 try {
                     int Id=Integer.parseInt(tID.getText()) ;
                     
                     
                     
                     
                     cnx = MyConnection.getInstance().getConnection();
                     ste = cnx.prepareStatement("select * from formulaire where Id='"+Id+"'");
                     formulaire f =new formulaire();
                     ResultSet rs = null;
                     try {
                         rs = ste.executeQuery();
                     } catch (SQLException ex) {
                         Logger.getLogger(SupprimerFormulaireController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     try{
                         if (rs.next()){
                             f.setId(Id);
                             f.setNom(rs.getString("Nom"));
                             f.setPrenom(rs.getString("Prenom"));
                             f.setDateNaissance(rs.getString("DateNaissance"));
                             f.setAdresse(rs.getString("Adresse"));
                             f.setSexe(rs.getString("Sexe"));
                             f.setDescriptionSymptomes(rs.getString("descriptionSymptomes"));
                         }
                         tNom.setText(f.getNom());
                         tPrenom.setText(f.getPrenom());
                         tAdresse.setText(f.getAdresse());
                         tDate.setText(f.getDateNaissance());
                         tDesc.setText(f.getDescriptionSymptomes());
                         tSexe.setText(f.getSexe());
                         
                         
                     } catch (SQLException ex) {
                         Logger.getLogger(ModificationController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                 } catch (SQLException ex) {
                     Logger.getLogger(ModificationController.class.getName()).log(Level.SEVERE, null, ex);
                 }
         
    }
    

    

    @FXML
    private void retour1(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();
            MenuController mc =loader.getController();
            btnOk.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
System.out.println(ex.getMessage());        }
    }

    @FXML
    private void suiv(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerFormulaire.fxml"));
            Parent root = loader.load();
           SupprimerFormulaireController sc =loader.getController();
            btnOk.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
System.out.println(ex.getMessage());   
        
    }
    
    }}
