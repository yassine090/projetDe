/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacepackage;

import QuestionsService.QuestionsService;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import projetpidev.Questions;
import projetpidev.formulaire;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AffichageSymtomesController implements Initializable {

    @FXML
    private RadioButton oui1;
    @FXML
    private RadioButton Non1;
    @FXML
    private RadioButton oui2;
    @FXML
    private RadioButton non2;
    @FXML
    private RadioButton jsp2;
    @FXML
    private RadioButton Oui3;
    @FXML
    private RadioButton oui4;
    @FXML
    private RadioButton Non4;
    @FXML
    private RadioButton Non3;
    @FXML
    private RadioButton jsp3;
    @FXML
    private RadioButton jsp4;
    @FXML
    private RadioButton oui5;
    @FXML
    private RadioButton non5;
    @FXML
    private RadioButton jsp5;
    @FXML
    private RadioButton oui6;
    @FXML
    private RadioButton non6;
    @FXML
    private RadioButton jsp6;
    @FXML
    private TextField IDS;
    @FXML
    private Button SUI;
    @FXML
    private RadioButton jsp1;
    @FXML
    private RadioButton oui7;
    @FXML
    private RadioButton non7;
    @FXML
    private RadioButton jsp7;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        
    }    
    String Question1;
    String Question2;
    String Question3;
    String Question4;
                            String Question5;
                            String Question6;
                                    String Question7;
                                            
                                                            
                                    
    @FXML
    private void pageSauivante(ActionEvent event) {
        try {
            if (oui1.isSelected()){
                Question1 = "oui";
                
            }
            if (Non1.isSelected()){
                Question1 = "non";
                
            }
            if (jsp1.isSelected()){
                Question1 = "jsp";
                
            }
            
            
            
            if (oui2.isSelected()){
                Question2 = "oui";
                
            }
            if (non2.isSelected()){
                Question2 = "non";
                
            }
            if (jsp2.isSelected()){
                Question2 = "jsp";
                
            }
            if (Oui3.isSelected()){
                Question3 = "oui";
                
            }
            if (Non3.isSelected()){
                Question3 = "non";
                
            }
            if (jsp3.isSelected()){
                Question3 = "jsp";
                
            }
            if (oui4.isSelected()){
                Question4 = "oui";
                
            }
            if (Non4.isSelected()){
                Question4 = "non";
                
            }
            if (jsp4.isSelected()){
                Question4 = "jsp";
                
            }
            if (oui5.isSelected()){
                Question5 = "oui";
                
            }
            if (non5.isSelected()){
                Question5 = "non";
                
            }
            if (jsp5.isSelected()){
                Question5 = "jsp";
                
            }
            if (oui6.isSelected()){
                Question6= "oui";
                
            }
            if (non6.isSelected()){
                Question6 = "non";
                
            }
            if (jsp6.isSelected()){
                Question6 = "jsp";
                
            }
            if (oui7.isSelected()){
                Question7 = "oui";
                
            }
            if (non7.isSelected()){
                Question7 ="non";
                
            }
            if (jsp7.isSelected()){
                Question7 = "jsp";
                
            }
            Questions Q = new Questions (Question1,Question2,Question3,Question4,Question5,Question6,Question7);
            QuestionsService Qs;
            Qs = new QuestionsService();
            Qs.Questionnaire(Q);
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Merci.fxml"));
            Parent root = loader.load();
            MerciController mc =loader.getController();
            SUI.getScene().setRoot(root);
        } catch (SQLException ex) {
            Logger.getLogger(AffichageSymtomesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AffichageSymtomesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
