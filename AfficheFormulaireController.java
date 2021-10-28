/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacepackage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AfficheFormulaireController implements Initializable {

    @FXML
    private TextField outnom;
    @FXML
    private TextField outprenom;
    @FXML
    private TextField outdate;
    @FXML
    private TextField outadresse;
    @FXML
    private TextField outsexe;
    @FXML
    private TextField outdesc;
    @FXML
    private Button btnSuivant;
    @FXML
    private AnchorPane retour0;
    @FXML
    private Button retourrr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setFnom(String fnom)
    {
        this.outnom.setText(fnom);
        
    }
    public void setfprenom(String fprenom)
    {
        this.outprenom.setText(fprenom);
    }
    public void setfadresse (String fadresse)
    {
        this.outadresse.setText(fadresse);
        
    }

    /**
     *
     * @param fdate
     */
    public void setfdate (String fdate)
    {
        this.outdate.setText(fdate);
        
    }
    public void setfsexe(String fsexe){
        this.outsexe.setText(fsexe);
    }
    public void setfdesc (String fdesc)
    {
        this.outdesc.setText(fdesc);
    }

    @FXML
    private void nextpage(ActionEvent event) throws SQLException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
            Parent root = loader.load();
            AccueilController ac =loader.getController();
            btnSuivant.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
System.out.println(ex.getMessage());        }
         
    }

    void setfdate(int rAge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void retour00(MouseEvent event) {}
    

    @FXML
    private void retourr(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Page1.fxml"));
            Parent root = loader.load();
            Page1Controller pr =loader.getController();
             retour0.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    }

