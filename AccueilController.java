/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacepackage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AccueilController implements Initializable {

    @FXML
    private Button btnSuivant2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nextpage2(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageSymtomes.fxml"));
            Parent root = loader.load();
            AffichageSymtomesController Ac =loader.getController();
            btnSuivant2.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
System.out.println(ex.getMessage());        }
         
    }
    
}
