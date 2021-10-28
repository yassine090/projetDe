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
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import projetpidev.formulaire;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Page1Controller implements Initializable {
    private formulaireServices fc =new formulaireServices();

    @FXML
    private TextField tID;
    @FXML
    private Button chercherID;
    private TextField tSexe;
    @FXML
    private TextArea tDesc;
    @FXML
    private TextField tDate;
    @FXML
    private TextField tAdresse;
    @FXML
    private TextField tPrenom;
    @FXML
    private TextField tNom;
    @FXML
    private TableView<formulaire> table_formulaire;
    @FXML
    private TableColumn<formulaire,String > tableNom;
    @FXML
    private TableColumn<formulaire, String>tablePrenom;
    @FXML
    private TableColumn<formulaire, String>tableAdresse;
    @FXML
    private TableColumn<formulaire, String> tableSexe;
    @FXML
    private TableColumn<formulaire, String> tableAge;
    @FXML
    private TableColumn<formulaire, String> tableDesc;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnModif;
    @FXML
    private Button ajouter;
    @FXML
    private TableColumn<?, ?> TableID;
    @FXML
    private RadioButton hom;
    @FXML
    private RadioButton fem;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refreshTableView();
    }    
    
     public Connection cnx;
        private PreparedStatement ste;

    @FXML
    private void chercherId(ActionEvent event) {
        int Id=Integer.parseInt(tID.getText()) ;
               
        
        
        try {
            cnx = MyConnection.getInstance().getConnection();
            ste = cnx.prepareStatement("select * from formulaire where Id='"+Id+"'");
            formulaire f =new formulaire();
            ResultSet rs = ste.executeQuery();
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
        refreshTableView();
        
         
    }

    @FXML
    private void supprimerFrmu(ActionEvent event) {
        try {
            int Id=Integer.parseInt(tID.getText()) ;
            
            
            
            
            cnx = MyConnection.getInstance().getConnection();
            ste = cnx.prepareStatement("select * from formulaire where Id='"+Id+"'");
            formulaire f =new formulaire();
            formulaireServices fs = new formulaireServices();
            fs.supprimerFormulaire(Id);
        } catch (SQLException ex) {
            Logger.getLogger(Page1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ModifierForm(ActionEvent event) {
        try {
            int Id=Integer.parseInt(tID.getText());
            String rNom = tNom.getText();
            String rPrenom = tPrenom.getText();
            String rAdresse = tAdresse.getText();
            String rDateNaissance = tDate.getText();
            String rSexe = tSexe.getText();
            String rDescription = tDesc.getText();
           //formulaire f = new formulaire(Id,rNom, rPrenom, rAdresse, rDateNaissance, rSexe, rDescription);
            formulaireServices fs = new formulaireServices();
            
            fs.modifierFormulaire(Id,rNom, rPrenom, rAdresse, rDateNaissance, rSexe, rDescription);
            
        } catch (SQLException ex) {
            Logger.getLogger(ModificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshTableView();
    }
    String rSexe;

    @FXML
    private void AjouterForm(ActionEvent event) {
        try {

            String rNom = tNom.getText();
            String rPrenom = tPrenom.getText();
            String rAdresse = tAdresse.getText();
            String rDateNaissance = tDate.getText();
            if (fem.isSelected()){
                rSexe =" Femme";
                
            }
            if (hom.isSelected()){
                rSexe = "Homme";}
            String rDescription = tDesc.getText();
            formulaire f = new formulaire(2,rNom, rPrenom, rAdresse, rDateNaissance, rSexe, rDescription);
            formulaireServices fs;
            fs = new formulaireServices();
        try {
            fs.ajouterFormulaire(f);
        } catch (SQLException ex) {
            Logger.getLogger(Page1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficheFormulaire.fxml"));
            Parent root = loader.load();
            AfficheFormulaireController af =loader.getController();
            af.setFnom(rNom);
            af.setfprenom(rPrenom);
            af.setfadresse(rAdresse);
            af.setfdate(rDateNaissance);
            af.setfsexe(rSexe);
            af.setfdesc(rDescription);
            ajouter.getScene().setRoot(root);
            JOptionPane.showMessageDialog(null, "confirmation d'ajout");
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        refreshTableView();
}

 private void refreshTableView(){
            
    
       
        
            
            
            TableID.setCellValueFactory(new PropertyValueFactory("Id"));
            tableNom.setCellValueFactory(new PropertyValueFactory("Nom"));
            tablePrenom.setCellValueFactory(new PropertyValueFactory("Prenom"));
            tableAdresse.setCellValueFactory(new PropertyValueFactory("Adresse"));
            tableAge.setCellValueFactory(new PropertyValueFactory("Age"));
            tableDesc.setCellValueFactory(new PropertyValueFactory("descriptionSymptomes"));
            tableSexe.setCellValueFactory(new PropertyValueFactory("Sexe"));
            table_formulaire.setItems(fc.afficherFormualrie());
            
            
       
            }

    @FXML
    private void hom(ActionEvent event) {
    }

    @FXML
    private void fem(ActionEvent event) {
    }
}