/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacepackage;

import formulaireServices.formulaireServices;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;
import projetpidev.formulaire;


/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjouterFormulaireController implements Initializable {

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtDateNaissance;
    @FXML
    private TextField txtSexe;
    @FXML
    private TextArea txtDescription;
    @FXML
    private Button btnValider;
    @FXML
    private Button btnRetour2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveFormulaire(ActionEvent event) throws SQLException {
        try {

            String rNom = txtNom.getText();
            String rPrenom = txtPrenom.getText();
            String rAdresse = txtAdresse.getText();
            String rDateNaissance = txtDateNaissance.getText();
            String rSexe = txtSexe.getText();
            String rDescription = txtDescription.getText();
            formulaire f = new formulaire(150,rNom, rPrenom, rAdresse, rDateNaissance, rSexe, rDescription);
            formulaireServices fs;
            fs = new formulaireServices();
            fs.ajouterFormulaire(f);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficheFormulaire.fxml"));
            Parent root = loader.load();
            AfficheFormulaireController af =loader.getController();
            af.setFnom(rNom);
            af.setfprenom(rPrenom);
            af.setfadresse(rAdresse);
            af.setfdate(rDateNaissance);
            af.setfsexe(rSexe);
            af.setfdesc(rDescription);
            btnValider.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
                }

    @FXML
    private void retourpage2(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();
            MenuController mc =loader.getController();
            btnValider.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
System.out.println(ex.getMessage());        }
    }
    
    }
    

