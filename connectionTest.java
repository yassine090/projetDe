/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectiontest;

import Myconnection.MyConnection;
import QuestionsService.QuestionsService;
import formulaireServices.formulaireServices;
import java.sql.SQLException;
import projetpidev.Questions;
import projetpidev.formulaire;



/**
 *
 * @author LENOVO
 */
public class connectionTest {
     public static void main(String[] args) throws SQLException{
         MyConnection mc= MyConnection.getInstance();
        Questions f1 =new Questions(2,"oui","oui","non","oui","jsp","null","true");
       QuestionsService qs= new QuestionsService(); 
       //fo.rechercherFormulaire(0);
      // fo.ajouterFormulaire(f1);}}
      //fo.ajouterFormulaire(f1);
       //fo.supprimerFormulaire(3);
       qs.Questionnaire(f1);
      //fo.rechercherFormulaire(9);
                 }
}